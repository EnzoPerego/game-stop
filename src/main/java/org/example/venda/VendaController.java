package org.example.venda;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getVendas() {
        return vendaService.getVendas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String realizarVenda(@RequestBody Venda venda) {
        boolean sucesso = vendaService.realizarVenda(venda);
        return sucesso ? "Venda realizada com sucesso" : "Erro ao realizar venda";
    }

    @GetMapping("/{id}")
    public Venda getVenda(@PathVariable Integer id) {
        return vendaService.getVenda(id);
    }

    @DeleteMapping("/{id}")
    public String cancelarVenda(@PathVariable Integer id) {
        boolean sucesso = vendaService.cancelarVenda(id);
        return sucesso ? "Venda cancelada com sucesso" : "Venda não encontrada";
    }
}
