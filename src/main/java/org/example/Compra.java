package org.example;

public class Compra {
    private Usuario comprador;
    private Produto produto;
    private int quantidade;
    private double valorTotal;



    public Compra(Usuario comprador, Produto produto, int quantidade) {
        this.comprador = comprador;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    public void realizarCompra() {
        produto.reduzirQuantidade(quantidade);
        comprador.adicionarProduto(produto);
        System.out.println("Compra realizada com sucesso: " + produto.getNome() + " - " + quantidade + " unidades.");
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
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
