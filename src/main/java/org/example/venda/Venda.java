package org.example.venda;

import org.example.produto.Produto;
import org.example.Usuario;

public class Venda {
    private Usuario vendedor;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Venda(Usuario vendedor, Produto produto, int quantidade) {
        this.vendedor = vendedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    public void realizarVenda() {
        produto.reduzirQuantidade(quantidade);
        System.out.println("Venda realizada para o cliente: " + vendedor.getNome() + " - " + produto.getNome());
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
