package org.example.controller;

import org.example.avaliacao.Avaliacao;
import org.example.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarAvaliacao(@RequestBody Avaliacao avaliacao) {
        if (avaliacao.getUsuario() == null) {
            return "Usuário não pode ser nulo";
        }
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            return "A nota deve estar entre 1 e 5";
        }
        avaliacaoService.adicionarAvaliacao(avaliacao);
        return "Avaliação adicionada com sucesso";
    }

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("/{nomeUsuario}")
    public List<Avaliacao> listarAvaliacoesPorUsuario(@PathVariable String nomeUsuario) {
        return avaliacaoService.listarAvaliacoesPorUsuario(nomeUsuario);
    }

    @DeleteMapping("/{index}")
    public String deletarAvaliacao(@PathVariable int index) {
        return avaliacaoService.removerAvaliacao(index);
    }
}
