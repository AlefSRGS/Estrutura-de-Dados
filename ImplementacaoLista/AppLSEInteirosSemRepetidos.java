package ImplementacaoLista;

import java.util.Scanner;

public class AppLSEInteirosSemRepetidos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSEInteirosSemRepetidos numeros;
        numeros = new LSEInteirosSemRepetidos();
        int op, num;
        do {
            exibirOpcoes();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor a ser inserido: ");
                    num = in.nextInt();
                    numeros.insertFirst(num);
                    break;
                case 2:
                    numeros.showAll();
                    break;
                case 3:
                    numeros.removeFirstNode();
                    break;
                case 4:
                System.out.print("Informe o valor a ser inserido: ");
                    num = in.nextInt();
                    numeros.insertEndListWithNoRepeat(num);
                    break;
                case 5:
                    numeros.removeLastNode();
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
        System.out.println("1 -Inserir novo valor no início da lista");
        System.out.println("2 -Exibir valores na lista");
        System.out.println("3 -Remover o nó que se encontra no início da lista");
        System.out.println("4 -Inserir novo valor no final da lista");
        System.out.println("5 -Remover o nó que se encontra no final da lista");
        System.out.println("0 -Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }
}
