package org.example;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Produto> produtosComprados = new ArrayList<>();

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void adicionarProduto(Produto produto) {
        produtosComprados.add(produto);
    }

    public ArrayList<Produto> getProdutosComprados() {
        return produtosComprados;
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

    public void setProdutosComprados(ArrayList<Produto> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }
}
