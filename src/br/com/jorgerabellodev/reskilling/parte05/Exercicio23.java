package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;

/**
 * Faça um programa que preencha uma matriz 3 x 4, calcule e mostre:
 * ■ ■ a quantidade de elementos pares;
 * ■ ■ a soma dos elementos ímpares;
 * ■ ■ a média de todos os elementos.
 */
public class Exercicio23 {
    public static void main(String[] args) {


        final int coluna = 3;
        final var linha = 4;

        var matriz = new int[coluna][linha];
        var qtdPares = 0;
        var somaImpares = 0;
        var somaTodos = 0.0;
        var mediaElemento = 0.0;
        var qtdElemento = 0;

        Random random = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    qtdPares++;
                }
                if (matriz[i][j] % 2 == 1) {
                    somaImpares += matriz[i][j];
                }
                somaTodos += matriz[i][j];
                qtdElemento++;
            }
            mediaElemento = somaTodos / qtdElemento;
        }
        System.out.println("Quantidade de elementos pares: " + qtdPares);
        System.out.println("Soma dos elementos ímpares: " + somaImpares);
        System.out.println("Média de todos os elementos: " + mediaElemento);

    }
}
