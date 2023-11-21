package ListaCircular;

public class Categoria implements Comparable<Categoria>{
    private String descricao;
    private ListaFilmes lista;

    public Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public ListaFilmes getLista() {
        return lista;
    }


    @Override
    public int compareTo(Categoria categoria) {
        return getDescricao().compareTo(categoria.getDescricao());
    }

    @Override
    public String toString() {
        String listaFilmes = "";
        NodeSecundario auxFilme = lista.getPrimeiro();
        for (int i = 0; i < this.lista.getQtd(); i++) {
            listaFilmes = listaFilmes.concat(auxFilme.getInfo()+"\n");
            auxFilme = auxFilme.getProx();
        }
        return "Categoria: " + getDescricao() +":\n" +
                listaFilmes;
    }
}