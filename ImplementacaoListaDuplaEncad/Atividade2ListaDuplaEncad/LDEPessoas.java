package ImplementacaoListaDuplaEncad.Atividade2ListaDuplaEncad;

public class LDEPessoas {
    private LDENodePessoa firstPessoa;
    private LDENodePessoa lastPessoa;
    private int totalPessoas;

    public LDENodePessoa getFirstPessoa() {
        return firstPessoa;
    }
    public LDENodePessoa getLastPessoa() {
        return lastPessoa;
    }
    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setFirstPessoa(LDENodePessoa firstPessoa) {
        this.firstPessoa = firstPessoa;
    }
    public void setLastPessoa(LDENodePessoa lastPessoa) {
        this.lastPessoa = lastPessoa;
    }

    public boolean isEmpty() {
        if(firstPessoa == null && lastPessoa == null && totalPessoas == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void cadastrarPessoa(Pessoa pessoaParaCadastrar) {
        LDENodePessoa novoNodePessoa = new LDENodePessoa(pessoaParaCadastrar);
        if(isEmpty()){
            firstPessoa = new LDENodePessoa(pessoaParaCadastrar);
            lastPessoa = new LDENodePessoa(pessoaParaCadastrar);
            totalPessoas++;
            return;
        }
        else if(firstPessoa.getDataNode().compareTo(pessoaParaCadastrar) == 1){
            System.out.println("Pessoa já cadastrada");
            return;
        }
        else if(lastPessoa.getDataNode().compareTo(pessoaParaCadastrar) == 1){
            System.out.println("Pessoa já cadastrada");
            return;
        }
        else if(firstPessoa.getNextAdressNode() == null){
            firstPessoa.setNextAdressNode(novoNodePessoa);
            lastPessoa = novoNodePessoa;
            lastPessoa.setPreviosAdressNode(firstPessoa);
            totalPessoas++;
        }
        else{
            LDENodePessoa auxNode = firstPessoa;
            while(auxNode != null){
                if(auxNode.getNextAdressNode() == null){
                    auxNode.setNextAdressNode(novoNodePessoa);
                    lastPessoa = novoNodePessoa;
                    lastPessoa.setPreviosAdressNode(auxNode);
                    totalPessoas++;
                    return;
                }
                auxNode = auxNode.getNextAdressNode();
            }
        }
    }

    public void cancelarCadastroPessoa() {
        if(isEmpty()){
            System.out.println("Nada registrado");
            return;
        }
        if(firstPessoa.getNextAdressNode() == null){
            firstPessoa = null;
            lastPessoa = null;
            totalPessoas--;
            return;
        }
        lastPessoa = lastPessoa.getPreviosAdressNode();
        lastPessoa.setNextAdressNode(null);
        totalPessoas--;
    }

    public void exibirPessoas() {
        if(isEmpty()){
            System.out.println("Nada registrado");
            return;
        }
        LDENodePessoa auxNode = firstPessoa;
        int auxCount = 1;
        while(auxNode!= null){
            System.out.printf("Pessoa %d:\n", auxCount);
            System.out.print("Nome: ");
            System.out.println(auxNode.getDataNode().getName());
            System.out.print("RG: ");
            System.out.println(auxNode.getDataNode().getRg());
            auxNode = auxNode.getNextAdressNode();
            auxCount++;
        }
    }

    public boolean verificarPessoa(String rgPessoaParaVerificar) {
        if(isEmpty()){
            return false;
        }
        if(lastPessoa.getDataNode().getRg().equals(rgPessoaParaVerificar)){
            return true;
        }
        if(firstPessoa.getDataNode().getRg().equals(rgPessoaParaVerificar)){
            return true;
        }
        LDENodePessoa auxNode = firstPessoa.getNextAdressNode();
        while(auxNode.getNextAdressNode() != null){
            if(auxNode.getDataNode().getRg().equals(rgPessoaParaVerificar)){
                return true;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return false;
    }

    public void removerCadastroPessoa(String rgPessoaRemover){
        if(isEmpty()){
            System.out.println("Nada registrado");
            return;
        }
        if(firstPessoa.getDataNode().getRg().equals(rgPessoaRemover)){
            firstPessoa = firstPessoa.getNextAdressNode();
            firstPessoa.setPreviosAdressNode(null);
            totalPessoas--;
            return;
        }
        if(lastPessoa.getDataNode().getRg().equals(rgPessoaRemover)){
            lastPessoa = lastPessoa.getPreviosAdressNode();
            lastPessoa.setNextAdressNode(null);
            totalPessoas--;
            return;
        }
        LDENodePessoa auxNode = firstPessoa.getNextAdressNode();
        while(auxNode.getNextAdressNode() != null){
            if(auxNode.getDataNode().getRg().equals(rgPessoaRemover)){
                auxNode.getPreviosAdressNode().setNextAdressNode(auxNode.getNextAdressNode());
                auxNode.getNextAdressNode().setPreviosAdressNode(auxNode.getPreviosAdressNode());
                totalPessoas--;
                return;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        System.out.println("Rg informado não tem registro");
    }
}
