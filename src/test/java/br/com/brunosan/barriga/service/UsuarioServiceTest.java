package br.com.brunosan.barriga.service;

import org.junit.jupiter.api.Test;

class UsuarioServiceTest {

    private UsuarioService service;
    
    @Test
    void deveSalvarUsuarioComSucesso() {
        service = new UsuarioService(null);
    }
}