package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Crie um programa que preencha uma matriz 5 x 5 de números reais, calcule e mostre a soma dos elementos da diagonal secundária.
 */
public class Exercicio18 {
    public static void main(String[] args) {

        var matriz = new int[5][5];
        var diagonalSecundario = 0.0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
                System.out.println(" [" + j + "] [" + i + "] : " + matriz[i][j]);

            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if ((i + j) == 4) {
                    diagonalSecundario += matriz[i][j];

                }
            }
        }
        System.out.println("Soma dos elementos da diagonal secundário é : " + diagonalSecundario);

    }
}
