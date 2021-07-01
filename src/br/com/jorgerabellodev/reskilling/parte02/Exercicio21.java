package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o preço de um produto e seu código de origem e mostre sua procedência.
 * A procedência obedece à tabela a seguir.
 * ------------------------------------------------------------
 * CÓDIGO DE ORIGEM         PROCEDÊNCIA
 * ------------------------------------------------------------
 * 1                            Sul
 * 2                            Norte
 * 3                            Leste
 * 4                            Oeste
 * 5 ou 6                       Nordeste
 * 7 ou 8 ou 9                  Sudeste
 * 10 a 20                      Centro-oeste
 * 21 a 30                      Nordeste
 * ------------------------------------------------------------
 */
public class Exercicio21 {
    public static void main(String[] args) {


        var scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o preço do produto:");
            var  produto = scanner.nextDouble();
            System.out.println("Informe o código do produto:");
            var codigo = scanner.nextInt();

            if (codigo == 1 ) {
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Sul ");
            }else if(codigo == 2) {
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Norte ");
            }else if(codigo == 3){
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Leste ");
            }else if(codigo == 4){
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Oeste ");
            } else if (codigo >= 5 && codigo <= 6) {
                 System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Nordeste ");
            } else if (codigo >= 7 && codigo <= 9) {
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Suldeste ");
            } else if (codigo >= 10 && codigo <= 20) {
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Centro-oeste ");
            } else if (codigo >= 21 && codigo <= 30) {
                System.out.println("Valor do produto: "+produto);
                System.out.println("Procedência Nordeste ");
            } else {
                System.out.println("Procedência não localizada");
            }
        } catch (
                InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
