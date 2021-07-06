package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * * Faça um programa que preencha um vetor com dez números inteiros e um segundo vetor com cinco números inteiros,
 * * calcule e mostre dois vetores resultantes. O primeiro vetor resultante será composto pela soma de cada números par do primeiro vetor
 * * somado a todos os números do segundo vetor. O segundo vetor resultante será composto pela quantidade de divisores que cada número ímpar
 * * do primeiro vetor tem no segundo vetor.
 */
// tirar dúvida da segunda ação.

public class Exercicio10 {

    public static void main(String[] args) {

        var primeiroConjuntoNumero = new int[10];
        var segundoConjuntoNumero = new int[5];
        var totalNumeroPar = 0;
        var totalNumeroImparPrimeiroVetor = 0;
        var totalNumeroImparSegundoVetor = 0;
        var somaTotalNumeroParComSegundoVetor = 0;
        var somaTotalSegundoVetor = 0;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < primeiroConjuntoNumero.length; i++) {
                System.out.println("Informe o número 1° vetor: ");
                primeiroConjuntoNumero[i] = scanner.nextInt();
            }

            for (int i = 0; i < segundoConjuntoNumero.length; i++) {
                System.out.println("Informe o número 2° vetor: ");
                segundoConjuntoNumero[i] = scanner.nextInt();

            }

            for (int i = 0; i < primeiroConjuntoNumero.length; i++) {
                if (primeiroConjuntoNumero[i] % 2 == 0) {
                    totalNumeroPar += primeiroConjuntoNumero[i];
                }
            }
            for (int i = 0; i < segundoConjuntoNumero.length; i++) {
                somaTotalSegundoVetor += segundoConjuntoNumero[i];
            }
            somaTotalNumeroParComSegundoVetor = totalNumeroPar + somaTotalSegundoVetor;

            for (int i = 0; i < primeiroConjuntoNumero.length; i++) {
                if (primeiroConjuntoNumero[i] % 2 == 1) {
                    totalNumeroImparPrimeiroVetor++;

                }
            }
            for (int i = 0; i < segundoConjuntoNumero.length; i++) {
                if (primeiroConjuntoNumero[i] % 2 == 1) {
                    totalNumeroImparSegundoVetor++;

                }
            }
            System.out.println("Total de números ímpar no 1° vetor: " + totalNumeroImparPrimeiroVetor);
            System.out.println("Total de números ímpar no 2° vetor: " + totalNumeroImparSegundoVetor);
            System.out.println("Soma dos números pares do 1° com todos os números do 2° vetor: " + somaTotalNumeroParComSegundoVetor);

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}



