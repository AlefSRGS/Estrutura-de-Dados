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
            if(buscaBinariaIterativa(circuloAInserir) != -1){
                System.out.println("Circulo ja existe na lista, não pode ser inserido.");
                return;
            }
            dados[qtd] = circuloAInserir;
            qtd++;
            System.out.println("Circulo inserido com sucesso!\n");
        }
    }
    public boolean isFull(){
        if(qtd == dados.length){
            return true;
        }else{
            return false;
        }
    }
    public boolean isEmpty(){
        if(qtd == 0){
            return true;
        }else{
            return false;
        }
    }
    public void exibirDados(){
        if(isEmpty()){
            System.out.println("Lista esta vazia, nada a exibir\n");
        }else{
            for(int i = 0; i < qtd; i++){
                if(dados[i] == null){
                    i++;
                }else{
                    System.out.printf("Circulo %d:",i+1);
                    System.out.println();
                    System.out.println(dados[i]);
                    System.out.println();
                }
            }
        }
    }
    public void OrdenarDadosCrescente(){
        if(isEmpty()){
            System.out.println("Vetor esta vazio, nada a ordenar");
            return;
        }
        int i , j , min;
        Circulo aux;
        for(i = 0; i < (qtd -1) ; i ++) {
            min = i ;
            for(j = i+1 ;j < qtd;j ++) {
                if(dados[j].compareTo(dados[min]) < 0) //comparando de um circulo é menor q o outro
                min = j ;
            }
            if (dados[i].compareTo(dados[min]) != 0) { //comparando se o circulo é diferente do outro
                aux = dados[i];
                dados[i] = dados[min];
                dados[min] = aux;
            }
        }
        System.out.println("Vetor ordenado com sucesso:\n");
        exibirDados();
    }
    public int buscaBinariaIterativa(Circulo CirculoProcurado){
        int posStart = 0;
        int posFinal = qtd-1;
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
