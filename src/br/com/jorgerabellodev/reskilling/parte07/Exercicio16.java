package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e mostre quantas letras, quantos números e quantos espaços
 * existem nela.
 */
public class Exercicio16 {
    public static void main(String[] args) {


        String frase = " Mengão campeão do mundo em 82! ";

        System.out.println("Quantidade de letra que possue na frase: " + frase.replaceAll("( )+[a-z]", "").trim().length());
        System.out.println("Quantidade de espaço que possue na frase: " + frase.replaceAll("[^ ]", "").length());
        System.out.println("Quantidade de número que possue na frase: " + frase.replaceAll("[^0-9]", "").length());

    }
}



