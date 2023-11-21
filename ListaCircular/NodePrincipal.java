package ListaCircular;

public class NodePrincipal {
    private Categoria info;
    private NodePrincipal ante;
    private NodePrincipal prox;

    public NodePrincipal(Categoria info){
        this.info = info;
    }

    public Categoria getInfo() {
        return info;
    }

    public NodePrincipal getAnte() {
        return ante;
    }

    public NodePrincipal getProx() {
        return prox;
    }

    public void setAnte(NodePrincipal ante) {
        this.ante = ante;
    }

    public void setProx(NodePrincipal prox) {
        this.prox = prox;
    }
}
