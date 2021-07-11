package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Faça um programa que preencha uma matriz 5 x 5 de números reais. A seguir, o programa deverá multiplicar cada linha
 * pelo elemento da diagonal principal daquela linha e mostrar a matriz após as multiplicações.
 */
public class Exercicio21 {
    public static void main(String[] args) {


        final int coluna = 5;
        final int linha = 5;

        var matriz = new int[coluna][linha];
        var multiplicacao = 0;
        var soma = 0;
        var elementoDiagonal = 0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[j][i];


                if (i == j) {
                    elementoDiagonal = matriz[i][j];
                }
                multiplicacao = elementoDiagonal * soma;
            }
            System.out.println("Soma da linha [" + i + "] " + soma + " multiplicado pelo elemento da diagonal principal: " + multiplicacao);
        }
    }
}

