package ListaArvoreB;

public class Retorno {
    private NodeB filhoDir;
    private boolean h;
    private int info;

    void setFilhoDir(NodeB f) {
        this.filhoDir = f;
    }

    NodeB getFilhoDir() {
        return this.filhoDir;
    }

    void setH(boolean h) {
        this.h = h;
    }

    boolean getH() {
        return this.h;
    }

    void setInfo(int info) {
        this.info = info;
    }

    int getInfo() {
        return this.info;
    }
}