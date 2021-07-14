package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Random;

/**
 * Faça uma sub-rotina que receba uma matriz 10X10 e determine o maior elemento acima da diagonal principal.
 * Esse valor deverá ser mostrado no programa principal.
 */
public class Exercicio21 {

    static int[][] matriz = new int[10][10];

    public static void main(String[] args) {

        SubRotina subRotina = new SubRotina();

        Random random = new Random();


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
                System.out.println("Informe o número da coluna [" + i + "] na linha [" + j + "]: " + matriz[i][j]);

            }

        }
        subRotina.diagonalPrincipal();
    }

    static class SubRotina {
        public void diagonalPrincipal() {
            int maiorMatriz = 0;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i == j) {
                        if (matriz[i][j] > maiorMatriz) {
                            maiorMatriz = matriz[i][j];
                        }
                    }

                }
            }
            System.out.println("\nMaior elemento da diagonal principal: " + maiorMatriz);

        }
    }
}
