package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o valor do salário mínimo e o valor do salário de um funcionário, calcule
 * e mostre a quantidade de salários mínimos que esse funcionário ganha.
 */
public class Exercicio12 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o valor do sálario mínimo: ");
            double salarioMinimo = scanner.nextDouble();
            System.out.println("Informe o valor do sálario do funcionário: ");
            double salario = scanner.nextDouble();

            double quantidade = salario / salarioMinimo;

            System.out.printf("Quantidade de salário mínimo que o funcionário recebe é: %.2f ",quantidade);
        } catch (
                InputMismatchException i) {
            System.out.println("Valor do salário não pode obter letra ou simbolo.");

        }
    }
}
