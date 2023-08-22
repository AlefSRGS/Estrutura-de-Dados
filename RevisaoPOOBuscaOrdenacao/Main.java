package RevisaoPOOBuscaOrdenacao;

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
            System.out.println("1 - Inserir um circulo novo circulo no vetor dados");
            System.out.println("2 - Exibir todos os circulos armazenados no vetor dados");
            System.out.println("3 - Ordenar os circulos do vetor dados");
            System.out.print("Qual das operacoes ira ser realizada: ");
            operacao = sc.nextInt();
            selectionOption(operacao, vetorCirculos);
        }
    }
    public static void selectionOption(int operacaoSelecionada, ListaDeFiguras vetorFiguras){
        Scanner sc = new Scanner(System.in);
        if(operacaoSelecionada == 1){
            System.out.print("Insira o raio do novo circulo: ");
            double raioDoCirculo = sc.nextDouble();
            System.out.println();
            System.out.print("Insira a posicao do circulo no eixo X: ");
            double coordX = sc.nextDouble();
            System.out.println();
            System.out.print("Insira a posicao do circulo no eixo Y: ");
            double coordY = sc.nextDouble();
            System.out.println();
            Circulo circuloNovo = new Circulo(coordX, coordY, raioDoCirculo);
            vetorFiguras.inserirCirculo(circuloNovo);
        }else if(operacaoSelecionada == 2){
            vetorFiguras.exibirDados();
        }else if(operacaoSelecionada == 3){
            vetorFiguras.OrdenarDadosCrescente();
        }
    }
    public static void main(String[] args) {
        menu();
    }
}