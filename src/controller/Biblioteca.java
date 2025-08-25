package controller;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.Comparator;

public class Biblioteca {
    public static ArrayList<Livro> livros = new ArrayList<>();
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void cadastrarLivro(String titulo, String autor, String edicao, String isbn) {
        livros.add(new Livro(titulo, autor, edicao, isbn));
        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listarLivros() {
        System.out.println("Lista de livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.println((i + 1) + " - " + l.getTitulo() + " | Autor: " + l.getAutor()
                    + " | Edição: " + l.getEdicao() + " | ISBN: " + l.getIsbn());
        }
    }

    public static void emprestarLivro(int indiceLivro, Usuario usuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getIndiceLivro() == indiceLivro && e.getUsuario().getNome().equalsIgnoreCase(usuario.getNome()) && e.getDataDevolucao() == null) {
                System.out.println("O usuário já pegou este livro e não devolveu ainda.");
                return;
            }
        }
        Emprestimo emprestimo = new Emprestimo(indiceLivro, usuario);
        emprestimos.add(emprestimo);
        livros.get(indiceLivro).incrementarEmprestimos();
        System.out.println("Livro \"" + livros.get(indiceLivro).getTitulo() + "\" emprestado para " + usuario.getNome()
                + " | Devolver até: " + emprestimo.getDataPrevistaDevolucao());
    }

    public static void listarEmprestimos() {
        System.out.println("Empréstimos ativos:");
        boolean temEmprestimo = false;

        for (Emprestimo e : emprestimos) {
            if (e.getDataDevolucao() == null) {
                System.out.println("Usuário: " + e.getUsuario().getNome() + " | Livro: "
                        + livros.get(e.getIndiceLivro()).getTitulo() + " | Devolver até: " + e.getDataPrevistaDevolucao());
                temEmprestimo = true;
            }
        }
        if (!temEmprestimo){
            System.out.println("Não há empréstimos!");
        }
    }

    public static void devolverLivro(int indiceLivro, String nomeUsuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getIndiceLivro() == indiceLivro && e.getUsuario().getNome().equalsIgnoreCase(nomeUsuario) && e.getDataDevolucao() == null) {
                e.devolver();
                long multa = e.calcularMulta();
                System.out.println("Livro devolvido! " + (multa > 0 ? "Multa: R$" + multa : "Sem multa."));
                return;
            }
        }
        System.out.println("Empréstimo não encontrado.");
    }

    public static void relatorioMaisEmprestados() {
        System.out.println("📊 Relatório de livros mais emprestados:");
        livros.stream()
                .sorted(Comparator.comparingInt(Livro::getContadorEmprestimos).reversed())
                .forEach(l -> System.out.println(l.getTitulo() + " | Total: " + l.getContadorEmprestimos()));
    }

    public static boolean temEmprestimosAtivos() {
        for (Emprestimo e : emprestimos) {
            if (e.getDataDevolucao() == null) {
                return true;
            }
        }
        return false;
    }
}
