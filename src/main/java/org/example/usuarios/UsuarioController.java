package org.example;

import org.example.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private org.example.UsuarioService usuarioService;

    @GetMapping
    public HashMap<String, Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null) {
            return "Nome não pode ser nulo";
        }
        if (usuario.getEmail() == null) {
            return "Email não pode ser nulo";
        }
        usuarioService.salvarUsuario(usuario);
        return "Usuário salvo com sucesso";
    }

    @GetMapping("/{email}")
    public Usuario getUsuario(@PathVariable String email) {
        return usuarioService.getUsuario(email);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirUsuario(@PathVariable String email) {
        Usuario usuario = usuarioService.removerUsuario(email);
        if (usuario != null) {
            return "Usuário removido com sucesso";
        }
        return "Usuário não encontrado";
    }

    @PutMapping("/{email}")
    public String editarUsuario(@PathVariable String email, @RequestBody Usuario usuario) {
        Usuario usuarioEditado = usuarioService.editarUsuario(email, usuario);
        if (usuarioEditado != null) {
            return "Usuário alterado com sucesso";
        }
        return "Usuário não encontrado";
    }
}