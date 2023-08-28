package EstoqueProdutos;
public class Produto implements Comparable <Produto>{
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int qntEstoque;

    public void Produto(String codigo, String descricao, String fornecedor, double preco, int qntEstoque){
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }
    public void Produto(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return preco;
    }
    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
    public int getQntEstoque() {
        return qntEstoque;
    }
    public void aplicarDesconto(double percentualDesconto){
        preco -= preco*(percentualDesconto/100);
    }
    public void aplicarAumento(double percentualDesconto){
        preco += preco*(percentualDesconto/100);
    }
    public void atualizarEstoque(int quantidadeAdicionar){
        qntEstoque += quantidadeAdicionar;
    }
    public void venderProduto(int quantidadeVender){
        qntEstoque -= quantidadeVender;
    }
    public String toString(){
        return "Produto: "+descricao+"\ncodigo: "+codigo+"\nValor: "+preco+"\nFornecedor: "+fornecedor+"\nQuantidade no estoque: "+qntEstoque+"\n";
    }
    @Override
    public int compareTo(Produto outroProduto) {
        if(codigo.equals(outroProduto.getCodigo())){
            return 1;
        }else{
            return -1;
        }
        
    }   
}
