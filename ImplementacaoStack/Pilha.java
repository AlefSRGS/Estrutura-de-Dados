public class Pilha {
    private int vetorInt[];
    private char[] frasePalavra;
    private int topo;

    public Pilha(int lenghtVetor){
        vetorInt = new int[lenghtVetor];
    }
    public Pilha(String fraseAdd){
        if(fraseAdd.matches("[0-9]+")){
            System.out.println("Por favor insira um texto valido.");
            return;
        }
        frasePalavra = new char[fraseAdd.length()];
        for (int i = 0; i < fraseAdd.length(); i++) {
            if(fraseAdd.charAt(i) == ' '){
                break;
            }else{
                pushPalavra(fraseAdd.charAt(i));
            }
        }
    }
    public char[] getFrasePalavra() {
        return frasePalavra;
    }
    public int top(){
        return vetorInt[topo];
    }
    public void pushPalavra(char letra){
        frasePalavra[topo] = letra;
        topo++;
    }
    public void push(int numAddVetor){
        if(numAddVetor == 0){
            System.out.println("Numero invalido, nao adicionado ao vetor");
            return;
        }
        if(isFull()){
            System.out.println("Vetor esta cheio impossivel adicionar");
            return;
        }else{
            vetorInt[topo] = numAddVetor;
            topo++;
        }
    }
    public int pop(){
        int numRemov = top();
        vetorInt[topo-1] = 0;
        return numRemov; 
    }
    public boolean isEmpty(){
        return (topo == 0);
    }
    public boolean isFull(){
        return(topo == vetorInt.length);
    }
    public void printNumStack(){
        for (int i = 0; i < topo; i++) {
            System.out.print(vetorInt[i]);
        }
        System.out.println();
    }
}
