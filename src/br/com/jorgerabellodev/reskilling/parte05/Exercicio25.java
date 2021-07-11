package br.com.jorgerabellodev.reskilling.parte05;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Crie um programa que:
 * ■ ■ receba o preço de dez produtos e armazene-os em um vetor;
 * ■ ■ receba a quantidade estocada de cada um desses produtos, em cinco armazéns diferentes, utilizando uma produtos 5 x 10.
 * O programa deverá calcular e mostrar:
 * ■ ■ a quantidade de produtos estocados em cada um dos armazéns;
 * ■ ■ a quantidade de cada um dos produtos estocados, em todos os armazéns juntos;
 * ■ ■ o preço do produto que possui maior estoque em um único armazém;
 * ■ ■ o menor estoque armazenado;
 * ■ ■ o custo de cada armazém.
 */
public class Exercicio25 {
    public static void main(String[] args) {
        final int coluna = 5;
        final var linha = 10;

        var precoProduto = new double[]{25, 10, 22.7, 33.9, 15.35, 12, 29, 45, 23, 39.9};
        var produtos = new int[coluna][linha];
        var qtdProduto = 0;
        var maiorEstoque = 0;
        var menorEstoque = Integer.MAX_VALUE;
        var precoMaiorEstoque = 0.0;
        var valorArmazem = 0.0;
        var decimal = new DecimalFormat("0.00");

        Random random = new Random();

        for (int i = 0; i < produtos.length; i++) {
            for (int j = 0; j < produtos[i].length; j++) {
                produtos[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < produtos.length; i++) {
            qtdProduto = 0;
            for (int j = 0; j < produtos[i].length; j++) {
                qtdProduto += produtos[i][j];
            }
            System.out.println("Quantidade de produtos estocados no armazém [" + (i + 1) + "]: " + qtdProduto);
        }
        System.out.println();
        for (int i = 0; i < produtos.length; i++) {
            for (int j = 0; j < produtos[i].length; j++) {
                System.out.println("Quantidade de produto [" + (j + 1) + "} no armazém [" + (i + 1) + "]: " + produtos[i][j]);
            }
        }
        for (int i = 0; i < produtos.length; i++) {

            for (int j = 0; j < produtos[i].length; j++) {

                if (produtos[i][j] > maiorEstoque) {
                    maiorEstoque = produtos[i][j];
                    precoMaiorEstoque = precoProduto[j];
                }
                if (produtos[i][j] < menorEstoque) {
                    menorEstoque = produtos[i][j];
                }
            }
        }
        System.out.println("\nPreço do produto que possui maior estoque em um único armazém " + precoMaiorEstoque);
        System.out.println("\nMenor estoque armazenado: " + menorEstoque + "\n");

        for (int i = 0; i < produtos.length; i++) {
            for (int j = 0; j < produtos[i].length; j++) {
                qtdProduto = produtos[i][j];
                valorArmazem = precoProduto[j] * qtdProduto;

                System.out.println("Quantidade de produto [" + (j + 1) + "] tem estocado no armazém [" + (i + 1) + "]: " + qtdProduto + " -> Valor de cada armazém: "
                        + decimal.format(valorArmazem));
            }
        }


    }
}
