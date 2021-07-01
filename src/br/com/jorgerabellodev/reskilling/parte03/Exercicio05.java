package br.com.jorgerabellodev.reskilling.parte03;

import java.util.Scanner;

/**
 * Faça um programa que mostre as tabuadas dos números de 1 a 10.
 */
public class Exercicio05 {
    public static void main(String[] args) {


        for (var i = 1; i < 11; i++) {
            System.out.println("\nTabuada de multiplicação " +i);
            for (var j = 1; j <11 ; j++)

                System.out.println(i + " x " + j + " = " + (j * i));
            }
        }

    }

