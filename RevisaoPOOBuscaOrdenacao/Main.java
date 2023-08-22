package RevisaoPOOBuscaOrdenacao;

import java.util.Scanner;

public class Main {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        int operacao = -1;
        while(operacao != 0) {
            System.out.println("1 - Inserir um circulo novo circulo no vetor dados");
            System.out.println("2 - Exibir todos os circulos armazenados no vetor dados");
            System.out.println("3 - Ordenar os circulos do vetor dados");
            System.out.print("Qual das operacoes ira ser realizada: ");
            operacao = sc.nextInt();
        }
    }
    public static void selectionOption(int operacaoSelecionada){
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
            inserirCirculo(circuloNovo);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o tamanho do vetor de circulos: ");
        int tamanho =  sc.nextInt();
        ListaDeFiguras(tamanho);
        System.out.println();
        menu();
    }
}