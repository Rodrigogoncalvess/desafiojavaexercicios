package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o total das vendas de cada vendedor de uma loja e armazene-as em um vetor.
 * Receba também o percentual de comissão a que cada vendedor tem direito e armazene-os em outro vetor.
 * Receba os nomes desses vendedores e armazene-os em um terceiro vetor. Existem apenas dez vendedores na
 * loja. Calcule e mostre:
 * ■ ■ um relatório com os nomes dos vendedores e os valores a receber referentes à comissão;
 * ■ ■ o total das vendas de todos os vendedores;
 * ■ ■ o maior valor a receber e o nome de quem o receberá;
 * ■ ■ o menor valor a receber e o nome de quem o receberá.
 */
public class Exercicio06 {
    public static void main(String[] args) {

        var percentual = new float[3];
        var nomes = new String[3];
        var totalDeVendas = new float[3];
        var comissao = 0.0;
        var somatorioTotal = 0.0;
        var maior = 0.0;
        var menor = 0.0;
        var indiceMaior = 0;
        var indiceMenor = 0;


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < nomes.length; i++) {
                System.out.println("Informe o nome do vendedor: ");
                nomes[i] = scanner.next();

                System.out.println("Informe o valor total da venda do vendedor: ");
                totalDeVendas[i] = scanner.nextFloat();

                System.out.println("Informe o valor do percentual: ");
                percentual[i] = scanner.nextFloat();
            }

            for (int i = 0; i < nomes.length; i++) {
                comissao = totalDeVendas[i] * percentual[i];
                somatorioTotal += totalDeVendas[i];

                if (i == 0) {
                    maior = comissao;
                    menor = comissao;
                }

                if (comissao > maior) {
                    maior = comissao;
                    indiceMaior = i;
                } else if (comissao < menor) {
                    menor = comissao;
                    indiceMenor = i;
                }
                System.out.println(nomes[i] + " : " + comissao);
            }
            System.out.println("Maior valor a receber e o nome de quem o receberá: " + nomes[indiceMaior] + " " + (totalDeVendas[indiceMaior] * percentual[indiceMaior]));
            System.out.println("Menor valor a receber e o nome de quem o receberá: " + nomes[indiceMenor] + " " + (totalDeVendas[indiceMenor] * percentual[indiceMenor]));
            System.out.println("Somatório das vendas: " + somatorioTotal);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}


