package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Scanner;

/**
 * Faça um programa que leia um vetor com quinze posições para números inteiros. Crie, a seguir, um vetor
 * resultante que contenha todos os números primos do vetor digitado. Escreva o vetor resultante.
 */
public class Exercicio24 {
    public static void main(String[] args) {

        var numero = new int[3];
        var numerosPrimos = new Integer[numero.length];
        var todosNumerosPrimos = 0;

        var scanner = new Scanner(System.in);

        for (var i = 0; i < numero.length; i++) {
            System.out.println("Digite um número: ");
            numero[i] = scanner.nextInt();

            if (EPrimo(numero[i])) {
                numerosPrimos[todosNumerosPrimos] = numero[i];
                todosNumerosPrimos++;
            }
        }
        System.out.println("Todos os números primos do vetor digitado:");
        for (int i = 0; i < numerosPrimos.length; i++) {
            if (numerosPrimos[i] != null) {
                System.out.print(numerosPrimos[i] + " ");
            }
        }

    }

    static boolean EPrimo(int numero) {
        var numDivisores = 0;
        for (int j = 1; j <= numero; j++) {
            if (numero % j == 0) {
                numDivisores++;
            }
        }
        if (numDivisores == 2) {

            return true;

        } else {

            return false;
        }
    }
}







