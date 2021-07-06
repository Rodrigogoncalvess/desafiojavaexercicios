package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha dois vetores de dez posições cada, determine e mostre um terceiro con-
 * tendo os elementos dos dois vetores anteriores ordenados de maneira decrescente.
 */
public class Exercicio17 {
    public static void main(String[] args) {

        var vetor1 = new int[10];
        var vetor2 = new int[10];


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < vetor1.length; i++) {
                System.out.println("Digite um número do 1° vetor : ");
                vetor1[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor1.length; i++) {
                System.out.println("Digite um número do 2° vetor : ");
                vetor2[i] = scanner.nextInt();
            }

            var vetor3 = new int[vetor1.length + vetor2.length];

            System.arraycopy(vetor1, 0, vetor3, 0, vetor1.length);
            System.arraycopy(vetor2, 0, vetor3, vetor1.length, vetor2.length);

            for (int i = 0; i < vetor3.length; i++) {
                vetor3[i] = vetor3.length - i;
                System.out.println(vetor3[i]);
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
