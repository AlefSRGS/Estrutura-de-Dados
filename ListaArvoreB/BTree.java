package ListaArvoreB;

public class BTree {
    private NodeB root;
    private final int ordem;
    private final int nChaves;
    private final int minimo;

    public BTree(int m) {
        this.ordem = m;
        this.nChaves = m - 1;
        this.minimo = m / 2;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int info) {
        if (isEmpty()) {
            this.root = new NodeB(this.ordem);
            this.root.preencherRaiz(info, null, null);
        } else {
            Retorno result = new Retorno();
            insertB(this.root, info, result);
            if (result.getH()) {
                NodeB novaRaiz = new NodeB(this.ordem);
                novaRaiz.preencherRaiz(result.getInfo(), this.root, result.getFilhoDir());
                this.root = novaRaiz;
            }
        }
    }

    private void insertB(NodeB raiz, int info, Retorno result) {
        if (raiz == null) {
            result.setH(true);
            result.setInfo(info);
            return;
        }
        int pos = raiz.buscaBinaria(info);
        if (pos < raiz.getN() && raiz.getInfo(pos) == info) {
            System.out.println("Chave já contida na árvore");
            result.setH(false);
            return;
        }
        if (raiz.getFilho(pos) == null) {

            if (raiz.getN() < this.nChaves) {
                raiz.inserirChave(info, null);
                result.setH(false);
            } else {

                cisaoNode(raiz, info, pos, result);
            }
        } else {
            insertB(raiz.getFilho(pos), info, result);
    
            if (result.getH()) {
                if (raiz.getN() < this.nChaves) {
                    raiz.inserirChave(result.getInfo(), result.getFilhoDir());
                    result.setH(false);
                } else {
                    cisaoNode(raiz, result.getInfo(), pos, result);
                }
            }
        }
    }
    
    private void cisaoNode(NodeB raiz, int info, int pos, Retorno result) {
        NodeB temp = new NodeB(this.ordem);
        int infoMediano = raiz.getInfo(this.minimo);
        for (int i = this.minimo + 1; i <= this.nChaves; i++) {
            temp.inserirChave(raiz.getInfo(i), raiz.getFilho(i + 1));
            raiz.setInfo(i, 0);
            raiz.setFilho(i + 1, null);
        }
        raiz.setN(this.minimo);
    
        if (pos <= this.minimo) {
            raiz.inserirChave(info, null);
        } else {
            temp.inserirChave(info, null);
        }
    
        result.setInfo(infoMediano);
        result.setFilhoDir(temp);
        result.setH(true);
    }

    public ResultadoBusca searchBiggestValue(NodeB raiz) {
        NodeB atual = raiz;
        if (atual == null) {
            return null; 
        }
        while (atual.getFilho(atual.getN()) != null) {
            atual = atual.getFilho(atual.getN());
        }
        return new ResultadoBusca(atual, atual.getN() - 1);
    }

    public NodeB searchSmallerValue(NodeB raiz) {
        NodeB atual = raiz;
        if (atual == null) {
            return null;  // Árvore está vazia
        }
        while (atual.getFilho(0) != null) {
            atual = atual.getFilho(0); 
        }
        return atual;
    }
    
    public int altura(NodeB raiz) {
        int altura = 0;
        NodeB atual = raiz;
        while (atual != null && atual.getFilho(0) != null) {
            altura++;
            atual = atual.getFilho(0); 
        }
        return altura;
    }

    public ResultadoBusca encontrarValorNaArvore(NodeB raiz, int valor) {
        NodeB atual = raiz;
        while (atual != null) {
            int pos = atual.buscaBinaria(valor);
            if (pos < atual.getN() && atual.getInfo(pos) == valor) {
                return new ResultadoBusca(atual, pos);
            }
            atual = atual.getFilho(pos);
        }
        return null;
    }
    
    
    public void emOrdem() {
        if (!isEmpty()) {
            root.percorrerEmOrdem();
        } else {
            System.out.println("Árvore vazia");
        }
    }
}
