package org.example.pagamento;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PagamentoService {

    private HashMap<Integer, Pagamento> pagamentos = new HashMap<>();
    private int idCounter = 1;

    public HashMap<Integer, Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void salvarPagamento(Pagamento pagamento) {
        pagamentos.put(idCounter, pagamento);
        idCounter++;
    }

    public Pagamento getPagamento(int id) {
        return pagamentos.get(id);
    }

    public Pagamento removerPagamento(int id) {
        return pagamentos.remove(id);
    }

    public Pagamento editarPagamento(int id, Pagamento pagamento) {
        Pagamento pagamentoEditar = getPagamento(id);

        if (pagamentoEditar != null) {
            if (pagamento.getValor() > 0) {
                pagamentoEditar.setValor(pagamento.getValor());
            }

            if (pagamento.getMetodoPagamento() != null && !pagamento.getMetodoPagamento().isEmpty()) {
                pagamentoEditar.setMetodoPagamento(pagamento.getMetodoPagamento());
            }
        }
        return pagamentoEditar;
    }
}
