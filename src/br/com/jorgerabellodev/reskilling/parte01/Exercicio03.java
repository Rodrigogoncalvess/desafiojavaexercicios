package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dois números, calcule e mostre a divisão do primeiro número pelo
 * segundo. Sabe-se que o segundo número não pode ser zero, portanto, não é necessário se preocupar
 * com validações.
 */
public class Exercicio03 {
    public static void main(String[] args) {

        double numero1;
        double numero2;
        double resultado;

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Digite um valor: ");
                numero1 = scanner.nextInt();
                if (numero1 <= 0) {
                    System.out.println("Valor não pode ser zero");
                    break;
                }
                System.out.println("Digite um valor: ");
                numero2 = scanner.nextInt();
                if (numero2 <= 0) {
                    System.out.println("Valor não pode ser zero");
                    break;
                }
                resultado = numero1 / numero2;
                System.out.printf("Resultado da divisão de dois números digitados: %.2f\n", resultado);
            }
        } catch (InputMismatchException i) {
            System.out.println("Necessário digitar um número.");
        }
    }
}