package br.com.biblioteca.controller;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;
    private LivroController livroController; 
    private int nextId;

    public EmprestimoController(LivroController livroController) {
        this.emprestimos = new ArrayList<>();
        this.livroController = livroController;
        this.nextId = 1;
    }

    public Emprestimo realizarEmprestimo(Usuario usuario, Livro livro, int diasParaDevolucao) {
        if (usuario == null || livro == null) {
            System.err.println("Erro: Usuário e livro não podem ser nulos para realizar empréstimo.");
            return null;
        }
        if (!livro.getStatus().equals("Disponível")) {
            System.err.println("Erro: O livro '" + livro.getTitulo() + "' não está disponível para empréstimo (Status: " + livro.getStatus() + ").");
            return null;
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(diasParaDevolucao);

        Emprestimo emprestimo = new Emprestimo(nextId++, usuario, livro, dataEmprestimo, dataDevolucaoPrevista, "Ativo");
        emprestimos.add(emprestimo);
        livroController.atualizarStatusLivro(livro.getIdLivro(), "Emprestado");
        System.out.println("Empréstimo realizado: " + emprestimo);
        return emprestimo;
    }public boolean realizarDevolucao(int idEmprestimo) {
        Emprestimo emprestimo = buscarEmprestimoPorId(idEmprestimo);
        if (emprestimo != null && emprestimo.getStatus().equals("Ativo")) {
            emprestimo.setDataDevolucaoReal(LocalDate.now());
            emprestimo.setStatus("Devolvido");
            livroController.atualizarStatusLivro(emprestimo.getLivro().getIdLivro(), "Disponível");
            System.out.println("Devolução realizada para o empréstimo ID: " + idEmprestimo);
            return true;
        }
        System.err.println("Empréstimo ID " + idEmprestimo + " não encontrado ou já foi devolvido.");
        return false;
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        return emprestimos.stream()
                          .filter(e -> e.getIdEmprestimo() == id)
                          .findFirst()
                          .orElse(null);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimos.stream()
                          .filter(e -> e.getStatus().equals("Ativo"))
                          .collect(Collectors.toList());
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return new ArrayList<>(emprestimos);
    }
}