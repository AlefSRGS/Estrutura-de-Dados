package ImplementacaoListaDuplaEncad;

public class LDEQueue {
    private LDENode firstNode;

    public void enQueue(LDENode newNode){
        if (isEmpty()) {
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        LDENode auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getAdressNextNode() == null){
                auxNode.setAdressNextNode(newNode);
                newNode.setAdressPreviosNode(auxNode);
                System.out.println("Valor inserido");
            }
            auxNode = auxNode.getAdressNextNode();
        }
    }

    public LDENode deQueue(){
        LDENode itemRemovido = firstNode;
        firstNode = firstNode.getAdressNextNode();
        firstNode.setAdressPreviosNode(null);
        System.out.println("Removido com sucesso!");
        return itemRemovido;
    }

    public LDENode head() {
        return firstNode;
    }

    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        return false;
    }
}
