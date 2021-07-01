package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba um conjunto de valores inteiros e positivos, calcule e mostre o maior e o
 * menor valor do conjunto. Considere que:
 * ■ ■ para encerrar a entrada de dados, deve ser digitado o valor zero;
 * ■ ■ para valores negativos, deve ser enviada uma mensagem;
 * ■ ■ os valores negativos ou iguais a zero não entrarão nos cálculos
 */
public class Exercicio24 {
    public static void main(String[] args) {

        var numero = new int[5];
        var valorMaior = 0;
        var valorMenor = Integer.MAX_VALUE;


        var teclado = new Scanner(System.in);

        try {

            for (int i = 0; i < numero.length; i++) {
                System.out.println("Digite um número: ");
                numero[i] = teclado.nextInt();

                if (numero[i] == 0) {
                    System.out.println("Programa finalizado!");
                    return;
                }
                if (numero[i] <= 0) {
                    System.out.println("Valor do número não pode ser negativo");

                }

                if (numero[i] > valorMaior) {
                    valorMaior = numero[i];
                }
                if (numero[i] <= valorMenor) {
                    valorMenor = numero[i];

                } else if (numero[i] <= 0) {

                } else if (valorMenor > 1) {

                }
            }
            System.out.println("Soma do número maior com o menor: " + (valorMaior + valorMenor));
            System.out.println("Calculo sem o número negativo: " + valorMaior);
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
