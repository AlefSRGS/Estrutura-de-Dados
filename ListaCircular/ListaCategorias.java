package ListaCircular;

public class ListaCategorias {
    private NodePrincipal primeiro;
    private NodePrincipal ultimo;
    private int qtd;
    public boolean isEmpty(){
        return primeiro == null && ultimo == null && qtd == 0;
    }
    public void inserirCategoriaOrdenada(Categoria novaCategoria){
        NodePrincipal novoNode = new NodePrincipal(novaCategoria);
        if(isEmpty()){
            primeiro = novoNode;
            ultimo = novoNode;
            this.qtd++;
            return;
        }
        if(this.primeiro.getInfo().compareTo(novaCategoria) == 0 || this.ultimo.getInfo().compareTo(novaCategoria) == 0){
            //para não inserir filmes repetidos
            return;
        }
        NodePrincipal auxNodePrincipal = this.primeiro;
        while(auxNodePrincipal != null){
            if(auxNodePrincipal.getInfo().compareTo(novaCategoria) == 0){
                //para não inserir filmes repetidos
                return;
            }
            else if(auxNodePrincipal == this.ultimo && auxNodePrincipal.getProx() == this.primeiro){
                this.ultimo.setProx(novoNode);
                novoNode.setProx(this.primeiro);
                novoNode.setAnte(this.ultimo);
                this.primeiro.setAnte(novoNode);
                this.ultimo = novoNode;
                this.qtd++;
                return;
            }
            if(auxNodePrincipal.getInfo().compareTo(novaCategoria) > 0 &&
                    auxNodePrincipal.getProx().getInfo().compareTo(novaCategoria) < 0){
                auxNodePrincipal.setProx(novoNode);
                auxNodePrincipal.getProx().setAnte(novoNode);
                novoNode.setAnte(auxNodePrincipal);
                novoNode.setProx(auxNodePrincipal.getProx());
                this.qtd++;
            }
            auxNodePrincipal = auxNodePrincipal.getProx();
        }
    }
    public void removerCategoria(String nomeCategoria){
        if(isEmpty()){
            return;
        }
        NodePrincipal categoriaParaRemover = buscarCategoria(nomeCategoria);
        if(categoriaParaRemover == null){
            return;
        }
        if(categoriaParaRemover == this.primeiro){
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
        if(categoriaParaRemover == ultimo){
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
        categoriaParaRemover.getProx().setAnte(categoriaParaRemover.getAnte());
        categoriaParaRemover.getAnte().setProx(categoriaParaRemover.getProx());
    }

    public NodePrincipal buscarCategoria(String nomeCategoria){
        if(isEmpty()){
            return null;
        }
        NodePrincipal auxNodeCategoria = this.primeiro;
        for (int i = 0; i < this.qtd; i++) {
            if(auxNodeCategoria.getInfo().getDescricao().equals(nomeCategoria)){
                return auxNodeCategoria;
            }
            auxNodeCategoria = auxNodeCategoria.getProx();
        }
        return null;
    }

    public void exibirCategorias(){
        if(isEmpty()){
            return ;
        }
        NodePrincipal auxNodeCategoria = this.primeiro;
        for (int i = 0; i < this.qtd; i++) {
            System.out.println(auxNodeCategoria.getInfo());
            auxNodeCategoria = auxNodeCategoria.getProx();
        }
    }
}
