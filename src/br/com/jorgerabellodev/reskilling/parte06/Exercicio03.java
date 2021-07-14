package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Elabore uma sub-rotina que receba dois números como parâmetros e retorne 0, se o primeiro número for
 * divisível pelo segundo número. Caso contrário, deverá retornar o próximo divisor.
 */
public class Exercicio03 {


    static int numero1;
    static int numero2;

    public static void main(String[] args) {

        SubRotina subRotina = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Primeiro número:");
        numero1 = scanner.nextInt();
        while (numero1 == 0) {
            if (numero1 == 0) {
                System.out.println("Primeiro número não pode ser zero, digite um valor válido:");
                numero1 = scanner.nextInt();
            }
        }

        System.out.println("Segundo número:");
        numero2 = scanner.nextInt();

        while (numero1 < numero2) {
            if (numero1 < numero2) {

                System.out.println("Digite novamente o segundo numero:");
                numero2 = scanner.nextInt();
            }
        }

        subRotina.divisor();

    }

    static class SubRotina {
        public void divisor() {
            if (numero1 % numero2 == 0) {
                System.out.println("Primeiro número é divisível pelo segundo!");
                return;
            }
            for (int i = numero2; i <= numero1; i++) {
                if (numero1 % i == 0) {
                    System.out.println("Próximo divisor é " + i);
                    break;
                }
            }

        }
    }

}





