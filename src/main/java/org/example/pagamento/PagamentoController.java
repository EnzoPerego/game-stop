package org.example.pagamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private HashMap<Integer, Pagamento> pagamentos = new HashMap<>();
    private int idCounter = 1;

    @GetMapping
    public HashMap<Integer, Pagamento> getPagamentos() {
        return pagamentos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarPagamento(@RequestBody Pagamento pagamento) {
        if (pagamento.getValor() <= 0) {
            return "O valor do pagamento deve ser maior que zero";
        }

        if (pagamento.getMetodoPagamento() == null || pagamento.getMetodoPagamento().isEmpty()) {
            return "O método de pagamento não pode ser nulo ou vazio";
        }

        pagamentos.put(idCounter, pagamento);
        idCounter++;
        return "Pagamento salvo com sucesso";
    }

    @GetMapping("/{id}")
    public Pagamento getPagamento(@PathVariable int id) {
        return pagamentos.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirPagamento(@PathVariable int id) {
        Pagamento pagamento = pagamentos.remove(id);
        if (pagamento != null) {
            return "Pagamento removido com sucesso";
        }
        return "Pagamento não encontrado";
    }

    @PutMapping("/{id}")
    public String editarPagamento(@PathVariable int id, @RequestBody Pagamento pagamento) {
        Pagamento pagamentoEditar = pagamentos.get(id);

        if (pagamentoEditar != null) {
            if (pagamento.getValor() > 0) {
                pagamentoEditar.setValor(pagamento.getValor());
            }

            if (pagamento.getMetodoPagamento() != null && !pagamento.getMetodoPagamento().isEmpty()) {
                pagamentoEditar.setMetodoPagamento(pagamento.getMetodoPagamento());
            }
            return "Pagamento alterado com sucesso";
        }

        return "Pagamento não encontrado";
    }
}
