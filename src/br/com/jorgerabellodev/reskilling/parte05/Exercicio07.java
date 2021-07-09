package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Elabore um programa que preencha uma matriz M de ordem 4 x 6 e uma segunda matriz N de ordem 6 x 4,
 * calcule e imprima a soma das linhas de M com as colunas de N.
 */
public class Exercicio07 {
    public static void main(String[] args) {

        var M = new int[4][6];
        var N = new int[6][4];
        var primeiraMatriz = 0;
        var segundaMatriz = 0;
        var somaDeLinha = 0;
        var test = 0;

        Scanner scanner = new Scanner(System.in);
        try {

//

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {


                    System.out.println("Informe o " + (j + 1) + "° valor da linha [" + j + "] da posição da coluna [" + i + "] : ");
                    M[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < N.length; i++) {
                for (int j = 0; j < N[i].length; j++) {
                    System.out.println("Informe o " + (j + 1) + "° número da coluna [" + j + "] da linha [" + i + "]  matriz N");
                    N[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    primeiraMatriz += M[i][j];
                }
            }
            for (int i = 0; i < N.length; i++) {
                for (int j = 0; j < N[i].length; j++) {
                    segundaMatriz += N[i][j];

                }

            }
            somaDeLinha = primeiraMatriz + segundaMatriz;

            System.out.println("Soma das linhas da matriz M " + primeiraMatriz);
            System.out.println("Soma das colunas da matriz N: " + segundaMatriz);
            System.out.println("Soma das linhas da matriz M e as colunas da matriz M: " + somaDeLinha);
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

}
