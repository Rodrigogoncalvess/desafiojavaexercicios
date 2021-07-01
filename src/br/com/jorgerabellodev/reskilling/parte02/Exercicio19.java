package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a altura e o sexo de uma pessoa e calcule e mostre seu peso ideal, utilizando
 * as seguintes fórmulas (onde h é a altura):
 * ■ ■ para homens: (72.7 * h) – 58.
 * ■ ■ para mulheres: (62.1 * h) – 44.7.
 */
public class Exercicio19 {
    public static void main(String[] args) {

        double altura;
        int sexo = 0;
        double peso;

        Scanner scanner = new Scanner(System.in);

        try {
            while (sexo != 2) {
                System.out.println("\nEscolha seu sexo para verificar seu peso ideal:\n\n" + "Opção 1 Masculino " + "\n"
                        + "Opção 2 Feminin0" + "\nOpção 0 Sair");
                sexo = scanner.nextInt();


                switch (sexo) {

                    case 1:
                        System.out.println("Informe sua altura:");
                        altura = scanner.nextDouble();
                        peso = (72.2 * altura) - 58;
                        System.out.printf("\nSeu peso ideal é: %.2f ", peso);
                        break;

                    case 2:
                        System.out.println("Informe sua altura:");
                        altura = scanner.nextDouble();
                        peso = (62.1 * altura) - 44.7;
                        System.out.printf("\nSeu peso ideal é: %.2f ", peso);
                        break;
                    case 0:
                        System.out.println("\n" + "Finalizado");
                        return;

                    default:
                        System.out.println("\nOpção inválida\n");
                        break;
                }

            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}


