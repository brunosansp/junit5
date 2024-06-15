package br.com.brunosan.barriga.domain;

import br.com.brunosan.barriga.domain.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.brunosan.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testing the Dominio::Usuario class")
class UsuarioTest {
    
    private Usuario usuario;
    
    @BeforeEach
    void init() {
        usuario = populateUsuario();
    }
    
    @Test
    @DisplayName("Deve criar um usuário válido")
    void deveCriarUsuarioValido() {
        Usuario usuarioValido = umUsuario().agora();
        assertNotNull(usuarioValido);
    }
    
    @Test
    void getId() {
        assertEquals(1L, usuario.getId());
    }
    
    @Test
    void getNome() {
        assertEquals("Usuario Valido", usuario.getNome());
    }
    
    @Test
    void getEmail() {
        assertEquals("user@email.com", usuario.getEmail());
    }
    
    @Test
    void getSenha() {
        assertEquals("123456", usuario.getSenha());
    }
    
    @Test
    void exemploTesteAllAssertionWithLambda() {
        assertAll("Usuario",
            () -> assertEquals(1L, usuario.getId()),
            () -> assertEquals("Usuario Valido", usuario.getNome()),
            () -> assertEquals("user@email.com", usuario.getEmail()),
            () -> assertEquals("123456", usuario.getSenha())
        );
    }
    
    @Test
    void deveRetornarExceçãoSeUsuarioSemNome() {
        assertThrows(ValidationException.class,
            () -> umUsuario().comNome(null).agora()
        );
    }
    
    private Usuario populateUsuario() {
        return new Usuario(1L, "Usuario Valido", "user@email.com", "123456");
    }
}