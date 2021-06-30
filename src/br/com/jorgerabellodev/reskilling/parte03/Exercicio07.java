package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade, a altura e o peso de cinco pessoas, calcule e mostre:
 * ■ ■ a quantidade de pessoas com idade superior a 50 anos;
 * ■ ■ a média das alturas das pessoas com idade entre 10 e 20 anos;
 * ■ ■ a porcentagem de pessoas com peso inferior a 40 kg entre todas as pessoas analisadas.
 */
public class Exercicio07 {
    public static void main(String[] args) {

        var idade = new int[6];
        var altura = new double[6];
        var peso = new double[6];
        var superior = 0;
        var media = 0;
        var mediaAltura = 0;
        var inferior = 0;
        var mediaInferior = 0;

        var scanner = new Scanner(System.in);

        try {
            for (var i = 1; i < 3; i++) {
                System.out.print("Informe sua idade: ");
                idade[i] = scanner.nextInt();
                System.out.print("Informe sua altura: ");
                altura[i] = scanner.nextDouble();
                System.out.print("Informe sua peso: ");
                peso[i] = scanner.nextDouble();

                if (idade[i] > 50) {
                    superior++;

                }
                if (idade[i] >= 10 && idade[i] <= 20) {
                    media++;
                    mediaAltura += altura[i];
                    mediaAltura /= media;
                }

                if (peso[i] < 40) {
                    inferior++;
                    mediaInferior += peso[i];
                    mediaInferior /= inferior;
                }

            }

            System.out.print("Idade superior 50 anos: " + superior);
            System.out.print("\nmédia das alturas das pessoas com idade entre 10 e 20 anos: " + mediaAltura);
            System.out.print("\nPeso inferior a 40 quilos: " + (mediaInferior));

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

