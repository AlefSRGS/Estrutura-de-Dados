package JoaoeMariaLanches;

public class FilaPedidos {
    private Pedido[] vetorPedidos;
    private int finalFilaPedido;

    public FilaPedidos(){
        vetorPedidos = new Pedido[20]; 
    }
    public int getFinalFila() {
        return finalFilaPedido;
    }
    public boolean isEmpty(){
        return (finalFilaPedido == 0);
    }
    public boolean isFull(){
        return(finalFilaPedido == vetorPedidos.length);
    }
    public int addQueue(Pedido novoPedidoAdd){
        if(isFull()){
            System.out.println("Fila cheia, impossivel adicionar.");
            return 0;
        }
        vetorPedidos[finalFilaPedido] = novoPedidoAdd;
        finalFilaPedido++;
        return 1;
    }
    public Pedido removeQueue(){
        if(isEmpty()){
            return null;
        }
        Pedido PedidoRemovidoFila = vetorPedidos[0];
        for (int i = 0; i < finalFilaPedido; i++) {
            if(i == finalFilaPedido-1){
                vetorPedidos[i] = null;
            }else{
                vetorPedidos[i] = vetorPedidos[i+1];
            }
        }
       finalFilaPedido--; 
       return PedidoRemovidoFila;
    }
    public void printNumFila(){
        for (int i = 0; i < finalFilaPedido; i++) {
            System.out.print(vetorPedidos[i]);
        }
        System.out.println();
    }
}
