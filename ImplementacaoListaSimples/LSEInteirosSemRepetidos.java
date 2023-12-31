

public class LSEInteirosSemRepetidos extends LSEInt{
    @Override
    public void insertFirst(int valueNewNode){
        LSENode newNode = new LSENode(valueNewNode);
        if (isEmpty()) {
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        if(searchDataInList(valueNewNode) == null){
            newNode.setAdressNextNode(firstNode);
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        System.out.println("Valores repetidos não podem ser inseridos");
    }
    private LSENode searchDataInList(int valueForSearch){
        LSENode auxNode =  firstNode;
        while(auxNode != null){
            if(auxNode.getDataNode() == valueForSearch){
                return auxNode;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        return null;
    }
    public void insertEndListWithNoRepeat(int valueNewNode){
        LSENode newNode = new LSENode(valueNewNode);
        if (isEmpty()) {
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        LSENode auxNode = firstNode;
        while(auxNode.getDataNode() != valueNewNode){
            if(auxNode.getAdressNextNode() == null){
                auxNode.setAdressNextNode(newNode);
                System.out.println("Valor inserido");
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        System.out.println("Valores repetidos não podem ser inseridos.");
    }
    public void removeLastNode(){
        if(isEmpty()){
            System.out.println("Lista vazia nada a remover.");
            return;
        }
        if(firstNode.getAdressNextNode() == null){
            removeFirstNode();
            return;
        }
        LSENode auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getAdressNextNode().getAdressNextNode() == null){
                auxNode.setAdressNextNode(null);
                System.out.println("Removido com sucesso.");
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
    }
    public void removeChoseNode(int valor){
        if(isEmpty()){
            System.out.println("Lista vazia nada a remover.");
            return;
        }
        if(firstNode.getDataNode() == valor){
            removeFirstNode();
            System.out.println("Removido com sucesso.");
            return;
        }
        LSENode auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getAdressNextNode().getAdressNextNode() == null){ //testa se o ultimo node é o escolhido
                auxNode.setAdressNextNode(null);
                System.out.println("Removido com sucesso.");
            }
            if(auxNode.getAdressNextNode().getDataNode() == valor){
                auxNode.setAdressNextNode(auxNode.getAdressNextNode().getAdressNextNode());
                System.out.println("Removido com sucesso.");
                return;
            }
        }
    }
}
