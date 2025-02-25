package org.example;

import java.util.HashMap;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    private static HashMap<Integer, Produto> produtosCadastrados = new HashMap<>();
    private static int contadorId = 1;


    public Produto(String nome, double preco, int quantidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        produtosCadastrados.put(this.id, this);
    }


    public void reduzirQuantidade(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            System.out.println("Quantidade reduzida! Novo estoque de " + nome + ": " + this.quantidade);
        } else {
            System.out.println("Erro: Estoque insuficiente para " + nome + ". Quantidade disponível: " + this.quantidade);
        }
    }


    public static void listarProdutos() {
        if (produtosCadastrados.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto produto : produtosCadastrados.values()) {
            System.out.println("ID: " + produto.id + " | Nome: " + produto.nome + " | Preço: R$" + produto.preco + " | Quantidade: " + produto.quantidade);
        }
    }

    public static Produto buscarProduto(int id) {
        return produtosCadastrados.get(id);
    }

    public static boolean removerProduto(int id) {
        if (produtosCadastrados.containsKey(id)) {
            produtosCadastrados.remove(id);
            return true;
        }
        return false;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
