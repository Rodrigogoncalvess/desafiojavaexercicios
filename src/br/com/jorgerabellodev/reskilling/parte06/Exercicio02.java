package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Crie uma sub-rotina que receba três números inteiros como parâmetros, representando horas, minutos e se-
 * gundos, e os converta em segundos. Exemplo: 2h, 40min e 10s correspondem a 9.610 segundos.
 */
public class Exercicio02 {


    public static void main(String[] args) {

        int horaDigitada;
        int minutosDigitados;
        int segundosDigitados;
        String continuar;
        boolean controladora = true;

        SubRotina sub = new SubRotina();

        Scanner scan = new Scanner(System.in);


        while (controladora == true) {
            System.out.println("Digite a hora: ");

            horaDigitada = scan.nextInt();
            if (horaDigitada > 24) {
                System.out.println("Hora não pode ser superior a 24, digite a hora novamente: ");
                horaDigitada = scan.nextInt();

            }
            System.out.println("Digite os minutos: ");
            minutosDigitados = scan.nextInt();

            if (minutosDigitados > 60) {
                System.out.println("Minutos não pode ser superior a 60, digite os minutos novamente: ");
                minutosDigitados = scan.nextInt();
            }
            System.out.println("Digite os segundos: ");
            segundosDigitados = scan.nextInt();

            if (segundosDigitados > 60) {
                System.out.println("Segundos não pode ser superior a 60, digite os segundos novamente: ");
                segundosDigitados = scan.nextInt();
            }

            System.out.println("A conversão corresponde : " + sub.conversao(horaDigitada, minutosDigitados, segundosDigitados) + " segundos.");

            System.out.println("\nDeseja continuar o programa? \n S - Sim ou N - Não.");
            continuar = scan.next();

            while ((!continuar.equalsIgnoreCase("S") && (!continuar.equalsIgnoreCase("N")))) {

                System.out.println("\nDigite uma das opções abaixo: \n S - Sim ou N - Não.");
                continuar = scan.next();

                if (continuar.equalsIgnoreCase("N")) {
                    System.out.println("Programa Finalizado!");
                    controladora = false;
                }
            }

        }

    }

    static class SubRotina {
        public int conversao(int hora, int minutos, int segundos) {

            return ((hora * 3600) + (minutos * 60) + segundos);

        }
    }
}

