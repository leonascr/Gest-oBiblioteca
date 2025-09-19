package br.com.biblioteca.controller;

import br.com.biblioteca.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioController {
    private List<Usuario> usuarios;
    private int nextId;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        this.nextId = 1;
    }

    public Usuario cadastrarUsuario(String nome, String email, String tipo, String matricula) {
        Usuario usuario = new Usuario(nextId++, nome, email, tipo, matricula);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario);
        return usuario;
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream()
                       .filter(u -> u.getIdUsuario() == id)
                       .findFirst()
                       .orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}