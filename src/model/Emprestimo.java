package model;

public class Emprestimo {
    int indiceLivro;
    String aluno;

    public Emprestimo(int indiceLivro, String aluno) {
        this.indiceLivro = indiceLivro;
        this.aluno = aluno;
    }

    public int getIndiceLivro() {
        return indiceLivro;
    }

    public String getAluno() {
        return aluno;
    }

    public void setIndiceLivro(int indiceLivro) {
        this.indiceLivro = indiceLivro;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}

