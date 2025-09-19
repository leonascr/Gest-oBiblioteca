package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int idEmprestimo;
    private Usuario usuario; 
    private Livro livro;     
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista; 
    private LocalDate dataDevolucaoReal;
    private String status; 

    public Emprestimo(int idEmprestimo, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, String status) {
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = status;
        this.dataDevolucaoReal = null; 
    }

    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + idEmprestimo +
               ", Usuário: " + (usuario != null ? usuario.getNome() : "N/A") +
               ", Livro: " + (livro != null ? livro.getTitulo() : "N/A") +
               ", Empréstimo: " + dataEmprestimo +
               ", Devolução Prevista: " + dataDevolucaoPrevista +
               ", Devolução Real: " + (dataDevolucaoReal != null ? dataDevolucaoReal : "Pendente") +
               ", Status: " + status;
    }
}