package br.com.brunosan.junit5_curso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    
    @Test
    void testSoma() {
        Calculadora calculadora = new Calculadora();
        int result = calculadora.soma(2, 3);
        assertEquals(5, result);
    }
}