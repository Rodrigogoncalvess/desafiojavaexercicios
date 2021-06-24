package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba uma hora (uma variável para hora e outra para minutos), calcule e
 * mostre:
 * a) a hora digitada convertida em minutos;
 * b) o total dos minutos, ou seja, os minutos digitados mais a conversão anterior;
 * c) o total dos minutos convertidos em segundos.
 */
public class Exercicio25 {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite a hora");
            int hora = scanner.nextInt();

            System.out.println("Digite os minutos");
            int minutos = scanner.nextInt();

            int horaDigitada = hora * 60;
            int totalminutos = minutos + horaDigitada;
            int segundos = totalminutos * 60;

            System.out.println("Conversão de hora para minuto: " + horaDigitada);
            System.out.println("Total de minutos com a conversão de hora: " + totalminutos);
            System.out.println("Total de segundo com a conversão de minutos: " + segundos);

        } catch (InputMismatchException i) {
            System.out.println("Conversão não pode obter letra ou simbolo.");
        }
    }
}
