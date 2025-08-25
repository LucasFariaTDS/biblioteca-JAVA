package model;

public class Aluno extends Usuario {
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getPrazoDevolucaoDias() {
        return 7;
    }
}
