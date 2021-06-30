package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dez números, calcule e mostre a soma dos números pares e a soma dos
 * números primos.
 */
public class Exercicio10 {
    public static void main(String[] args) {

        var numero = new int[10];
        var somaPar = 0;
        var somaPrimo = 0;

        var scanner = new Scanner(System.in);

        try {
            for (var i = 0; i < 10; i++) {
                System.out.println("Digite um número: ");
                numero[i] = scanner.nextInt();

                if (numero[i] % 2 == 0) {
                    somaPar += numero[i];
                }
                if (numero[i] == 2) {
                    somaPrimo += numero[i];
                }
                if (numero[i] % 2 == 1) {
                    somaPrimo += numero[i];
                }
            }
            System.out.println("Soma total dos números primos: " + (somaPrimo));
            System.out.println("Soma total dos  números pares: " + somaPar);
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}




