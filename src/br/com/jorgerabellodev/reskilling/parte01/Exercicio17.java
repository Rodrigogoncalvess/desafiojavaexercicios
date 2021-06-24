package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o raio, calcule e mostre:
 * a) o comprimento de uma esfera; sabe-se que C = 2 * PI * R;
 * b) a área de uma esfera; sabe-se que A = PI * R^2 ;
 * c) o volume de uma esfera; sabe-se que V = 3⁄4 * PI * R^3 .
 */
public class Exercicio17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o raio da esfera que deseja obter a área, comprimento e volume:");
            double raio = scanner.nextDouble();

            double comprimento = 2 * Math.PI * raio;
            double area = 4 * Math.PI * (Math.pow(raio, 2));
            double volume = (4 * Math.PI * Math.pow(raio, 3) / 3);


            System.out.printf("Comprimento de uma esfera: %.2f", comprimento);
            System.out.printf("\nÁrea de uma esfera: %.2f", area);
            System.out.printf("\nvolume de uma esfera: %.2f", volume);
        } catch (
                InputMismatchException i) {
            System.out.println("Valor do raio não pode obter letra ou simbolo.");
        }
    }
}
