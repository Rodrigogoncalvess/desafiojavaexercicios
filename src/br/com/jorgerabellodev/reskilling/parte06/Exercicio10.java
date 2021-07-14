package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Elabore uma sub-rotina que receba como parâmetro um valor N (inteiro e maior ou igual a 1) e determine o valor da sequência S, descrita a seguir:
 * S = 1 + 1/2 + 1/3 ...
 * OBS: A quantidade de parcelas que compõe S é igual a N.
 */
public class Exercicio10 {
    public static void main(String[] args) {

        double numero;
        double sequencia = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        numero = scanner.nextInt();

        if (numero >= 1) {
            for (int i = 1; i <= numero; i++) {
                if (i % 2 == 0) {
                    sequencia -= (double) 1 / i;
                } else {
                    sequencia += (double) 1 / i;
                }
                System.out.println(sequencia);
            }
        }
    }
}

