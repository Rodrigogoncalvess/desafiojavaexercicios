package br.com.jorgerabellodev.reskilling.parte08;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Foi feita uma estatística em 15 estados brasileiros para coletar dados sobre acidentes de trânsito. Em cada
 * estado foram observados os seguintes aspectos:
 * ■ ■ nome do estado;
 * ■ ■ número de veículos que circularam nesse estado (em 2012);
 * ■ ■ número de acidentes de trânsito (em 2012).
 * Crie um programa que permita conhecer:
 * ■ ■ o maior e o menor índice de acidentes de trânsito e o nome dos estados em que eles ocorreram;
 * ■ ■ o percentual de veículos em cada estado;
 * ■ ■ a média de acidentes em cada um dos estados.
 */
public class Exercicio08 {
    public static void main(String[] args) {

        String[] nomeDoEstado = new String[3];
        int[] numeroDeVeiculo = new int[nomeDoEstado.length];
        int[] numeroDeAcidente = new int[nomeDoEstado.length];
        int maiorIndeceAcidente = 0;
        int menorIndeceAcidente = Integer.MAX_VALUE;
        double totalVeiculo = 0.0;
        double totalAcidente = 0.0;
        double percentual;
        double mediaAcidente;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");


        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < nomeDoEstado.length; i++) {
            System.out.println("Inserir o nome do estado:");
            nomeDoEstado[i] = teclado.next();
            System.out.println("Informe o número de veículos que circularam nesse estado(em 2012):");
            numeroDeVeiculo[i] = teclado.nextInt();
            System.out.println("número de acidentes de trânsito (em 2012):");
            numeroDeAcidente[i] = teclado.nextInt();
        }
        int contadorMaior = 0;
        int contadorMenor = 0;

        for (int i = 0; i < nomeDoEstado.length; i++) {

            if (numeroDeAcidente[i] > maiorIndeceAcidente) {
                maiorIndeceAcidente = numeroDeAcidente[i];
                contadorMaior = i;
            }
            if (numeroDeAcidente[i] < menorIndeceAcidente) {
                menorIndeceAcidente = numeroDeAcidente[i];
                contadorMenor = i;
            }
            totalVeiculo += numeroDeVeiculo[i];
            totalAcidente += numeroDeAcidente[i];
        }
        for (int i = 0; i < nomeDoEstado.length; i++) {
            percentual = (numeroDeVeiculo[i] * 100) / totalVeiculo;
            mediaAcidente = (numeroDeAcidente[i] * 100) / totalAcidente;

            System.out.println("O estado de " + nomeDoEstado[i] + " tem " + decimalFormat.format(percentual) + "% dos veículos pesquisado.");
            System.out.println("O estado " + nomeDoEstado[i] + " teve  " + decimalFormat.format(mediaAcidente) + "% de média de acidente.\n");

        }

        System.out.println("O estado " + nomeDoEstado[contadorMaior] + " teve o maior número de acidentes: " + maiorIndeceAcidente);
        System.out.println("O estado " + nomeDoEstado[contadorMenor] + " teve o menor número de acidentes: " + menorIndeceAcidente);


    }
}
