package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba duas notas, calcule e mostre a média ponderada dessas notas, consi-
 * derando peso 2 para a primeira e peso 3 para a segunda
 */
public class Exercicio04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Dgite a primeira nota: ");
            double nota1 = scanner.nextInt();

            System.out.println("Dgite a segunda nota: ");
            double nota2 = scanner.nextInt();

            double media = (((nota1 * 2) + (nota2 * 3)) / (2 + 3));
            System.out.println("Resultado da média ponderada: " + media);
        } catch (InputMismatchException i) {
            System.out.println("Nota não pode obter letra ou simbolo");
        }
    }
}