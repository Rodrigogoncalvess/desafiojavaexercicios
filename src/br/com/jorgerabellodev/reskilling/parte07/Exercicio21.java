package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e realize a criptografia dela, trocando a primeira e a última
 * palavra de lugar.
 * Exemplo:
 * Frase: ESTRELAS E LUA ESTÃO NO CÉU
 * Saída: CÉU E LUA ESTÃO NO ESTRELAS
 */
public class Exercicio21 {
    public static void main(String[] args) {

        String frase = "ESTRELAS E LUA ESTÃO NO CÉU";

        String[] novaFrase = frase.split(" ");

        String primeriraPosiao = novaFrase[0];
        String posicaoFinal = novaFrase[novaFrase.length - 1];

        novaFrase[novaFrase.length - 1] = primeriraPosiao;
        novaFrase[0] = posicaoFinal;

        System.out.println(String.join(" ", novaFrase));

    }
}
