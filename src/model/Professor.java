package model;

public class Professor extends Usuario {
    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getPrazoDevolucaoDias() {
        return 15;
    }
}

