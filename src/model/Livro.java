package model;

public class Livro {
    String titulo;
    String autor;
    String edicao;
    int isnb;

    public Livro(String titulo, String autor,String edicao, int isnb) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.isnb = isnb;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getIsnb() {
        return isnb;
    }

    public void setIsnb(int isnb) {
        this.isnb = isnb;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
