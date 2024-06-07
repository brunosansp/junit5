package br.com.brunosan.junit5_curso;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class CalculadoraTest {
    
    private static Calculadora calculadora;
    private static int contador = 0;
    
    @BeforeEach
    void beforeEach() {
        System.out.println("^^^^");
    }
    
    @AfterEach
    void afterEach() {
        System.out.println("vvvv");
    }
    
    @BeforeAll
    static void init() {
        calculadora = new Calculadora();
        System.out.println("--- Before All ---");
    }
    
    @AfterAll
    static void afterAll() {
        System.out.println("--- After All ---");
    }
    
    @Test
    void testSoma() {
        System.out.println(++contador);
        int result = calculadora.soma(2, 3);
        assertEquals(5, result);
    }
    
    @Test
    void testDivisao() {
        System.out.println(++contador);
        float result = calculadora.divisao(8, 2);
        assertEquals(4, result);
    }
    
    @Test
    void testDivisao_ShouldReturnNegativeNumber() {
        System.out.println(++contador);
        float result = calculadora.divisao(6, -2);
        assertEquals(-3, result);
    }
    
    @Test
    void testDivisao_ShouldReturnDecimalNumber() {
        System.out.println(++contador);
        float result = calculadora.divisao(10, 3);
        assertEquals(3.3333332538604736, result);
        assertEquals(3.33, result, 0.01);
    }
    
    @Test
    void testDivisao_ShouldThrowException_When_DenominatorNumberZero_Junit4() {
        try {
            float result = 6 / 0;
            fail("Deveria ter lançado uma exceção na divisão");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }
    
    @Test
    void testDivisao_ShouldThrowException_When_DenominatorNumberZero_Junit5() {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> {
            float result = 10 / 0;
        });
        assertEquals("/ by zero", arithmeticException.getMessage());
    }
}