package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e faça a criptografia dela, substituindo as vogais pelos seguintes
 * números: a = 1, e = 2, i = 3, o = 4 e u = 5.
 */
public class Exercicio19 {
    public static void main(String[] args) {

        String frase;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        frase = scanner.nextLine();
        frase = frase.toLowerCase();

        frase = frase.replace("a", "1")
                .replace("e", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("u", "5");

        System.out.println(frase);
    }
}

