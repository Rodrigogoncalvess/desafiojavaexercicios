package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia um vetor A de dez posições. Em seguida, compacte o vetor, retirando os
 * valores nulos e negativos. Armazene esse resultado no vetor B. Mostre o vetor B. (Lembre-se: o vetor B
 * pode não ser completamente preenchido.)
 */
public class Exercicio22 {
    public static void main(String[] args) {


        var vetorA = new int[10];
        var vetorB = new int[vetorA.length];
        var numeroNegativo = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < vetorA.length; i++) {
                System.out.println("Digite o número do vetor : ");
                vetorA[i] = scanner.nextInt();
            }
            System.out.println("Números inteiros positivos: ");
            for (int i = 0; i < vetorA.length; i++) {
                if (vetorA[i] >= 0) {
                    System.out.print(vetorA[i] + " ");
                }
            }
            System.out.println();
            for (int i = 0; i < vetorA.length; i++) {
                if (vetorA[i] <= 0) {
                    vetorB[i] = vetorA[i];
                    System.out.println("Posição " + i + " valores nulos ou negativos " + vetorB[i]);
                }
            }
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

}
