package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade, o peso, a altura, a cor dos olhos (A — azul; P — preto; V — verde; e
 * C — castanho) e a cor dos cabelos (P — preto; C — castanho; L — louro; e R — ruivo) de seis pessoas, e que
 * calcule e mostre:
 * ■ ■ a quantidade de pessoas com idade superior a 50 anos e peso inferior a 60 kg;
 * ■ ■ a média das idades das pessoas com altura inferior a 1,50 m;
 * ■ ■ a porcentagem de pessoas com olhos azuis entre todas as pessoas analisadas; e
 * ■ ■ a quantidade de pessoas ruivas e que não possuem olhos azuis.
 */
public class Exercicio08 {
    public static void main(String[] args) {

        var idade = new double[6];
        var peso = new double[6];
        var altura = new double[6];
        var corOlhos = new String[6];
        var corCabelo = new String[6];
        var idadeSuperior = 0;
        var alturaInferior = 0.0;
        var mediaIdade = 0.0;
        var porcentagemOlhos = 0.0;
        var mediaOlhos = 0.0;
        var mediaPessoa = 0;
        var cabeloOlhos = 0;


        var scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < 6; i++) {
                System.out.print("Informe sua idade: ");
                idade[i] = scanner.nextInt();
                System.out.print("Informe seu peso: ");
                peso[i] = scanner.nextDouble();
                System.out.print("Informe sua altura: ");
                altura[i] = scanner.nextDouble();

                System.out.print("Informe a cor dos olhos" +
                        " \nA — azul; \nP — preto; \nV — verde; \nC — castanho ");
                corOlhos[i] = scanner.next();
                while (!corOlhos[i].equals("A") && !corOlhos[i].equals("V") && !corOlhos[i].equals("P") && !corOlhos[i].equals("C")) {

                    System.out.println("\nOpção inválida, digite uma das opções listado abaixo:\nInforme a cor dos olhos" +
                            " \nA — azul; \nP — preto; \nV — verde; \n C — castanho ");
                    corOlhos[i] = scanner.next();

                }
                System.out.print("\nInforme a cor do cabelo: \n P — preto; \nC — castanho; \nL — louro;  \nR — ruivo");
                corCabelo[i] = scanner.next();
                while (!corCabelo[i].equals("P") && !corCabelo[i].equals("C") && !corCabelo[i].equals("L") && !corCabelo[i].equals("R")) {

                }
                if (idade[i] > 50 && peso[i] < 60) {
                    idadeSuperior++;
                }
                if (altura[i] < 1.5) {
                    alturaInferior++;
                    mediaIdade += altura[i];
                    mediaIdade /= alturaInferior;
                }
                if (corOlhos[i].equals("A")) {
                    porcentagemOlhos++;
                    mediaPessoa = corCabelo.length;
                    mediaOlhos = porcentagemOlhos / mediaPessoa;
                }
                if (corCabelo[i].equals("R") && !corOlhos[i].equals("A")) {
                    cabeloOlhos++;
                }

            }
            System.out.println("Quantidade de pessoas com idade superior a 50 anos e peso inferior a 60 kg: " + idadeSuperior);
            System.out.print("\nMédia das idades das pessoas com altura inferior a 1,50 m: " + mediaIdade + "\n");
            System.out.printf("Porcentagem de pessoas com olhos azuis entre todas as pessoas analisadas:%.2f ", mediaOlhos);
            System.out.print("\nQuantidade de pessoas ruivas e que não possuem olhos azuis: " + cabeloOlhos);

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}


