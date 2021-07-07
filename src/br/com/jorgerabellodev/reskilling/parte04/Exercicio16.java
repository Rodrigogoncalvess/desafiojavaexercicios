package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o nome de cinco produtos e seus respectivos preços. Calcule e mostre:
 * ■ ■ a quantidade de produtos com preço inferior a R$ 50,00;
 * ■ ■ o nome dos produtos com preço entre R$ 50,00 e R$ 100,00;
 * ■ ■ a média dos preços dos produtos com preço superior a R$ 100,00.
 */
public class Exercicio16 {
    public static void main(String[] args) {

        var produto = new String[5];
        var preco = new double[5];
        var qtdProduto = 0;
        var qtdProdutoMaior = 0.0;
        var mediaPreco = 0.0;
        var mediaPrecoTotal = 0.0;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < preco.length; i++) {
                System.out.println("Digite o nome do produto: ");
                produto[i] = scanner.next();

                System.out.println("Preço do produto " + produto[i] + " : ");
                preco[i] = scanner.nextFloat();
            }
            for (int i = 0; i < preco.length; i++) {
                if (preco[i] < 50) {
                    qtdProduto++;
                    System.out.println("Quantidade de produtos com preço inferior a R$ 50,00 é: " + qtdProduto);
                }
            }
            System.out.println("Nome dos produtos com preço entre R$ 50,00 e R$ 100,00;");
            for (int i = 0; i < produto.length; i++) {
                if ((preco[i] > 50) && (preco[i] <= 100)) {
                    System.out.println(produto[i]);
                }
            }
            for (int i = 0; i < produto.length; i++) {
                if (preco[i] > 100) {
                    mediaPreco++;
                    qtdProdutoMaior += (int) preco[i];
                    mediaPrecoTotal = qtdProdutoMaior / mediaPreco;
                }
            }
            System.out.println("Média dos preços dos produtos com preço superior a R$ 100,00 = " + mediaPrecoTotal);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}