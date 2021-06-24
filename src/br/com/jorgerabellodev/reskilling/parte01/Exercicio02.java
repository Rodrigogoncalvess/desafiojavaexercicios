package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba três números, calcule e mostre a multiplicação desses números.
 */
public class Exercicio02 {
    public static void main(String[] args) {

        int[] numeros = new int[3];

        Scanner scanner = new Scanner(System.in);
        int resultado = 1;
        try {
            for (int i = 0; i < numeros.length; i++) {
                System.out.println("Digite um valor: ");
                numeros[i] = scanner.nextInt();
                resultado *= numeros[i];
            }
            System.out.println("Resultado da multiplicaçao dos três números digitados: \n" + resultado);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Necessário digitar um número.");
        }
    }
}