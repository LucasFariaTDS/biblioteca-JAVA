package controller;

import model.Emprestimo;
import model.Livro;

import java.util.ArrayList;

public  class Biblioteca {
    static ArrayList<Livro> livros = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void cadastrarLivro(String titulo, String autor, String edicao, int isbn) {
        livros.add(new Livro(titulo, autor,  edicao, isbn));
        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listarLivros() {
        System.out.println("Lista de livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + 1 + " - " + livros.get(i).getTitulo() + " | Autor: "
                    + livros.get(i).getAutor() + " | Edição: " + livros.get(i).getEdicao() +" | ISBN: " + livros.get(i).getIsnb());
        }
    }

    public static void emprestarLivro(int indiceLivro, String aluno) {
        for (Emprestimo e : emprestimos){
            if (e.getIndiceLivro() == indiceLivro && e.getAluno() == aluno){
                System.out.println("Livro já emprestado para o aluno: " + aluno);
            }
        }
        emprestimos.add(new Emprestimo(indiceLivro, aluno));
        System.out.println("Livro \"" + livros.get(indiceLivro).getTitulo() + "\" emprestado para " + aluno);
    }

    public static void listarEmprestimos() {
        System.out.println("Empréstimos realizados:");
        for (Emprestimo e : emprestimos) {
            System.out.println("Aluno: " + e.getAluno() + " | Livro: " +
                    livros.get(e.getIndiceLivro()).getTitulo());
        }
    }
}
