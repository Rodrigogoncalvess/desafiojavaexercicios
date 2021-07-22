package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Arrays;

/**
 * Faça um programa que receba duas cadeias de caracteres e verifique se a primeira cadeia digitada é permuta-
 * ção da segunda cadeia, ou seja, se todos os caracteres da primeira cadeia estão presentes na segunda cadeia,
 * mesmo que em posições diferentes.
 * Exemplo:
 * “abccde” é uma permutação de “cbadce”, mas não é de “abcdef” nem de “abcde”
 */
public class Exercicio05 {
    public static void main(String[] args) {

        String primeiraCadeia = "abcdde";
        String segundaCadeia = "cbadce";
        char[] chars1 = primeiraCadeia.toCharArray();
        char[] chars2 = segundaCadeia.toCharArray();
        int contador = 0;
        int[] guardaContador = new int[primeiraCadeia.length()];

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (primeiraCadeia.length() == segundaCadeia.length()) {
            for (int i = 0; i < chars1.length; i++) {
                //              contador = 0;
                for (int j = i; j < chars2.length; j++) {
                    if (chars1[i] == chars2[j]) {
                        guardaContador[i] = chars1[i];
                        break;
                    }
                }
            }
            for (int i = 0; i < guardaContador.length; i++) {
                if (guardaContador[i] == chars2[i]) {

                } else {
                    System.out.println("Todas as palavras não são iguais!");
                    return;
                }
            }
            System.out.println("Todas as palavras são iguais!");
        } else {
            System.out.println("Não é o mesmo tamanho não pode ser igual!");
        }

    }
}
