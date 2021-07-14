package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba um valor inteiro e positivo, calcule e mostre seu fatorial.
 */
public class Exercicio08 {

    static int total = 1;

    public static void main(String[] args) {

        int numero;

        SubRotina subRotina = new SubRotina();

        Scanner scan = new Scanner(System.in);


        System.out.println("Digite um número: ");
        numero = scan.nextInt();

        System.out.println("Valor do fatorial é " + subRotina.multiplicacao(numero));


    }

    static class SubRotina {
        public int multiplicacao(int valor) {
            for (int i = 2; i <= valor; i++) {
                total *= i;

            }
            return total;
        }
    }
}
