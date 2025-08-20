package view;

import controller.Biblioteca;
import model.Emprestimo;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static controller.Biblioteca.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean finalizar = false;

        do {
            System.out.println("1 - Cadastrar livro \n" +
                    "2 - Pegar livro emprestado \n" +
                    "3 - Verificar livros emprestados \n" + 
                    "4 - Mostrar livros \n" +
                    "5 - Editar livro \n" +
                    "6 - Devolver livro"+
                    "7 - Encerrar");
            int escolha = sc.nextInt();
            System.out.println();

            switch (escolha){
                case 1:
                    System.out.println("Titulo do livro: ");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    System.out.println("Autor do livro: ");
                    String autor = sc.nextLine();
                    System.out.println("Edição do livro");
                    String edicao = sc.nextLine();
                    System.out.println("ISBN do livro: ");
                    int isnb = sc.nextInt();

                    Biblioteca.cadastrarLivro(titulo, autor, edicao, isnb);
                    System.out.println();
                    break;

                case 2:
                    listarLivros();
                    System.out.println();

                    System.out.println("Qual indice do livro ?");
                    int indice = sc.nextInt();
                    System.out.println("Qual nome de quem irá pegar o livro emprestado ?");
                    String nomeEmp = sc.next();
                    LocalDate.now();

                    Biblioteca.emprestarLivro(indice - 1, nomeEmp);
                    System.out.println();
                    break;

                case 3:

                    listarEmprestimos();
                    System.out.println();
                    break;

                case 4:

                    listarLivros();
                    System.out.println();
                    break;

                case 5:


                    break;

                case 6:

                    System.out.println("Qual livro você deseja devolver ?");


                    break;

                default:
                finalizar = true;
                break;
            }
        }while (finalizar == false);
    }
}