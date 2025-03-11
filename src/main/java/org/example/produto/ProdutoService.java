package org.example.produto;

import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class ProdutoService {
    private final HashMap<Integer, Produto> produtosCadastrados = new HashMap<>();
    private int contadorId = 1;

    public HashMap<Integer, Produto> getProdutos() {
        return produtosCadastrados;
    }

    public Produto salvarProduto(String nome, double preco, int quantidade) {
        if (nome == null || nome.isEmpty() || preco <= 0 || quantidade < 0) {
            return null;
        }
        Produto produto = new Produto(nome, preco, quantidade);
        produtosCadastrados.put(produto.getId(), produto);
        return produto;
    }

    public Produto getProduto(Integer id) {
        return produtosCadastrados.get(id);
    }

    public boolean removerProduto(Integer id) {
        return produtosCadastrados.remove(id) != null;
    }

    public boolean adicionarEstoque(Integer id, int quantidade) {
        Produto produto = produtosCadastrados.get(id);
        if (produto != null) {
            produto.adicionarEstoque(quantidade);
            return true;
        }
        return false;
    }

    public boolean reduzirEstoque(Integer id, int quantidade) {
        Produto produto = produtosCadastrados.get(id);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produto.reduzirQuantidade(quantidade);
            return true;
        }
        return false;
    }
}
