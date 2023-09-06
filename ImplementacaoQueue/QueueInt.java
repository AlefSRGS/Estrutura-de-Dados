package ImplementacaoQueue;

public class QueueInt {
    private int vetorInt[];
    private int finalFila;

    public void QueueInt(){
        int[] vetorInt = new int[20]; 
    }
    public void QueueInt(int lenghtVetor){
        int[] vetorInt = new int[lenghtVetor]; 
    }
    public boolean isEmpty(){
        return (finalFila == 0);
    }
    public boolean isFull(){
        return(finalFila == vetorInt.length);
    }
    public void addQueue(int novoItemAdd){
        if(isFull()){
            System.out.println("Fila cheio, impossivel adicionar.");
            return;
        }
        vetorInt[finalFila] = novoItemAdd;
        finalFila++;
    }
    public int removeQueue(){
        if(isEmpty()){
            return 0;
        }
        int itemRemovidoFila = vetorInt[0];
        for (int i = 0; i < finalFila+1; i++) {
            if(i == finalFila){
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
