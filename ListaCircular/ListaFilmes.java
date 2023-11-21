package ListaCircular;

public class ListaFilmes {
    private NodeSecundario primeiro;
    private NodeSecundario ultimo;
    private int qtd;
    public boolean isEmpty(){
        return primeiro == null && ultimo == null && qtd == 0;
    }
    public void exibirFilmes() {
        if(isEmpty()){
            return ;
        }
        NodeSecundario auxFilme = this.primeiro;
        for (int i = 0; i < this.qtd; i++) {
            System.out.println(auxFilme.getInfo());
            auxFilme = auxFilme.getProx();
        }

    }

    public NodeSecundario getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NodeSecundario primeiro) {
        this.primeiro = primeiro;
    }

    public NodeSecundario getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodeSecundario ultimo) {
        this.ultimo = ultimo;
    }

    public int getQtd() {
        return qtd;
    }

    public void inserirFilmeOrdenado(Filme novoFilme){
        NodeSecundario novoNode = new NodeSecundario(novoFilme);
        if(isEmpty()){
            primeiro = novoNode;
            ultimo = novoNode;
            this.qtd++;
            return;
        }
        if(this.primeiro.getInfo().compareTo(novoFilme) == 0 || this.ultimo.getInfo().compareTo(novoFilme) == 0){
            //para não inserir filmes repetidos
            return;
        }
        NodeSecundario auxNodeSecundario = this.primeiro;
        while(auxNodeSecundario != null){
            if(auxNodeSecundario.getInfo().compareTo(novoFilme) == 0){
                //para não inserir filmes repetidos
                return;
            }
            else if(auxNodeSecundario == this.ultimo && auxNodeSecundario.getProx() == this.primeiro){
                this.ultimo.setProx(novoNode);
                novoNode.setProx(this.primeiro);
                novoNode.setAnte(this.ultimo);
                this.primeiro.setAnte(novoNode);
                this.ultimo = novoNode;
                this.qtd++;
                return;
            }
            if(auxNodeSecundario.getInfo().compareTo(novoFilme) > 0 &&
            auxNodeSecundario.getProx().getInfo().compareTo(novoFilme) < 0){
                auxNodeSecundario.setProx(novoNode);
                auxNodeSecundario.getProx().setAnte(novoNode);
                novoNode.setAnte(auxNodeSecundario);
                novoNode.setProx(auxNodeSecundario.getProx());
                this.qtd++;
            }
            auxNodeSecundario = auxNodeSecundario.getProx();
        }
    }
    public void removerFilme(String nomeFilme){
        if(isEmpty()){
            return;
        }
        NodeSecundario filmeParaRemover = buscarFilme(nomeFilme);
        if(filmeParaRemover == null){
            return;
        }
        if(filmeParaRemover == primeiro){
            if(this.qtd == 2){
                this.ultimo.setAnte(null);
                this.ultimo.setAnte(null);
                this.primeiro = this.ultimo;
                this.qtd--;
                return;
            }
            primeiro.getProx().setAnte(ultimo);
            ultimo.setProx(primeiro.getProx());
            primeiro = primeiro.getProx();
            this.qtd--;
            return;
        }
        if(filmeParaRemover == ultimo){
            if (this.qtd == 2){
                this.primeiro.setAnte(null);
                this.primeiro.setAnte(null);
                this.ultimo = null;
                this.qtd--;
                return;
            }
            ultimo.getAnte().setProx(primeiro);
            primeiro.setAnte(ultimo.getAnte());
            ultimo = ultimo.getAnte();
            this.qtd--;
            return;
        }
        filmeParaRemover.getProx().setAnte(filmeParaRemover.getAnte());
        filmeParaRemover.getAnte().setProx(filmeParaRemover.getProx());
    }

    public NodeSecundario buscarFilme(String nomeFilme){
        if(isEmpty()){
            return null;
        }
        NodeSecundario auxNodeFilme = this.primeiro;
        for (int i = 0; i < this.qtd; i++) {
            if(auxNodeFilme.getInfo().getTitulo().equals(nomeFilme)){
                return auxNodeFilme;
            }
            auxNodeFilme = auxNodeFilme.getProx();
        }
        return null;
    }
}
