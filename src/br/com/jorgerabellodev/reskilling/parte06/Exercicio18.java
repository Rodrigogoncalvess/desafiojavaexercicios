package br.com.jorgerabellodev.reskilling.parte06;

/**
 * Crie uma sub-rotina que gere e mostre os três primeiros números primos acima de 100.
 */
public class Exercicio18 {
    public static void main(String[] args) {

        int numero = 110;

        for (int i = 100; i < numero; i++) {
            if (EPrimo(i)) {
                System.out.println("Esse é número primo: " + i);

            }
        }

    }

    static boolean EPrimo(int numero) {
        var numDivisores = 0;
        for (int j = 1; j <= numero; j++) {
            if (numero % j == 0) {
                numDivisores++;
            }
        }
        if (numDivisores == 2) {

            return true;

        } else {

            return false;
        }
    }
}