package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com quinze números, determine e mostre:
 * ■ ■ o maior número e a posição por ele ocupada no vetor;
 * ■ ■ o menor número e a posição por ele ocupada no vetor.
 */
public class Exercicio18 {
    public static void main(String[] args) {


        var vetor = new int[15];
        var maior = 0;
        var menor = Integer.MAX_VALUE;
        var indiceMaior = 0;
        var indiceMenor = 0;


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < vetor.length; i++) {
                System.out.println("Digite um número do vetor : ");
                vetor[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor.length; i++) {

                if (vetor[i] > maior) {
                    maior = vetor[i];
                    indiceMaior = i;
                }
                if (vetor[i] <= menor) {
                    menor = vetor[i];
                    indiceMenor = i;
                }
            }

            System.out.println("Posição por ele ocupada no vetor é " + indiceMaior + " e seu  maior número é " + maior);
            System.out.println("Posição por ele ocupada no vetor é " + indiceMenor + " e seu  menor número é " + menor);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
