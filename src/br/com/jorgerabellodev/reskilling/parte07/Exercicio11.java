package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e mostre quantas vezes cada palavra aparece na frase digitada.
 */
public class Exercicio11 {
    public static void main(String args[]) {
        String frase = "Flamengo Flamengo";
        int contador = 0;
        String v = "";

        frase = frase.toLowerCase();


        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(i) == frase.charAt(j)) {
                    contador++;
                }
            }

            char caracter = frase.charAt(i);
            if (caracter >= 'a' && caracter <= 'z' && !v.contains("" + caracter)) {
                v = v + caracter;
                System.out.println("A letra " + frase.charAt(i) + " aparece " + contador + " vezes.");
            }
            contador = 0;
        }
    }
}






