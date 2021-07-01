package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cada espectador de um cinema respondeu a um questionário no qual constava sua idade e sua opinião
 * em relação ao filme: ótimo — 3; bom — 2; regular — 1. Faça um programa que receba a idade e a opinião de
 * quinze espectadores, calcule e mostre:
 * ■ ■ a média das idades das pessoas que responderam ótimo;
 * ■ ■ a quantidade de pessoas que responderam regular; e
 * ■ ■ a percentagem de pessoas que responderam bom, entre todos os espectadores analisados.
 */
public class Exercicio14 {
    public static void main(String[] args) {
        var idade = new double[15];
        var filme = 0;
        var mediaOtima = 0;
        var mediaBom = 0.0;
        var mediaRegular = 0;
        var mediaIdade = 0.0;

        var decimal = new DecimalFormat("0.00");

        var scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < 3; i++) {

                System.out.println("Digite sua idade: ");
                idade[i] = scanner.nextInt();

                System.out.println("Digite sua  sua opinião em relação ao filme \n" +
                        "1 - Ótimo\n" +
                        "2 - Bom\n" +
                        "3 - Regular");
                filme = scanner.nextInt();

                while (filme != 3) {

                    switch (filme) {
                        case 1:
                            mediaOtima++;
                            mediaIdade += idade[i];
                            mediaIdade = mediaIdade / mediaOtima;
                            break;
                        case 2:
                            mediaBom++;
                            mediaIdade /= idade.length;
                            break;

                        case 3:
                            mediaRegular++;
                            break;



                    }break;

                }
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
        System.out.println("média das idades das pessoas que responderam ótimo: " + (decimal.format(mediaIdade)));
        System.out.println("Quantidade de pessoas que responderam regular: " + (decimal.format(mediaBom)));
        System.out.println("Quantidade de pessoas que responderam regular: " + mediaRegular);


    }
}

