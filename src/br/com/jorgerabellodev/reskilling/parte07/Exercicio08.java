package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma frase e um caractere e verifique se o caractere digitado é encontrado na
 * frase ou não e, se for encontrado, quantas vezes isso acontece.
 */
public class Exercicio08 {
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

        for (int i = 0; i < frase.length(); i++) {
            if (caracter == frase.charAt(i)) {
                contador++;
            }
        }
        System.out.println("Caracter digitado foi encontrado na frase: " + contador);
    }
}

