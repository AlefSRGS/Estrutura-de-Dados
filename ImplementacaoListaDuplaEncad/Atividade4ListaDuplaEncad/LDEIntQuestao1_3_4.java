package ImplementacaoListaDuplaEncad.Atividade4ListaDuplaEncad;

import ImplementacaoListaDuplaEncad.Atividade3ListaDuplaEncad.LDENodeInt;

public  class LDEIntQuestao1_3_4 {
    private LDENodeInt primeiro;
    private LDENodeInt ultimo;

    public boolean isEmpty() {
        return this.primeiro == null && this.ultimo == null;
    }

    //primeira questao:
    public void insertWithRepeat(int newValueNode) {
        LDENodeInt newNode = new LDENodeInt(newValueNode);
        //lista estando vazia
        if (isEmpty()) {
            this.primeiro = newNode;
            this.ultimo = newNode;
            return;
        }
        //tendo apenas 1 item na lista
        else if(this.primeiro.compareTo(this.ultimo) == 0 && this.primeiro.getNextAdressNode() == null) {
            //o primeiro sendo maior ou igual ao valor a ser inserido
            if(this.primeiro.compareTo(newNode) >= 0) {
                newNode.setNextAdressNode(this.primeiro);
                this.primeiro = newNode;
                newNode.getNextAdressNode().setPreviosAdressNode(this.primeiro);
                this.ultimo = newNode.getNextAdressNode();
            //o primeiro sendo menor que o valor a ser inserido
            }else {
                this.primeiro.setNextAdressNode(newNode);
                newNode.setPreviosAdressNode(this.primeiro);
                this.ultimo = newNode;
                return;
            }
        }
        LDENodeInt auxNode = this.primeiro.getNextAdressNode();
        while (auxNode != null) {
            if(auxNode.compareTo(newNode) >= 0){
                newNode.setPreviosAdressNode(auxNode.getPreviosAdressNode());
                newNode.setNextAdressNode(auxNode);
                auxNode.getPreviosAdressNode().setNextAdressNode(newNode);
                auxNode.setPreviosAdressNode(newNode);
                return;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        newNode.setPreviosAdressNode(this.ultimo);
        this.ultimo.setNextAdressNode(newNode);
        newNode = this.ultimo;
    }

    //terceira questao:
    public void removeCopys(int valueToRemove){
        if (isEmpty()) {
            return;
        } else if (primeiro.getDataNode() == valueToRemove && primeiro.getNextAdressNode() == null) {
            this.primeiro = null;
            this.ultimo = null;
            return;
        }
        LDENodeInt auxNode = primeiro;
        while (auxNode != null) {
            if (auxNode.getDataNode() == valueToRemove) {
                if (auxNode == primeiro) {
                    auxNode.getNextAdressNode().setPreviosAdressNode(null);
                    primeiro = auxNode.getNextAdressNode();
                } else {
                    auxNode.getPreviosAdressNode().setNextAdressNode(auxNode.getNextAdressNode());
                }
                if (auxNode == ultimo) {
                    auxNode.getPreviosAdressNode().setNextAdressNode(null);
                    ultimo = auxNode.getPreviosAdressNode();
                } else {
                    auxNode.getNextAdressNode().setPreviosAdressNode(auxNode.getPreviosAdressNode());
                }
            }
            //para uma lista em ordem crescente
            if(auxNode.getNextAdressNode().getDataNode() > valueToRemove){
                return;
            }
            auxNode = auxNode.getNextAdressNode();
        }
    }
    //quarta questao:
    public LDENodeInt searchNode(int valueToSearch){
        if(isEmpty()){
            return null;
        }
        else if(primeiro.getDataNode() == valueToSearch){
            return primeiro;
        } else if (ultimo.getDataNode() == valueToSearch) {
            return ultimo;
        }
        LDENodeInt auxNode = this.primeiro.getNextAdressNode();
        while(auxNode!=null){
            if(auxNode.getDataNode() == valueToSearch){
                return auxNode;
            }
            //apenas para lista em ordem decrescente
            if(auxNode.getDataNode() < valueToSearch){
                return null;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return null;
    }

    public void removeNodeInt(int valueToRemove){
        LDENodeInt nodeToRemove = searchNode(valueToRemove);
        if(nodeToRemove == primeiro){
            nodeToRemove.getNextAdressNode().setPreviosAdressNode(null);
            primeiro = nodeToRemove.getNextAdressNode();
        }else{
            nodeToRemove.getPreviosAdressNode().setNextAdressNode(nodeToRemove.getNextAdressNode());
        }
        if (nodeToRemove == ultimo) {
            nodeToRemove.getPreviosAdressNode().setNextAdressNode(null);
            ultimo = nodeToRemove.getPreviosAdressNode();
        }else {
            nodeToRemove.getNextAdressNode().setPreviosAdressNode(nodeToRemove.getPreviosAdressNode());
        }
    }

}