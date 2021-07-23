package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e mostre quantas letras diferentes ela contém.
 */
public class Exercicio07 {
    public static void main(String[] args) {

        String frase = "Faça um programa que receba uma";
        String v = "";
        int contador = 0;
        int letrasDiferentes = 0;
        frase = frase.toUpperCase();

        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(i) == frase.charAt(j)) {
                    contador++;
                }
            }
            char c = frase.charAt(i);
            if (c >= 64 && c <= 200 && !v.contains("" + c)) {
                v = v + c;

                letrasDiferentes++;

                System.out.println("A letra " + frase.charAt(i) + " aparece " + contador + " vezes.");
            }
            contador = 0;
        }
        System.out.println("Total de letras diferentes: " + letrasDiferentes);
    }
}













