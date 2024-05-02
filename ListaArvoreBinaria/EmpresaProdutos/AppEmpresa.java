package ListaArvoreBinaria.EmpresaProdutos;

import java.util.Scanner;

public class AppEmpresa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;
        SearchTree searchTree = new SearchTree();
        do {
            exibirOpcoes();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Insira a descrição do produto: ");
                    String desc = in.nextLine();
                    System.out.println("Insira codigo do produto: ");
                    int code = in.nextInt();
                    System.out.println("Insira o provedor do produto: ");
                    String provider = in.nextLine();
                    System.out.println("Insira o preço do produto: ");
                    double price = in.nextDouble();
                    System.out.println("Insira a quantidade do produto no estoque: ");
                    int qtdEstoque = in.nextInt();
                    Produto novProduto = new Produto(code, desc, provider, price, qtdEstoque);
                    searchTree.insert(novProduto);
                    break;
                case 2:
                    searchTree.emOrdem();
                    break;
                case 3:
                    System.out.println("insira o codigo do produto: ");
                    int codigoProduto = in.nextInt();
                    Produto produtoEncontrado = searchTree.find(codigoProduto);
                    if(produtoEncontrado != null){
                        System.out.println("Produto encontrado!");
                        System.out.println(produtoEncontrado);
                    }else{
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("insira o codigo do produto: ");
                    codigoProduto = in.nextInt();
                    produtoEncontrado = searchTree.find(codigoProduto);
                    if(produtoEncontrado != null){
                        System.out.println("Ensira o novo preço do produto: ");
                        double novoPreco = in.nextDouble();
                        produtoEncontrado.setPrice(novoPreco);
                    }else{
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 5:
                    System.out.println("insira o codigo do produto: ");
                    codigoProduto = in.nextInt();
                    produtoEncontrado = searchTree.find(codigoProduto);
                    if(produtoEncontrado != null){
                        System.out.println("Ensira a nova quantidade no estoque do produto: ");
                        int novaQtd = in.nextInt();
                        produtoEncontrado.setQtd(novaQtd);
                    }else{
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }
    public static void exibirOpcoes() {
        System.out.println("Opções");
        System.out.println("1 -Cadastrar novo produto");
        System.out.println("2 -Exibir todos os produtos");
        System.out.println("3 -Exibir produto especifico");
        System.out.println("4 -Alterar preço de um produto");
        System.out.println("5 -Alterar quantidade de um produto no estoque");
        System.out.println("0 -Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }
}
