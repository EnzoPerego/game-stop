package org.example;

import java.util.HashMap;

public class Estoque {
    private HashMap<Integer, Produto> produtos;

    public Estoque() {
        produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    public Produto buscarProduto(int id) {
        return produtos.get(id);
    }

    public void listarProdutos() {
        for (Produto produto : produtos.values()) {
            System.out.println(produto.getNome() + " - " + produto.getPreco() + " - Quantidade: " + produto.getQuantidade());
        }
    }

    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Integer, Produto> produtos) {
        this.produtos = produtos;
    }
}

