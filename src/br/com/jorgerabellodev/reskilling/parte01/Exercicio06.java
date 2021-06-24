package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Um funcionário recebe um salário fixo mais 4% de comissão sobre as vendas. Faça um programa
 * que receba o salário fixo do funcionário e o valor de suas vendas, calcule e mostre a comissão e seu
 * salário final.
 */
public class Exercicio06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o salário do funcionário: ");
            double salarioFixo = scanner.nextDouble();
            System.out.println("Informe o valor da venda: ");
            double vendas = scanner.nextDouble();

            double comissao = (vendas * 0.04);
            System.out.println("Valor da venda o funcionário obteve uma comissão: " + comissao);
            double salario = salarioFixo + comissao;
            System.out.println("Salário mais comissão: " + salario);
        } catch (InputMismatchException i) {
            System.out.println("Valor da compra não pode obter letra ou simbolo.");

        }
    }
}