package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Elabore um programa que preencha uma matriz 5 x 5 e crie dois vetores de cinco posições cada um, que
 * contenham, respectivamente, as somas das linhas e das colunas da matriz. O programa deverá escrever
 * a matriz e os vetores criados.
 */
public class Exercicio16 {
    public static void main(String[] args) {

        var matriz = new int[5][5];
        var vetor = new int[matriz.length];
        var somaVetor = 0;

        Random random = new Random();


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                vetor[i] = matriz[i][j] = random.nextInt(10);
                somaVetor += vetor[i];
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.println("Linha [" + j + "] da posição da coluna [" + i + "] : " + matriz[i][j]);
            }
        }
        System.out.println("Soma das linhas e das colunas da matriz: " + somaVetor);
    }
}


