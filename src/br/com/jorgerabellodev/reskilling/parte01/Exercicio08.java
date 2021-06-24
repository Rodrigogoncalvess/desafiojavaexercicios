package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o peso de uma pessoa em quilos, calcule e mostre esse peso em gramas.
 */
public class Exercicio08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o seu peso: ");
            double quilos = scanner.nextDouble();

            double gramas = quilos / 0.001;
            System.out.println("O peso convertido em gramas é: " + gramas);

        } catch (InputMismatchException i) {
            System.out.println("Valor do peso não pode obter letra ou simbolo.");

        }
    }
}
