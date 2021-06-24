package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dois números, calcule e mostre a subtração do primeiro número pelo
 * segundo.
 */
public class Exercicio01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite um número:");
            int numero1 = scanner.nextInt();
            System.out.println();
            System.out.println("Digite um número:");
            int numero2 = scanner.nextInt();

            numero1 -= numero2;
            System.out.println("\nResulatdo da subtração do primeiro número pelo segundo: \n" + numero1);

        } catch (InputMismatchException i) {
            System.out.println("Necessário digitar um número.");
        }
    }
}