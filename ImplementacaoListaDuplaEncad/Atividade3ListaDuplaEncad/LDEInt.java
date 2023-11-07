package Atividade3ListaDuplaEncad;

public class LDEInt {
    private LDENodeInt firstNode;
    private LDENodeInt lastNode;
    private int qtdNode;

    public int getQtdNode() {
        return qtdNode;
    }
    public LDENodeInt getFirstNode() {
        return firstNode;
    }
    
    public boolean isEmpty() {
        return firstNode == null && lastNode == null && qtdNode == 0;
    }

    public void insertNode(int dataNewNode) {
        LDENodeInt novoNode = new LDENodeInt(dataNewNode);
        if (isEmpty()) {
            firstNode = novoNode;
            lastNode = novoNode;
        } 
        else if(firstNode.getNextAdressNode() == null){
            firstNode.setNextAdressNode(novoNode);
            lastNode = novoNode;
            lastNode.setPreviosAdressNode(firstNode);

        }
        else {
            LDENodeInt auxNode = firstNode;
            while(auxNode != null){
                if(auxNode.getNextAdressNode() == null){
                    auxNode.setNextAdressNode(novoNode);
                    lastNode = novoNode;
                    lastNode.setPreviosAdressNode(auxNode);
                    qtdNode++;
                    return;
                }
                auxNode = auxNode.getNextAdressNode();
            }
        }
        qtdNode++;
    }

    public int removeRepetNode(int dataNode) {
        if(isEmpty()){
            return 0;
        }else if(firstNode.getDataNode() == dataNode && firstNode.getNextAdressNode() == null){
            firstNode = null;
            lastNode = null;
            qtdNode--;
            return 1;
        }
        int qtdValueInList = 0;
        LDENodeInt auxNode = firstNode;
        while(auxNode != null){
            if(auxNode.getDataNode() == dataNode){
                qtdValueInList++;
                if(auxNode == firstNode){
                    auxNode.getNextAdressNode().setPreviosAdressNode(null);
                    firstNode = auxNode.getNextAdressNode();
                }else{
                    auxNode.getPreviosAdressNode().setNextAdressNode(auxNode.getNextAdressNode());
                }
                if(auxNode == lastNode){
                    auxNode.getPreviosAdressNode().setNextAdressNode(null);
                    lastNode = auxNode.getPreviosAdressNode();
                }else{
                    auxNode.getNextAdressNode().setPreviosAdressNode(auxNode.getPreviosAdressNode());
                }
                qtdNode--;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return qtdValueInList;
    }

    public void insertNodeWithoutRepet(int numberToInsert){
        if(isEmpty()){
            firstNode = new LDENodeInt(numberToInsert);
            lastNode = new LDENodeInt(numberToInsert);
            qtdNode++;
            return;
        }
        else if(firstNode.getDataNode() == numberToInsert){
            System.out.println("Valor repetido, não inserido.");
            return;
        }
        else if(lastNode.getDataNode() == numberToInsert){
            System.out.println("Valor repetido, não inserido.");
            return;
        }
        else{
            LDENodeInt novoNode = new LDENodeInt(numberToInsert);
            LDENodeInt auxNode = firstNode;
            while(auxNode != null){
                if(auxNode.getDataNode() == numberToInsert){
                    System.out.println("Valor repetido, não inserido.");
                    return;
                }
                else if(auxNode.getNextAdressNode() == null){
                    auxNode.setNextAdressNode(novoNode);
                    lastNode = novoNode;
                    lastNode.setPreviosAdressNode(auxNode);
                    qtdNode++;
                    return;
                }
                auxNode = auxNode.getNextAdressNode();
            }
        }
    }

    public LDEInt intersection(LDEInt otherList){
        if(isEmpty() || otherList.isEmpty()){
            return null;
        }
        LDEInt intersectedList = new LDEInt();
        LDENodeInt auxNode = firstNode;
        LDENodeInt auxNode2 = otherList.getFirstNode();
        if(qtdNode < otherList.getQtdNode()){
            while(auxNode != null){
                while(auxNode2 != null){
                    if(auxNode.getDataNode() == auxNode2.getDataNode()){
                        intersectedList.insertNodeWithoutRepet(auxNode.getDataNode());
                    }
                    auxNode2 = auxNode2.getNextAdressNode();
                }
                auxNode = auxNode.getNextAdressNode();
            }
        }else{
            while(auxNode2 != null){
                while(auxNode != null){
                    if(auxNode2.getDataNode() == auxNode.getDataNode()){
                        intersectedList.insertNodeWithoutRepet(auxNode2.getDataNode());
                    }
                    auxNode = auxNode.getNextAdressNode();
                }
                auxNode2 = auxNode2.getNextAdressNode();
            }
        }
        return intersectedList;
    }

    public LDEInt union(LDEInt otherList){
        LDEInt unionList = new LDEInt();
        if(isEmpty() && otherList.isEmpty()){
            return unionList;
        }else if(isEmpty() && !otherList.isEmpty()){
            return otherList;
        }else if(!isEmpty() && otherList.isEmpty()){
            return this;
        }
        LDENodeInt auxNode = firstNode;
        while(auxNode!=null){
            unionList.insertNodeWithoutRepet(auxNode.getDataNode());
            auxNode = auxNode.getNextAdressNode();
        }
        auxNode = otherList.getFirstNode();
        while(auxNode!=null){
            unionList.insertNodeWithoutRepet(auxNode.getDataNode());
            auxNode = auxNode.getNextAdressNode();
        }
        return unionList;
    }

    public LDEInt difference(LDEInt otherList){
        LDEInt differenceList = new LDEInt();
        if(isEmpty() && otherList.isEmpty()){
            return differenceList;
        }else if(isEmpty() && !otherList.isEmpty()){
            return differenceList;
        }else if(!isEmpty() && otherList.isEmpty()){
            return this;
        }
        LDENodeInt auxNode = firstNode;
        while(auxNode!=null){
            if(!otherList.searchInList(auxNode.getDataNode())){
                differenceList.insertNodeWithoutRepet(auxNode.getDataNode());
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return differenceList;
    }

    public boolean searchInList(int numberToSearch){
        LDENodeInt auxNode = firstNode;
        while(auxNode!=null){
            if(auxNode.getDataNode() == numberToSearch){
                return true;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return false;
    }
    public void printAllItensInList(){
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        LDENodeInt auxNode = firstNode;
        while(auxNode!=null){
            System.out.println(auxNode.getDataNode());
            auxNode = auxNode.getNextAdressNode();
        }
    }
}
