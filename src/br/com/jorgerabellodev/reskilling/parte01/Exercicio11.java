package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que calcule e mostre a área de um losango. Sabe-se que: A = (diagonal maior * dia-
 * gonal menor)/2.
 */
public class Exercicio11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe a área maior do losango que deseja calcular: ");
            double maior = scanner.nextDouble();
            System.out.println("Informe a área menor do losango que deseja calcular: ");
            double menor = scanner.nextDouble();

            double area = (maior * menor) / 2;

            System.out.println("Área do losango é: " + area);
        } catch (
                InputMismatchException i) {
            System.out.println("Valor do losango não pode obter letra ou simbolo.");

        }
    }
}

