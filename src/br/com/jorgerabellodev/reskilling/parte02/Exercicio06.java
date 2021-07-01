package br.com.jorgerabellodev.reskilling.parte02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba dois números e execute uma das operações listadas a seguir, de acordo com a
 * escolha do usuário. Se for digitada uma opção inválida, mostre mensagem de erro e termine a execução do
 * programa. As opções são:
 * a) O primeiro número elevado ao segundo número.
 * b) Raiz quadrada de cada um dos números.
 * c) Raiz cúbica de cada um dos números.
 */
public class Exercicio06 {
    public static void main(String[] args) {


        double num1;
        double num2;
        double calculo;
        double raiz;

        Scanner scanner = new Scanner(System.in);


        int opcao = 0;
        try {

            while (opcao != 4) {
                System.out.println("Opção 1 O primeiro número elevado ao segundo número" + "\n"
                        + "Opção 2 Raiz quadrada de cada um dos números"
                        + "\n" + "Opção 3 Raiz cúbica de cada um dos números");
                opcao = scanner.nextInt();


                switch (opcao) {
                    case 1:
                        System.out.println("Digite o primeiro número: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Digite o segundo número: ");
                        num2 = scanner.nextDouble();
                        calculo= Math.pow(num1,num2);
                        System.out.println("O resultado do primeiro número elevado ao segundo é: " + calculo);
                        break;

                    case 2:
                        System.out.println("Digite o primeiro número: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Digite o segundo número: ");
                        num2 = scanner.nextDouble();
                        calculo= Math.pow(num1,2);
                        raiz= Math.pow(num2,2);
                        System.out.println("O resultado do primeiro número digitado ao quadrado: " + calculo);
                        System.out.println("O resultado do segundo número digitado ao quadrado: " + raiz);
                        break;
                    case 3:
                        System.out.println("Digite o primeiro número: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Digite o segundo número: ");
                        num2 = scanner.nextDouble();
                        calculo= Math.cbrt(num1);
                        raiz= Math.cbrt(num2);
                        System.out.println("O resultado do primeiro número digitado a raiz cúbica: " + calculo);
                        System.out.println("O resultado do segundo número digitado a raiz cúbica: " + raiz);
                        break;


                    default:
                        System.out.println("\nOpção inválida\n");
                }
            }
            System.out.println("\n" + "Finalizado");

        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo para escolha da operação ");
        }
    }
}


