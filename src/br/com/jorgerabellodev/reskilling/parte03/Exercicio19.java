package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o tipo da ação, ou seja, uma letra a ser comercializada na bolsa de valores,
 * o preço de compra e o preço de venda de cada ação e que calcule e mostre:
 * ■ ■ o lucro de cada ação comercializada;
 * ■ ■ a quantidade de ações com lucro superior a R$ 1.000,00;
 * ■ ■ a quantidade de ações com lucro inferior a R$ 200,00;
 * ■ ■ o lucro total da empresa.
 * Finalize com o tipo de ação ‘F’.
 */
public class Exercicio19 {
    public static void main(String[] args) {

        var letra = new String[5];
        var precoCompra = new double[5];
        var precoVenda = new double[5];
        var lucroSuperior = 0;
        var lucroInferior = 0;
        var lucroTotal = 0.0;

        var teclado = new Scanner(System.in);

        try {
            for (int i = 0; i < letra.length; i++) {

                System.out.println("Digite uma letra: ");
                letra[i] = teclado.next();

                if (letra[i].equals("F")) {
                    System.out.println("Programa finalizado!");
                    break;

                }

                System.out.println("Digite o preço de compra");
                precoCompra[i] = teclado.nextDouble();

                System.out.println("Digite o preço de venda");
                precoVenda[i] = teclado.nextDouble();


                if (precoCompra[i] > 1000) {
                    lucroSuperior++;
                }
                if (precoVenda[i] < 200) {
                    lucroInferior++;
                }

                lucroTotal = lucroSuperior + lucroInferior;
            }
            System.out.println("Quantidade de ações com lucro superior a R$ 1.000,00 foi " + lucroSuperior);
            System.out.println("Quantidade de ações com lucro inferior a R$ 200,00 foi " + lucroInferior);
            System.out.println("lucro total da empresa: " + lucroTotal);
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
