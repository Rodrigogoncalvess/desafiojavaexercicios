package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e mostre cada palavra dela em uma linha separada.
 * Exemplo:
 * Frase: COMPUTADORES SÃO MÁQUINAS POTENTES
 * Saída:
 * COMPUTADORES
 * SÃO
 * MÁQUINAS
 * POTENTES
 */
public class Exercicio02 {
    public static void main(String[] args) {

        String frase = "COMPUTADORES SÃO MÁQUINAS POTENTES";

        frase=frase.replaceAll("[ ]","\n");

        System.out.println(frase);
    }
}
