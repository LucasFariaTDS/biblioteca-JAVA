package model;

public class Livro {
    private String titulo;
    private String autor;
    private String edicao;
    private String isbn;
    private int contadorEmprestimos = 0;

    public Livro(String titulo, String autor, String edicao, String isbn) {
        if (isbn == null || isbn.isEmpty() || edicao == null || edicao.isEmpty()) {
            throw new IllegalArgumentException("ISBN e edição são obrigatórios!");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void incrementarEmprestimos() {
        contadorEmprestimos++;
    }

    public int getContadorEmprestimos() {
        return contadorEmprestimos;
    }
}
