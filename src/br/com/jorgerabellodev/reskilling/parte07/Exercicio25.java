package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e faça a criptografia, retirando das palavras suas vogais. O
 * programa deverá armazenar essas vogais e suas posições originais em vetores, mostrar a frase criptografada e posteriormente descriptografá-la.
 */
public class Exercicio25 {
    public static void main(String[] args) {

        String frase = "programa vogais";

        String novaFrase;

        novaFrase = frase.replaceAll("[aeiouAEIOU]", "");

        System.out.println("Frase criptografada: " + novaFrase);
        System.out.println("Frase descriptografada: " + frase);

    }
}
