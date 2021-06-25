package br.com.jorgerabellodev.reskilling.parte02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dois números e execute as operações listadas a seguir, de acordo com a escolha do usuário.
 * ----------------------------------------------------------
 * EscoLha do usuário      |     operação
 * ----------------------------------------------------------
 * 1                       |    Média entre os números digitados
 * 2                       |    Diferença do maior pelo menor
 * 3                       |    Produto entre os números digitados
 * 4                       |    Divisão do primeiro pelo segundo
 * ----------------------------------------------------------
 * Se a opção digitada for inválida, mostre uma mensagem de erro e termine a execução do programa.
 * Lembre-se de que, na operação 4, o segundo número deve ser diferente de zero.
 */
public class Exercicio05 {
    public static void main(String[] args) {

        double num1;
        double num2;
        double media;

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        try {

            while (opcao != 5) {
                System.out.println("Opção 1 Média entre os números digitados" + "\n"
                        + "Opção 2 Diferença do maior pelo menor"
                        + "\n" + "Opção 3 Produto entre os números digitados" + "\n" + "Opção 4 Divisão do primeiro pelo segundo");
                opcao = scanner.nextInt();


                switch (opcao) {
                    case 1:
                        System.out.println("Digite o primeiro número: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Digite o segundo número: ");
                        num2 = scanner.nextDouble();
                        media = (num1 + num2) / 2;
                        System.out.println("Média dos números digitados é: " + media);
                        break;

                    case 2:
                        double[] numero = new double[2];
                        for (int i = 0; i < numero.length; i++) {
                            System.out.println("Digite um número:");
                            numero[i] = scanner.nextInt();
                        }
                        Arrays.sort(numero);

                        double maior = numero[1];
                        double menor = numero[0];
                        System.out.println("A diferença do maior para o menor número que foi digitado é:  " + (maior - menor));
                        break;
                    case 3:
                        System.out.println("Digite o número do produto desejado: ");
                        num1 = scanner.nextInt();
                        if (num1 == 1) {
                            System.out.println("Produto escolhido foi 1");
                        } else {
                            System.out.println("Produto escolhido foi 2");
                        }
                        break;
                    case 4:
                        System.out.println("Digite um número : ");
                        num1 = scanner.nextInt();
                        System.out.println("Digite um número : ");
                        num2 = scanner.nextInt();
                        if (num2 == 0) {
                            System.out.println("O segundo número não pode ser apenas zero, operação cancelada.");
                        } else {
                            media = num1 / num2;
                            System.out.println("Divisão dos números digitados foi: " + media);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida\n");
                }
            }
            System.out.println("\n" + "Finalizado");

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo para escolha da operação ");
        }
    }
}
