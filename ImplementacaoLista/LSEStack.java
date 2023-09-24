package ImplementacaoLista;

public class LSEStack {
    private LSENode topNode;
    /*
    private int maxLengthStack;
    public LSEStack(int maxLengthStack){
        this.maxLengthStack = maxLengthStack;
    }
    public LSEStack(){
        maxLengthStack = 20;
    }
    */
    public void pushNode(int valueNewNode){
        LSENode newNode = new LSENode(valueNewNode);
        if(isEmpty()){
            topNode = newNode;
        }
        newNode.setAdressNextNode(topNode);
        topNode = newNode;
        System.out.println("Inserido com sucesso!");
    }
    public LSENode popNode(){
        if(!isEmpty()){
            LSENode removedNode = topNode;
            topNode = topNode.getAdressNextNode();
            return removedNode;
        }
        return null;
    }
    public LSENode topNode() {
        return topNode;
    }
    public boolean isEmpty(){
        if(topNode == null){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        /* 
        int countNodeIntStack = 0;
        LSENode auxNode = topNode;
        while(auxNode != null){
            if(countNodeIntStack == maxLengthStack){
                return true;
            }
            countNodeIntStack++;
        }
        */
        return false;
    }
}
