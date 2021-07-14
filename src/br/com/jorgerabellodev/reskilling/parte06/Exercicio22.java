package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Random;

/**
 * Criar um programa que:
 * ■ ■ utilize uma sub-rotina para receber os elementos de uma matriz 10X5 de números reais;
 * ■ ■ utilize uma sub-rotina para calcular a soma de todos os elementos localizados abaixo da sexta linha
 * dessa matriz;
 * Os resultados deverão ser mostrados no programa principal.
 */
public class Exercicio22 {

    static int[][] matriz = new int[10][5];

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();

        Random random = new Random();


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(5);
                System.out.println("Informe o número da coluna [" + i + "] na linha [" + j + "]: " + matriz[i][j]);

            }

        }
        sub.somaMatriz();

    }

    static class SubRotina {
        public void somaMatriz() {
            int soma = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 1; j < matriz[i].length; j++) {
                    soma += matriz[i][j];
                }

            }
            System.out.println("\nSoma de todos os elementos localizados abaixo da sexta linha: " + soma);

        }
    }
}


