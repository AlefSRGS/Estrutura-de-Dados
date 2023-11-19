package ImplementacaoListaSimples.ListaAluno;

import java.util.Scanner;

public class AppAluno {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSEAluno turma;
        turma = new LSEAluno();
        int op;
        do {
            exibirOpcoes();
            op = in.nextInt();
            switch (op) {
                case 1:
                    Aluno aluno1 = new Aluno("00000845365", "Alef", 10.0, 0);
                    Aluno aluno2 = new Aluno("00000823445", "carlos", 7.0, 0);
                    Aluno aluno3 = new Aluno("00000845675", "eduardo", 5.0, 0);
                    Aluno aluno4 = new Aluno("00000890287", "franklin", 2.0, 0);
                    turma.insertEndListWithNoRepeat(aluno1);        
                    turma.insertEndListWithNoRepeat(aluno2);        
                    turma.insertEndListWithNoRepeat(aluno3);        
                    turma.insertEndListWithNoRepeat(aluno4);        
                    turma.insertEndListWithNoRepeat(aluno4);        
                    break;
                case 2:
                    turma.showAll();
                    break;
                case 3:
                    LSEAluno listPassed = new LSEAluno();
                    LSEAluno listFailed = new LSEAluno();
                    turma.passedAndFailed(listPassed, listFailed);
                    System.out.println("Alunos aprovados: ");
                    listPassed.showAll();
                    System.out.println("Alunos reprovados: ");
                    listFailed.showAll();
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
        System.out.println("1 -Inserir novo aluno na turma");
        System.out.println("2 -Exibir todos os alunos na turma");
        System.out.println("3 -Mostrar todos os alunos aprovados e reprovados na turma");
        System.out.println("0 -Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }
}
