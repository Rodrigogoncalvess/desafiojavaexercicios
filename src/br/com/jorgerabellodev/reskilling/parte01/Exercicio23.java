package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a medida de dois ângulos de um triângulo, calcule e mostre a medida do
 * terceiro ângulo. Sabe-se que a soma dos ângulos de um triângulo é 180 graus.
 */
public class Exercicio23 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe primeiro ângulo do triângulo: ");
            double base1 = scanner.nextDouble();
            System.out.println("Informe segundo ângulo do triângulo: ");
            double base2 = scanner.nextDouble();

            double area = 180 - (base1 + base2);

            System.out.println("Medida do terceiro ângulo é: " + area);
        } catch (
                InputMismatchException i) {
            System.out.println("Número do ãngulo não pode obter letra ou simbolo.");

        }
    }
}
