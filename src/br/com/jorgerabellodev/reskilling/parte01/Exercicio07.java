package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o peso de uma pessoa, calcule e mostre:
 * a) o novo peso, se a pessoa engordar 15% sobre o peso digitado;
 * b) o novo peso, se a pessoa emagrecer 20% sobre o peso digitado.
 */
public class Exercicio07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o seu peso: ");
            double peso = scanner.nextDouble();

            double engordar = (peso * 0.15) + peso;
            double emagrecer = (peso * 0.20) + peso;
            System.out.println("se a pessoa engordar 15% seu peso atual será: " + engordar);
            System.out.println("se a pessoa emagrecer 20% seu peso atual será: " + emagrecer);

        } catch (InputMismatchException i) {
            System.out.println("Valor da compra não pode obter letra ou simbolo.");

        }
    }
}
