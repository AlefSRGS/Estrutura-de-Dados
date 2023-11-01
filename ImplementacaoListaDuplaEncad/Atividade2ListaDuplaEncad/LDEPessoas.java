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
        if(firstPessoa.getDataNode().compareTo(pessoaParaCadastrar) == 1){
            System.out.println("Pessoa já cadastrada");
        }
        else if(lastPessoa.getDataNode().compareTo(pessoaParaCadastrar) == 1){
            System.out.println("Pessoa já cadastrada");
        }
        else{
            LDENodePessoa auxNode = new LDENodePessoa(firstPessoa.getDataNode());
            while(auxNode != null){
                if(auxNode.getNextAdressNode() == null){
                    auxNode.setNextAdressNode(new LDENodePessoa(pessoaParaCadastrar));
                    auxNode.getNextAdressNode().setPreviosAdressNode(auxNode);
                    totalPessoas++;
                    return;
                }
                auxNode = auxNode.getNextAdressNode();
            }
        }
    }

    public void cancelarCadastroPessoa(Pessoa pessoaParaCancelar) {
        lastPessoa.getPreviosAdressNode().setNextAdressNode(null);
        totalPessoas--;
    }

    public void exibirPessoas() {
        LDENodePessoa auxNode = firstPessoa;
        int auxCount = 0;
        while(auxNode!= null){
            System.out.printf("Pessoa %d:\n", auxCount);
            System.out.println(auxNode.getDataNode().getName());
            System.out.println(auxNode.getDataNode().getRg());
            auxNode = auxNode.getNextAdressNode();
            auxCount++;
        }
    }

    public boolean verificarPessoa(Pessoa pessoaParaVerificar) {
        
        if(lastPessoa.getDataNode().compareTo(pessoaParaVerificar) == 1){
            return true;
        }
        if(firstPessoa.getDataNode().compareTo(pessoaParaVerificar) == 1){
            return true;
        }
        LDENodePessoa auxNode = firstPessoa.getNextAdressNode();
        while(auxNode != null){
            if(auxNode.getDataNode().compareTo(pessoaParaVerificar) == 1){
                return true;
            }
            auxNode = auxNode.getNextAdressNode();
        }
        return false;
    }

    public void removerCadastroPessoa(String rgPessoaRemover){
        if(firstPessoa.getDataNode().getRg().equals(rgPessoaRemover)){
            firstPessoa = firstPessoa.getNextAdressNode();
            totalPessoas--;
            return;
        }
        if(lastPessoa.getDataNode().getRg().equals(rgPessoaRemover)){
            lastPessoa = lastPessoa.getPreviosAdressNode();
            totalPessoas--;
        }
        LDENodePessoa auxNode = firstPessoa.getNextAdressNode();
        while(auxNode!= null){
            if(auxNode.getDataNode().getRg().equals(rgPessoaRemover)){
                auxNode.getPreviosAdressNode().setNextAdressNode(auxNode.getNextAdressNode());
                auxNode.getNextAdressNode().setPreviosAdressNode(auxNode);
                totalPessoas--;
                return;
            }
            auxNode = auxNode.getNextAdressNode();
        }
    }
}
