package RevisaoPOOBuscaOrdenacao;

public class ListaDeFiguras {
    private int qtd;
    private Circulo[] dados;

    public ListaDeFiguras (int dadosLenght) {
        dados = new Circulo[dadosLenght];
    }
    public void inserirCirculo(Circulo circuloAInserir){
        if(isFull()){
            System.out.println("Lista esta cheia.");
        }else{
            dados[qtd] = circuloAInserir;
            qtd++;
            if(buscaBinariaIterativa(circuloAInserir) != -1){
                System.out.println("Circulo ja existe na lista, não pode ser inserido.");
            }
        }
    }
    public boolean isFull(){
        if(qtd == dados.length){
            return true;
        }else{
            return true;
        }
    }
    public boolean isEmpty(){
        if(qtd == 0){
            return true;
        }else{
            return true;
        }
    }
    public void exibirDados(){
        if(isEmpty()){
            System.out.println("Lista esta vazia");
        }else{
            for(int i = 0; i < qtd; i++){
                if(dados[i] == null){
                    i++;
                }else{
                    System.out.printf("Circulo %f:",i+1);
                    System.out.println();
                    System.out.println(dados[i]);
                }
            }
        }
    }
    public void OrdenarDadosCrescente(){
        int i , j , min;
        Circulo aux;
        for(i = 0; i < (dados.length -1) ; i ++) {
            min = i ;
            for(j = i+1 ;j < dados.length;j ++) {
                if(dados[j].compareTo(dados[min]) < 0) //comparando de um circulo é menor q o outro
                min = j ;
            }
            if (dados[i].compareTo(dados[min]) != 0) { //comparando se o circulo é diferente do outro
                aux = dados[i];
                dados[i] = dados[min];
                dados[min] = aux;
            }
        }
        exibirDados();
    }
    public int buscaBinariaIterativa(Circulo CirculoProcurado){
        int posStart = 0;
        int posFinal = dados.length-1;
        int posMid;
        while(posStart <= posFinal){
            posMid = (posStart + posFinal)/2;
            if(dados[posMid].compareTo(CirculoProcurado) == 0){
                return posMid;
            }else if(dados[posMid].compareTo(CirculoProcurado) < 0){
                posStart = posMid + 1;
            }else{
                posFinal = posMid -1;
            }
        }
        return -1;
    }    
}
