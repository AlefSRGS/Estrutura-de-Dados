package ListaArvoreAVL;

class AVLNode<T extends Comparable<T>> {
    private AVLNode<T> left;
    private AVLNode<T> right;
    private T info;
    private int fatBal;

    AVLNode(T info){
        this.info = info;
    }
    void setInfo(T info) {
        this.info = info;
    }
    T getInfo() {
        return info;
    }
    void setLeft(AVLNode<T> left) {
        this.left = left;
    }
    void setRight(AVLNode<T> right) {
        this.right = right;
    }

    AVLNode<T> getLeft() {
        return left;
    }
    AVLNode<T> getRight() {
        return right;
    }
    int getFatBal() {
        return fatBal;
    }
    void setFatBal(int fatBal) {
        this.fatBal = fatBal;
    }
    public int compareTo(T valor) {
        return 0;
    }
}
