package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Um banco concederá um crédito especial aos seus clientes, de acordo com o saldo médio no último ano. Faça
 * um programa que receba o saldo médio de um cliente e calcule o valor do crédito, de acordo com a tabela a
 * seguir. Mostre o saldo médio e o valor do crédito.
 * --------------------------------------------------------
 * Saldo Médio              |   Percentual
 * --------------------------------------------------------
 * Acima de R$ 400,00       |   30% do saldo médio
 * R$ 400,00                |   25% do saldo médio
 * R$ 300,00                |   20% do saldo médio
 * Até R$ 200,00            |   10% do saldo médio
 * --------------------------------------------------------
 **/

public class Exercicio09 {
    public static void main(String[] args) {

        double credito;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe seu saldo médio para obter o percentual de crédito disponivel:");
            credito = scanner.nextDouble();
            if (credito > 400) {
                double receber = (credito * 0.30);
                System.out.println("Saldo médio no último ano: " + credito);
                System.out.println("Crédito de 30% disponivel: " + (decimalFormat.format(receber)));
            } else if (credito >= 301 && credito <= 400) {
                double receber = (credito * 0.25);
                System.out.println("Saldo médio no último ano: " + credito);
                System.out.println("Crédito de 25% disponivel: " + (decimalFormat.format(receber)));
            } else if (credito >= 201 && credito <= 300) {
                double receber = (credito * 0.20);
                System.out.println("Saldo médio no último ano: " + credito);
                System.out.println("Crédito de 20% disponivel: " + (decimalFormat.format(receber)));
            } else if (credito <= 200) {
                double receber = (credito * 0.10);
                System.out.println("Saldo médio no último ano: " + credito);
                System.out.println("Crédito de 10% disponivel: " + (decimalFormat.format(receber)));
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

