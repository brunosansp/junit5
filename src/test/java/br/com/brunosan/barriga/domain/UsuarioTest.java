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
        usuario = umUsuario().agora();
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
        assertEquals("Usuário Válido", usuario.getNome());
    }
    
    @Test
    void getEmail() {
        assertEquals("user@email.com", usuario.getEmail());
    }
    
    @Test
    void getSenha() {
        assertEquals("12345678", usuario.getSenha());
    }
    
    @Test
    void exemploTesteAllAssertionWithLambda() {
        assertAll("Usuario",
            () -> assertEquals(1L, usuario.getId()),
            () -> assertEquals("Usuário Válido", usuario.getNome()),
            () -> assertEquals("user@email.com", usuario.getEmail()),
            () -> assertEquals("12345678", usuario.getSenha())
        );
    }
    
    @Test
    void deveRetornarExcecaoSeUsuarioSemNome() {
        ValidationException ex = assertThrows(ValidationException.class,
            () -> umUsuario().comNome(null).agora()
        );
        assertEquals("Nome é obrigatório", ex.getMessage());
    }
    
    @Test
    void deveRetornarExcecaoSeUsuarioSemEmail() {
        ValidationException ex = assertThrows(ValidationException.class,
            () -> umUsuario().comEmail(null).agora()
        );
        assertEquals("Email é obrigatório", ex.getMessage());
    }
    
    @Test
    void deveRetornarExcecaoSeUsuarioSemSenha() {
        ValidationException ex = assertThrows(ValidationException.class,
            () -> umUsuario().comSenha(null).agora()
        );
        assertEquals("Senha é obrigatória", ex.getMessage());
    }
}