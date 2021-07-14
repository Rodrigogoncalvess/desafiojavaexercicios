package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Elabore uma sub-rotina que receba um vetor X de 15 números inteiros como parâmetro e retorne a
 * quantidade de valores pares em X.
 */
public class Exercicio15 {

    static int[] vetor = new int[15];

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um valor: ");
            vetor[i] = scanner.nextInt();

        }
        sub.qtdNumerosPares(vetor);
    }

    static class SubRotina {
        public void qtdNumerosPares(int[] valor) {
            var qtdPares = 0;
            for (int num : valor) {
                if (num % 2 == 0) {
                    qtdPares++;
                }
            }
            System.out.println("Quantidade de valores pares no vetor é " + qtdPares);

        }
    }
}
