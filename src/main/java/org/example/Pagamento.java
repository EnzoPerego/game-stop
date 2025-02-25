package org.example;

public class Pagamento {
    private double valor;
    private String metodoPagamento;

    public Pagamento(double valor, String metodoPagamento) {
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public void realizarPagamento() {
        System.out.println("Pagamento de R$ " + valor + " realizado com sucesso via " + metodoPagamento);
    }
}
