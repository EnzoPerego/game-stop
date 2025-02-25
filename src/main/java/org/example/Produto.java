package org.example;

public class Produto {
    private String nome;
    private int id;
    private double preco;
    private int quantidade;

    public Produto(String nome, int id, double preco, int quantidade) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void reduzirQuantidade(int quantidadeVendida) {
        if (quantidadeVendida <= quantidade) {
            this.quantidade -= quantidadeVendida;
        } else {
            System.out.println("Quantidade insuficiente em estoque!");
        }
    }
}
