package RevisaoPOOBuscaOrdenacao;

public class Circulo implements Comparable <Circulo>{
    private double coordX;
    private double coordY;
    private double raio;

    public double getRaio() {
        return raio;
    }
    public double getCoordX() {
        return coordX;
    }
    public double getCoordY() {
        return coordY;
    }
    public Circulo(double coordX, double coordY, double raio){
        this.coordX = coordX;
        this.coordY = coordY;
        this.raio = raio;
    }
    public double circunferencia(double raioDoCirculo){
        return 2*(Math.PI*raioDoCirculo);
    }
    public double areaDoCirculo(double raio){
        return Math.PI*(raio*raio);
    }
    public double volumeDaEsfera(double raio){
        return (4*Math.PI*(Math.pow(raio,3)))/3;
    }
    public void moverCirculo(double novoCoordX, double novoCoordY){
        this.coordX = novoCoordX;
        this.coordY = novoCoordY;
    }

    @Override
    public int compareTo(Circulo outroCirculo) {
        if(this.raio == outroCirculo.raio){
            return 0;
        }else if(this.raio > outroCirculo.raio){
            return 1;
        }else{
            return -1;
        }
    }
    public String toString(){
        return "Raio: " + this.raio + "\nCoordenadas: ("+this.coordX+","+this.coordY+").";
    }
}
