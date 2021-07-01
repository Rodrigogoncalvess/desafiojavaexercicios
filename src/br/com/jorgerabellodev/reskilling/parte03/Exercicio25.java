package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma agência bancária possui vários clientes que podem fazer investimentos com rendimentos mensais,
 * conforme a tabela a seguir:
 * -----------------------------------------------------------------------------------------------------------------
 * Tipo         Descrição                       RendimenTo mensal
 * -----------------------------------------------------------------------------------------------------------------
 * 1            Poupança                            1,5%
 * 2            Poupança plus                       2%
 * 3            Fundos de renda fixa                4%
 * -----------------------------------------------------------------------------------------------------------------
 * Faça um programa que leia o código do cliente, o tipo do investimento e o valor investido, e que calcule
 * e mostre o rendimento mensal de acordo com o tipo do investimento. No final, o programa deverá mostrar
 * o total investido e o total de juros pagos.
 * A leitura terminará quando o código do cliente digitado for menor ou igual a 0.
 */
public class Exercicio25 {
    public static void main(String[] args) {

        var cliente = 0;
        var valor = 0.0;
        var valorTotal = 0.0;
        final var poupanca = 1.5;
        final var poupancaPlus = 2;
        final var fundosDeRendaFixa = 4;

        var scanner = new Scanner(System.in);
        try {
            while (cliente != 3) {
                System.out.println("Informe o tipo de investimento:\n" +
                        "1 - Poupança\n" +
                        "2 - Poupança Plus\n" +
                        "3 - Fundos de renda fixa");
                cliente = scanner.nextInt();
                if (cliente <= 0) {
                    System.out.println("Programa finalizado!");
                    break;
                }
                switch (cliente) {
                    case 1:
                        System.out.println("Informe o valor do investimento:");
                        valor = scanner.nextDouble();
                        valorTotal = poupanca / valor * 100;
                        System.out.printf("Valor do juros pago: %.2f\n", valorTotal);
                        System.out.printf("Valor do investimento: %.2f\n", valor);
                        System.out.printf("Valor total do investimento: %.2f\n", (valor + valorTotal));
                        break;

                    case 2:
                        System.out.println("Informe o valor do investimento:");
                        valor = scanner.nextDouble();
                        valorTotal = poupancaPlus / valor * 100;
                        System.out.printf("Valor do juros pago: %.2f\n", valorTotal);
                        System.out.printf("Valor do investimento: %.2f\n", valor);
                        System.out.printf("Valor total do investimento: %.2f", (valor + valorTotal));
                        break;

                    case 3:
                        System.out.println("Informe o valor do investimento:");
                        valor = scanner.nextDouble();
                        valorTotal = fundosDeRendaFixa / valor * 100;
                        System.out.printf("Valor do juros pago: %.2f\n", valorTotal);
                        System.out.printf("Valor do investimento: %.2f\n", valor);
                        System.out.printf("Valor total do investimento: %.2f", (valor + valorTotal));
                        break;
                }
            }
        }catch (InputMismatchException inputMismatchException){
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

