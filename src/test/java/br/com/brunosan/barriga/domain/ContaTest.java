package br.com.brunosan.barriga.domain;

import br.com.brunosan.barriga.domain.builders.ContaBuilder;
import br.com.brunosan.barriga.domain.builders.UsuarioBuilder;
import br.com.brunosan.barriga.domain.exceptions.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static br.com.brunosan.barriga.domain.builders.ContaBuilder.umaConta;
import static br.com.brunosan.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTest {
    
    @Test
    void deveCriarContaValida() {
        // criar uma conta
        Conta conta = umaConta().agora();
        // fazer assertivas em cima da conta
        assertAll("Conta",
            () -> assertEquals(1L, conta.id()),
            () -> assertEquals("Conta Válida", conta.nome()),
            () -> assertEquals(umUsuario().agora(), conta.usuario()),
            () -> assertInstanceOf(Usuario.class, umUsuario().agora())
        );
    }
    
    @ParameterizedTest
    @MethodSource("dataProvider")
    void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem) {
        String errorMessage = assertThrows(ValidationException.class,
            () -> umaConta().comId(id).comNome(nome).comUsuario(usuario).agora()
        ).getMessage();
        assertEquals(mensagem, errorMessage);
    }
    
    private static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(1L, null, umUsuario().agora(), "Nome é obrigatório"),
            Arguments.of(1L, "Conta Válida", null, "Usuário é obrigatório")
        );
    }
}
