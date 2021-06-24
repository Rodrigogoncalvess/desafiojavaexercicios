package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que calcule e mostre a área de um trapézio.
 * Sabe-se que: A = ((base maior + base menor) * altura)/2
 */
public class Exercicio09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe a altura do trapézio: ");
            double altura = scanner.nextDouble();

            System.out.println("Informe o tamanho da base maior do trapézio: ");
            double baseMaior = scanner.nextDouble();

            System.out.println("Informe o tamanho da base menor do trapézio: ");
            double baseMenor = scanner.nextDouble();

            double area =((baseMaior+baseMenor)*altura)/2;

            System.out.println("Tamanho do trapézio é: "+area);

        } catch (InputMismatchException i) {
            System.out.println("Valor do peso não pode obter letra ou simbolo.");

        }
    }
}