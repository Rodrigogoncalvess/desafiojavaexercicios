package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Crie uma sub-rotina que receba como parâmetro um valor inteiro e positivo e retorne a soma dos divisores
 * desse valor.
 */
public class Exercicio09 {

    static int total;

    public static void main(String[] args) {

        int numero;

        SubRotina subRotina = new SubRotina();

        Scanner scan = new Scanner(System.in);


        System.out.println("Digite um número: ");
        numero = scan.nextInt();

        System.out.println("Soma dos divisores desse número é " + subRotina.divisores(numero));

    }

    static class SubRotina {
        public int divisores(int valor) {
            for (int i = 1; i < valor; i++) {
                if (valor % i == 0) {
                    total += i;
                }
            }
            return total;
        }
    }
}
