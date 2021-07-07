package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia um vetor com quinze posições para números inteiros. Depois da leitura, di-
 * vida todos os seus elementos pelo maior valor do vetor. Mostre o vetor após os cálculos.
 */
public class Exercicio25 {
    public static void main(String[] args) {

        var vetor = new int[15];
        var maior = 0;
        var somaVetor = 0;
        var dividirVetor = 0;


        Scanner scanner = new Scanner(System.in);

        try {

            for (int i = 0; i < vetor.length; i++) {
                System.out.println("Digite um número : ");
                vetor[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] > maior) {
                    maior = vetor[i];
                }
            }
            for (int i = 0; i < vetor.length; i++) {
                somaVetor += vetor[i];
            }
            dividirVetor = somaVetor / maior;
            System.out.println("Dividido pelo maior número do vetor: " + dividirVetor);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}