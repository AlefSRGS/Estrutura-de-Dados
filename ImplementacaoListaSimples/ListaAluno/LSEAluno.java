package ListaAluno;

public class LSEAluno {
    private LSENodeAluno firstNodeAluno;

    public LSENodeAluno getFirstNodeAluno() {
        return firstNodeAluno;
    }
    public boolean isEmpty() {
        return firstNodeAluno == null;
    }
    public void insertEndListWithNoRepeat(Aluno nodeAluno){
        LSENodeAluno newNodeAluno = new LSENodeAluno(nodeAluno);
        if (isEmpty()) {
            firstNodeAluno = newNodeAluno;
            System.out.println("Valor inserido");
            return;
        }
        LSENodeAluno auxNode = firstNodeAluno;
        while(!auxNode.getdataAluno().compareTo(nodeAluno)){
            if(auxNode.getAdressNextNode() == null){
                auxNode.setAdressNextNode(newNodeAluno);
                System.out.println("Valor inserido");
                return;
            }
            auxNode = auxNode.getAdressNextNode();
        }
        System.out.println("Valores repetidos não podem ser inseridos.");
    }
    public void showAll(){
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        LSENodeAluno auxNode = firstNodeAluno;
        while(auxNode != null){
            System.out.println(auxNode.getdataAluno());
            auxNode = auxNode.getAdressNextNode();
        }
    }
    public void passedAndFailed(LSEAluno passedAluno, LSEAluno failedAluno){
        if(isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        LSENodeAluno auxNode = firstNodeAluno;
        while(auxNode!= null){
            if(auxNode.getdataAluno().getMedia() >= 7){
                passedAluno.insertEndListWithNoRepeat(auxNode.getdataAluno());
            }else{
                failedAluno.insertEndListWithNoRepeat(auxNode.getdataAluno());
            }
            auxNode = auxNode.getAdressNextNode();
        }

    }
}