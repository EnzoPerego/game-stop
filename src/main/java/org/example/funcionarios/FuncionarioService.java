package org.example.funcionarios;

import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class FuncionarioService {
    private HashMap<Integer, Funcionario> funcionarios = new HashMap<>();

    public HashMap<Integer, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
    }

    public Funcionario getFuncionario(int id) {
        return funcionarios.get(id);
    }

    public Funcionario removerFuncionario(int id) {
        return funcionarios.remove(id);
    }

    public Funcionario editarFuncionario(int id, Funcionario funcionario) {
        Funcionario funcionarioExistente = getFuncionario(id);
        if (funcionarioExistente != null) {
            if (funcionario.getNome() != null) {
                funcionarioExistente.setNome(funcionario.getNome());
            }
            if (funcionario.getCargo() != null) {
                funcionarioExistente.setCargo(funcionario.getCargo());
            }
        }
        return funcionarioExistente;
    }
}
