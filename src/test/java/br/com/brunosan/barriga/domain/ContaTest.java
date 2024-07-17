package br.com.brunosan.barriga.domain;

import br.com.brunosan.barriga.domain.builders.ContaBuilder;
import br.com.brunosan.barriga.domain.builders.UsuarioBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ContaTest {

    @Test
    void deveCriarContaValida() {
        // criar uma conta
        Conta conta = ContaBuilder.umaConta().agora();
        // fazer assertivas em cima da conta
        assertAll("Conta",
            () -> assertEquals(1L, conta.id()),
            () -> assertEquals("Conta Válida", conta.nome()),
            () -> assertEquals(UsuarioBuilder.umUsuario().agora(), conta.usuario()),
            () -> assertInstanceOf(Usuario.class, UsuarioBuilder.umUsuario().agora())
        );
    }
}
