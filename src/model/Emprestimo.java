package model;

import java.time.LocalDate;

public class Emprestimo {
    private int indiceLivro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    public Emprestimo(int indiceLivro, Usuario usuario) {
        this.indiceLivro = indiceLivro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(usuario.getPrazoDevolucaoDias());
    }

    public int getIndiceLivro() {
        return indiceLivro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
    }

    public long calcularMulta() {
        if (dataDevolucao == null) return 0;
        long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
        return diasAtraso > 0 ? diasAtraso * 2 : 0;
    }
}


