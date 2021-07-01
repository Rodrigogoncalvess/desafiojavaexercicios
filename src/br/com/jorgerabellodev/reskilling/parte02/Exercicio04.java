package br.com.jorgerabellodev.reskilling.parte02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba três números e mostre o maior.
 */
public class Exercicio04 {
    public static void main(String[] args) {

        int[] numero = new int[3];
        int maior;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < numero.length; i++) {
                System.out.println("Digite um número:");
                numero[i] = scanner.nextInt();
            }
            Arrays.sort(numero);
            maior = numero[2];
            System.out.println("O maior número digita foi:  " + maior);
        } catch (
                InputMismatchException i) {
            System.out.println("Não pode inserir letra ou símbolo ");
        }
    }
}

