package ListaArvoreBinaria.EmpresaProdutos;

public class TreeNode {
    private Produto info;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Produto info){
        this.info = info;
    }

    public void insertNode(Produto novoProduto) {
        if(this.info.compareTo(novoProduto) == 0){
            return;
        }
        if(this.info.compareTo(novoProduto) < 0){
            if(this.left == null){
                setLeft(new TreeNode(novoProduto));
            }else{
                this.left.insertNode(novoProduto);
            }
        }
        else{
            if(this.right == null){
                setRight(new TreeNode(novoProduto));
            }else{
                this.right.insertNode(novoProduto);
            }
        }
    }
    public Produto findNode(int codigoProduto){
        if(this.info.getCodeProduct() == codigoProduto){
            return info;
        }
        if(this.info.getCodeProduct() < codigoProduto){
            if(this.left == null){
                return null;
            }
            else{
                return this.left.findNode(codigoProduto);
            }
        }
        else{
            if(this.right == null){
                return null;
            }else{
                return this.right.findNode(codigoProduto);
            }
        }
    }
    public void exibirEmOrdem(TreeNode treeNode){
        if(treeNode != null){
            //começa pela esquerda (ordem crescente)
            exibirEmOrdem(treeNode.getLeft());
            System.out.println(treeNode);
            exibirEmOrdem(treeNode.getRight());
        }
    }
    
    public Produto getInfo() {
        return info;
    }
    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setInfo(Produto info) {
        this.info = info;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
