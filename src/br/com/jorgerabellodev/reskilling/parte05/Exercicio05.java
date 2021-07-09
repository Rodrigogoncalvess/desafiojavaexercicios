package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Elabore um programa que preencha uma matriz 12 x 4 com os valores das vendas de uma loja, em que cada
 * linha representa um mês do ano e cada coluna representa uma semana do mês. O programa deverá calcular
 * e mostrar:
 * ■ ■ o total vendido em cada mês do ano, mostrando o nome do mês por extenso;
 * ■ ■ o total vendido em cada semana durante todo o ano;
 * ■ ■ o total vendido pela loja no ano.
 */
public class Exercicio05 {
    public static void main(String[] args) {


        var mes = new String[12];
        var valorDaVenda = new double[mes.length][4];
        var soma = 0.0;
        var primeiraSemana = 0.0;
        var segundaSemana = 0.0;
        var terceiraSemana = 0.0;
        var quartaSemana = 0.0;
        var valorTotal = 0.0;


        Scanner scanner = new Scanner(System.in);

        try {

            for (int i = 0; i < mes.length; i++) {
                System.out.println("Informe o mês: ");
                mes[i] = scanner.next();
                for (int j = 0; j < valorDaVenda[i].length; j++) {
                    System.out.println("Informe o valor da venda da " + (j + 1) + "° semana:");
                    valorDaVenda[i][j] = scanner.nextDouble();
                }
            }

            for (int i = 0; i < valorDaVenda.length; i++) {
                soma = 0;

                for (int j = 0; j < valorDaVenda[i].length; j++) {
                    soma += valorDaVenda[i][j];
                    if (j == 0) {
                        primeiraSemana += valorDaVenda[i][j];
                    }
                    if (j == 1) {
                        segundaSemana += valorDaVenda[i][j];
                    }
                    if (j == 2) {
                        terceiraSemana += valorDaVenda[i][j];
                    }
                    if (j == 3) {
                        primeiraSemana += valorDaVenda[i][j];
                    }
                }
                valorTotal += soma;

                System.out.println("O total vendido no mês de " + mes[i] + " foi de: " + soma);
            }

            System.out.println("Valor total das vendas da primeira semana: " + primeiraSemana);
            System.out.println("Valor total das vendas da segunda semana: " + segundaSemana);
            System.out.println("Valor total das vendas da terceira semana: " + terceiraSemana);
            System.out.println("Valor total das vendas da quarta semana: " + quartaSemana);

            System.out.println("O total vendido pela loja no ano: " + valorTotal);

        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}