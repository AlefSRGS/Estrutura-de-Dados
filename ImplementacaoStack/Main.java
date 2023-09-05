import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Pilha convertionBinaryImplemented(Pilha numBinary, int numForConvert){
        int quoeficient = 0;
        int resto = 0;
        while (numForConvert != 0) {
            quoeficient = numForConvert / 2;
            resto = numForConvert % 2;
            if (numBinary.isFull() == false) {
                numBinary.push(resto);
            }
            numForConvert = quoeficient;
        }
        return numBinary;
    }
    static Stack convertionBinaryStackNativoJava(Stack numBinary, int numForConvert){
        int quoeficient = 0;
        int resto = 0;
        int qtdPreenchido = 0;
        while (numForConvert != 0) {
            quoeficient = numForConvert / 2;
            resto = numForConvert % 2;
            if (qtdPreenchido != 32) {
                numBinary.push(resto);
                qtdPreenchido++;
            }
            numForConvert = quoeficient;
        }
        return numBinary;
    }
    static void optionSelected(int option){
        Scanner sc = new Scanner(System.in);
        if(option == 1){
            
            System.out.println("1 - Conversão com classe implementada");
            System.out.println("2 - Conversão com classe nativa java");
            System.out.print("Qual opcao deseja: ");
            int subSelectionConversao = sc.nextInt();
            if(subSelectionConversao == 1){
                Pilha numBinary = new Pilha(32);
                System.out.print("Qual o valor inteiro a ser convertido para binario: ");
                int numForConvert = sc.nextInt();
                numBinary = convertionBinaryImplemented(numBinary, numForConvert);
                System.out.printf("O numero %d convertido para binario fica: ",numForConvert);
                numBinary.printNumStack();
                System.out.println();
            }else if(subSelectionConversao == 2){
                Stack<Integer> numBinary2 = new Stack<>();
                System.out.print("Qual o valor inteiro a ser convertido para binario: ");
                int numForConvert = sc.nextInt();
                numBinary2 = convertionBinaryStackNativoJava(numBinary2, numForConvert);
                System.out.printf("O numero %d convertido para binario fica: ",numForConvert);
                System.out.print(numBinary2);
                System.out.println();
                System.out.println();
            }
            
        }else if(option == 2){
            System.out.print("Qual o texto que sera testado: ");
            String textTestPalindrome = sc.nextLine();
            Pilha textPilha = new Pilha(textTestPalindrome);
            if(isPalindrome(textPilha)){
                System.out.println("O texto é um palindromo.");
            }else{
                System.out.println("O texto não é um palindromo.");
            }
        }else if(option == 0){
            return;
        }
    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            System.out.println("1 - Converter numero para binario");
            System.out.println("2 - Descobrir se é palindromo");
            System.out.println("0 - Finalizar programa");
            System.out.print("Qual opcao deseja: ");
            option = sc.nextInt();
            System.out.println();
            optionSelected(option);
        }
        return;
    }
    static boolean isPalindrome(Pilha frasePalavra){
        boolean testPalindrome = true;
        for(int i =0;i<((frasePalavra.getFrasePalavra().length/2)-1);i++){
            if(frasePalavra.getFrasePalavra()[i] != frasePalavra.getFrasePalavra()[frasePalavra.getFrasePalavra().length-i-1]){
                testPalindrome = false;
            }
        }
        return testPalindrome;
    }
    public static void main(String[] args) {
        menu();
    }
}
