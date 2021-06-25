package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o salário bruto de um funcionário e, usando a tabela a seguir, calcule e
 * mostre o valor a receber. Sabe-se que este é composto pelo salário bruto acrescido de gratificação e des-
 * contado o imposto de 7% sobre o salário.
 * ----------------------------------------------
 * TABELA DE GRATIFICAÇÕES
 * ----------------------------------------------
 * SALÁRIO                      GRATIFICAÇÃO
 * ----------------------------------------------
 * Até R$ 350,00                  R$ 100,00
 * R$ 350,00 A R$ 600,00          R$ 75,00
 * R$ 600,00 a R$ 900,00          R$ 50,00
 * Acima de R$ 900,00             R$ 35,00
 * ----------------------------------------------
 */
public class Exercicio12 {
    public static void main(String[] args) {

        double salario;
        double gratificacao;
        double desconto;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o valor do salário:");
            salario = scanner.nextDouble();
            if (salario <= 350) {
                gratificacao = (salario + 100);
                desconto = gratificacao * 0.07;
                System.out.println("Salário com a gratificação R$ 100,00: " + (decimalFormat.format(gratificacao)));
                System.out.println("Novo salário após o desconto de 7%: " + (decimalFormat.format(gratificacao-desconto)));
            } else if (salario >= 351 && salario <= 600) {
                gratificacao = (salario + 75);
                desconto = gratificacao * 0.07;
                System.out.println("Salário com a gratificação R$ 75,00: " + (decimalFormat.format(gratificacao)));
                System.out.println("Novo salário após o desconto de 7%: " + (decimalFormat.format(gratificacao-desconto)));
            } else if (salario >= 601 && salario <= 900) {
                gratificacao = (salario + 50);
                desconto = gratificacao * 0.07;
                System.out.println("Salário com a gratificação R$ 50,00: " + (decimalFormat.format(gratificacao)));
                System.out.println("Novo salário após o desconto de 7%: " + (decimalFormat.format(gratificacao-desconto)));
            } else if (salario != 900) {
                gratificacao = (salario + 35);
                desconto = gratificacao * 0.07;
                System.out.println("Salário com a gratificação R$ 35,00: " + (decimalFormat.format(gratificacao)));
                System.out.println("Novo salário após o desconto de 7%: " + (decimalFormat.format(gratificacao-desconto)));
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
