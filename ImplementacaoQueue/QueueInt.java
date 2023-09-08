package ImplementacaoQueue;

public class QueueInt {
    private int vetorInt[];
    private int finalFila;

    public QueueInt(){
        vetorInt = new int[20]; 
    }
    public QueueInt(int lenghtVetor){
        vetorInt = new int[lenghtVetor]; 
    }
    public int getFinalFila() {
        return finalFila;
    }
    public boolean isEmpty(){
        return (finalFila == 0);
    }
    public boolean isFull(){
        return(finalFila == vetorInt.length);
    }
    public int addQueue(int novoItemAdd){
        if(isFull()){
            System.out.println("Fila cheia, impossivel adicionar.");
            return 0;
        }
        vetorInt[finalFila] = novoItemAdd;
        finalFila++;
        return 1;
    }
    public int removeQueue(){
        if(isEmpty()){
            return 0;
        }
        int itemRemovidoFila = vetorInt[0];
        for (int i = 0; i < finalFila; i++) {
            if(i == finalFila-1){
                vetorInt[i] = 0;
            }else{
                vetorInt[i] = vetorInt[i+1];
            }
        }
       finalFila--; 
       return itemRemovidoFila;
    }
    public void printNumFila(){
        for (int i = 0; i < finalFila; i++) {
            System.out.print(vetorInt[i]);
        }
        System.out.println();
    }
}
