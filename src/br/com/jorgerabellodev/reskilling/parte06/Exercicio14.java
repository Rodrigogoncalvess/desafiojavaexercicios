package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba um vetor X de 30 elementos inteiros como parâmetro e retorne dois
 * vetores A e B. O vetor A deve conter os elementos de X que sejam maiores que zero e o vetor B, os elementos menores ou iguais a zero.
 */
public class Exercicio14 {

    static int[] vetor = new int[3];

    public static void main(String[] args) {


        int menor = 0;
        int maior = 0;

        SubRotina subRotina = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor: ");
            vetor[i] = scanner.nextInt();

        }
//
        subRotina.vetores(vetor);
        subRotina.imprimirMaior();
        subRotina.imprimirMenor();
    }

    static class SubRotina {
        static int[] vetorA = new int[3];
        static int[] vetorB = new int[3];

        public void vetores(int[] valor) {
            int positivo = 0;
            int negativo = 0;


            for (int num : vetor) {
                if (num > 0) {
                    vetorA[positivo] = num;
                    positivo++;

                } else {
                    vetorB[negativo] = num;
                    negativo++;
                }
            }

        }

        public void imprimirMaior() {


            System.out.println("Vetor A recebe números maior que 0: " + Arrays.toString(vetorA));

        }

        public void imprimirMenor() {
            System.out.println("Vetor B recebe números menores que 1: " + Arrays.toString(vetorB));
        }

    }
}



