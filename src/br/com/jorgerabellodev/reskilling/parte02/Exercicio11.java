package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o salário atual de um funcionário e, usando a tabela a seguir, calcule e
 * mostre o valor do aumento e o novo salário.
 * ------------------------------------------------------------------
 * SALÁRIO                           PERCENTUAL DE AUMENTO
 * ------------------------------------------------------------------
 * Até R$ 300,00                              15%
 * ------------------------------------------------------------------
 * R$ 300,00                                  10%
 * ------------------------------------------------------------------
 * R$ 600,00                                   5%
 * ------------------------------------------------------------------
 * Acima de R$ 900,00                          0%
 * ------------------------------------------------------------------
 */
public class Exercicio11 {
    public static void main(String[] args) {

        double salario;
        double aumento;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o valor do salário:");
            salario = scanner.nextDouble();
            if (salario <= 300) {
                aumento = (salario * 0.15);
                System.out.println("Valor do aumento: " + (decimalFormat.format(aumento)));
                System.out.println("Novo salário após o reajuste de 15%: " + (decimalFormat.format(aumento+salario)));
            } else if (salario >= 301 && salario <= 600) {
                aumento = (salario * 0.10);
                System.out.println("Valor do aumento: " + (decimalFormat.format(aumento)));
                System.out.println("Novo salário após o reajuste de 10%: " + (decimalFormat.format(aumento+salario)));
            } else if (salario >= 601 && salario <= 900) {
                aumento = (salario * 0.05);
                System.out.println("Valor do aumento: " + (decimalFormat.format(aumento)));
                System.out.println("Novo salário após o reajuste de 5%: " + (decimalFormat.format(aumento+salario)));
            }else {
                System.out.println("Salário atual não terá aumento! ");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
