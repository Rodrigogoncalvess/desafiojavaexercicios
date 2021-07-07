package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha três vetores com dez posições cada um: o primeiro vetor, com os nomes de
 * dez produtos; o segundo vetor, com os códigos dos dez produtos; e o terceiro vetor, com os preços dos produtos.
 * Mostre um relatório apenas com o nome, o código, o preço e o novo preço dos produtos que sofrerão aumento.
 * Sabe-se que os produtos que sofrerão aumento são aqueles que possuem código par ou preço superior a R$ 1.000,00. Sabe-se ainda
 * que, para os produtos que satisfazem as duas condições anteriores, código e preço, o aumento será de 20%; para aqueles que
 * satisfazem apenas a condição de preço, o aumento será de 10%.
 */
public class Exercicio09 {
    public static void main(String[] args) {

        var nomesProdutos = new String[10];
        var codigoProdutos = new int[10];
        var precoProdutos = new float[10];
        var novoPrecoProduto = new float[10];
        var controladora = false;


        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < nomesProdutos.length; i++) {
                System.out.println("Informe o nome do produto: ");
                nomesProdutos[i] = scanner.next();


                System.out.println("Informe o código do produto: ");
                codigoProdutos[i] = scanner.nextInt();

                System.out.println("Informe o preço do produto: ");
                precoProdutos[i] = scanner.nextFloat();
            }
            for (int i = 0; i < nomesProdutos.length; i++) {

                if ((codigoProdutos[i] % 2 == 0) && (precoProdutos[i] > 1000)) {
                    novoPrecoProduto[i] = ((float) (precoProdutos[i] * 0.2) + precoProdutos[i]);
                    controladora = true;

                    System.out.println("Produtos que sofrerão aumento de 20%: " + nomesProdutos[i] + " de " + precoProdutos[i] + " para " + novoPrecoProduto[i]);

                } else if ((codigoProdutos[i] % 2 == 0) || (precoProdutos[i] > 1000)) {
                    novoPrecoProduto[i] = ((float) (precoProdutos[i] * 0.1) + precoProdutos[i]);
                    controladora = true;

                    System.out.println("Produtos que sofrerão aumento de 10%: " + nomesProdutos[i] + " de " + precoProdutos[i] + " para " + novoPrecoProduto[i]);

                }
            }
            if (controladora == false) {
                System.out.println("Nenhum produto sofrerá aumento!");
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}



