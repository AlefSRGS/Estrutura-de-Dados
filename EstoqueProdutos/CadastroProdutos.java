package EstoqueProdutos;

import java.util.Scanner;

public class CadastroProdutos {
    private Produto[] estoqueProdutos;
    private int qntProdutoEstoque;

    public CadastroProdutos(int capacidadeEstoque){
        this.estoqueProdutos =  new Produto[capacidadeEstoque];
    }
    public void cadastrarNovoProduto(Produto novoProduto){
        int posicaoProduto = consultaProdutos(novoProduto.getCodigo());
        if(posicaoProduto == -1){
            estoqueProdutos[qntProdutoEstoque] = novoProduto;
            qntProdutoEstoque++;
            System.out.println("Produto cadastrado com sucesso!");
        }else{
            System.out.println("Produto com o mesmo codigo ja cadastrado:");
            estoqueProdutos[posicaoProduto].toString();
        }
    }
    public int consultaProdutos(String codigoProduto){
        for(int posicaoProdutoEstoque = 0; posicaoProdutoEstoque < estoqueProdutos.length; posicaoProdutoEstoque++){
            if(codigoProduto.equals(estoqueProdutos[posicaoProdutoEstoque].getCodigo())){
                return posicaoProdutoEstoque;
            }
        }
        return -1;
    }
    public void exibirDadosProdutosEstoque(){
        System.out.println("Produtos cadastrados no estoque:");
        for (int i = 0; i < qntProdutoEstoque; i++) {
            if(estoqueProdutos[i] != null){
                estoqueProdutos[i].toString();
            }
        }
    }
    public void exibirDadosProdutoUnico(String codigoProduto){
        estoqueProdutos[consultaProdutos(codigoProduto)].toString();
    }
    public void alterarPrecoProduto(String codigoProduto, double porcentagemAlteracao, int tipoAlteracao){
        Scanner sc = new Scanner(System.in);
        int posicaoProdutoEstoque = consultaProdutos(codigoProduto);
        if(posicaoProdutoEstoque == -1){
            System.out.println("Produto não tem cadastro, impossivel alteração.");
            return;
        }
        if(tipoAlteracao == 1){
            estoqueProdutos[posicaoProdutoEstoque].aplicarAumento(porcentagemAlteracao);
            System.out.println("Aumento no produto foi aplicado com sucesso!");
        }else if(tipoAlteracao == 2){
            estoqueProdutos[posicaoProdutoEstoque].aplicarDesconto(porcentagemAlteracao);
            System.out.println("Desconto no produto foi aplicado com sucesso");
        }
    }
    public void atualizarProdutoEstoque(String codigoProduto, int qntProdutoAdd){
        int posicaoProduto = consultaProdutos(codigoProduto);
        if(posicaoProduto == -1){
            System.out.println("Produto não tem cadastro, impossivel atualização.");
        }else{
            estoqueProdutos[posicaoProduto].atualizarEstoque(qntProdutoAdd);
            System.out.println("Estoque do produto atualizado!");
        }
    }
    public void vendaProdutoEstoque(String codigoProduto, int qntVendida){
        int posicaoProduto = consultaProdutos(codigoProduto);
        if(posicaoProduto == -1){
            System.out.println("Produto não tem cadastro, impossivel a venda.");
        }else{
            estoqueProdutos[posicaoProduto].venderProduto(qntVendida);
            System.out.println("Venda do produto realizada!");
        }
    }
    public void removerCadastroProduto(String codigoProduto){
        int posicaoProduto = consultaProdutos(codigoProduto);
        if(posicaoProduto == -1){
            System.out.println("Produto ja removido ou não possui cadastro.");
        }else{
            estoqueProdutos[posicaoProduto] = estoqueProdutos[posicaoProduto+1];
            for(int i = posicaoProduto+1; i < estoqueProdutos.length; i++) {
                if(estoqueProdutos[i] == null){
                    break;
                }else{
                    estoqueProdutos[i] = estoqueProdutos[i+1];
                }
            }
        }
    }
}
