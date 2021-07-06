package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia dois vetores de dez posições e faça a multiplicação dos elementos de mesmo
 * índice, colocando o resultado em um terceiro vetor. Mostre o vetor resultante.
 */
public class Exercicio19 {
    public static void main(String[] args) {


        var vetor1 = new int[10];
        var vetor2 = new int[10];


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < vetor1.length; i++) {
                System.out.println("Digite um número do 1° vetor : ");
                vetor1[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor2.length; i++) {
                System.out.println("Digite um número do 2° vetor : ");
                vetor2[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor1.length; i++) {
                vetor1[i] *= vetor2[i];
            }

            var vetor3 = new int[vetor1.length];

            System.arraycopy(vetor1, 0, vetor3, 0, vetor1.length);

            for (int i = 0; i < vetor3.length; i++) {
                System.out.println("multiplicação dos elementos de mesmo índice " + i + " com o valor: " + vetor3[i]);
            }

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }


}


