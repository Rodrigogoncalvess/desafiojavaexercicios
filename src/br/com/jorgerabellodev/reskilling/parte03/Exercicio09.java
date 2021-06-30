package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dez idades, pesos e alturas, calcule e mostre:
 * ■ ■ a média das idades das dez pessoas;
 * ■ ■ a quantidade de pessoas com peso superior a 90 kg e altura inferior a 1,50 metro; e
 * ■ ■ a porcentagem de pessoas com idade entre 10 e 30 anos entre as pessoas que medem mais de 1,90 m.
 */
public class Exercicio09 {
    public static void main(String[] args) {


        var idade = new double[10];
        var peso = new double[10];
        var altura = new double[10];
        var mediaIdade = 0.0;
        var somaIdade = 0.0;
        var acimaDoPeso = 0;
        var mediaTotal = 0.0;
        var alturaSuperior = 0.0;
        var porcentagem = 0.0;
        var decimal = new DecimalFormat("0.00");


        var scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < 3; i++) {
                System.out.print("Informe sua idade: ");
                idade[i] = scanner.nextInt();
                System.out.print("Informe seu peso: ");
                peso[i] = scanner.nextDouble();
                System.out.print("Informe sua altura: ");
                altura[i] = scanner.nextDouble();


                if (idade[i] > 0) {
                    mediaIdade++;
                    somaIdade += idade[i];
                    mediaTotal = somaIdade / mediaIdade;
                }

                if (peso[i] > 90 && altura[i] < 1.50) {
                    acimaDoPeso++;

                }
                if (idade[i] >= 10 && idade[i] <= 30 && altura[i] > 1.90) {
                    alturaSuperior++;
                    porcentagem = (alturaSuperior / idade.length) * 100;
                }

            }
            System.out.print("Média das idades das dez pessoas: " + (decimal.format(mediaTotal)) + "\n");
            System.out.print("Quantidade de pessoas com peso superior a 90 kg e altura inferior a 1,50 metro: " + (decimal.format(acimaDoPeso)) + "\n");
            System.out.printf("Porcentagem de pessoas com idade entre 10 e 30 anos entre as pessoas que medem mais de 1,90 m: %.2f ", porcentagem);

        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

