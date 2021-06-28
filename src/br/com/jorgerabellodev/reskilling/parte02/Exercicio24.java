package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o preço, a categoria (1 — limpeza; 2 — alimentação; ou 3 — vestuário)
 * e a situação (R — produtos que necessitam de refrigeração; e N — produtos que não necessitam de re-
 * frigeração).
 * Calcule e mostre:
 * ■ ■ O valor do aumento, usando as regras que se seguem.
 * <p>
 * ------------------------------------------------------------
 * PREÇO           CATEGORIA           PERCENTUAL DE AUMENTO
 * ------------------------------------------------------------
 *                         1                       5%
 * <= 25                   2                       8%
 *                         3                       10%
 * ------------------------------------------------------------
 * 1                       12%
 * > 25                     2                       15%
 * 3                       18%
 * ------------------------------------------------------------
 * <p>
 * ■ ■ O valor do imposto, usando as regras a seguir.
 * O produto que preencher pelo menos um dos seguintes requisitos pagará imposto equivalente a 5%
 * do preço; caso contrário, pagará 8%. Os requisitos são:
 * Categoria: 2
 * Situação: R
 * ■ ■ O novo preço, ou seja, o preço mais aumento menos imposto.
 * ■ ■ A classificação, usando as regras a seguir.
 * ------------------------------------------------------------
 * NOVO PREÇO                       CLASSIFICAÇÃO
 * ------------------------------------------------------------
 * <= R$ 50,00                          Barato
 * Entre R$ 50,00 e R$ 120,00           Normal
 * >= R$ 120,00                         Caro
 * ------------------------------------------------------------
 */
public class Exercicio24 {
    public static void main(String[] args) {

        var preco = 0.0;
        var categoria = 0;
        var situacao = "";
        var aumento = "Valor do aumento:%.2f ";
        var precoNovo = 0.0;
        var porcentagem = 0.0;
        var valorDigitado = "Valor digitado: ";
        var valorNovo = "Valor novo: ";
        var refrigeracao = "Produtos que necessitam de refrigeração";
        var semRefrigeracao = "Produtos que não necessitam de refrigeração";

        var scanner = new Scanner(System.in);


        try {
            System.out.println("Informe o preço:");
            preco = scanner.nextDouble();

            System.out.println("Informe a categoria:" + "\n 1- Limpeza" + "\n 2 -Alimentação" + "\n 3 - Vestuário");
            categoria = scanner.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
        while (!situacao.equals("R") && !situacao.equals("N")) {
            System.out.println("Informe a situação: \n R - Produtos que necessitam de refrigeração \n N - Produtos que não necessitam de refrigeração ");
            situacao = scanner.next();

            if (!situacao.equals("R") && !situacao.equals("N")) {
                System.out.println("Digite uma das opções listado abaixo:\n");
            }
        }
        switch (categoria) {
            case 1:
                if (preco <= 25) {
                    porcentagem = preco * 0.05;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);

                } else if (preco != 25) {
                    porcentagem = preco * 0.12;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);
                }
                if (precoNovo <= 50) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Barato");

                }
                if (precoNovo >= 51 && precoNovo <= 120) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Normal");

                }
                if (precoNovo >= 121) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Caro");
                }
                if (situacao.equals("R")) {
                    System.out.println(refrigeracao);
                }
                if (situacao.equals("N")) {
                    System.out.println(semRefrigeracao);
                }
                break;
            case 2:
                if (preco <= 25) {
                    porcentagem = preco * 0.08;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);
                } else if (preco > 25) {
                    porcentagem = preco * 0.15;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);
                }
                if (precoNovo <= 50) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Barato");

                }
                if (precoNovo >= 51 && precoNovo <= 120) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Normal");

                }
                if (precoNovo >= 121) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Caro");
                }
                if (situacao.equals("R")) {
                    System.out.println(refrigeracao);
                }
                if (situacao.equals("N")) {
                    System.out.println(semRefrigeracao);
                }
                break;

            case 3:
                if (preco <= 25) {
                    porcentagem = preco * 0.10;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);
                } else if (preco > 18) {
                    porcentagem = preco * 0.15;
                    precoNovo = porcentagem + preco;
                    System.out.printf(aumento , porcentagem);
                }
                if (precoNovo <= 50) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Barato");

                }
                if (precoNovo >= 51 && precoNovo <= 120) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Normal");

                }
                if (precoNovo >= 121) {
                    System.out.println(valorDigitado + preco);
                    System.out.println(valorNovo + precoNovo + " Classificado como Caro");
                }
                if (situacao.equals("R")) {
                    System.out.println(refrigeracao);
                }
                if (situacao.equals("N")) {
                    System.out.println(semRefrigeracao);
                }
                break;

            default:
        }


    }
}
