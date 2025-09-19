package br.com.biblioteca.view;

import br.com.biblioteca.controller.AutorController;
import br.com.biblioteca.controller.EmprestimoController;
import br.com.biblioteca.controller.LivroController;
import br.com.biblioteca.controller.UsuarioController;
import br.com.biblioteca.model.Autor;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static AutorController autorController = new AutorController();
    private static LivroController livroController = new LivroController();
    private static UsuarioController usuarioController = new UsuarioController();
    private static EmprestimoController emprestimoController = new EmprestimoController(livroController); // Injeta o LivroController

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Gerenciador de Biblioteca!");
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gerenciar Autores");
            System.out.println("2. Gerenciar Livros");
            System.out.println("3. Gerenciar Usuários");
            System.out.println("4. Gerenciar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    menuAutores();
                    break;
                case 2:
                    menuLivros();
                    break;
                case 3:
                    menuUsuarios();
                    break;
                case 4:
                    menuEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAutores() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Autores ---");
            System.out.println("1. Cadastrar Autor");
            System.out.println("2. Listar Autores");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Autor: ");
                    String nomeAutor = scanner.nextLine();
                    autorController.cadastrarAutor(nomeAutor);
                    break;
                case 2:
                    System.out.println("\n--- Lista de Autores ---");
                    List<Autor> autores = autorController.listarAutores();
                    if (autores.isEmpty()) {
                        System.out.println("Nenhum autor cadastrado.");
                    } else {
                        autores.forEach(System.out::println);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuLivros() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Livros ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do Livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Ano do Livro: ");
                    int anoLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID do Autor (se não souber, cadastre primeiro): ");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine();
                    Autor autor = autorController.buscarAutorPorId(idAutor);
                    if (autor != null) {
                        livroController.cadastrarLivro(tituloLivro, anoLivro, autor);
                    } else {
                        System.out.println("Autor com ID " + idAutor + " não encontrado. Cadastre-o primeiro.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Lista de Livros ---");
                    List<Livro> livros = livroController.listarLivros();
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        livros.forEach(System.out::println);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuUsuarios() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Usuários ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Email do Usuário: ");
                    String emailUsuario = scanner.nextLine();
                    System.out.print("Tipo do Usuário (Aluno/Professor/Admin): ");
                    String tipoUsuario = scanner.nextLine();
                    System.out.print("Matrícula do Usuário: ");
                    String matriculaUsuario = scanner.nextLine();
                    usuarioController.cadastrarUsuario(nomeUsuario, emailUsuario, tipoUsuario, matriculaUsuario);
                    break;
                case 2:
                    System.out.println("\n--- Lista de Usuários ---");
                    List<Usuario> usuarios = usuarioController.listarUsuarios();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        usuarios.forEach(System.out::println);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuEmprestimos() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Empréstimos ---");
            System.out.println("1. Realizar Empréstimo");
            System.out.println("2. Realizar Devolução");
            System.out.println("3. Listar Empréstimos Ativos");
            System.out.println("4. Listar Todos os Empréstimos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do Usuário para Empréstimo: ");
                    int idUserEmprestimo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID do Livro para Empréstimo: ");
                    int idLivroEmprestimo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Dias para Devolução: ");
                    int dias = scanner.nextInt();
                    scanner.nextLine();

                    Usuario user = usuarioController.buscarUsuarioPorId(idUserEmprestimo);
                    Livro book = livroController.buscarLivroPorId(idLivroEmprestimo);

                    if (user != null && book != null) {
                        emprestimoController.realizarEmprestimo(user, book, dias);
                    } else {
                        System.out.println("Usuário ou Livro não encontrados. Verifique os IDs.");
                    }
                    break;
                case 2:
                    System.out.print("ID do Empréstimo para Devolução: ");
                    int idEmprestimoDevolucao = scanner.nextInt();
                    scanner.nextLine();
                    emprestimoController.realizarDevolucao(idEmprestimoDevolucao);
                    break;
                case 3:
                    System.out.println("\n--- Empréstimos Ativos ---");
                    List<br.com.biblioteca.model.Emprestimo> emprestimosAtivos = emprestimoController.listarEmprestimosAtivos();
                    if (emprestimosAtivos.isEmpty()) {
                        System.out.println("Nenhum empréstimo ativo.");
                    } else {
                        emprestimosAtivos.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.println("\n--- Todos os Empréstimos ---");
                    List<br.com.biblioteca.model.Emprestimo> todosEmprestimos = emprestimoController.listarTodosEmprestimos();
                    if (todosEmprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo registrado.");
                    } else {
                        todosEmprestimos.forEach(System.out::println);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}