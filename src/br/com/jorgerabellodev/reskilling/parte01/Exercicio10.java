package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que calcule e mostre a área de um quadrado. Sabe-se que: A = lado * lado.
 */
public class Exercicio10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe a área de um quadrado que deseja calcular: ");
            double lado = scanner.nextDouble();
            double area = Math.pow(lado,2);

            System.out.println("Área do quadrado é: " + area);
        } catch (
                InputMismatchException i) {
            System.out.println("Valor da área não pode obter letra ou simbolo.");

        }
    }
}

