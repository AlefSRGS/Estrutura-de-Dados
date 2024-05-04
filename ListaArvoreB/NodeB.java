package ListaArvoreB;

public class NodeB {
    private int n; // Número atual de chaves
    private int[] infos; // chaves int
    private NodeB[] filhos; // ponteros de referências para os filhos

    NodeB(int m) { // m = ordem
        infos = new int[m - 1]; // m - 1 chaves
        filhos = new NodeB[m]; // m filhos
    }

    void setN(int n) {
        this.n = n;
    }

    int getN() {
        return this.n;
    }

    int getInfo(int i) {
        return this.infos[i];
    }

    NodeB getFilho(int i) {
        return this.filhos[i];
    }

    void setInfo(int i, int value) {
        this.infos[i] = value;
    }

    void setFilho(int i, NodeB f) {
        this.filhos[i] = f;
    }

    void preencherRaiz(int value, NodeB r, NodeB filhoDir) {
        this.infos[0] = value;
        this.filhos[0] = r;
        this.filhos[1] = filhoDir;
        this.n = 1;
    }

    void inserirChave(int value, NodeB filhoDir) {
        int pos;
        int k = this.n;
        pos = buscaBinaria(value);
        while (k > pos) {
            this.filhos[k + 1] = this.filhos[k];
            this.infos[k] = this.infos[k - 1];
            k--;
        }
        this.infos[pos] = value;
        this.filhos[pos + 1] = filhoDir;
        this.n++;
    }

    int buscaBinaria(int value) {
        int meio, i = 0, f = this.n - 1;
        while (i <= f) {
            meio = (i + f) / 2;
            if (value == this.infos[meio]) {
                return meio;
            } else if (value < this.infos[meio]) {
                f = meio - 1;
            } else {
                i = meio + 1;
            }
        }
        return i;
    }

    public void percorrerEmOrdem() {
        for (int i = 0; i < this.n; i++) {
            if (this.filhos[i] != null) {
                this.filhos[i].percorrerEmOrdem();
            }
            System.out.println(this.infos[i]);
        }
        if (this.filhos[this.n] != null) {
            this.filhos[this.n].percorrerEmOrdem();
        }
    }
}
