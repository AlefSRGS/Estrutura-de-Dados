public class StackInt {
    private int vetorInt[];
    private int topo;

    public StackInt(){
        vetorInt = new int[10];
    }
    public StackInt(int lenghtVetor){
        vetorInt = new int[lenghtVetor];
    }

    public int top(){
        return vetorInt[topo - 1];
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
            System.out.println("Numero adicionado ao vetor");
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
}
