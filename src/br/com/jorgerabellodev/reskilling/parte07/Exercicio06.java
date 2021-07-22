package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e gere uma nova frase, duplicando cada caractere da frase digitada.
 * Exemplo:
 * Frase: PROGRAMAR É BOM
 * Saída: PPRROOGGRRAAMMAARR ÉÉ BBOOMM
 */
public class Exercicio06 {
    public static void main(String[] args) {

        String frase = "PROGRAMAR É BOM";

        StringBuilder novaFrase = new StringBuilder();

        for (char caracter : frase.toCharArray()) {
            novaFrase.append(caracter).append(caracter);
        }

        System.out.println(novaFrase);

    }
}
