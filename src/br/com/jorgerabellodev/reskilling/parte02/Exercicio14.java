package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o salário de um funcionário e, usando a tabela a seguir, calcule e mostre
 * o novo salário.
 * ------------------------------------------------------------
 * FAIXA SALARIAL           % DE AUMENTO
 * ------------------------------------------------------------
 * Até R$ 300,00                    50%
 * R$ 300,00 A R$ 500,00            40%
 * R$ 500,00 A R$ 700,00            30%
 * R$ 700,00 A R$ 800,00            20%
 * R$ 800,00 A R$ 1.000,00          10%
 * Acima de R$ 1.000,00              5%
 * ------------------------------------------------------------
 */
public class Exercicio14 {
    public static void main(String[] args) {

        double salario;
        double aumento;


        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o valor do salário:");
            salario = scanner.nextDouble();
            if (salario <= 300) {
                aumento = (salario * 0.50)+salario;
                System.out.println("Novo salário após o aumento 50%: " + (decimalFormat.format(aumento)));

            } else if (salario >= 301 && salario <= 500) {
                aumento = (salario * 0.40)+salario;
                System.out.println("Novo salário após o aumento 40%: " + (decimalFormat.format(aumento)));
            } else if (salario >= 501 && salario <= 700) {
                aumento = (salario * 0.30)+salario;
                System.out.println("Novo salário após o aumento 30%: " + (decimalFormat.format(aumento)));
            } else if (salario >= 701 && salario <= 800) {
                aumento = (salario * 0.20)+salario;
                System.out.println("Novo salário após o aumento 20%: " + (decimalFormat.format(aumento)));
            }  else if (salario >= 801 && salario <= 1000) {
                    aumento = (salario*0.10)+salario;
                    System.out.println("Novo salário após o aumento 10%: " + (decimalFormat.format(aumento)));
            } else if (salario != 1000) {
                aumento = (salario * 0.05)+salario;
                System.out.println("Novo salário após o aumento 5%: " + (decimalFormat.format(aumento)));
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
