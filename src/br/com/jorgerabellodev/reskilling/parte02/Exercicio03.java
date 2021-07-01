package br.com.jorgerabellodev.reskilling.parte02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dois números e mostre o menor.
 */
public class Exercicio03 {
    public static void main(String[] args) {

        int[] numero = new int[2];
        int menor;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < numero.length; i++) {
                System.out.println("Digite um número:");
                numero[i] = scanner.nextInt();
            }
            Arrays.sort(numero);
            menor = numero[0];
            System.out.println("O menor número digita foi:  " + menor);
        } catch (
                InputMismatchException i) {
            System.out.println("Não pode inserir letra ou símbolo ");
        }
    }
}


