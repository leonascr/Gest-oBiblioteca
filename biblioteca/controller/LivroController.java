package br.com.biblioteca.controller;

import br.com.biblioteca.model.Autor;
import br.com.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroController {
    private List<Livro> livros;
    private int nextId;

    public LivroController() {
        this.livros = new ArrayList<>();
        this.nextId = 1;
    }

    public Livro cadastrarLivro(String titulo, int ano, Autor autor) {
        if (autor == null) {
            System.err.println("Erro: Autor não pode ser nulo para cadastrar livro.");
            return null;
        }
        Livro livro = new Livro(nextId++, titulo, ano, autor, "Disponível");
        livros.add(livro);
        System.out.println("Livro cadastrado: " + livro);
        return livro;
    }

    public Livro buscarLivroPorId(int id) {
        return livros.stream()
                     .filter(l -> l.getIdLivro() == id)
                     .findFirst()
                     .orElse(null);
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public boolean atualizarStatusLivro(int idLivro, String novoStatus) {
        Livro livro = buscarLivroPorId(idLivro);
        if (livro != null) {
            livro.setStatus(novoStatus);
            System.out.println("Status do livro " + livro.getTitulo() + " atualizado para: " + novoStatus);
            return true;
        }
        System.err.println("Livro com ID " + idLivro + " não encontrado para atualizar status.");
        return false;
    }
}