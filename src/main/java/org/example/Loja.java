package org.example;

public class Loja {
    private Estoque estoque;

    public Loja() {
        estoque = new Estoque();
    }

    public void adicionarProdutoAoEstoque(Produto produto) {
        estoque.adicionarProduto(produto);
    }

    public void listarProdutos() {
        estoque.listarProdutos();
    }

    public void realizarCompra(Usuario comprador, Produto produto, int quantidade) {
        Compra compra = new Compra(comprador, produto, quantidade);
        compra.realizarCompra();
    }

    public void realizarVenda(Usuario vendedor, Produto produto, int quantidade) {
        Venda venda = new Venda(vendedor, produto, quantidade);
        venda.realizarVenda();
    }

    public void adicionarAvaliacao(Usuario usuario, Produto produto, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(usuario, produto, nota, comentario);
        avaliacao.exibirAvaliacao();
    }

    public void realizarPagamento(double valor, String metodoPagamento) {
        Pagamento pagamento = new Pagamento(valor, metodoPagamento);
        pagamento.realizarPagamento();
    }
}
