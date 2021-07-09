package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha uma matriz 20 x 10 com números inteiros, e some cada uma das colunas,
 * armazenando o resultado da soma em um vetor. A seguir, o programa deverá multiplicar cada elemento da
 * matriz pela soma da coluna e mostrar a matriz resultante.
 */
public class Exercicio06 {
    public static void main(String[] args) {


        var numero = new int[3][2];
        var soma = new int[numero.length];
        var total = 0;
        var multiplicacao = 0;
        var valorDoVetor = 0;

        Scanner scanner = new Scanner(System.in);

        try {

            for (int i = 0; i < numero.length; i++) {
                for (int j = 0; j < numero[i].length; j++) {
                    System.out.println("Informe a coluna : ");
                    numero[i][j] = scanner.nextInt();

                    System.out.println("Informe o valor da posição:");
                    numero[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < numero.length; i++) {
                for (int j = 0; j < numero[i].length; j++) {
                    soma[i] += numero[i][j];
                }
            }
            for (int i = 0; i < soma.length; i++) {
                for (int j = 0; j < numero[i].length; j++) {

                    valorDoVetor = numero[i][j];
                    total = 0;
                    total += soma[i];
                    multiplicacao = total * valorDoVetor;
                    System.out.println("Valor total multiplicado pelo somatório da coluna " + i + " e multiplicado pela posição " + j + " : " + multiplicacao);
                }
                System.out.println("Valor total da soma de cada coluna " + i + " : " + total + "\n");
            }
        } catch (
                InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

}
