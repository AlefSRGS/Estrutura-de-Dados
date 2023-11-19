package ImplementacaoListaSimples.ListaAluno;

public class Aluno {
    private String matricula;
    private String nome;
    private double media;
    private int faltas;

    public Aluno(String matricula, String nome, double media, int faltas) {
        this.matricula = matricula;
        this.nome = nome;
        this.media = media;
        this.faltas = faltas;
    }
    public boolean compareTo(Aluno outroAluno) {
        if(matricula.equals(outroAluno.matricula)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Aluno:\n" + "matricula: " + matricula + "\nnome: " + nome + "\nmedia: " + media + "\nfaltas: " + faltas + "\n";
    }
    public String getMatricula() {
        return matricula;
    }
    public int getFaltas() {
        return faltas;
    }
    public double getMedia() {
        return media;
    }
    public String getNome() {
        return nome;
    }
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    public void setmedia(double media) {
        this.media = media;
    }
    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }
}
