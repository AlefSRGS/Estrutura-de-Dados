package ImplementacaoListaSimples.ListaAluno;

public class LSENodeAluno{
    private Aluno dataAluno;
    private LSENodeAluno adressNextNode;

    public LSENodeAluno(Aluno dataAluno){
        this.dataAluno = dataAluno;
    }
    
    public LSENodeAluno getAdressNextNode() {
        return adressNextNode;
    }
    public Aluno getdataAluno() {
        return dataAluno;
    }
    public void setAdressNextNode(LSENodeAluno adressNextNode) {
        this.adressNextNode = adressNextNode;
    }
    public void setdataAluno(Aluno dataAluno) {
        this.dataAluno = dataAluno;
    }
}
