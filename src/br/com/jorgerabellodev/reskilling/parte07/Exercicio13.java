package br.com.jorgerabellodev.reskilling.parte07;

import java.util.Scanner;

/**
 * Faça um programa que receba uma cadeia de caracteres e o número de repetições (limitado a 5) e gere uma
 * nova cadeia.
 * Exemplo:
 * Cadeia = Ui!
 * Número = 3
 * Nova cadeia = Ui! Ui! Ui!
 */
public class Exercicio13 {
    public static void main(String[] args) {


        String cadeia;
        int repeticao;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a cadeia de caracteres:");
        cadeia = scanner.nextLine();

        System.out.println("Digite o número de repetições que deseja:");
        repeticao = scanner.nextInt();

        while (repeticao > 5 || repeticao < 1) {
            System.out.println("Número de repetições não pode ser superior a 5 vezes, digite novamente o número:");
            repeticao = scanner.nextInt();

        }

        cadeia = cadeia.repeat(repeticao);

        System.out.println(cadeia);
    }
}
