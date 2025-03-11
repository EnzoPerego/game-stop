package org.example.emprestimo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public HashMap<Integer, Emprestimo> getEmprestimos() {
        return emprestimoService.getEmprestimos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarEmprestimo(@RequestBody Emprestimo emprestimo) {
        if (emprestimo.getUsuario() == null || emprestimo.getProdutos() == null || emprestimo.getProdutos().isEmpty()) {
            return "Usuário e produtos são obrigatórios para realizar um empréstimo.";
        }

        emprestimoService.salvarEmprestimo(emprestimo);
        return "Empréstimo salvo com sucesso";
    }

    @GetMapping("/{id}")
    public Emprestimo getEmprestimo(@PathVariable int id) {
        return emprestimoService.getEmprestimo(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirEmprestimo(@PathVariable int id) {
        Emprestimo emprestimo = emprestimoService.removerEmprestimo(id);
        if (emprestimo != null) {
            return "Empréstimo removido com sucesso";
        }
        return "Empréstimo não encontrado";
    }

    @PutMapping("/{id}")
    public String editarEmprestimo(@PathVariable int id, @RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoEditado = emprestimoService.editarEmprestimo(id, emprestimo);
        if (emprestimoEditado != null) {
            return "Empréstimo alterado com sucesso";
        }
        return "Empréstimo não encontrado";
    }
}