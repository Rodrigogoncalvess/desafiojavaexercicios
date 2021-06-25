package br.com.jorgerabellodev.reskilling.parte02;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * O preço ao consumidor de um carro novo é a soma do custo de fábrica com a porcentagem do distri-
 * buidor e dos impostos, ambos aplicados ao custo de fábrica. As porcentagens encontram-se na tabela a
 * seguir. Faça um programa que receba o custo de fábrica de um carro e mostre o preço ao consumidor.
 * ------------------------------------------------------------------------------------------------
 * Custo de Fábrica                        |  % Do distribuidor     |   % Dos impostos
 * ------------------------------------------------------------------------------------------------
 * Até R$ 12.000,00                        |          5             |        Isento
 * Entre R$ 12.000,00 e R$ 25.000,00       |         10             |          15
 * Acima de R$ 25.000,00 5                 |         15             |         20
 * ------------------------------------------------------------------------------------------------
 */
public class Exercicio10 {
    public static void main(String[] args) {

        double custo;
        double distribuidor;
        double imposto;
        double consumidor;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o custo de fabrica do veículo para obter o valor final do consumidor:");
            custo = scanner.nextDouble();
            if (custo <= 12000) {
                distribuidor = (custo * 0.05);
                consumidor=distribuidor+custo;
                System.out.println("Preço para o consumidor: " + (decimalFormat.format(consumidor)));
            } else if (custo >= 12001 && custo <= 25000) {
                distribuidor = (custo * 0.10);
                imposto = (custo * 0.15) ;
                consumidor=custo+distribuidor+imposto;
                System.out.println("Preço para o consumidor: " + (decimalFormat.format(consumidor)));
            } else if (custo != 25000) {
                distribuidor = (custo * 0.15);
                imposto = (custo * 0.20);
                consumidor=custo+distribuidor+imposto;
                System.out.println("Preço para o consumidor: " + (decimalFormat.format(consumidor)));
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

