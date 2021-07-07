package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com dez números reais, calcule e mostre a quantidade de números
 * negativos e a soma dos números positivos desse vetor.
 */
public class Exercicio07 {
    public static void main(String[] args) {

        var numeroReais = new int[10];
        var positivo = 0;
        var negativo = 0;


        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < numeroReais.length; i++) {
                System.out.println("Informe o numero: ");
                numeroReais[i] = scanner.nextInt();

                if (numeroReais[i] <= -1) {
                    negativo++;
                }
                if (numeroReais[i] >= 0) {
                    positivo += numeroReais[i];
                }
            }
            System.out.println("Quantidade de números negativos: " + negativo);
            System.out.println("Soma dos números positivos: " + positivo);

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
