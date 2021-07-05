package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com quinze elementos inteiros e verifique a existência de elementos
 * iguais a 30, mostrando as posições em que apareceram.
 */
public class Exercicio04 {
    public static void main(String[] args) {

        var numero = new int[15];


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < numero.length; i++) {
                System.out.println("Informe o número: ");
                numero[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] == 30) {
                System.out.println("Existe o 30 na posição " + i + "°");
            }

        }

    }

}

