package org.example;

import org.example.usuarios.Usuario;

public class Avaliacao {
    private Usuario usuario;
    private String tipoTransacao; // "Venda", "Compra" ou "Empréstimo"
    private int nota; // Nota de 1 a 5
    private String comentario;

    public Avaliacao(Usuario usuario, String tipoTransacao, int nota, String comentario) {
        this.usuario = usuario;
        this.tipoTransacao = tipoTransacao;
        this.nota = validarNota(nota);
        this.comentario = comentario;
    }

    private int validarNota(int nota) {
        if (nota < 1) return 1;
        if (nota > 5) return 5;
        return nota;
    }

    public void exibirAvaliacao() {
        System.out.println("Avaliação de " + tipoTransacao + " feita por: " + usuario.getNome());
        System.out.println("Nota: " + nota + "/5");
        System.out.println("Comentário: " + comentario);
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = validarNota(nota);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
