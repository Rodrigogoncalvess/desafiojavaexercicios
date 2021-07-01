package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba quatro notas de um aluno, calcule e mostre a média aritmética das notas e a
 * mensagem de aprovado ou reprovado, considerando para aprovação média 7.
 */
public class Exercicio01 {
    public static void main(String[] args) {

        double[] notas = new double[4];

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < notas.length; i++) {
                System.out.println("Digite a nota: " + (i + 1));
                notas[i] = scanner.nextDouble();
            }
            double media = 0;
            for (int i = 0; i < notas.length; i++) {
                media += notas[i];
                System.out.println("Notas " + (i + 1) + ": " + notas[i]);
            }
            media /= notas.length;
            System.out.println("Média final: " + media);

            if (media < 7) {
                System.out.println("Aluno reprovado");
            } else {
                System.out.println("Aluno aprovado");
            }

        } catch (InputMismatchException i) {
            System.out.println("Não pode inserir letra ou símbolo ");
        }
    }
}
