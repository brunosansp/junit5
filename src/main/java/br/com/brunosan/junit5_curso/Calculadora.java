package br.com.brunosan.junit5_curso;

public class Calculadora {
    
    public int soma(int a, int b) {
        return a + b;
    }
    
    public float divisao(int numerador, int denominador) {
        return (float) numerador / denominador;
    }
    
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        System.out.println(calculadora.soma(2, 3));
        System.out.println(calculadora.soma(3, 4));
        System.out.println(calculadora.soma(5, 6));
        
        System.out.println(calculadora.soma(2, 3) == 5);
        System.out.println(calculadora.soma(3, 4) == 7);
        System.out.println(calculadora.soma(5, 6) == 11);
    }
}
