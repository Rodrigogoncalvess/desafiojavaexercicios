package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o preço de um produto, calcule e mostre, de acordo com as tabelas a seguir, o novo preço e a classificação.
 * ------------------------------------------------------------
 * TABELA 1 — PERCENTUAL DE AUMENTO
 * ------------------------------------------------------------
 * PREÇO                             %
 * ------------------------------------------------------------
 * Até R$ 50,00                      5
 * Entre R$ 50,00 e R$ 100,00       10
 * Acima de R$ 100,00               15
 * ------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------
 * TABELA 2 — CLASSIFICAÇÕES
 * -------------------------------------------------------------------------
 * NOVO PREÇO                                      CLASSIFICAÇÃO
 * -------------------------------------------------------------------------
 * Até R$ 80,00                                     Barato
 * Entre R$ 80,00 e R$ 120,00 (inclusive)           Normal
 * Entre R$ 120,00 e R$ 200,00 (inclusive)          Caro
 * Maior que R$ 200,00                              Muito caro
 * -------------------------------------------------------------------------
 */
public class Exercicio13 {
    public static void main(String[] args) {

        double produto;
        double percentual;
        double aumento = 0;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o valor do produto:");
            produto = scanner.nextDouble();
            if (produto <= 50) {
                percentual = (produto * 0.05);
                aumento = percentual + produto;
                System.out.println("Novo preço: " + (decimalFormat.format(aumento)));
            } else if (produto >= 51 && produto <= 100) {
                percentual = (produto * 0.10);
                aumento = percentual + produto;
                System.out.println("Novo preço: " + (decimalFormat.format(aumento)));
            } else if (produto != 100) {
                percentual = (produto * 0.15);
                aumento = percentual + produto;
                System.out.println("Novo preço: " + (decimalFormat.format(aumento)));
            }
            if (aumento <= 80) {
                System.out.println("Classifcação do produto: Barato!");
            }
            if (aumento >= 81 && aumento <= 120) {
                System.out.println("Classifcação do produto: Normal!");
            }
            if (aumento >= 121 && aumento <= 200) {
                System.out.println("Classifcação do produto: Caro!");
            }
            if (aumento >= 200) {
                System.out.println("Classifcação do produto: Muito caro!");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

