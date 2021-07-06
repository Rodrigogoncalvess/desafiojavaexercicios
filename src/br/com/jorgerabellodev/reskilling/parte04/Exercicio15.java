package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o nome de oito clientes e armazene-os em um vetor. Em um segundo vetor,
 * armazene a quantidade de DVDs locados em 2011 por cada um dos oito clientes. Sabe-se que, para cada
 * dez locações, o cliente tem direito a uma locação grátis. Faça um programa que mostre o nome de todos
 * os clientes, com a quantidade de locações grátis a que ele tem direito.
 */
public class Exercicio15 {
    public static void main(String[] args) {

        var nomeCliente = new String[8];
        var dvdsLocados = new int[8];
        var qtdGratis = 0;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < nomeCliente.length; i++) {
                System.out.println("Digite o nome do cliente: ");
                nomeCliente[i] = scanner.next();

                System.out.println("Quantidade de DVDs locados em 2011 pelo " + nomeCliente[i] + " foi de : ");
                dvdsLocados[i] = scanner.nextInt();
            }

            System.out.println("Lista dos clientes cadastrados:");
            for (int i = 0; i < nomeCliente.length; i++) {
                System.out.println(nomeCliente[i]);
            }

            for (int i = 0; i < nomeCliente.length; i++) {
                if (dvdsLocados[i] > 10) {
                    qtdGratis = dvdsLocados[i] / 10;

                    System.out.println("\nCliente " + nomeCliente[i] + " tem direito a locação grátis de " + qtdGratis + " DVDs.");

                } else {
                    System.out.println("Cliente " + nomeCliente[i] + " não atingiu as 10 locações para obter a locaçãos gátis!");
                }
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}