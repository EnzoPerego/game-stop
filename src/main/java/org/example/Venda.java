package org.example;

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
}
