package br.com.jorgerabellodev.reskilling.parte05;

/**
 * Crie um programa que preencha uma matriz 5 x 5 com números inteiros, calcule e mostre a soma:
 * ■ ■ dos elementos da linha 4;
 * ■ ■ dos elementos da coluna 2;
 * ■ ■ dos elementos da diagonal principal;
 * ■ ■ dos elementos da diagonal secundária;
 * ■ ■ de todos os elementos da matriz.
 */
public class Exercicio10 {
    public static void main(String[] args) {

        var matriz = new int[5][5];
        var linha = 0;
        var coluna = 0;
        var diagonalPrincipal = 0;
        var diagonalSecundario = 0;
        var somaTotal = 0;

        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 15;
        matriz[0][3] = 13;
        matriz[0][4] = 18;
        matriz[1][0] = 29;
        matriz[1][1] = 33;
        matriz[1][2] = 2;
        matriz[1][3] = 6;
        matriz[1][4] = 9;
        matriz[2][0] = 55;
        matriz[2][1] = 9;
        matriz[2][2] = 17;
        matriz[2][3] = 15;
        matriz[2][4] = 19;
        matriz[3][0] = 91;
        matriz[3][1] = 2;
        matriz[3][2] = 9;
        matriz[3][3] = 7;
        matriz[3][4] = 5;
        matriz[4][0] = 21;
        matriz[4][1] = 27;
        matriz[4][2] = 24;
        matriz[4][3] = 27;
        matriz[4][4] = 34;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 3) {
                    linha += matriz[i][j];
                }
                if (i == 1) {
                    coluna += matriz[i][j];
                }
                if (i == j) {
                    diagonalPrincipal += matriz[i][j];
                }
                if ((i + j) == 4) {
                    diagonalSecundario += matriz[i][j];
                }
                somaTotal += matriz[i][j];
            }
        }
        System.out.println("Soma dos elementos da linha 4: " + linha);
        System.out.println("Soma dos elementos da coluna 2: " + coluna);
        System.out.println("Soma dos elementos da diagonal principal: " + diagonalPrincipal);
        System.out.println("Soma dos elementos da diagonal secundária: " + diagonalSecundario);
        System.out.println("Soma de todos os elementos da matriz: " + somaTotal);
    }
}
