package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa para criptografar uma frase dada pelo usuário. Na criptografia, a frase deverá ser invertida
 * e as consoantes deverão ser trocadas por #.
 * Exemplo:
 * Frase: EU ESTOU NA ESCOLA
 * Saída: A#O##E A# UO##E UE
 */
public class Exercicio01 {
    public static void main(String[] args) {

        String palavra = "EU ESTOU NA ESCOLA";

        palavra = new StringBuilder(palavra).reverse().toString();

        palavra = palavra.replaceAll("[^aeiouAEIOU ]", "#");

        System.out.println(palavra);
    }
}
