package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade de oito pessoas, calcule e mostre:
 * a) a quantidade de pessoas em cada faixa etária;
 * b) a porcentagem de pessoas na primeira faixa etária com relação ao total de pessoas.
 * c) a porcentagem de pessoas na última faixa etária com relação ao total de pessoas
 * ------------------------------------------------------------
 * FAIXA ETÁRIA             IDADE
 * ------------------------------------------------------------
 * 1                     Até 15 anos
 * 2                     De 16 a 30 anos
 * 3                     De 31 a 45 anos
 * 4                     De 46 a 60 anos
 * 5                     Acima de 60 anos
 * ------------------------------------------------------------
 */
public class Exercicio03 {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var idade = 0;
        var quantidade1 = 0;
        var quantidade2 = 0;
        var pessoa1 = 0;
        var pessoa2 = 0;
        var pessoa3 = 0;
        var pessoa4 = 0;
        var pessoa5 = 0;
        var porcentagem = 100;

        try {
            for (var i = 1; i < 9; i++) {
                System.out.print("Digite idade da " + i + "° pessoa: ");
                idade = scanner.nextInt();


                if (idade <= 15) {
                    pessoa1++;
                }
                if (idade >= 16 && idade <= 30) {
                    pessoa2++;
                }
                if (idade >= 31 && idade <= 45) {
                    pessoa3++;
                }
                if (idade >= 46 && idade <= 60) {
                    pessoa4++;
                }
                if (idade > 60) {
                    pessoa5++;
                }
                quantidade1 = pessoa1 * porcentagem / i;
                quantidade2 = pessoa5 * porcentagem / i;
            }

            System.out.println("Quantidade de pessoas na faixa etária  <=15: " + pessoa1);
            System.out.println("Quantidade de pessoas na faixa etária >= 16 & <= 30: " + pessoa2);
            System.out.println("Quantidade de pessoas na faixa etária >= 31 & <= 45: " + pessoa3);
            System.out.println("Quantidade de pessoas na faixa etária >=46 & <= 60: " + pessoa4);
            System.out.println("Quantidade de pessoas na faixa etária <= 61: " + pessoa5);

            System.out.println("Porcentagem de pessoas na primeira faixa etária com relação ao total de pessoas " + quantidade1 + "%");
            System.out.println("Porcentagem de pessoas na última faixa etária com relação ao total de pessoas " + quantidade2 + "%");

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");

        }
    }
}

