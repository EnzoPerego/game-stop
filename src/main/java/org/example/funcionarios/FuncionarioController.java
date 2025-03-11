package org.example.funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public HashMap<Integer, Funcionario> getFuncionarios() {
        return funcionarioService.getFuncionarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarFuncionario(@RequestBody Funcionario funcionario) {
        if (funcionario.getNome() == null) {
            return "Nome não pode ser nulo";
        }
        if (funcionario.getCargo() == null) {
            return "Cargo não pode ser nulo";
        }
        funcionarioService.salvarFuncionario(funcionario);
        return "Funcionário salvo com sucesso";
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionario(@PathVariable int id) {
        return funcionarioService.getFuncionario(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirFuncionario(@PathVariable int id) {
        Funcionario funcionario = funcionarioService.removerFuncionario(id);
        if (funcionario != null) {
            return "Funcionário removido com sucesso";
        }
        return "Funcionário não encontrado";
    }

    @PutMapping("/{id}")
    public String editarFuncionario(@PathVariable int id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioEditado = funcionarioService.editarFuncionario(id, funcionario);
        if (funcionarioEditado != null) {
            return "Funcionário alterado com sucesso";
        }
        return "Funcionário não encontrado";
    }
}