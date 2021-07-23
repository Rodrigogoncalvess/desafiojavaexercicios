package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e converta as vogais de suas palavras para maiúsculo e as con-
 * soantes para minúsculo.
 */
public class Exercicio14 {
    public static void main(String[] args) {

        String frase;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        frase = scanner.nextLine();

        frase = frase.toLowerCase().replace("a", "A").replace("e", "E").replace("i", "I")
                .replace("o", "O").replace("u", "U");

        System.out.println(frase);

    }
}

