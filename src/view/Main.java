package view;

import controller.Biblioteca;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean finalizar = false;

        do {
            System.out.println("\n1 - Cadastrar livro \n" +
                    "2 - Pegar livro emprestado \n" +
                    "3 - Verificar livros emprestados \n" +
                    "4 - Mostrar livros \n" +
                    "5 - Devolver livro \n" +
                    "6 - Relatório de livros mais emprestados \n" +
                    "7 - Encerrar\n");
            System.out.print("Digite o número: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Edição: ");
                    String edicao = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    Biblioteca.cadastrarLivro(titulo, autor, edicao, isbn);
                }
                case 2 -> {
                    Biblioteca.listarLivros();
                    System.out.print("Qual índice do livro? ");
                    int indice = sc.nextInt() - 1;
                    sc.nextLine();
                    System.out.print("Nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo (1-Aluno, 2-Professor): ");
                    int tipo = sc.nextInt();
                    Usuario usuario = (tipo == 1) ? new Aluno(nome) : new Professor(nome);
                    Biblioteca.emprestarLivro(indice, usuario);
                }
                case 3 -> Biblioteca.listarEmprestimos();
                case 4 -> Biblioteca.listarLivros();
                case 5 -> {
                    if (!Biblioteca.temEmprestimosAtivos()) {
                        System.out.println("Não há nenhum livro para ser devolvido.");
                    } else {
                        Biblioteca.listarEmprestimos();
                        System.out.print("Qual livro deseja devolver? ");
                        int indice = sc.nextInt() - 1;
                        sc.nextLine();
                        System.out.print("Nome do usuário: ");
                        String nome = sc.nextLine();
                        Biblioteca.devolverLivro(indice, nome);
                    }
                }
                case 6 -> Biblioteca.relatorioMaisEmprestados();
                case 7 -> {
                    System.out.println("Tenha uma boa leitura!");
                    finalizar = true;
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (!finalizar);
    }
}
