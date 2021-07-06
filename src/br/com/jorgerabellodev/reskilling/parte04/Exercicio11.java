package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dez números inteiros e armazene-os em um vetor. Calcule e mostre dois
 * vetores resultantes: o primeiro com os números pares e o segundo, com os números ímpares.
 */
public class Exercicio11 {
    public static void main(String[] args) {

        var numeros = new int[10];
        var pares = new int[10];
        var impares = new int[10];
        var numerosPares = 0;
        var numerosImpares = 0;


        Scanner scanner = new Scanner(System.in);

        try {

            for (int i = 0; i < numeros.length; i++) {
                System.out.println("Informe o número: ");
                numeros[i] = scanner.nextInt();

                if (numeros[i] % 2 == 0) {
                    pares[numerosPares] = numeros[i];
                    numerosPares++;
                }
                if (numeros[i] % 2 == 1) {
                    impares[numerosImpares] = numeros[i];
                    numerosImpares++;
                }
            }
            var totalPares = new int[numerosPares];
            for (int i = 0; i < numerosPares; i++) {
                totalPares[i] = pares[i];
            }
            var totalImpares = new int[numerosImpares];
            for (int i = 0; i < numerosImpares; i++) {
                totalImpares[i] = impares[i];

            }
            System.out.println("Todos os números pares: " + Arrays.toString(totalPares));
            System.out.println("Todos os números ímpares: " + Arrays.toString(totalImpares));

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
