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
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}