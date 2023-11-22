package ListaCircular;

import java.util.Scanner;

public class AppStreamingVideo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListaCategorias categorias = new ListaCategorias();
        int op;
        do {
            exibirOpcoes();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Insira a descrição da nova categoria: ");
                    String desc = in.nextLine();
                    Categoria novaCategoria = new Categoria(desc);
                    categorias.inserirCategoriaOrdenada(novaCategoria);
                    break;
                case 2:
                    System.out.println("Insira a descrição da categoria que deseja remover: ");
                    String descCategoriaParaRemover = in.nextLine();
                    categorias.removerCategoria(descCategoriaParaRemover);
                    break;
                case 3:
                    System.out.println("Insira a descrição da categoria que deseja adicionar um filme: ");
                    String descCategoriaAddFilme = in.nextLine();
                    try{
                        Categoria categoriaInserirFilme = categorias.buscarCategoria(descCategoriaAddFilme).getInfo();
                        System.out.println("ensira as informações do filme:");
                        System.out.print("Titulo: ");
                        String tituloFilme = in.nextLine();
                        System.out.print("Genero: ");
                        String generoFilme = in.nextLine();
                        System.out.print("Classificação: ");
                        String classificacaoFilme = in.nextLine();
                        System.out.print("Ano de lançamento: ");
                        int anoDeLancamentoFilme = in.nextInt();
                        Filme novoFilme = new Filme(tituloFilme, generoFilme, classificacaoFilme, anoDeLancamentoFilme);
                        categoriaInserirFilme.getLista().inserirFilmeOrdenado(novoFilme);
                    }
                    catch (NullPointerException e){
                        System.out.println("Categoria ainda não existe.");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Insira a descrição da categoria que deseja remover um filme: ");
                    String descCategoriaRemoverFilme = in.nextLine();
                    try{
                        Categoria categoriaRemoverFilme = categorias.buscarCategoria(descCategoriaRemoverFilme).getInfo();
                        System.out.println("Insira o titulo do filme que deseja remover");
                        String tituloFilmeRemover = in.nextLine();
                        categoriaRemoverFilme.getLista().removerFilme(tituloFilmeRemover);
                    }
                    catch (NullPointerException e){
                        System.out.println("Categoria ainda não existe.");
                        break;
                    }
                    break;
                case 5:
                    if(categorias.isEmpty()) {
                        System.out.println("Nenhuma categoria ou filme adicionados ainda.");
                        break;
                    }
                    System.out.println("Titulo do filme que deseja remover: ");
                    String nomeFilmeRemover = in.nextLine();
                    NodePrincipal auxNodeCategoria = categorias.getPrimeiro();
                    for (int i = 0; i < categorias.getQtd(); i++) {
                        auxNodeCategoria.getInfo().getLista().removerFilme(nomeFilmeRemover);
                        auxNodeCategoria = auxNodeCategoria.getProx();
                    }
                    break;
                case 6:
                    if(categorias.isEmpty()) {
                        System.out.println("Nenhuma categoria ou filme adicionados ainda.");
                        break;
                    }
                    NodePrincipal auxNodeCategoria2 = categorias.getPrimeiro();
                    System.out.println("Qual o titulo do filme que deseja alterar as informações: ");
                    String nomeFilmeAlterar = in.nextLine();
                    String novoTitulo = "", novoGenero = "", novaClassificacao = "";
                    int novoAnoLancamento = 0;
                    String desejaAlterar;
                    System.out.println("Deseja alterar o titulo do filme(Y/n):");
                    desejaAlterar = in.nextLine();
                    if(desejaAlterar.equals("Y")){
                        System.out.println("Qual o novo titulo do filme: ");
                        novoTitulo = in.nextLine();
                    }
                    System.out.println("Deseja alterar o genero do filme(Y/n):");
                    desejaAlterar = in.nextLine();
                    if(desejaAlterar.equals("Y")){
                        System.out.println("Qual o novo genero do filme: ");
                        novoGenero = in.nextLine();
                    }
                    System.out.println("Deseja alterar o classificação do filme(Y/n):");
                    desejaAlterar = in.nextLine();
                    if(desejaAlterar.equals("Y")){
                        System.out.println("Qual a nova classificação do filme: ");
                        novaClassificacao = in.nextLine();
                    }
                    System.out.println("Deseja alterar o ano de lançamento do filme(Y/n):");
                    desejaAlterar = in.nextLine();
                    if(desejaAlterar.equals("Y")){
                        System.out.println("Qual o novo ano de lançamento do filme: ");
                        novoAnoLancamento = in.nextInt();
                    }
                    for (int i = 0; i < categorias.getQtd(); i++) {
                        NodeSecundario posFilmeNaLista = auxNodeCategoria2.getInfo().getLista().buscarFilme(nomeFilmeAlterar);
                        if(posFilmeNaLista != null) {
                            posFilmeNaLista.getInfo().setTitulo(novoTitulo);
                            posFilmeNaLista.getInfo().setGenero(novoGenero);
                            posFilmeNaLista.getInfo().setClassificacao(novaClassificacao);
                            posFilmeNaLista.getInfo().setAno(novoAnoLancamento);
                        }
                        auxNodeCategoria2 = auxNodeCategoria2.getProx();
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
        System.out.println("Opções: ");
        System.out.println("1 - Adicionar uma nova categoria");
        System.out.println("2 - Remover uma categoria");
        System.out.println("3 - Adicionar novo filme a uma categoria");
        System.out.println("4 - Remover um filme de uma categoria");
        System.out.println("5 - Remover um filme de todas as categorias");
        System.out.println("6 - Editar informações de um filme");
        System.out.println("0 - sair");
        System.out.print("Digite a opção desejada: ");
    }
}
