package br.com.jorgerabellodev.reskilling.parte03;

import java.util.Scanner;

/**
 * Faça um programa que receba várias idades, calcule e mostre a média das idades digitadas. Finalize di-
 * gitando idade igual a zero.
 */
public class Exercicio16 {
    public static void main(String[] args) {

        var idade = new double[10];
        var media = 0.0;
        var mediaIdadesDigitadas = 0.0;

        var scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println(" Digite a idade: ");
            idade[i] = scanner.nextDouble();
            media += idade[i];
            mediaIdadesDigitadas = media / idade.length;
            if (idade[i] == 0) {
                System.out.println("Programa finalizado!");
                System.exit(0);
            }
        }
        System.out.printf("Média das idades digitadas: %.2f", mediaIdadesDigitadas);


    }
}