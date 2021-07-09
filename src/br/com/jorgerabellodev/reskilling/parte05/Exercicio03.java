package br.com.jorgerabellodev.reskilling.parte05;


/**
 * Elabore um programa que preencha uma matriz 6 x 3, calcule e mostre:
 * ■ ■ o maior elemento da matriz e sua respectiva posição, ou seja, linha e coluna;
 * ■ ■ o menor elemento da matriz e sua respectiva posição, ou seja, linha e coluna.
 */
public class Exercicio03 {
    public static void main(String[] args) {


        var matriz = new int[6][3];
        var maior = 0;
        int menor = Integer.MAX_VALUE;
        var indiceLinhaMaior = 0;
        var indiceColunaMaior = 0;
        var indiceLinhaMenor = 0;
        var indiceColunaMenor = 0;

        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 15;
        matriz[1][0] = 29;
        matriz[1][1] = 33;
        matriz[1][2] = 2;
        matriz[2][0] = 55;
        matriz[2][1] = 9;
        matriz[2][2] = 19;
        matriz[3][0] = 91;
        matriz[3][1] = 2;
        matriz[3][2] = 5;
        matriz[4][0] = 21;
        matriz[4][1] = 27;
        matriz[4][2] = 24;
        matriz[5][0] = 38;
        matriz[5][1] = 34;
        matriz[5][2] = 26;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                    indiceLinhaMaior = i;
                    indiceColunaMaior = j;
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    indiceLinhaMenor = i;
                    indiceColunaMenor = j;
                }
            }
        }
        System.out.println("Linha " + indiceLinhaMaior + " e coluna " + indiceColunaMaior + " do maior elemento da matriz: " + maior);
        System.out.println("Linha " + indiceLinhaMenor + " e coluna " + indiceColunaMenor + " do menor elemento da matriz: " + menor);

    }
}
