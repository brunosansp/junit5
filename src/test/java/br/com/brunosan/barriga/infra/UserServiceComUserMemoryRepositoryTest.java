package br.com.brunosan.barriga.infra;

import br.com.brunosan.barriga.domain.Usuario;
import br.com.brunosan.barriga.infra.UsuarioMemoryRespository;
import br.com.brunosan.barriga.service.UsuarioService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static br.com.brunosan.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {
    private static UsuarioService service = new UsuarioService(new UsuarioMemoryRespository());
    
    @Test
    @Order(1)
    void deveSalvarUsuarioValido() {
        Usuario usuario = service.salvar(umUsuario().comId(null).agora());
        assertNotNull(usuario.getId());
    }

//    @Test
//    @Order(2)
//    void deveRejeitarUsuarioExistente() {
//        ValidationException exception = assertThrows(ValidationException.class, () ->
//            service.salvar(umUsuario().comId(null).agora())
//        );
//        assertEquals("Usuário user@email.com já cadastrado!", exception.getMessage());
//    }
}
