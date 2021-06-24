package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o número de lados de um polígono convexo, calcule e mostre o número
 * de diagonais desse polígono. Sabe-se que ND = N * (N − 3)/2, em que N é o número de lados do
 * polígono.
 */
public class Exercicio22 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o número da diagonal: ");
            double ladoPoligono = scanner.nextDouble();

            double numeroDiagonais = ladoPoligono * (ladoPoligono - 3) / 2;

            System.out.println("Lados de um polígono convexo: " + numeroDiagonais);
        } catch (
                InputMismatchException i) {
            System.out.println("Número do diagonal não pode obter letra ou simbolo.");

        }
    }
}
