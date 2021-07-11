package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Elabore um programa que preencha uma matriz 4 x 5, calcule e mostre um vetor com cinco posições, onde cada posição
 * contém a soma dos elementos de cada coluna da matriz. O programa deverá mostrar apenas os elementos do vetor maiores que dez.
 * Se não existir nenhum elemento maior que dez, deverá mostrar uma mensagem.
 */
public class Exercicio24 {
    public static void main(String[] args) {

        final int coluna = 4;
        final var linha = 5;

        var matriz = new int[coluna][linha];
        var somaColuna = 0;
        boolean validador = false;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(5);
                System.out.println("[ " + i + " ] [ " + j + " ] valor da linha: " + matriz[i][j]);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            somaColuna = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                somaColuna += matriz[i][j];
            }
            if (somaColuna > 10) {
                validador = true;
                System.out.println("Soma dos elementos da coluna [" + i + "] totalizou: " + somaColuna);
            }
        }
        while (validador == false) {

            System.out.println("Não existe nem um vetor com a soma total superior a 10.");
            return;
        }
    }
}
