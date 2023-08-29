package RevisaoPOOBuscaOrdenacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o tamanho do vetor de circulos: ");
        int tamanho =  sc.nextInt();
        ListaDeFiguras vetorCirculos = new ListaDeFiguras(tamanho);
        System.out.println();
        int operacao = -1;
        while(operacao != 0) {
            System.out.println("1 - Inserir um circulo novo no vetor dados.");
            System.out.println("2 - Exibir todos os circulos armazenados no vetor dados.");
            System.out.println("3 - Ordenar os circulos do vetor dados.");
            System.out.println("4 - Buscar por um circulo no vetor.");
            System.out.print("Qual das operacoes ira ser realizada: ");
            operacao = sc.nextInt();
            System.out.println();
            selectionOption(operacao, vetorCirculos);
        }
    }
    public static void selectionOption(int operacaoSelecionada, ListaDeFiguras vetorFiguras){
        Scanner sc = new Scanner(System.in);
        if(operacaoSelecionada == 1){
            double raioDoCirculo = 0, coordX = 0, coordY = 0;
            try {
                System.out.print("Insira o raio do novo circulo: ");
                raioDoCirculo = sc.nextDouble();

                System.out.print("Insira a posicao do circulo no eixo X: ");
                coordX = sc.nextDouble();

                System.out.print("Insira a posicao do circulo no eixo Y: ");
                coordY = sc.nextDouble();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Por Favor ensira dados validos!");
                selectionOption(operacaoSelecionada, vetorFiguras);
            }
            Circulo circuloNovo = new Circulo(coordX, coordY, raioDoCirculo);
            vetorFiguras.inserirCirculo(circuloNovo);

        }else if(operacaoSelecionada == 2){
            vetorFiguras.exibirDados();

        }else if(operacaoSelecionada == 3){
            vetorFiguras.OrdenarDadosCrescente();
            System.out.println();

        }else if(operacaoSelecionada == 4){
            if(vetorFiguras.isEmpty()){
                System.out.println("Lista vazia, nada para buscar.\n");
                return;
            }
            System.out.print("Insira o raio do circulo a ser consultado: ");
            double raioCirculoConsulta = sc.nextDouble();
            Circulo circuloParaConsulta = new Circulo(0.0, 0.0, raioCirculoConsulta);
            int resultBusca = vetorFiguras.buscaBinariaIterativa(circuloParaConsulta);
            if(resultBusca == -1){
                System.out.println("Circulo inexistente no vetor.");
                System.out.println();
            }else{
                System.out.printf("Circulo encontrado com sucesso e esta na posicao %d do vetor\n", resultBusca);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}