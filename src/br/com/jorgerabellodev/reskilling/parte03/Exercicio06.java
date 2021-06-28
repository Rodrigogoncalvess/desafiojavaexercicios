package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma loja utiliza o código V para transação à vista e P para transação a prazo. Faça um programa que receba
 * o código e o valor de quinze transações, calcule e mostre:
 * ■ ■ o valor total das compras à vista;
 * ■ ■ o valor total das compras a prazo;
 * ■ ■ o valor total das compras efetuadas; e
 * ■ ■ o valor da primeira prestação das compras a prazo juntas, sabendo-se que serão pagas em três vezes.
 */
public class Exercicio06 {

    public static void main(String[] args) {

        var aVista = "\nValor total das compras a vista: ";
        var aPrazo = "\nValor total das compras a prazo: ";
        var opcao = "";
        var codigoProdutoAVista = new double[16];
        var codigoProdutoAPrazo = new double[16];
        var valorProdutoAVista = new double[16];
        var valorProdutoAPrazo = new double[16];
        var comprasAVista = 0.0;
        var comprasAPrazo = 0.0;
        var comprasTotal = "\nvalor total das compras efetuadas: ";
        var pagamentoParcelado = 3;

        var scanner = new Scanner(System.in);


        while (!opcao.equals("V") && !opcao.equals("P")) {
            System.out.println("Informe a forma de pagamento: \n V - Pagamento à vista \n P - Pagamento à prazo");
            opcao = scanner.next();

            if (!opcao.equals("V") && !opcao.equals("P")) {
                System.out.println("Digite uma das opções listado abaixo:\n");
            }
        }
        try {
            do {
                if (opcao.equals("V")) {
                    for (var j = 1; j < 16; j++) {
                        System.out.print("\nDigite o codigo do " + j + "° produto a vista: ");
                        codigoProdutoAVista[j] = scanner.nextInt();

                        System.out.print("Digite o valor do produto a vista: ");
                        valorProdutoAVista[j] = scanner.nextDouble();
                        comprasAVista += valorProdutoAVista[j];
                    }
                    for (var i = 1; i < 16; i++) {
                        System.out.print("\nDigite o codigo do " + i + "° produto a prazo: ");
                        codigoProdutoAPrazo[i] = scanner.nextInt();

                        System.out.print("Digite o valor do produto a prazo: ");
                        valorProdutoAPrazo[i] = scanner.nextDouble();

                        comprasAPrazo += valorProdutoAPrazo[i];
                    }
                } else if (opcao.equals("P")) {
                    for (var i = 1; i < 16; i++) {

                        System.out.print("\nDigite o codigo do " + i + "° produto a prazo: ");
                        codigoProdutoAPrazo[i] = scanner.nextInt();

                        System.out.print("Digite o valor do produto a prazo: ");
                        valorProdutoAPrazo[i] = scanner.nextDouble();

                        comprasAPrazo += valorProdutoAPrazo[i];

                    }
                    for (var j = 1; j < 16; j++) {

                        System.out.print("\nDigite o codigo do " + j + "° produto a vista: ");
                        codigoProdutoAVista[j] = scanner.nextInt();

                        System.out.print("Digite o valor do produto a vista: ");
                        valorProdutoAVista[j] = scanner.nextDouble();
                        comprasAVista += valorProdutoAVista[j];
                    }
                }
                System.out.print(aVista + comprasAVista);
                System.out.print(aPrazo + comprasAPrazo);
                System.out.print(comprasTotal + (comprasAPrazo + comprasAVista) + "\n");
                System.out.printf("Valor das compras a prazo parcelado em três vezes: %.2f ", (comprasAPrazo / pagamentoParcelado));
                break;
            } while (true);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

