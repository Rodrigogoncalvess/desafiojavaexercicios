package br.com.jorgerabellodev.reskilling.parte05;

/**
 * Elabore um programa que: preencha uma matriz 6 x 4; recalcule a matriz digitada, onde cada linha de-
 * verá ser multiplicada pelo maior elemento da linha em questão; mostre a matriz resultante.
 */
public class Exercicio13 {
    public static void main(String[] args) {

        var matriz = new int[6][4];
        var linha = 0;
        var maiorNumeroLinha = 0;


        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 15;
        matriz[0][3] = 13;
        matriz[1][0] = 29;
        matriz[1][1] = 3;
        matriz[1][2] = 2;
        matriz[1][3] = 6;
        matriz[2][0] = 45;
        matriz[2][1] = 9;
        matriz[2][2] = 17;
        matriz[2][3] = 15;
        matriz[3][0] = 71;
        matriz[3][1] = 2;
        matriz[3][2] = 9;
        matriz[3][3] = 7;
        matriz[4][0] = 88;
        matriz[4][1] = 27;
        matriz[4][2] = 58;
        matriz[4][3] = 27;
        matriz[5][0] = 92;
        matriz[5][1] = 2;
        matriz[5][2] = 9;
        matriz[5][3] = 7;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maiorNumeroLinha) {
                    maiorNumeroLinha = matriz[i][j];
                }
                System.out.println("[ " + i + " ] [ " + j + " ] valor da linha: " + matriz[i][j] + " multiplicado por: " + maiorNumeroLinha);
                linha = matriz[i][j] * maiorNumeroLinha;
                System.out.println("[ " + i + " ] [ " + j + " ] resultado da multiplicação = " + linha);
            }

        }

    }
}


