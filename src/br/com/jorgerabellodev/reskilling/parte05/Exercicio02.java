package br.com.jorgerabellodev.reskilling.parte05;

/**
 * Crie um programa que preencha uma matriz 2 x 4 com números inteiros, calcule e mostre:
 * ■ ■ a quantidade de elementos entre 12 e 20 em cada linha;
 * ■ ■ a média dos elementos pares da matriz.
 */
public class Exercicio02 {
    public static void main(String[] args) {

        var matriz = new int[2][4];
        var totalElementos = 0;
        var qtdElementos = 0.0;
        var mediaElementos = 0.0;

        matriz[0][0] = 22;
        matriz[0][1] = 12;
        matriz[0][2] = 4;
        matriz[0][3] = 29;
        matriz[1][0] = 18;
        matriz[1][1] = 55;
        matriz[1][2] = 9;
        matriz[1][3] = 19;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((matriz[i][j] >= 12) && (matriz[i][j] <= 20)) {
                    totalElementos++;
                }
                if (matriz[i][j] % 2 == 0) {
                    qtdElementos += matriz[i][j];
                }
            }
            mediaElementos = qtdElementos / matriz.length;

        }
        System.out.println("A quantidade de elementos entre 12 e 20 em cada linha: " + totalElementos);
        System.out.println("a média dos elementos pares da matriz.: " + mediaElementos);
    }
}

