package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e um caractere e verifique em que posição da frase o caractere
 * digitado aparece pela última vez.
 */
public class Exercicio10 {
    public static void main(String[] args) {


        String frase;
        int contador = 0;
        int caracter;

        Scanner scan = new Scanner(System.in);


        System.out.println("Digite a frase:");
        frase = scan.nextLine();
        System.out.println("Digite o caracter:");
        caracter = scan.next().charAt(0);

        frase = frase.toLowerCase();
        int posicao = 0;
        for (int i = 0; i < frase.length(); ++i) {
            if (caracter == frase.charAt(i)) {
                posicao = i;
            }
        }
        System.out.println("O último caracter encontrado na frase está na posição [" + posicao + "] e foi a letra: " + frase.charAt(posicao));

    }
}
