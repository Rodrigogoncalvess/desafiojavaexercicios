package br.com.jorgerabellodev.reskilling.parte06;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba um valor inteiro e verifique se ele é positivo ou negativo.
 */
public class Exercicio05 {

    public static void main(String[] args) {

        int numero;

        Scanner teclado = new Scanner(System.in);

        SubRotina sub = new SubRotina();

        try {
            System.out.println("Digite um valor: ");
            numero = teclado.nextInt();

            System.out.println(sub.validador(numero));

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

    static class SubRotina {
        public int validador(int numero) {

            if (numero >= 0) {
                System.out.println("Número digitado é positivo!");
            } else {
                System.out.println("Número digitado é negativo!");
            }
            return numero;
        }
    }
}
