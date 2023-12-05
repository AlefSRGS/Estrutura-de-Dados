package ListaArvore.EmpresaProdutos;

import java.util.Stack;

public class SearchTree {
    private TreeNode raiz;

    public boolean isEmpty(){
        return this.raiz == null;
    }

    public void insert(Produto novoProduto){
        if(isEmpty()){
            this.raiz = new TreeNode(novoProduto);
            return;
        }
        this.raiz.insertNode(novoProduto);
    }
    public Produto find(int codigoProduto){
        if(isEmpty()){
            return null;
        }
        return raiz.findNode(codigoProduto);
    }
    public void emOrdem(){
        if(isEmpty()){
            return;
        }
        exibirEmOrdem(raiz);
    }
    private void exibirEmOrdem(TreeNode treeNode){
        if(treeNode != null){
            //começa pela esquerda (ordem crescente)
            exibirEmOrdem(treeNode.getLeft());
            System.out.println(treeNode);
            exibirEmOrdem(treeNode.getRight());
        }
    }
    public int alterarPrecoProduto(int codigoProduto, double novoPreco){
        Produto produtoEncontrado = raiz.findNode(codigoProduto);
        if(produtoEncontrado != null) {
            produtoEncontrado.setPrice(novoPreco);
            return 1;
        }
        return 0;
    }
    public int alterarQtdEstoqueProduto(int codigoProduto, int novaQtd){
        Produto produtoEncontrado = raiz.findNode(codigoProduto);
        if(produtoEncontrado != null) {
            produtoEncontrado.setQtd(novaQtd);;
            return 1;
        }
        return 0;
    }

    public Produto buscaNaoRecursiva(int codigoProduto){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode auxNode = this.raiz;
        stack.push(auxNode);
        while(stack.isEmpty() && auxNode != null){

        }
    }
    public void insertNaoRecursivo(Produto novoProduto){
        
    }
}
