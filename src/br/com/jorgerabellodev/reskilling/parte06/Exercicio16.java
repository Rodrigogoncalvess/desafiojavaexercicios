package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Faça uma sub-rotina que receba um vetor X de 20 de números reais como parâmetro e retorne a soma dos elementos de X.
 */
public class Exercicio16 {

    static int[] vetor = new int[2];

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor: ");
            vetor[i] = scanner.nextInt();
        }
        sub.somaNumerosReais(vetor);
    }

    static class SubRotina {
        public void somaNumerosReais(int[] valor) {
            var soma = 0;
            for (int num : valor) {
                soma += num;
            }
            System.out.println("Soma dos elementos do vetor é " + soma);
        }

    }


}
