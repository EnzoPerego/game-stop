package org.example;

import org.example.usuarios.Usuario;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class UsuarioService {
    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void salvarUsuario(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    public Usuario getUsuario(String email) {
        return usuarios.get(email);
    }

    public Usuario removerUsuario(String email) {
        return usuarios.remove(email);
    }

    public Usuario editarUsuario(String email, Usuario usuario) {
        Usuario usuarioExistente = getUsuario(email);
        if (usuarioExistente != null) {
            if (usuario.getNome() != null) {
                usuarioExistente.setNome(usuario.getNome());
            }
        }
        return usuarioExistente;
    }
}
