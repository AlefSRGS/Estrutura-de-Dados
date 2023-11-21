package ImplementacaoListaDuplaEncad.Atividade2ListaDuplaEncad;

public class LDENodePessoa {
    private Pessoa dataNode;
    private LDENodePessoa nextAdressNode;
    private LDENodePessoa previosAdressNode;

    public LDENodePessoa(Pessoa dataNode) {
        this.dataNode = dataNode;
    }

    public Pessoa getDataNode() {
        return dataNode;
    }   
    public LDENodePessoa getNextAdressNode() {
        return nextAdressNode;
    }
    public LDENodePessoa getPreviosAdressNode() {
        return previosAdressNode;
    }
    public void setNextAdressNode(LDENodePessoa nextAdressNode) {
        this.nextAdressNode = nextAdressNode;
    }
    public void setPreviosAdressNode(LDENodePessoa previosAdressNode) {
        this.previosAdressNode = previosAdressNode;
    }
}