package ListaArvoreAVL;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private boolean status;

    private boolean isEmpty(){
        return root == null;
    }

    public void insert(T value){
        if(this.isEmpty()){
            this.root = new AVLNode<T>(value);
            this.status = true;
        }
        else{
            this.root = insertNode(this.root, value);
        }
    }

    private AVLNode<T> insertNode(AVLNode<T> r, T value){
        if(r == null){
            r = new AVLNode<T>(value);
            this.status = true;
        }
        else if(r.getInfo().compareTo(value) > 0){
            r.setLeft(insertNode(r.getLeft(), value));
            if(this.status == true){
                switch (r.getFatBal()) {
                    case 1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(-1);
                        break;
                    case -1:
                        r = this.rotateRight(r);
                        break;
                }
            }
        }
        else{
            r.setRight(insertNode(r.getRight(), value));
            if(this.status == true){
                switch (r.getFatBal()) {
                    case -1:
                        r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0:
                        r.setFatBal(1);
                        break;
                    case 1:
                        r = this.rotateLeft(r);
                        break;
                }
            }    
        }
        return r;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> a) {
        AVLNode<T> b, c;
       b = a.getRight();
       if(b.getFatBal() == -1){ //rotacao simples
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setFatBal(0);
            a = b;
        }
       else{ //rotacao dupla
            c = b.getLeft();
            b.setLeft(c.getRight());
            c.setRight(b);
            a.setRight(c.getLeft());
            c.setLeft(a);
            if(c.getFatBal() == 1){
                a.setFatBal(-1);
            }else{
                a.setFatBal(0);
            }
            if(c.getFatBal() == -1){
                b.setFatBal(1);
            }else{
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    private AVLNode<T> rotateRight(AVLNode<T> a) {
       AVLNode<T> b, c;
       b = a.getLeft();
       if(b.getFatBal() == -1){ //rotacao simples
            a.setLeft(b.getRight());
            b.setRight(a);
            a.setFatBal(0);
            a = b;
        }
       else{ //rotacao dupla
            c = b.getRight();
            b.setRight(c.getLeft());
            c.setLeft(b);
            a.setLeft(c.getRight());
            c.setRight(a);
            if(c.getFatBal() == -1){
                a.setFatBal(1);
            }else{
                a.setFatBal(0);
            }
            if(c.getFatBal() == 1){
                b.setFatBal(0);
            }else{
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }
    
    public void passeioPorNivel(){
        Queue<AVLNode<T>> fila;
        AVLNode<T> aux;
        if(this.isEmpty() == false){
            fila = new LinkedList<>();
            fila.add(this.root);
            int nivel = 0;
            while (fila.isEmpty() == false) {
                nivel++;
                System.out.println("Nivel: " + nivel + ": ");
                for(int i = 0; i < fila.size(); i++){
                    aux = fila.remove();
                    System.out.println(aux.getInfo() + " ");

                    if(aux.getLeft() != null){
                        fila.add(aux.getLeft());
                    }
                    if(aux.getRight() != null){
                        fila.add(aux.getRight());
                    }
                }
                System.out.println();
            }
        }
    }

    public void passeioEmOrdem(){
        if(this.isEmpty() == false){
            this.percorrerEmOrdem(root);
        }
    }

    private void percorrerEmOrdem(AVLNode<T> r) {
        if(r != null){
            percorrerEmOrdem(r.getLeft());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getRight());
        }
    }
    public void remover(T valorRemover){
        this.root = removerNode(root, valorRemover);
    }
    private AVLNode<T> removerNode(AVLNode<T> avlNode, T valor) {
        // Verifica se o nó atual é nulo, indicando que o valor não está na árvore
        if (avlNode == null) {
            return avlNode;
        } else if (valor.compareTo(avlNode.getInfo()) < 0) {
            // Se o valor a ser removido for menor que o valor do nó atual, vai para a subárvore à esquerda
            avlNode.setLeft(removerNode(avlNode.getLeft(), valor));
        } else if (avlNode.compareTo(valor) > 0) {
            // Se o valor a ser removido for maior que o valor do nó atual, vai para a subárvore à direita
            avlNode.setRight(removerNode(avlNode.getRight(), valor));
        } else {
            // Achou o nó que precisa ser removido
            if (avlNode.getLeft() == null) {
                // Se o nó não tem filho à esquerda
                if (this.status == true) {
                    // Verifica se a árvore está desbalanceada e realiza as rotações necessárias
                    switch (avlNode.getFatBal()) {
                        case 1:
                            avlNode.setFatBal(0);
                            this.status = false;
                            break;
                        case 0:
                            avlNode.setFatBal(-1);
                            break;
                        case -1:
                            avlNode = this.rotateRight(avlNode);
                            break;
                        default:
                            break;
                    }
                    avlNode = avlNode.getRight();
                }
            } else if (avlNode.getRight() == null) {
                // Se o nó não tem filho à direita
                if (this.status == true) {
                    // Verifica se a árvore está desbalanceada e realiza as rotações necessárias
                    switch (avlNode.getFatBal()) {
                        case 1:
                            avlNode = this.rotateLeft(avlNode);
                            break;
                        case 0:
                            avlNode.setFatBal(1);
                            break;
                        case -1:
                            avlNode.setFatBal(0);
                            this.status = false;
                            break;
                        default:
                            break;
                    }
                }
                avlNode = avlNode.getLeft();
            } else {
                // Se o nó tem ambos os filhos
                // Encontra o nó mais à direita da subárvore esquerda
                AVLNode<T> replaceNode = new AVLNode<T>(avlNode.getLeft().getInfo());
                while (replaceNode.getRight() != null) {
                    replaceNode = replaceNode.getRight();
                }
                // Cria um novo nó com o valor do nó substituto
                AVLNode<T> novoNode = new AVLNode<T>(replaceNode.getInfo());
                // Substitui o nó removido 
                novoNode.setRight(avlNode.getRight());
                novoNode.setLeft(removerNode(avlNode.getLeft(), replaceNode.getInfo()));
                avlNode = novoNode;
            }
        }
        return avlNode;
    }
}
