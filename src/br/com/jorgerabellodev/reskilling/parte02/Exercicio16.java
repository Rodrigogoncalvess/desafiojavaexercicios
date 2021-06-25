package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma empresa decide aplicar descontos nos seus preços usando a tabela a seguir. Faça um programa que
 * receba o preço atual de um produto e seu código, calcule e mostre o valor do desconto e o novo preço.
 * ------------------------------------------------------------
 * PREÇO ATUAL                          % DE DESCONTO
 * ------------------------------------------------------------
 * Até R$ 30,00                         Sem desconto
 * Entre R$ 30,00 e R$ 100,00              10%
 * Acima de R$ 100,00                      15%
 * ------------------------------------------------------------
 */
public class Exercicio16 {

    public static void main(String[] args) {

        double produto;
        int codigo;
        double desconto;


        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o valor do produto:");
            produto = scanner.nextDouble();
            System.out.println("Código do produto:");
            codigo = scanner.nextInt();
            if (produto <= 30) {
                System.out.println("Produto não teve desconto: " + (decimalFormat.format(produto)) + "\nCódigo do produto: " + codigo);

            } else if (produto >= 31 && produto <= 100) {
                desconto = produto * 0.10;
                System.out.println("Produto teve desconto: " + (decimalFormat.format(desconto)));
                System.out.println("Novo preço do produto: " + (decimalFormat.format(produto - desconto)) + "\nCódigo do produto: " + codigo);

            } else if (produto != 100) {
                desconto = produto * 0.15;
                System.out.println("Produto teve desconto: " + (decimalFormat.format(desconto)));
                System.out.println("Novo preço do produto: " + (decimalFormat.format(produto - desconto)) + "\nCódigo do produto: " + codigo);
            }
        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

