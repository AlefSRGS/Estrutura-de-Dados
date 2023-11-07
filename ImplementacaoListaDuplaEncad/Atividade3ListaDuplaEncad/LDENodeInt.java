package Atividade3ListaDuplaEncad;

public class LDENodeInt implements Comparable<LDENodeInt> {
    private int dataNode;
    private LDENodeInt nextAdressNode;
    private LDENodeInt previosAdressNode;

    public LDENodeInt(int dataNode) {
        this.dataNode = dataNode;
    }
    public int getDataNode() {
        return dataNode;
    }
    public LDENodeInt getNextAdressNode() {
        return nextAdressNode;
    }
    public LDENodeInt getPreviosAdressNode() {
        return previosAdressNode;
    }
    public void setDataNode(int dataNode) {
        this.dataNode = dataNode;
    }
    public void setNextAdressNode(LDENodeInt nextAdressNode) {
        this.nextAdressNode = nextAdressNode;
    }
    public void setPreviosAdressNode(LDENodeInt previosAdressNode) {
        this.previosAdressNode = previosAdressNode;
    }

    @Override
    public int compareTo(LDENodeInt otherNode) {
        if(getDataNode() > otherNode.getDataNode()){
            return 1;
        } else if (getDataNode() < otherNode.getDataNode()) {
            return -1;
        }
        return 0;
    }
}
