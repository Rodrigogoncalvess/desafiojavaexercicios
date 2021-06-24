package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o preço de um produto, calcule e mostre o novo preço, sabendo-se
 * que este sofreu um desconto de 10%.
 */
public class Exercicio05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o preço de um produto para obter o desconto: ");
            double produto = scanner.nextDouble();

            double desconto = produto / 10;
            System.out.println("Produto sofreu 10% de desconto: " + desconto);
        } catch (InputMismatchException i) {
            System.out.println("Nota não pode obter letra ou simbolo");

        }
    }
}