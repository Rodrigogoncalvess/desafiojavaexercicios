package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e gere uma nova, retirando os espaços excedentes no início e no fim
 * da frase e entre suas palavras.
 */
public class Exercicio03 {
    public static void main(String[] args) {

        String frase = "Mengão vai                       ganhar hoje!";

        frase=frase.replaceAll("\s+"," ");

        System.out.println(frase);

    }
}
