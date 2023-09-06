package ImplementacaoQueue;

import java.util.Random;
import java.util.Scanner;

public class SistemaFilaBanco {
    static void optionSelected(int option, QueueInt filaSenhasAtendimento){
        Scanner sc = new Scanner(System.in);
        if(option == 1){
            Random random = new Random();
            int novaSenha = random.nextInt(999);
            int resultAdd = filaSenhasAtendimento.addQueue(novaSenha);
            if(resultAdd == 0){
                System.out.println("Todas as cadeiras ocupados, por favor voltei em outro momento para retirar sua senha de atendimento.\n");
                return;
            }else{
                System.out.printf("Sua senha é %d, existem %d pessoas na sua frente.\n", novaSenha, filaSenhasAtendimento.getFinalFila()-1);
            }
        }else if(option == 2){
            int resultAtendimento = filaSenhasAtendimento.removeQueue();
            if(resultAtendimento == 0){
                System.out.println("Nenhum cliente na fila, impossivel realizar atendimento.");
            }else{
                System.out.printf("Cliente de senha %d por favor se dirigir ao guichê 01 para atendimento\n",resultAtendimento);
            }

        }else if(option == 0){
            return;
        }
    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        QueueInt filaSenhasAtendimento = new QueueInt();
        while (option != 0) {
            System.out.println("1 - Retirar nova senha para atendimento");
            System.out.println("2 - Chamar senha para atendimento");
            System.out.println("0 - Finalizar programa");
            System.out.print("Qual opcao deseja: ");
            option = sc.nextInt();
            System.out.println();
            optionSelected(option, filaSenhasAtendimento);
        }
        return;
    }
    public static void main(String[] args) {
        menu();
    }
}
