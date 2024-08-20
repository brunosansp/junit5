package br.com.brunosan.barriga.repositories;

import br.com.brunosan.barriga.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    
    Usuario salvar(Usuario usuario);
    Optional<Usuario> getUserByEmail(String email);
}
