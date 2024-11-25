package br.com.brunosan.barriga.infra;

import br.com.brunosan.barriga.domain.Usuario;
import br.com.brunosan.barriga.repositories.UsuarioRepository;

import java.util.Optional;

import static br.com.brunosan.barriga.domain.builders.UsuarioBuilder.umUsuario;

public class UsuarioDummyRepository implements UsuarioRepository {
    @Override
    public Usuario salvar(Usuario usuario) {
        return umUsuario()
            .comNome(usuario.getNome())
            .comEmail(usuario.getEmail())
            .comSenha(usuario.getSenha())
            .agora();
    }
    
    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return Optional.of(umUsuario().comEmail(email).agora());
    }
}
