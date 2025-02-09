package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com seis elementos numéricos inteiros. Calcule e mostre:
 * ■ ■ todos os números pares;
 * ■ ■ a quantidade de números pares;
 * ■ ■ todos os números ímpares;
 * ■ ■ a quantidade de números ímpares.
 */
public class Exercicio01 {
    public static void main(String[] args) {

        var numero = new int[6];
        var pares = new int[6];
        var impar = new int[6];
        var numeroPares = 0;
        var numeroImpar = 0;

        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < numero.length; i++) {
                System.out.println("Informe o número: ");
                numero[i] = scanner.nextInt();
            }

            for (int i = 0; i < numero.length; i++) {

                if (numero[i] % 2 == 0) {
                    pares[numeroPares] = numero[i];
                    numeroPares++;

                } else {
                    impar[numeroImpar] = numero[i];
                    numeroImpar++;
                }
            }
            var totalPar = new int[numeroPares];

            for (int i = 0; i < numeroPares; i++) {

                totalPar[i] = pares[i];
            }
            var totalImpar = new int[numeroImpar];
            for (int i = 0; i < numeroImpar; i++) {

                totalImpar[i] = impar[i];
            }

            System.out.println("Quantidade de números pares: " + numeroPares);
            System.out.println("todos os números pares: " + Arrays.toString(totalPar));
            System.out.println("Quantidade de números ímpares: " + numeroImpar);
            System.out.println("todos os números ímpares: " + Arrays.toString(totalImpar));
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
