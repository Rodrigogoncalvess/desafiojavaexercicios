package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Crie um programa que preencha duas matrizes 3 x 8 com números inteiros, calcule e mostre:
 * ■ ■ a soma das duas matrizes, resultando em uma terceira matriz também de ordem 3 x 8;
 * ■ ■ a diferença das duas matrizes, resultando em uma quarta matriz também de ordem 3 x 8.
 */
public class Exercicio08 {
    public static void main(String[] args) {

        final var coluna = 3;
        final var linha = 8;

        var primeiraMatriz = new int[coluna][linha];
        var segundaMatriz = new int[coluna][linha];
        var terceiraMatriz = new int[coluna][linha];
        var quartaMatriz = new int[coluna][linha];
        var somaPrimeiraMatriz = 0;
        var somaSegundaMatriz = 0;
        var somaDuasMatriz = 0;
        var diferecaEntreMatriz = 0;


        Scanner scanner = new Scanner(System.in);

        try {

            for (int i = 0; i < primeiraMatriz.length; i++) {
                for (int j = 0; j < primeiraMatriz[i].length; j++) {

                    System.out.println("Informe o " + (j + 1) + "° valor da linha [" + j + "] da primeira matriz na posição da coluna [" + i + "] : ");
                    primeiraMatriz[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < segundaMatriz.length; i++) {
                for (int j = 0; j < segundaMatriz[i].length; j++) {

                    System.out.println("Informe o " + (j + 1) + "° valor da linha [" + j + "] da segunda matriz na posição da coluna [" + i + "] : ");
                    segundaMatriz[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < primeiraMatriz.length; i++) {
                for (int j = 0; j < primeiraMatriz[i].length; j++) {
                    somaPrimeiraMatriz += primeiraMatriz[i][j];
                }
            }

            for (int i = 0; i < segundaMatriz.length; i++) {
                for (int j = 0; j < segundaMatriz[i].length; j++) {
                    somaSegundaMatriz += segundaMatriz[i][j];
                }
            }
            for (int i = 0; i < terceiraMatriz.length; i++) {
                for (int j = 0; j < terceiraMatriz[i].length; j++) {
                    terceiraMatriz[i][j] = somaPrimeiraMatriz + somaSegundaMatriz;
                    somaDuasMatriz = terceiraMatriz[i][j];
                }
                System.out.println("A soma das duas matrizes: " + somaDuasMatriz);
            }
            for (int i = 0; i < quartaMatriz.length; i++) {
                for (int j = 0; j < quartaMatriz[i].length; j++) {
                    quartaMatriz[i][j] = somaPrimeiraMatriz - somaSegundaMatriz;
                    diferecaEntreMatriz = quartaMatriz[i][j];

                }
            }
            System.out.println("A diferença das duas matrizes: " + diferecaEntreMatriz);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
