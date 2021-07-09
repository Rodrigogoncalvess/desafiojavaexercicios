package br.com.jorgerabellodev.reskilling.parte05;

/**
 * Faça um programa que preencha uma matriz 2 x 3, calcule e mostre a quantidade de elementos da matriz que não pertencem ao intervalo [5,15].
 */
public class Exercicio14 {
    public static void main(String[] args) {

        var matriz = new int[2][3];
        var qtdElementos = 0;

        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 15;
        matriz[1][0] = 29;
        matriz[1][1] = 3;
        matriz[1][2] = 2;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 5) {
                    System.out.println("[ " + i + " ] [ " + j + " ] valor da linha: " + matriz[i][j]);

                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 15) {
                    System.out.println("[ " + i + " ] [ " + j + " ] valor da linha: " + matriz[i][j]);

                }
            }
        }
    }
}
