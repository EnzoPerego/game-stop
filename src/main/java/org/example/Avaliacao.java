package org.example;

public class Avaliacao {
    private Usuario usuario;
    private Produto produto;
    private int nota;
    private String comentario;

    public Avaliacao(Usuario usuario, Produto produto, int nota, String comentario) {
        this.usuario = usuario;
        this.produto = produto;
        this.nota = nota;
        this.comentario = comentario;
    }

    public void exibirAvaliacao() {
        System.out.println("Avaliação de " + produto.getNome() + " por " + usuario.getNome() + ": " + nota + "/5");
        System.out.println("Comentário: " + comentario);
    }
}
