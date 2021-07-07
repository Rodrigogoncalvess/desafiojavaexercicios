package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia dois vetores (A e B) com cinco posições para números inteiros. O programa
 * deve, então, subtrair o primeiro elemento de A do último de B, acumulando o valor, subtrair o segundo
 * elemento de A do penúltimo de B, acumulando o valor e assim por diante. Ao final, mostre o resultado
 * de todas as subtrações realizadas.
 */
public class Exercicio23 {
    public static void main(String[] args) {

        var vetorA = new int[5];
        var vetorB = new int[vetorA.length];
        var numerosInvertido = 0;


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < vetorA.length; i++) {
                System.out.println("Digite um número do 1° vetor : ");
                vetorA[i] = scanner.nextInt();
            }
            for (int i = vetorB.length - 1; i >= 0; i--) {
                System.out.println("Digite um número do 2° vetor : ");
                vetorB[i] = scanner.nextInt();
            }

            for (int i = 0; i < vetorA.length; i++) {
                vetorA[i] -= vetorB[i];

                System.out.println("subtrações dos números do vetor A com o vetor B invertido: " + vetorA[i]);
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
