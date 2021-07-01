package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade e o peso de quinze pessoas, e que calcule e mostre as médias dos
 * pesos das pessoas da mesma faixa etária. As faixas etárias são: de 1 a 10 anos, de 11 a 20 anos, de 21 a
 * 30 anos e de 31 anos para cima
 */
public class Exercicio13 {
    public static void main(String[] args) {


        var idade = new int[15];
        var peso = new double[15];
        var mediaPeso = 0.0;
        var faixaEtaria1 = 0.00;
        var faixaEtaria2 = 0.00;
        var faixaEtaria3 = 0.00;
        var faixaEtaria4 = 0.00;
        var decimal = new DecimalFormat("0.00");

        var scanner = new Scanner(System.in);

        try {
            for (var i = 0; i < 15; i++) {
                System.out.print("Informe sua idade: ");
                idade[i] = scanner.nextInt();
                System.out.print("Informe sua peso: ");
                peso[i] = scanner.nextDouble();

                if (idade[i] >= 1 && idade[i] <= 10) {
                    mediaPeso += peso[i];
                    faixaEtaria1 = mediaPeso / idade.length;
                }
                if (idade[i] >= 11 && idade[i] <= 20) {
                    mediaPeso += peso[i];
                    faixaEtaria2 = mediaPeso / idade.length;
                }
                if (idade[i] >= 21 && idade[i] <= 30) {
                    mediaPeso += peso[i];
                    faixaEtaria3 = mediaPeso / idade.length;
                }
                if (idade[i] >= 31) {
                    mediaPeso += peso[i];
                    faixaEtaria4 = mediaPeso / idade.length;
                }
            }
            System.out.print("Média de peso na faixa etária de 1 a 10 anos: " + (decimal.format(faixaEtaria1)));
            System.out.print("\nMédia de peso na faixa etária de 11 a 20 anos: " + (decimal.format(faixaEtaria2)));
            System.out.print("\nMédia de peso na faixa etária de 21 a 30 anos: " + (decimal.format(faixaEtaria3)));
            System.out.print("\nMédia de peso na faixa etária maior que 31 anos: " + (decimal.format(faixaEtaria4)));
        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

