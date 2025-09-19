package br.com.biblioteca.controller;

import br.com.biblioteca.model.Autor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorController {
    private List<Autor> autores;
    private int nextId;

    public AutorController() {
        this.autores = new ArrayList<>();
        this.nextId = 1;
    }

    public Autor cadastrarAutor(String nome) {
        Autor autor = new Autor(nextId++, nome);
        autores.add(autor);
        System.out.println("Autor cadastrado: " + autor);
        return autor;
    }

    public Autor buscarAutorPorId(int id) {
        return autores.stream()
                      .filter(a -> a.getIdAutor() == id)
                      .findFirst()
                      .orElse(null);
    }

    public List<Autor> listarAutores() {
        return new ArrayList<>(autores); 
    }
}