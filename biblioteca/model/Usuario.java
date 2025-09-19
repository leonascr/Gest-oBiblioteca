package br.com.biblioteca.model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String tipo; 
    private String matricula;

    public Usuario(int idUsuario, String nome, String email, String tipo, String matricula) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.matricula = matricula;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "ID: " + idUsuario + ", Nome: " + nome + ", Email: " + email +
               ", Tipo: " + tipo + ", Matrícula: " + matricula;
    }
}