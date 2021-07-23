package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e faça a criptografia dela, utilizando a representação ASCII de
 * cada caractere mais um espaço, e depois proceda à sua descriptografia.
 */
public class Exercicio20 {
    public static void main(String[] args) {

        String frase;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        frase = scanner.nextLine();

        String descripografada = frase;
        frase = frase.replaceAll("(.)", "$1 ");

        int caracter;
        int[] criptografada = new int[frase.length()];


        for (int i = 0; i < frase.length(); i++) {
            caracter = frase.charAt(i);
            criptografada[i] = caracter;
        }
        System.out.print("Frase criptografada: " + Arrays.toString(criptografada));
        System.out.println("\nFrase descriptografada: " + descripografada);
    }
}
