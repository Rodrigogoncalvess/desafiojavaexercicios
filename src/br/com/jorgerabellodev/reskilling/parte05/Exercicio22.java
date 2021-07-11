package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Crie um programa que preencha uma matriz 6 x 10, some as colunas individualmente e acumule as somas na 7 a linha da matriz.
 * O programa deverá mostrar o resultado de cada coluna.
 */
public class Exercicio22 {
    public static void main(String[] args) {

        final var linha = 6;
        final int coluna = 10;

        var matriz = new int[linha][coluna];
        var somaColuna = 0;
        var totalSomaColuna = 0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            somaColuna = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                somaColuna += matriz[i][j];
            }
            totalSomaColuna += somaColuna;
            System.out.println("Soma de cada coluna: " + somaColuna);

        }
        System.out.println("Total da soma de todas as colunas: " + totalSomaColuna);
    }
}
