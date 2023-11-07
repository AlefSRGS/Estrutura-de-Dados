package Atividade4ListaDuplaEncad;

import Atividade3ListaDuplaEncad.LDENodeInt;

public  class LDEInt4Questao {
    private LDENodeInt primeiro;
    private LDENodeInt ultimo;

    public boolean isEmpty() {
        return this.primeiro == null && this.ultimo == null;
    }
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


}