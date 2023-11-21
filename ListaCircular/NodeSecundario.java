package ListaCircular;

public class NodeSecundario {
    private Filme info;
    private NodeSecundario ante;
    private NodeSecundario prox;

    public NodeSecundario(Filme info){
        this.info = info;
    }
    public Filme getInfo() {
        return info;
    }

    public NodeSecundario getAnte() {
        return ante;
    }

    public void setAnte(NodeSecundario ante) {
        this.ante = ante;
    }

    public NodeSecundario getProx() {
        return prox;
    }

    public void setProx(NodeSecundario prox) {
        this.prox = prox;
    }
}
