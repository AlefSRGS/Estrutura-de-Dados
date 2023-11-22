package ImplementacaoListaDuplaEncad.Atividade3ListaDuplaEncad;

import java.util.Objects;
import java.util.Scanner;

public class AppAtv3LDE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LDEInt listaA = new LDEInt();
        LDEInt listaB = new LDEInt();

        System.out.println("Insira os valores da lista A:");
        String option = "";
        int qtdInserido = 0;
        while(!Objects.equals(option, "Y")){
            qtdInserido++;
            System.out.println("Insira o valor " + qtdInserido + ":");
            int valor = sc.nextInt();
            listaA.insertNodeWithoutRepet(valor);
            System.out.print("Deseja parar de inserir valores? Y/n: ");
            option = sc.nextLine();
        }

        System.out.println("Insira os valores da lista A:");
        option = "";
        qtdInserido = 0;
        while(!Objects.equals(option, "Y")){
            qtdInserido++;
            System.out.println("Insira o valor " + qtdInserido + ":");
            int valor = sc.nextInt();
            listaB.insertNodeWithoutRepet(valor);
            System.out.print("Deseja parar de inserir valores? Y/n: ");
            option = sc.nextLine();
        }

        System.out.println("Valores da lista A:");
        listaA.printAllItensInList();
        System.out.println();
        System.out.println();
        System.out.println("Valores da lista B:");
        listaB.printAllItensInList();
        System.out.println();
        System.out.println();
        System.out.println("Lista interseção:");
        LDEInt listaIntersecao = listaA.intersection(listaB);
        listaIntersecao.printAllItensInList();
        System.out.println();
        System.out.println();
        LDEInt listaUniao = listaA.union(listaB);
        listaUniao.printAllItensInList();
        System.out.println();
        System.out.println();
        LDEInt listaDiferenca = listaA.difference(listaB);
        listaDiferenca.printAllItensInList();

    }
}
