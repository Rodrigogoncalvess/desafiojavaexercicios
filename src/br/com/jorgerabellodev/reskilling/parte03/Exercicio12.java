package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dez números inteiros e mostre a quantidade de números primos dentre os
 * números que foram digitados.
 */
public class Exercicio12 {
    public static void main(String[] args) {
        var numero = new int[10];
        var somaPrimo = 0;

        var scanner = new Scanner(System.in);

        try {
            for (var i = 0; i < 10; i++) {
                System.out.print("Digite um número: ");
                numero[i] = scanner.nextInt();

                if (numero[i] == 2) {
                    somaPrimo++;
                }
                if (numero[i] % 2 == 0) {
                    somaPrimo++;
                }
            }
            System.out.println("Quantidade de números primos dentre os números que foram digitados: " + (somaPrimo));
        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
