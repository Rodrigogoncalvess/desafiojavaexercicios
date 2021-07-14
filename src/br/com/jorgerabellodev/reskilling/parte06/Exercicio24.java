package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Faça um programa que receba a temperatura média de cada mês do ano e armazene-as em um vetor. O
 * programa deverá calcular e mostrar a maior e a menor temperatura do ano, junto com o mês em que elas
 * ocorreram (o mês deverá ser mostrado por extenso: 1 = janeiro; 2 = fevereiro; ...).
 * OBS: Não se preocupe com empates. Cada cálculo deve ser realizado e mostrado em uma sub-rotina.
 */
public class Exercicio24 {

    static int[] mes = new int[12];
    static int maiorTemperatura = 0;
    static int menorTemperatura = Integer.MAX_VALUE;
    static int indiceMaior = 0;
    static int indiceMenor = 0;

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < mes.length; i++) {
            System.out.println("Informe a temperatura do mês " + (i + 1) + " : ");
            mes[i] = scanner.nextInt();
        }

        sub.temperatura();

    }

    static class SubRotina {

        public void temperatura() {

            for (int i = 0; i < mes.length; i++) {
                if (mes[i] > maiorTemperatura) {
                    maiorTemperatura = mes[i];
                    indiceMaior = i + 1;
                }
                if (mes[i] < menorTemperatura) {
                    menorTemperatura = mes[i];
                    indiceMenor = i + 1;
                }

            }

            System.out.println("\nMaior temperatura foi " + maiorTemperatura + "° no mês de: ");
            switch (indiceMaior) {
                case 1:
                    System.out.println("Janeiro\n");
                    break;
                case 2:
                    System.out.println("Fevereiro\n");
                    break;
                case 3:
                    System.out.println("Março\n");
                    break;
                case 4:
                    System.out.println("Abril\n");
                    break;
                case 5:
                    System.out.println("Maio\n");
                    break;
                case 6:
                    System.out.println("Junho\n");
                    break;
                case 7:
                    System.out.println("Julho\n");
                    break;
                case 8:
                    System.out.println("Agosto\n");
                    break;
                case 9:
                    System.out.println("Setembro\n");
                    break;
                case 10:
                    System.out.println("Outubro\n");
                    break;
                case 11:
                    System.out.println("Novembro\n");
                    break;
                case 12:
                    System.out.println("Dezembro\n");
                    break;

            }

            System.out.println("Menor temperatura foi " + menorTemperatura + "° no mês de: ");

            switch (indiceMenor) {
                case 1:
                    System.out.println("Janeiro\n");
                    break;
                case 2:
                    System.out.println("Fevereiro\n");
                    break;
                case 3:
                    System.out.println("Março\n");
                    break;
                case 4:
                    System.out.println("Abril\n");
                    break;
                case 5:
                    System.out.println("Maio\n");
                    break;
                case 6:
                    System.out.println("Junho\n");
                    break;
                case 7:
                    System.out.println("Julho\n");
                    break;
                case 8:
                    System.out.println("Agosto\n");
                    break;
                case 9:
                    System.out.println("Setembro\n");
                    break;
                case 10:
                    System.out.println("Outubro\n");
                    break;
                case 11:
                    System.out.println("Novembro\n");
                    break;
                case 12:
                    System.out.println("Dezembro\n");
                    break;

            }

        }
    }

}


