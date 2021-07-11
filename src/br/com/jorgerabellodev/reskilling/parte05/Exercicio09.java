package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha uma matriz 3 x 3 com números reais e outro valor numérico digitado pelo
 * usuário. O programa deverá calcular e mostrar a matriz resultante da multiplicação do número digitado por
 * cada elemento da matriz.
 */
public class Exercicio09 {
    public static void main(String[] args) {

        var matriz = new int[3][3];
        var valorNumerico = 0;
        var numero = 0;

        matriz[0][0] = 22;
        matriz[0][1] = 11;
        matriz[0][2] = 4;
        matriz[1][0] = 44;
        matriz[1][1] = 55;
        matriz[1][2] = 9;
        matriz[2][0] = 2;
        matriz[2][1] = 5;
        matriz[2][2] = 21;

        Scanner scan = new Scanner(System.in);

        try {

            System.out.println("Digite uma valor númerico para realizar multiplicação com cada elemento da matriz:");
            valorNumerico = scan.nextInt();

            System.out.println();
            for (int i = 0; i < matriz.length; i++) {

                for (int j = 0; j < matriz[i].length; j++) {

                    System.out.println("Coluna[ " + i + " ] linha [ " + j + " ] tem o valor: " + matriz[i][j]);
                    numero = matriz[i][j] * valorNumerico;
                    System.out.println("Multiplicação do número digitado pelo o elemento da matriz: " + numero);
                }
                System.out.println();
            }
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
