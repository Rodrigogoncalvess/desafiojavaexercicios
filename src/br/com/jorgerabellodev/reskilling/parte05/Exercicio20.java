package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Elabore um programa que preencha uma matriz 5 x 5 com números reais e encontre o maior valor da matriz.
 * A seguir, o programa deverá multiplicar cada elemento da diagonal principal pelo maior valor encontrado e mostrar a matriz resultante após as multiplicações.
 */
public class Exercicio20 {
    public static void main(String[] args) {

        final int coluna = 5;
        final int linha = 5;

        var matriz = new int[coluna][linha];
        var diagonalPrincipal = 0;
        var maior = 0;
        var mediaElemento = 0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
                System.out.println("[" + i + "] [" + j + "] : " + matriz[i][j]);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];

                }
                if (i == j) {
                    mediaElemento++;
                    diagonalPrincipal = matriz[i][j];
                }
                mediaElemento = (diagonalPrincipal * maior);
            }
            System.out.println("Multiplicação do maior número da matriz por cada elemento da diagonal principal: " + mediaElemento);

        }
        System.out.println("Maior valor da matriz: " + maior);
    }
}
