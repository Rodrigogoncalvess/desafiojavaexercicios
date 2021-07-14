package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba um número inteiro e positivo N como parâmetro e retorne a soma dos núme-
 * ros inteiros existentes entre o número 1 e N (inclusive).
 */
public class Exercicio01 {

    static int total;

    public static void main(String[] args) {

        int numero;

        SubRotina sub = new SubRotina();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número: ");
        numero = scan.nextInt();

        System.out.println("Soma dos números inteiros: " + (sub.soma(numero)));
    }

    static class SubRotina {
        public int soma(int valor) {
            for (int i = 1; i <= valor; i++) {
                total += i;
            }
            return total;
        }
    }
}
