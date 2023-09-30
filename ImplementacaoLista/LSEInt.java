package ImplementacaoLista;

public class LSEInt {
    protected LSENode firstNode;

    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }
    public LSENode getFirstNode() {
        return firstNode;
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
    public void insertEndList(int valueNewNode){
        LSENode newNode = new LSENode(valueNewNode);
        if (isEmpty()) {
            firstNode = newNode;
            return;
        }
        LSENode auxNode = firstNode;
        while(true){
            if(auxNode.getAdressNextNode() == null){
                auxNode.setAdressNextNode(newNode);
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
    }
    public LSEInt copiar(){
        LSEInt copiedList = new LSEInt();
        LSENode auxNode = firstNode;
        while (auxNode != null) {
            copiedList.insertEndList(auxNode.getDataNode());
            auxNode = auxNode.getAdressNextNode();
        }

        return copiedList;
    }
    public void soma(LSEInt list1, LSEInt list2, LSEInt listSum){
        if(list1.isEmpty){
            listSum = list2.copiar();
        }
        if(list2.isEmpty()){
            listSum = list1.copiar();
        }
        LSEInt auxNodeList1 = list1.getFirstNode();
        LSEInt auxNodeList2 = list2.getFirstNode();

        while (auxNodeList1 != null && auxNodeList2 != null){
            
        }
    }
}