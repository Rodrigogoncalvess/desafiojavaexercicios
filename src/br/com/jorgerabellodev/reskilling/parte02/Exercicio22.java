package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade e o peso de uma pessoa. De acordo com a tabela a seguir, verifique
 * e mostre em qual grupo de risco essa pessoa se encaixa.
 * --------------------------------------------------------------------------------------------------------------------
 * |                                    PESO
 * IDADE     | --------------------------------------------------------------------------------------------------
 * |  Até 60            Entre 60 e 90 (inclusive)           Acima de 90
 * --------------------------------------------------------------------------------------------------------------------
 * Menores que 20  |   9                        8                               7
 * De 20 a 50      |   6                        5                               4
 * Meiores que 50  |   3                        2                               1
 * --------------------------------------------------------------------------------------------------------------------
 */
public class Exercicio22 {
    public static void main(String[] args) {

        int idade;
        double peso;

        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("Informe sua idade e seu peso para saber qual é seu grupo de risco:");
            System.out.println("\nDigite sua idade:");
            idade = teclado.nextInt();

            System.out.println("Digite seu peso:");
            peso = teclado.nextDouble();


            if (idade < 20 && peso <= 60) {
                System.out.println("Grupo de risco é 9");

            } else if (idade < 20 && peso > 60 && peso <= 90) {
                System.out.println("Grupo de risco é 8");

            } else if ((idade < 20) && (peso > 90)) {
                System.out.println("Grupo de risco é 7");

            } else if ((idade >= 20) && (idade <= 50) && (peso <= 60)) {
                System.out.println("Grupo de risco é 6");

            } else if ((idade >= 20) && (idade <= 50) && (peso > 60) && (peso <= 90)) {
                System.out.println("Grupo de risco é 5");

            } else if ((idade >= 20) && (idade <= 50) && (peso > 90)) {
                System.out.println("Grupo de risco é 4");

            } else if (idade > 50 && peso <= 60) {
                System.out.println("Grupo de risco é 3");

            } else if ((idade > 50) && (peso > 60) && (peso <= 90)) {
                System.out.println("Grupo de risco é 2");

            } else if (idade > 50 && peso > 90) {
                System.out.println("Grupo de risco é 1");

            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode ser digitado letra ou simbolo!");
        }
    }
}