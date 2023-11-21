package ImplementacaoListaDuplaEncad.Atividade2ListaDuplaEncad;

import java.util.Scanner;

public class AppPredio {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDEPessoas pessoas = new LDEPessoas();
        int op;
        String rgPessoa;
        do {
            exibirOpcoes();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o nome da pessoa a ser registrada: ");
                    String nomePessoa = in.nextLine();
                    System.out.print("Informe o RG da pessoa a ser registrada: ");
                    rgPessoa = in.nextLine();
                    Pessoa novPessoa = new Pessoa(rgPessoa, nomePessoa);
                    pessoas.cadastrarPessoa(novPessoa);
                    break;
                case 2:
                    pessoas.cancelarCadastroPessoa();
                    break;
                case 3:
                    pessoas.exibirPessoas();
                    break;
                case 4:
                    System.out.print("Informe o rg da pessoa a ser procurada: ");
                    rgPessoa = in.nextLine();
                    if(pessoas.verificarPessoa(rgPessoa)){
                        System.out.println("Pessoa tem registro");
                    }else{
                        System.out.println("Pessoa não registrada");
                    }
                    break;
                case 5:
                    System.out.print("Informe o rg da pessoa a ser removida: ");
                    rgPessoa = in.nextLine();
                    pessoas.removerCadastroPessoa(rgPessoa);
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
        System.out.println("1 -Cadastrar pessoas");
        System.out.println("2 -Cancelar ultimo registro");
        System.out.println("3 -Exibir todos os registros");
        System.out.println("4 -Verificar pessoa registrada");
        System.out.println("5 -Remover registro por RG");
        System.out.println("0 -Encerrar programa");
        System.out.print("Digite a opção desejada: ");
    }
}
