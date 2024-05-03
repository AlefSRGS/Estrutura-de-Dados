class NodeB<T extends Comparable<T>> {
    private int n;
    private T[] infos;
    private NodeB[] filhos;

    NodeB(int m) {
        infos = new Object[m];
        filhos = new NodeB[m];
    }

    void setN(int n) {
        this.n = n;
    }

    int getN() {
        return this.n;
    }

    T getInfo(int i) {
        return (T) this.infos[i];
    }

    NodeB getFilho(int i) {
        return this.filhos[i];
    }

    void setInfo(int i, Object value) {
        this.infos[i] = value;
    }

    void setFilho(int i, NodeB f) {
        this.filhos[i] = f;
    }

    void preencherRaiz(Object value, NodeB r, NodeB filhoDir) {
        this.infos[0] = value;
        this.filhos[0] = r;
        this.filhos[1] = filhoDir;
        this.n = 1;
    }

    void insereChave(T value, NodeB filhoDir) {
        int pos;
        int k = this.n;
        pos = buscaBinaria(value);
        while (k > pos && value.compareTo((T) this.infos[k - 1]) < 0) {
            this.filhos[k + 1] = this.filhos[k];
            this.infos[k] = this.infos[k - 1];
            k--;
        } // insere a chave na posição ideal
        this.infos[pos] = value;
        this.filhos[pos + 1] = filhoDir;
        this.n++;
    }

    int buscaBinaria(T value) {
        int meio, i, f, compara;
        i = 0;
        f = this.n - 1;
        while (i <= f) {
            meio = (i + f) / 2;
            compara = value.compareTo((T) this.infos[meio]);
            if (compara == 0) {
                return meio;
            } else if (compara < 0) {
                f = meio - 1;
            } else {
                i = meio + 1;
            }
        }
        return i;
    }

    public void percorrerEmOrdem() {
        int i;
        for (i = 0; i < this.n; i++) {
            if (this.filhos[i] != null) {
                this.filhos[i].percorrerEmOrdem();
            }
            System.out.println(this.infos[i]);
        }
        if (this.filhos[i] != null) {
            this.filhos[i].percorrerEmOrdem();
        }
    }
}

public class BTree<T extends Comparable<T>> {
    private NodeB<T> root;
    private final int ordem;
    private final int nChaves;
    private final int minimo;

    public BTree(int m) {
        this.ordem = m;
        this.nChaves = m - 1;
        this.minimo = m / 2;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T info) {
        T infoRetorno;
        if (this.isEmpty() == true) {
            this.root = new NodeB(this.ordem);
            this.root.preencherRaiz(info, null, null);
        } else {
            Retorno result = new Retorno();
            insertB(this.root, info, result);
            boolean h = result.getH();
            if (h) {      
                filhoDir = result.getFilhoDir();
                infoRetorno = (T)result.getInfo();
                NodeB novaRaiz = new NodeB(this.ordem);
                novaRaiz.preencherRaiz(infoRetorno, this.root, filhoDir);
                this.root = novaRaiz;
            }
        }
    }

private void insertB(NodeB raiz, T info, Retorno result) {
    int i, pos;
    T infoMediano;        
    NodeB filhoDir;             
    if (raiz == null) {
        chaveresult.setH(true);
        result.setInfo(info);
    } else {
        pos = raiz.buscaBinaria(info);
        if (pos < raiz.getN() && raiz.getInfo(pos) == info) {
            System.out.println("Chave já contida na árvore");
            result.setH(false);
        } else {    
            this.insertB(raiz.getFilho(pos), info, result);
            if (result.getH()) {   
                if (raiz.getN() < this.nChaves) {    
                    raiz.insereChave(result.getInfo(), result.getFilhoDir());
                    result.setH(false);
                } else {    
                    temp = new NodeB(this.ordem);
                    infoMediano = (T)raiz.getInfo(this.minimo + 1);
                    temp.setFilho(0, raiz.getFilho(this.minimo + 1));
                    for (i = this.minimo + 1; i < this.nChaves; i++) {
                        temp.insereChave(raiz.getInfo(i), raiz.getFilho(i + 1));
                    }
                    for (i = this.minimo + 1; i < this.nChaves; i++) {
                        raiz.setInfo(i, null);
                        raiz.setFilho(i + 1, null);
                    }
                    raiz.setN(this.minimo);
                    if (pos <= this.minimo) {
                        raiz.insereChave(result.getInfo(), result.getFilhoDir());
                    } else {
                        temp.insereChave(result.getInfo(), result.getFilhoDir());
                    }
                    mediano.result.setInfo(infoMediano);
                    result.setFilhoDir(temp);
                }
            }
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == false) {
            root.percorrerEmOrdem();
        } else {
            System.out.println("Árvore vazia");
        }
    }

    public class Retorno<T extends Comparable<T>> {
        private NodeB filhoDir;
        private boolean h;
        private T info;

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

        void setInfo(T info) {
            this.info = info;
        }

        T getInfo() {
            return this.info;
        }
    }
}