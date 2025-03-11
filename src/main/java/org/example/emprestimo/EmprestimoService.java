package org.example.emprestimo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EmprestimoService {

    private HashMap<Integer, Emprestimo> emprestimos = new HashMap<>();
    private int idCounter = 1;

    public HashMap<Integer, Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void salvarEmprestimo(Emprestimo emprestimo) {
        emprestimos.put(idCounter, emprestimo);
        idCounter++;
    }

    public Emprestimo getEmprestimo(int id) {
        return emprestimos.get(id);
    }

    public Emprestimo removerEmprestimo(int id) {
        return emprestimos.remove(id);
    }

    public Emprestimo editarEmprestimo(int id, Emprestimo emprestimo) {
        Emprestimo emprestimoEditar = getEmprestimo(id);

        if (emprestimoEditar != null) {
            if (emprestimo.getUsuario() != null) {
                emprestimoEditar.setUsuario(emprestimo.getUsuario());
            }
            if (emprestimo.getProdutos() != null && !emprestimo.getProdutos().isEmpty()) {
                emprestimoEditar.setProdutos(emprestimo.getProdutos());
            }
            if (emprestimo.getDataEmprestimo() != null) {
                emprestimoEditar.setDataEmprestimo(emprestimo.getDataEmprestimo());
            }
            if (emprestimo.getDataDevolucao() != null) {
                emprestimoEditar.setDataDevolucao(emprestimo.getDataDevolucao());
            }
        }
        return emprestimoEditar;
    }
}