package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba a idade de um nadador e mostre sua categoria, usando as regras a seguir.
 * Para idade inferior a 5, deverá mostrar mensagem.
 * ------------------------------------------------------------
 * CATEGORIUA               IDADE
 * ------------------------------------------------------------
 * Infantil                 5 a 7
 * Juvenil                  8 a 10
 * Adolescente              11 a 15
 * Adulto                   16 a 30
 * Sênior                   Acima de 30
 * ------------------------------------------------------------
 */
public class Exercicio20 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe sua idade:");
            int idade = scanner.nextInt();

            if (idade >= 1 && idade <= 4) {
                System.out.println("Sem Categoria ");
            } else if (idade >= 5 && idade <= 7) {
                System.out.println("Categoria Infantil");
            } else if (idade >= 8 && idade <= 10) {
                System.out.println("Categoria Juvenil");
            } else if (idade >= 11 && idade <= 15) {
                System.out.println("Categoria Adolescente");
            } else if (idade >= 16 && idade <= 30) {
                System.out.println("Categoria Adulto");
            } else if (idade >= 31) {
                System.out.println("Categoria Sênior");
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

