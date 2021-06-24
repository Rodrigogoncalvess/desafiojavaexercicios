package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a medida do ângulo formado por uma escada apoiada no chão e a dis-
 * tância em que a escada está da parede, calcule e mostre a medida da escada para que se possa alcançar
 * sua ponta.
 */
public class Exercicio20 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe a distância da escada da parede: ");
            double distancia = scanner.nextDouble();
            System.out.println("Informe a medida da escada: ");
            double altura = scanner.nextDouble();

            double medida =  altura /distancia;

            System.out.println("Medida da escada para que se possa ponta: " + medida);
        } catch (
                InputMismatchException i) {
            System.out.println("O programa não aceita letra ou simbolo.");

        }
    }
}
