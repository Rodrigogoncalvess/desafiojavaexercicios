package br.com.jorgerabellodev.reskilling.parte06;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Elabore uma sub-rotina que leia um número não determinado de valores positivos e retorne a média aritmética desses valores.
 * Terminar a entrada de dados com o valor zero.
 */
public class Exercicio07 {
    public static void main(String[] args) {

        double numero = 1;
        double soma = 0;
        double media;
        double valor = 0;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scan = new Scanner(System.in);


        while (numero != 0) {
            System.out.println("Digite um número: ");
            numero = scan.nextInt();
            if (numero == 0) {
                System.out.println("Programa finalizado!");
                break;
            }

            while (numero < 0) {
                System.out.println("Digite um número positivo");
                System.out.println("Digite um número: ");
                numero = scan.nextInt();

            }
            soma += numero;
            valor++;
            media = soma / valor;

            System.out.println("Média aritmética desses valores digitados é " + decimalFormat.format(media));

        }
    }
}


