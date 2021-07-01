package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba:
 * ■ ■ o código do produto comprado; e
 * ■ ■ a quantidade comprada do produto.
 * Calcule e mostre:
 * ■ ■ o preço unitário do produto comprado, seguindo a Tabela I;
 * ■ ■ o preço total da nota;
 * ■ ■ o valor do desconto, seguindo a Tabela II e aplicado sobre o preço total da nota; e
 * ■ ■ o preço final da nota depois do desconto.
 * <p>
 * ------------------------------------------------------------
 * TABELA I
 * ------------------------------------------------------------
 * CÓDIGO              PREÇO
 * 1 A  10             R$ 10,00
 * 11 A 20             R$ 15,00
 * 21 A 30             R$ 20,00
 * 31 A 40             R$ 30,00
 * ------------------------------------------------------------
 * --------------------------------------------------------------
 * TABELA II
 * ------------------------------------------------------------
 * PREÇO TOTAL DA NOTA              % DE DESCONTO
 * ATÉ R$ 250,00                       5%
 * ENTRE R$ 250,00 E R$ 500            10%
 * ACIMA DE R$ 500,00                  15%
 * ------------------------------------------------------------
 */
public class Exercicio23 {
    public static void main(String[] args) {

        int preco1 = 10;
        int preco2 = 15;
        int preco3 = 20;
        int preco4 = 30;
        int valorUnit;
        double valorTotal = 0;
        double desconto;

        var scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o código do produto:");
            var codigo = scanner.nextInt();
            System.out.println("Informe a quantidade do produto que foi comprado:");
            var quantidade = scanner.nextInt();
            System.out.println("Quantidade comprada do produto: " + quantidade);

            if (codigo >= 1 && codigo <= 10) {
                valorUnit = preco1;
                valorTotal = preco1 *= quantidade;
                System.out.println("Valor unitário: " + valorUnit);
                System.out.println("Valor total da compra: " + valorTotal);

            } else if (codigo >= 11 && codigo <= 20) {
                valorUnit = preco2;
                valorTotal = preco2 *= quantidade;
                System.out.println("Valor unitário: " + valorUnit);
                System.out.println("Valor total da compra: " + valorTotal);
            } else if (codigo >= 21 && codigo <= 30) {
                valorUnit = preco3;
                valorTotal = preco3 *= quantidade;
                System.out.println("Valor unitário: " + valorUnit);
                System.out.println("Valor total da compra: " + valorTotal);
            } else if (codigo >= 31 && codigo <= 40) {
                valorUnit = preco4;
                valorTotal = preco4 *= quantidade;
                System.out.println("Valor unitário: " + valorUnit);
                System.out.println("Valor total da compra: " + valorTotal);
            }
            if (valorTotal <= 250) {
                desconto = valorTotal * 0.05;
                System.out.println("Preço final da nota depois do desconto: " + (valorTotal - desconto));
            } else if (valorTotal >= 251 && valorTotal <= 500) {
                desconto = valorTotal * 0.10;
                System.out.println("Preço final da nota depois do desconto: " + (valorTotal - desconto));
            } else if (valorTotal >= 501) {
                desconto = valorTotal * 0.15;
                System.out.println("Preço final da nota depois do desconto: " + (valorTotal - desconto));
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}


