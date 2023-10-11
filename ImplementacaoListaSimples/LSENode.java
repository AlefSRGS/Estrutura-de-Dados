

public class LSENode {

    private int dataNode;
    private LSENode adressNextNode;

    public LSENode(int dataNode){
        this.dataNode = dataNode;
    }
    
    public LSENode getAdressNextNode() {
        return adressNextNode;
    }
    public int getDataNode() {
        return dataNode;
    }
    public void setAdressNextNode(LSENode adressNextNode) {
        this.adressNextNode = adressNextNode;
    }
    public void setDataNode(int dataNode) {
        this.dataNode = dataNode;
    }
}
