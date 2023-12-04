package ListaArvore;

public class ProdutoTree {
    private final int codeProduct;
    private String description;
    private String provider;
    private double price;
    private int qtd;

    public ProdutoTree(int codeProduct, String description, String provider, double price, int qtd) {
        this.codeProduct = codeProduct;
        this.description = description;
        this.provider = provider;
        this.price = price;
        this.qtd = qtd;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public String getDescription() {
        return description;
    }

    public String getProvider() {
        return provider;
    }

    public double getPrice() {
        return price;
    }

    public int getQtd() {
        return qtd;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
