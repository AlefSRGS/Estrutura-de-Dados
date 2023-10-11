

import java.util.Scanner;

public class AppLSEInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSEInt numeros;
        numeros = new LSEInt();
        int op, num, qtd;
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
                    System.out.print("Informe o valor a ser procurado: ");
                    num = in.nextInt();
                    qtd = numeros.countDataInList(num);
                    System.out.println(num + " aparece " + qtd + " vezes na lista.");
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
        System.out.println("4 -Procurar um valor na lista");
        System.out.println("0 -Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }
}
