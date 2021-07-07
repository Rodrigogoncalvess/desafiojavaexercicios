package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia um vetor com dez posições para números inteiros. Crie um segundo vetor,
 * substituindo os valores nulos por 1. Mostre os dois vetores.
 */
public class Exercicio21 {
    public static void main(String[] args) {


        var vetor1 = new int[10];
        var vetor2 = new int[vetor1.length];


        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < vetor1.length; i++) {
                System.out.println("Digite o número do vetor : ");
                vetor1[i] = scanner.nextInt();
            }
            System.out.println("Números inteiros positivos: ");
            for (int i = 0; i < vetor1.length; i++) {
                if (vetor1[i] != 0) {
                    System.out.print(vetor1[i] + " ");
                }
            }
            for (int i = 0; i < vetor1.length; i++) {
                if (vetor1[i] == 0) {
                    vetor2[i] += 1;
                    System.out.println("\nPosição " + i + " foi substituída por " + vetor2[i] + " por ser nula");
                }
            }
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

}

