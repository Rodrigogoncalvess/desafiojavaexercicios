package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Faça um programa que preencha e mostre a média dos elementos da diagonal principal de uma matriz
 * 10 x 10.
 */
public class Exercicio17 {
    public static void main(String[] args) {

        var matriz = new int[10][10];
        var diagonal = 0;
        var mediaDiagonal = 0.0;
        var diagonalPrincipal = 0.0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (i == j) {
                    diagonalPrincipal += matriz[i][j];
                    diagonal++;
                }

            }
        }
        mediaDiagonal = diagonalPrincipal / diagonal;


        System.out.println("Soma dos elementos da diagonal principal: " + diagonalPrincipal);
        System.out.println("Média da soma dos elementos da diagonal principal: " + mediaDiagonal);

    }
}

