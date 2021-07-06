package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Scanner;

/**
 * Faça um programa que receba cinco números e mostre a saída a seguir:
 * Digite o 1o número 5
 * Digite o 2o número 3
 * Digite o 3o número 2
 * Digite o 4o número 0
 * Digite o 5o número 2
 * Os números digitados foram: 5 + 3 + 2 + 0 + 2 = 12
 */
public class Exercicio12 {
    public static void main(String[] args) {

        var numero = new int[6];
        var somaNumeros = 0;

        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i < numero.length; i++) {
            System.out.println("Digite o " + i + "° número: ");
            numero[i] = scanner.nextInt();
            somaNumeros += numero[i];

        }  System.out.println("Os números digitados foram: " + numero[1] + " + "+ numero[2]  + " + " + numero[3]  + " + " + numero[4] + " + " +numero[5]  + " = " + somaNumeros);

    }
}
