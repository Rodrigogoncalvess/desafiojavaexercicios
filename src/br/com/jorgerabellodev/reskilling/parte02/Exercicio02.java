package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba duas notas, calcule e mostre a média aritmética e a mensagem que se encontra
 * na tabela a seguir:
 * -----------------------------------------
 * MÉDIA aritmética   |  Mensagem
 * -----------------------------------------
 * 0,0 a 3,0          |  Reprovado
 * 3,0 a 7,0          |  Exame
 * 7,0 a 10,0         |  Aprovado
 * -----------------------------------------
 */
public class Exercicio02 {
    public static void main(String[] args) {

        double[] notas = new double[2];

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
            System.out.println("Média aritmética: " + media);

            if (media >= 0 && media < 3) {
                System.out.println("Aluno reprovado");
            } else if (media >= 3 && media < 7) {
                System.out.println("Exame");
            } else if (media >= 7) {
                System.out.println("Aluno aprovado");
            }

        } catch (InputMismatchException i) {
            System.out.println("Não pode inserir letra ou símbolo ");
        }
    }
}
