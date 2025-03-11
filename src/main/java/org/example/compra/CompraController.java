package org.example.compra;

import org.example.compra.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarCompra(@RequestBody Compra compra) {
        compraService.adicionarCompra(compra);
        return "Compra realizada com sucesso";
    }

    @GetMapping
    public List<Compra> listarCompras() {
        return compraService.listarCompras();
    }
}
