
package Atividade1ListaDuplaEncad;

public class LDEInteirosSemRepetidos {
    private LDENode firstNode;

    public boolean isEmpty(){
        if(firstNode == null){
            return true;
        }
        return false;
    }

    public void insertFirstWithNoRepeat(int valueNewNode){
        LDENode newNode = new LDENode(valueNewNode);
        if (isEmpty()) {
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        if(searchDataInList(valueNewNode) == null){
            firstNode.setAdressPreviosNode(newNode);
            newNode.setAdressNextNode(firstNode);
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        System.out.println("Valores repetidos não podem ser inseridos");
    }

    public void insertEndListWithNoRepeat(int valueNewNode){
        LDENode newNode = new LDENode(valueNewNode);
        if (isEmpty()) {
            firstNode = newNode;
            System.out.println("Valor inserido");
            return;
        }
        LDENode auxNode = firstNode;
        while(auxNode.getDataNode() != valueNewNode){
            if(auxNode.getAdressNextNode() == null){
                auxNode.setAdressNextNode(newNode);
                newNode.setAdressPreviosNode(auxNode);
                System.out.println("Valor inserido");
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        System.out.println("Valores repetidos não podem ser inseridos.");
    }

    public void removeFirstNode(){
        if(!isEmpty()){
            firstNode = firstNode.getAdressNextNode();
            firstNode.setAdressPreviosNode(null);
            System.out.println("Removido com sucesso!");
            return;
        }
        System.out.println("Lista vazia, nada a remover");
    }

    public void removeLastNode(){
        if(isEmpty()){
            System.out.println("Lista vazia nada a remover.");
            return;
        }
        LDENode auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getAdressNextNode().getAdressNextNode() == null){
                auxNode.setAdressNextNode(null);
                System.out.println("Removido com sucesso.");
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
    }

    public void showAll(){
        LDENode auxNode;
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
        LDENode adressNodeRemove = searchDataInList(valor);
        if(adressNodeRemove != null){
            adressNodeRemove.getAdressPreviosNode().setAdressNextNode(adressNodeRemove.getAdressNextNode()); //muda o valor do atributo 'adressNextNode' do node anterior ao qual se deseja remover, para o valor do atributo 'adressNextNode' do node que se deseja remover 
            adressNodeRemove.getAdressNextNode().setAdressPreviosNode(adressNodeRemove.getAdressPreviosNode()); //muda o valor do atributo 'adressPreviosNode' do node posterior ao qual se deseja remover, para o valor do atributo 'adressPreviosNode' do node que se deseja remover 
            System.out.println("Removido com sucesso.");
            return;
        }
        System.out.println("Valor inserido não existe na lista.");
    }

    public LDENode searchDataInList(int valueForSearch){
        LDENode auxNode =  firstNode;
        while(auxNode != null){
            if(auxNode.getDataNode() == valueForSearch){
                return auxNode;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        return null;
    }
}