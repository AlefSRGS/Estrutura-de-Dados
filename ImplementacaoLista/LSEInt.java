package ImplementacaoLista;

public class LSEInt {
    protected LSENode firstNode;

    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }

    public void insertFirst(int valueNewNode){
        LSENode newNode = new LSENode(valueNewNode);
        if(isEmpty()){
            firstNode = newNode;
        }
        newNode.setAdressNextNode(firstNode);
        firstNode = newNode;
        System.out.println("Inserido com sucesso!");
    }

    public void removeFirstNode(){
        if(!isEmpty()){
            firstNode = firstNode.getAdressNextNode();
            System.out.println("Removido com sucesso!");
            return;
        }
        System.out.println("Lista vazia, nada a remover");
    }

    public void showAll(){
        LSENode auxNode;
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        auxNode = firstNode;
        while(auxNode != null){
            System.out.println(auxNode.getDataNode());
            auxNode = auxNode.getAdressNextNode();
        }
    }

    public int countDataInList(int dataSought){
        if(isEmpty()){
            return 0;
        }
        int count = 0;
        LSENode auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getDataNode() == dataSought){
                count++;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        return count;
    }
}