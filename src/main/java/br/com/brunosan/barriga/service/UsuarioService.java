package br.com.brunosan.barriga.service;

import br.com.brunosan.barriga.domain.Usuario;
import br.com.brunosan.barriga.domain.exceptions.ValidationException;
import br.com.brunosan.barriga.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;
    
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public Usuario salvar(Usuario usuario) {
        repository.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
            throw new ValidationException(String.format("Usuário %s já cadastrado!", usuario.getEmail()));
        });
        return repository.salvar(usuario);
    }
}
