import java.util.Scanner;

public class ConversionNumBinary {
    static StackInt convertionBinary(StackInt numBinary, int numForConvert){
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackInt numBinary = new StackInt(32);
        System.out.println("Qual o valor inteiro a ser convertido para binario: ");
        int numForConvert = sc.nextInt();
    }
}
