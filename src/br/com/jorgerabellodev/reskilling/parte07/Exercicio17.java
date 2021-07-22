package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba uma frase e, a cada duas palavras dela, realize uma criptografia, ou seja:
 * a primeira letra da primeira palavra da frase concatenada com a última letra da segunda palavra, conca-
 * tenada com a segunda letra da primeira palavra e com a penúltima letra da segunda palavra e assim por
 * diante. No caso de quantidade de palavras ímpares, a última palavra deve simplesmente ser invertida.
 * Exemplos:
 * Frase: Aula com bola
 * Saída: Amuolca alob
 * Frase: Casa com janelas coloridas
 * Saída: Cmaosca jsaandeilraosloc
 */
public class Exercicio17 {

    public static void main(String[] args) {
        String frase = "Aula com bola";
        System.out.println(criptografia(frase));
    }

    static String criptografia(String frase) {

        String[] palavras = frase.split(" ");

        boolean ePar = palavras.length % 2 == 0;

        StringBuilder builder = new StringBuilder();

        try {
            for (int i = 0; i < palavras.length; i += 2) {
                builder.append(joinRevert(new String[]{palavras[i], palavras[i + 1]})).append(" ");
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        if (!ePar) {
            builder.append(reverse(palavras[palavras.length - 1]));
        }
        return builder.toString();
    }


    static String reverse(String palavra) {
        return new StringBuilder(palavra).reverse().toString();
    }

    static String joinRevert(String[] palavras) {
        String segunda = reverse(palavras[1]);
        StringBuilder join = new StringBuilder();
        int i = 0;
        while (true) {
            if (i < palavras[0].length()) {
                join.append(palavras[0].charAt(i));
            }
            if (i < segunda.length()) {
                join.append(segunda.charAt(i));
            }
            if (i > segunda.length() && i > palavras[0].length()) {
                break;
            }
            i++;
        }
        return join.toString();
    }
}



