package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade e a altura de várias pessoas, calcule e mostre a média das alturas
 * daquelas com mais de 50 anos. Para encerrar a entrada de dados, digite idade menor ou igual a zero.
 */
public class Exercicio22 {
    public static void main(String[] args) {

        var idade = new int[10];
        var altura = 0.0;
        var media = 0;
        var mediaAltura = 0.0;

        var teclado = new Scanner(System.in);

        try {

            for (int i = 0; i < idade.length; i++) {
                System.out.println("Informe idade:");
                idade[i] = teclado.nextInt();

                if (idade[i] <= 0) {
                    System.out.println("Programa encerrado!");
                    return;
                }

                System.out.println("Informe altura:");
                altura = teclado.nextDouble();

                if (idade[i] > 50) {
                    media++;
                    mediaAltura += altura;
                    mediaAltura /= media;
                }
            }
            System.out.println("Média das alturas daquelas com mais de 50 anos: " + mediaAltura);
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
