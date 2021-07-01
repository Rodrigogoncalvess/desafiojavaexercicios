package br.com.jorgerabellodev.reskilling.parte03;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia cinco grupos de quatro valores (A, B, C, D) e mostre-os na ordem lida. Em segui-
 * da, organize-os em ordem crescente e decrescente.
 */
public class Exercicio01 {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        var valores = new int[6];

        try {
            for (var i = 1; i < valores.length; i++) {
                System.out.print("Digite " + i + "° numeros: ");
                valores[i] = scanner.nextInt();
            }
            Arrays.sort(valores);

            System.out.print("Ordem crescente:    ");
            for (var j = 1; j < valores.length; j++) {
                System.out.print(valores[j] + "  ");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
