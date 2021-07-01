package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o valor de um carro e mostre uma tabela com os seguintes dados: preço
 * final, quantidade de parcelas e valor da parcela. Considere o seguinte:
 * ■ ■ o preço final para compra à vista tem desconto de 20%;
 * ■ ■ a quantidade de parcelas pode ser: 6, 12, 18, 24, 30, 36, 42, 48, 54 e 60; e
 * ■ ■ os percentuais de acréscimo encontram-se na tabela a seguir.
 * -------------------------------------------------------------------------------------------------------------------
 * QUANTIDADE DE PARCELAS           PERCENTUAL DE ACRÉSCIMO SOBRE O PREÇO FINAL
 * -------------------------------------------------------------------------------------------------------------------
 * 6                                        3%
 * 12                                       6%
 * 18                                       9%
 * 24                                       12%
 * 30                                       15%
 * 36                                       18%
 * 42                                       21%
 * 48                                       24%
 * 54                                       27%
 * 60                                       30%
 * -------------------------------------------------------------------------------------------------------------------
 */
public class Exercicio11 {
    public static void main(String[] args) {

        var valorCarro = 0.0;
        var valorParcela = 0.0;
        var opcao = 0;
        var precoFinal = 0.0;
        var compraAVista = 0.0;
        var desconto = 0.0;
        var qtdParcela = 0.0;

        var scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o valor do carro: ");
            valorCarro = scanner.nextDouble();

            while (opcao != 10) {
                System.out.println("Digite  quantidade de parcela" +
                        "\n 1 - 6 parcelas" +
                        "\n 2 - 12 parcelas" +
                        "\n 3 - 18 parcelas" +
                        "\n 4 - 24 parcelas" +
                        "\n 5 - 30 parcelas" +
                        "\n 6 - 36 parcelas" +
                        "\n 7 - 42 parcelas" +
                        "\n 8 - 48 parcelas" +
                        "\n 9 - 54 parcelas" +
                        "\n 10 - 60 parcelas");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        valorParcela = (valorCarro / 100) * 3;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 6);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 2:
                        valorParcela = (valorCarro / 100) * 6;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 12);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 3:
                        valorParcela = (valorCarro / 100) * 9;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 18);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 4:
                        valorParcela = (valorCarro / 100) * 12;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 24);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 5:
                        valorParcela = (valorCarro / 100) * 15;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 30);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 6:
                        valorParcela = (valorCarro / 100) * 18;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 36);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 7:
                        valorParcela = (valorCarro / 100) * 21;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 42);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 8:
                        valorParcela = (valorCarro / 100) * 24;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 48);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 9:
                        valorParcela = (valorCarro / 100) * 27;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 54);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;
                    case 10:
                        valorParcela = (valorCarro / 100) * 30;
                        precoFinal = valorParcela + valorCarro;
                        desconto = ((precoFinal / 100) * 20);
                        compraAVista = precoFinal - desconto;
                        qtdParcela = (precoFinal / 60);

                        System.out.printf("Valor da parcela: %.2f ", qtdParcela);
                        System.out.println("\nValor do carro com as parcelas: " + precoFinal);
                        System.out.println("preço final para compra à vista tem desconto de 20%: " + compraAVista);
                        break;

                    default:
                }
                break;
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

