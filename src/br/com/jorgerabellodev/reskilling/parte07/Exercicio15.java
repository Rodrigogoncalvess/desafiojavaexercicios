package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e, cada vez que aparecer nela um algarismo entre 0 e 9, substi-
 * tua-o, escrevendo-o por extenso.
 * Exemplo:
 * Frase: EU ESTOU NA POLTRONA 5.
 * Saída: EU ESTOU NA POLTRONA CINCO.
 */
public class Exercicio15 {
    public static void main(String[] args) {

        String frase;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        frase = scanner.nextLine();

        frase = frase.replace("0", "ZERO")
                .replace("1", "UM")
                .replace("2", "DOIS")
                .replace("3", "TRES")
                .replace("4", "QUATRO")
                .replace("5", "CINCO")
                .replace("6", "SEIS")
                .replace("7", "SETE")
                .replace("8", "OITO")
                .replace("9", "NOVE");

        frase = frase.toUpperCase();

        System.out.println(frase);
    }
}

