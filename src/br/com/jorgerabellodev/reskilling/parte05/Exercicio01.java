package br.com.jorgerabellodev.reskilling.parte05;

/**
 * Faça um programa que preencha uma matriz 3 x 5 com números inteiros, calcule e mostre a quantidade de
 * elementos entre 15 e 20.
 */
public class Exercicio01 {
    public static void main(String[] args) {
        var matriz = new int[3][5];
        var total = 0;

        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 4;
        matriz[0][3] = 29;
        matriz[0][4] = 33;
        matriz[1][0] = 44;
        matriz[1][1] = 55;
        matriz[1][2] = 9;
        matriz[1][3] = 19;
        matriz[1][4] = 91;
        matriz[2][0] = 2;
        matriz[2][1] = 5;
        matriz[2][2] = 21;
        matriz[2][3] = 27;
        matriz[2][4] = 24;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("[ " + i + " ] [ " + j + " ]" + matriz[i][j]);
                if ((matriz[i][j] >= 15) && (matriz[i][j] <= 20)) {
                    total++;
                }
            }
        }
        System.out.println("Quantidade de números entre 15 e 20: " + total);
    }
}

