package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que leia um vetor com dez posições para números inteiros e mostre somente os nú-
 * meros positivos.
 */
public class Exercicio20 {
    public static void main(String[] args) {


        var vetor = new int[10];
        var numeroPositivo = 0;


        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < vetor.length; i++) {
                System.out.println("Digite o número do vetor : ");
                vetor[i] = scanner.nextInt();
            }
            for (int i = 0; i < vetor.length; i++) {

                if (vetor[i] >= 0) {
                    numeroPositivo = vetor[i];
                    System.out.print("Os números positivos do vetor " + numeroPositivo + " ");
                }
            }
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

}

