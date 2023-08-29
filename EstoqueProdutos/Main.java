package EstoqueProdutos;

import java.util.Scanner;

public class Main {
    public static void selectionOption(int optionSelected, CadastroProdutos estoqueProdutos){
        Scanner sc = new Scanner(System.in);
        if(optionSelected == 1){
            System.out.println("Opções de cadastro: ");
            System.out.println("1 - Cadastrar apenas o codigo do produto");
            System.out.println("2 - Cadastrar produto por completo");
            System.out.print("Digite a opção desejada:");
            int optionCadastro = sc.nextInt();
            if(optionCadastro == 1){
                System.out.print("Qual o codigo do novo produto a cadastrar: ");
                sc.nextLine();
                String codigoProduto = sc.nextLine();
                Produto novoProduto = new Produto(codigoProduto);
                estoqueProdutos.cadastrarNovoProduto(novoProduto);
            }else if(optionCadastro == 2){
                System.out.print("Qual o codigo do novo produto a cadastrar: ");
                String codigoProduto = sc.nextLine();
                System.out.print("Qual a descrição do novo produto a cadastrar: ");
                String descricaoProduto = sc.nextLine();
                System.out.print("Qual o fornecedor do novo produto a cadastrar: ");
                String fornecedorProduto = sc.nextLine();
                System.out.print("Qual o preço do novo produto a cadastrar: ");
                double precoProduto = sc.nextDouble();
                System.out.print("Quantos produtos tem no estoque: ");
                int qntEstoqueProduto = sc.nextInt();
                Produto novoProduto = new Produto(codigoProduto, descricaoProduto, fornecedorProduto,precoProduto, qntEstoqueProduto);
                estoqueProdutos.cadastrarNovoProduto(novoProduto);
            }
        }else if(optionSelected == 2){
            System.out.print("Qual o codigo do produto que deseja exibir seus dados: ");
            String codigoProdutoConsulta = sc.nextLine();
            System.out.println(estoqueProdutos.exibirDadosProdutoUnico(codigoProdutoConsulta));
            
        }else if(optionSelected == 3){
            estoqueProdutos.exibirDadosProdutosEstoque();
        }else if(optionSelected == 4){
            System.out.print("Qual o codigo do produto a modificar: ");
            String codigoProdutoAlterarPreco = sc.nextLine();
            System.out.println();
            System.out.println("1 - Aumento preço produto");
            System.out.println("2 - Reduzir preço produto");
            System.out.print("Digite opção desejada: ");
            int optionMudancaPreço = sc.nextInt();
            System.out.print("Porcentagem da alteração de preço: ");
            double porcentagemMudancaPreco = sc.nextDouble();
            System.out.println();
            estoqueProdutos.alterarPrecoProduto(codigoProdutoAlterarPreco, porcentagemMudancaPreco, optionMudancaPreço);
        }else if(optionSelected == 5){
            System.out.print("Qual o codigo do produto a modificar: ");
            String codigoProdutoAlterarEstoque = sc.nextLine();
            System.out.println("Quantos produtos vão ser adicionados ao estoque: ");
            int produtosAddEstoque =  sc.nextInt();
            estoqueProdutos.atualizarProdutoEstoque(codigoProdutoAlterarEstoque, produtosAddEstoque);
        }else if(optionSelected == 6){
            System.out.print("Qual o codigo do produto que sera vendido: ");
            String codigoProdutoVendido = sc.nextLine();
            System.out.println("Quantidade de produtos que vão ser vendidos: ");
            int produtosVendidos =  sc.nextInt();
            estoqueProdutos.vendaProdutoEstoque(codigoProdutoVendido, produtosVendidos);
        }else if(optionSelected == 7){
            System.out.print("Qual o codigo do produto que tera seu cadastro removido: ");
            String codigoProdutoCadastroRemovido = sc.nextLine();
            estoqueProdutos.removerCadastroProduto(codigoProdutoCadastroRemovido);
        }
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        CadastroProdutos estoqueProdutos = new CadastroProdutos(10);
        int optionSelected = -1;
        while(optionSelected != 0){
            System.out.println("Opções:");
            System.out.println("1 –Cadastro de um produto");
            System.out.println("2 –Exibição dos dados de um produto");
            System.out.println("3 –Exibição de todos os produtos da loja");
            System.out.println("4 –Alterar o preço de um produto");
            System.out.println("5 –Atualizar o estoque de um produto");
            System.out.println("6 –Realizar a venda de um produto");
            System.out.println("7 –Remover um produto do cadastro");
            System.out.println("0 –Sair do programa");
            System.out.print("Digite a opção desejada: ");
            optionSelected = sc.nextInt();
            System.out.println();
            selectionOption(optionSelected, estoqueProdutos);
        }
    }
    public static void main(String[] args) {
        System.out.println("Loja Preço Bom\nSistema de Controle de Estoque");
        menu();
    }
}
