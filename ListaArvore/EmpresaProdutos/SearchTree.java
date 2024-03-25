package ListaArvore.EmpresaProdutos;

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
        TreeNode auxNodeTree = raiz;
        while (auxNodeTree != null) {
            if (codigoProduto == auxNodeTree.getInfo().getCodeProduct()) {
                return auxNodeTree.getInfo();
            } else if (codigoProduto < auxNodeTree.getInfo().getCodeProduct()) {
                auxNodeTree = auxNodeTree.getLeft(); 
            } else {
                auxNodeTree = auxNodeTree.getRight(); 
            }
        }
        return null;
    }

    public void insertNaoRecursivo(Produto novoProduto){
        TreeNode newNode = new TreeNode(novoProduto);
        if (isEmpty()) {
            raiz = newNode;
            return;
        }
        TreeNode pai = raiz;
        TreeNode filho = null;

        while (true) {
            filho = pai;
            if (novoProduto.compareTo(pai.getInfo()) < 0) {
                pai = pai.getLeft();
                if (pai == null) {
                    filho.setLeft(newNode);
                    return;
                }
            }
            else {
                pai = pai.getRight(); 
                if (pai == null) {
                    filho.setRight(newNode);
                    return;
                }
            }
        }
    }
}
