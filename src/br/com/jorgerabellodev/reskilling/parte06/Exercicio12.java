package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Crie uma sub-rotina que receba como parâmetro dois valores X e Z, calcule e retorne X^2 sem utilizar
 * funções ou operadores de potência prontos.
 */
public class Exercicio12 {

    static int total;

    public static void main(String[] args) {

        int num1;
        int num2;

        SubRotina sub = new SubRotina();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite 1° valor:");
        num1 = scan.nextInt();

        System.out.println("Digite 2° valor:");
        num2 = scan.nextInt();

        System.out.println("Soma dos dois valores já com a o 1° valor elevadoa a potência 2: " + sub.quadrado(num1, num2));
    }

    static class SubRotina {
        public int quadrado(int valor1, int valor2) {
            total = valor1 * valor1;
            total = total + valor2;

            return total;
        }
    }

}
