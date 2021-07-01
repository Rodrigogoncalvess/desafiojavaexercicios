package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade de uma pessoa e mostre a mensagem de maioridade ou não.
 */
public class Exercicio18 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe sua idade:");
            int idade = scanner.nextInt();
            if (idade >= 18) {
                System.out.println("Você já é adulto!");

            } else {
                System.out.println("Você ainda não atingiu a maioridade!");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}



