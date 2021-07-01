package br.com.jorgerabellodev.reskilling.parte03;

import java.util.Scanner;

/**
 * Faça um programa que receba um número, calcule e mostre a tabuada desse número.
 * Exemplo:
 * Digite um número: 5
 * 5 × 0 = 0
 * 5 × 1 = 5
 * 5 × 2 = 10
 * 5 × 3 = 15
 * 5 × 4 = 20
 * 5 × 5 = 25
 * 5 × 6 = 30
 * 5 × 7 = 35
 * 5 × 8 = 40
 * 5 × 9 = 45
 * 5 × 10 = 50
 */
public class Exercicio04 {

    public static void main(String[] args) {

        var numero = 0;

        var scanner = new Scanner(System.in);
        System.out.println("Digite um número para obter a tabuada de multiplicação:");

        numero = scanner.nextInt();
        for (var i = 0; i < 11; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));

        }

    }
}
