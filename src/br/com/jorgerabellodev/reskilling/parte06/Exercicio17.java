package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Elabore uma sub-rotina que calcule o máximo divisor comum (MDC) de dois números recebidos como
 * parâmetros.
 */
public class Exercicio17 {

    static int valor1;
    static int valor2;

    public static void main(String[] args) {


        SubRotina sub = new SubRotina();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite o primeiro valor: ");
        valor1 = scanner.nextInt();
        System.out.println("Digite o segundo valor: ");
        valor2 = scanner.nextInt();

        System.out.println("O máximo de divisor comum MDC é " + (sub.divisorComum(valor1)));
    }


    static class SubRotina {
        public int divisorComum(int resto) {

            while (valor2 != 0) {
                resto = valor1 % valor2;
                valor1 = valor2;
                valor2 = resto;

            }
            return valor1;


        }
    }
}