package br.com.jorgerabellodev.reskilling.parte01;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o valor dos catetos de um triângulo, calcule e mostre o valor da hipo-tenusa
 */
public class Exercicio16 {
    public static void main(String[] args)
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o valor do cateto oposto:");
            double catetoOposto = scanner.nextInt();
            System.out.println("Informe o valor do cateto adjacente:");
            double catetoAdjacente = scanner.nextInt();
            double valor = ((Math.pow(catetoAdjacente, 2)) + (Math.pow(catetoOposto, 2)));
            System.out.println("Valor da hipotenusa é: " + (decimalFormat.format(Math.sqrt(valor))));
        } catch (InputMismatchException i) {
            System.out.println("O programa não aceita letra ou simbolo.");
        }
    }
}
