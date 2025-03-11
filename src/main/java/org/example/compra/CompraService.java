package org.example.compra;

import org.example.compra.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    private final List<Compra> compras = new ArrayList<>();

    public void adicionarCompra(Compra compra) {
        compras.add(compra);
        compra.realizarCompra();
    }

    public List<Compra> listarCompras() {
        return new ArrayList<>(compras);
    }
}
