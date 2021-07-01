package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa para calcular e mostrar o salário reajustado de um funcionário. O percentual de aumento
 * encontra-se na tabela a seguir.
 * ------------------------------------------------
 * Salário              | Percentual de aumento
 * ------------------------------------------------
 * Até R$ 300,00        |   35%
 * Acima de R$ 300,00   |   15%
 * ------------------------------------------------
 */
public class Exercicio08 {
    public static void main(String[] args) {

        double salario;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe seu salário para saber qual percentual de reajuste terá direito:");
            salario = scanner.nextDouble();
            if (salario <= 300) {
                double receber = (salario * 0.35) + salario;
                System.out.println("Funcionário terá um aumento no salário 35%, valor já com o reajuste:" + (decimalFormat.format(receber)));
            } else {
                double receber = (salario * 0.15) + salario;
                System.out.println("Funcionário terá um aumento no salário 15%, valor já com o reajuste:" + (decimalFormat.format(receber)));

            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
