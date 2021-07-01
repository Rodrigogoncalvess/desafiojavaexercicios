package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.String.format;

/**
 * Uma empresa decide dar um aumento de 30% aos funcionários com salários inferiores a R$ 500,00. Faça um
 * programa que receba o salário do funcionário e mostre o valor do salário reajustado ou uma mensagem, caso
 * ele não tenha direito ao aumento.
 */
public class Exercicio07 {
    public static void main(String[] args) {


        double salario;

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe seu salário para saber se tem direito ao aumento 30% :");
            salario = scanner.nextDouble();
            if (salario < 500) {
                double receber = (salario * 0.3) + salario;
                System.out.printf("Funcionário terá um aumento no salário, valor já com o reajuste: %.2f", receber);
            } else {
                System.out.println("Funcionário não tem direito ao aumento!");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
