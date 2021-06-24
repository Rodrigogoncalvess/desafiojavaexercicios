package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o número de horas trabalhadas, o valor do salário mínimo e o número
 * de horas extras trabalhadas, calcule e mostre o salário a receber, de acordo com as regras a seguir:
 * a) a hora trabalhada vale 1/8 do salário mínimo;
 * b) a hora extra vale 1/4 do salário mínimo;
 * c) o salário bruto equivale ao número de horas trabalhadas multiplicado pelo valor da hora trabalhada;
 * d) a quantia a receber pelas horas extras equivale ao número de horas extras trabalhadas multiplicado pelo valor
 * da hora extra;
 * e) o salário a receber equivale ao salário bruto mais a quantia a receber pelas horas extras.
 */
public class Exercicio21 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o número de horas trabalahas: ");
            double horasTrabalhada = scanner.nextDouble();
            System.out.println("Informe o valor do sálario mínimo: ");
            double salarioMinimo = scanner.nextDouble();
            System.out.println("Informe o número de horas extras trabalhadas: ");
            double horaExtra = scanner.nextDouble();

            double valorHorasTrabalhada = (salarioMinimo / 8);
            double valorHorasExtra = (salarioMinimo / 4);
            double salarioBruto = horasTrabalhada * valorHorasTrabalhada;
            double receberExtra = horaExtra * valorHorasExtra;

            System.out.println("Salário bruto " + (salarioBruto + receberExtra));
        } catch (
                InputMismatchException i) {
            System.out.println("Valor do salário não pode obter letra ou simbolo.");

        }
    }
}

