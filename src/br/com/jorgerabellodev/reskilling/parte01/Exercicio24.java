package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a quantidade de dinheiro em reais que uma pessoa que vai viajar possui. Ela
 * vai passar por vários países e precisa converter seu dinheiro em dólares, marco alemão e libra esterlina. Sabe-
 * -se que a cotação do dólar é de R$ 1,80; do marco alemão, de R$ 2,00; e da libra esterlina, de R$ 3,57. O
 * programa deve fazer as conversões e mostrá-las
 */
public class Exercicio24 {
    public static void main(String[] args) {

        final double dolar = 1.80;
        final double marcoAlemao = 2;
        final double libraEsterlina = 3.57;
        double valor;
        int conversao;


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Opção 1 para conversão de Reais para dolar:\n" +
                    "Opção 2 para conversão de Reais para Marco Alemão:\n" +
                    "Opção 3 para conversão de Libra Esterlina para dolar: ");
            conversao = scanner.nextInt();

            switch (conversao) {
                case 1 -> {
                    System.out.println("Digite um valor que deseja realizar a conversão:");
                    valor = scanner.nextDouble();
                    valor /= dolar;
                    System.out.printf("Valor convertido: %.2f \n", valor);
                }
                case 2 -> {
                    System.out.println("Digite um valor que deseja realizar a conversão:");
                    valor = scanner.nextDouble();
                    valor /= marcoAlemao;
                    System.out.printf("Valor convertido: %.2f \n", valor);
                }
                case 3 -> {
                    System.out.println("Digite um valor que desaja realizar a conversão:");
                    valor = scanner.nextDouble();
                    valor /= libraEsterlina;
                    System.out.printf("Valor convertido: %.2f \n", valor);
                }
                default -> System.out.println("Opção inválida\n");
            }
            System.out.println("\nOperação finalizada" );
            break;

        }
    }
}


