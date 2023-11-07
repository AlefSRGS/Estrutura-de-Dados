package Atividade1ListaDuplaEncad;

public class LDENode {
    private int dataNode;
    private LDENode adressNextNode;
    private LDENode adressPreviosNode;

    public LDENode(int dataNode){
        this.dataNode = dataNode;
    }
    
    public LDENode getAdressNextNode() {
        return adressNextNode;
    }
    public int getDataNode() {
        return dataNode;
    }
    public void setAdressNextNode(LDENode adressNextNode) {
        this.adressNextNode = adressNextNode;
    }
    public void setDataNode(int dataNode) {
        this.dataNode = dataNode;
    }
    public LDENode getAdressPreviosNode() {
        return adressPreviosNode;
    }
    public void setAdressPreviosNode(LDENode adressPreviosNode) {
        this.adressPreviosNode = adressPreviosNode;
    }
}