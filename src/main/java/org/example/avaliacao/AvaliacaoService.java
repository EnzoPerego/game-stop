package org.example.service;

import org.example.avaliacao.Avaliacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvaliacaoService {
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return new ArrayList<>(avaliacoes);
    }

    public List<Avaliacao> listarAvaliacoesPorUsuario(String nomeUsuario) {
        List<Avaliacao> resultado = new ArrayList<>();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getUsuario().getNome().equalsIgnoreCase(nomeUsuario)) {
                resultado.add(avaliacao);
            }
        }
        return resultado;
    }

    public String removerAvaliacao(int index) {
        if (index >= 0 && index < avaliacoes.size()) {
            avaliacoes.remove(index);
            return "Avaliação deletada com sucesso";
        }
        return "Falha ao deletar a avaliação.";
    }
}
