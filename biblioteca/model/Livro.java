package br.com.biblioteca.model;

public class Livro {
    private int idLivro;
    private String titulo;
    private int ano;
    private Autor autor; 
    private String status; 

    public Livro(int idLivro, String titulo, int ano, Autor autor, String status) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.status = status;
    }

    
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + idLivro + ", Título: " + titulo + ", Ano: " + ano +
               ", Autor: " + (autor != null ? autor.getNome() : "N/A") +
               ", Status: " + status;
    }
}