package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Faça um programa que preencha uma matriz 8 x 6 de inteiros, calcule e mostre a média dos elementos das linhas pares da matriz.
 */
public class Exercicio19 {
    public static void main(String[] args) {

        var matriz = new int[5][5];
        var somaElementos = 0.0;
        var media = 0.0;
        var mediaElemento = 0.0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);

            }
        }
        for (int i = 0; i < matriz.length; i++) {
            media++;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    somaElementos += matriz[i][j];
                }
            }
            mediaElemento = somaElementos / media;
        }
        System.out.println("Soma dos elementos pares : " + somaElementos);
        System.out.println("Média: " + mediaElemento);

    }
}
