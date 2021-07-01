package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que apresente o menu de opções a seguir:
 * Menu de opções:
 * 1. Média aritmética
 * 2. Média ponderada
 * 3. Sair
 * Digite a opção desejada.
 * Na opção 1: receber duas notas, calcular e mostrar a média aritmética.
 * Na opção 2: receber três notas e seus respectivos pesos, calcular e mostrar a média ponderada.
 * Na opção 3: sair do programa.
 * Verifique a possibilidade de opção inválida. Nesse caso, o programa deverá mostrar uma mensagem.
 */
public class Exercicio20 {
    public static void main(String[] args) {

        var mediaAritmetica = 0;
        var mediaPonderada = 0.0;
        var valor = new int[4];
        var numeroMedia = 0;
        var numero1 = 0;
        var numero2 = 0;
        var numero3 = 0;
        var opcao = 0;
        var decimal = new DecimalFormat("0.00");

        var scanner = new Scanner(System.in);
        try {
            while (opcao != 3) {
                System.out.println("\nDigite uma das opções abaixo: " +
                        "\n 1 - Média aritmética" +
                        "\n 2 - Média ponderada" +
                        "\n 3 - Sair");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        for (var i = 1; i < 3; i++) {
                            System.out.println("Digite o " + i + "° número: ");
                            numeroMedia = scanner.nextInt();
                            mediaAritmetica += numeroMedia / 2;
                        }
                        System.out.println("Média aritmética: " + mediaAritmetica);
                        break;

                    case 2:
                        for (var i = 1; i < valor.length; i++) {
                            System.out.println("Digite o " + i + "° número: ");
                            valor[i] = scanner.nextInt();
                            numero1 = valor[1] * 2;
                            numero2 = valor[2] * 2;
                            numero3 = valor[3] * 3;
                            mediaPonderada = (float) (numero1 + numero2 + numero3) / 7;

                        }
                        System.out.println("Média ponderada: " + (decimal.format(mediaPonderada)));
                    case 3:
                        System.out.println("Programa finalizado");
                    default:
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
