

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

    public void somar(LSEInt list1, LSEInt list2){
        if(list1.isEmpty() && list2.isEmpty()){
            System.out.println("As duas listas estao vazias, nada a somar.");
            return;
        }
        LSENode auxNodeList1 = list1.getFirstNode();
        LSENode auxNodeList2 = list2.getFirstNode();
        int valueNodeList1Sum = 0, valueNodeList2Sum = 0;
        while (auxNodeList1 != null || auxNodeList2 != null){
            if(auxNodeList1 == null){
                valueNodeList1Sum = 0;
            }else{
                valueNodeList1Sum = auxNodeList1.getDataNode();
                auxNodeList1 = auxNodeList1.getAdressNextNode();
            }
            if(auxNodeList2 == null){
                valueNodeList2Sum = 0;
            }else{
                valueNodeList2Sum = auxNodeList2.getDataNode();
                auxNodeList2 = auxNodeList2.getAdressNextNode();
            }
            insertEndList(valueNodeList1Sum + valueNodeList2Sum);
        }
    }
}