
public class Pessoa implements Comparable<Pessoa> {
    private String rg;
    private String name;
    

    public Pessoa(String rg, String name) {
        this.rg = rg;
        this.name = name;
    }

    public String getRg() {
        return rg;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        if(rg.equals(outraPessoa.getRg())){
            return 1;
        }
        return 0;
    }
}