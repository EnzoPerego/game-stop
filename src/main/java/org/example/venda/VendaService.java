package org.example.venda;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    private final List<Venda> vendas = new ArrayList<>();
    private int contadorId = 1;

    public List<Venda> getVendas() {
        return vendas;
    }

    public boolean realizarVenda(Venda venda) {
        if (venda.getProduto().getQuantidade() >= venda.getQuantidade()) {
            venda.getProduto().reduzirQuantidade(venda.getQuantidade());
            vendas.add(venda);
            return true;
        }
        return false;
    }

    public Venda getVenda(Integer id) {
        return id >= 0 && id < vendas.size() ? vendas.get(id) : null;
    }

    public boolean cancelarVenda(Integer id) {
        if (id >= 0 && id < vendas.size()) {
            vendas.remove(id.intValue());
            return true;
        }
        return false;
    }
}
