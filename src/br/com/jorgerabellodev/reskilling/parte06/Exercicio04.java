package br.com.jorgerabellodev.reskilling.parte06;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba como parâmetro o raio de uma esfera, calcule e mostre no programa principal
 * o seu volume: v = 4/3 * R^3.
 */
public class Exercicio04 {

    public static void main(String[] args) {

        double esfera;

        DecimalFormat decimalFormat = new DecimalFormat("0.000");

        Scanner scanner = new Scanner(System.in);

        SubRotina sub = new SubRotina();

        try {
            System.out.println("Informe o raio da esfera para calcular seu volume: ");
            esfera = scanner.nextDouble();

            System.out.println("O seu volume é: " + decimalFormat.format(sub.raio(esfera)));
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

    static class SubRotina {
        public double raio(double valor) {
            valor = (3 * Math.pow(valor, 3) / 4);
            return valor;
        }
    }
}
