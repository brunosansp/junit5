package br.com.brunosan.barriga.domain.infra;

import br.com.brunosan.barriga.domain.Usuario;
import br.com.brunosan.barriga.domain.exceptions.ValidationException;
import br.com.brunosan.barriga.infra.UsuarioMemoryRespository;
import br.com.brunosan.barriga.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static br.com.brunosan.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceComUserMemoryRepositoryTest {
    private static UsuarioService service = new UsuarioService(new UsuarioMemoryRespository());
    
    @Test
    void deveSalvarUsuarioValido() {
        Usuario usuario = service.salvar(umUsuario().comId(null).agora());
        assertNotNull(usuario.getId());
    }
    
//    @Test
//    void deveRejeitarUsuarioExistente() {
//        ValidationException exception = assertThrows(ValidationException.class, () ->
//            service.salvar(umUsuario().comId(null).agora())
//        );
//        assertEquals("Usuário user@email.com já cadastrado!", exception.getMessage());
//    }
}
