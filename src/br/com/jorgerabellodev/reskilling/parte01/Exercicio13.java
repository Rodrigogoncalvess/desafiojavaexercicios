package br.com.jorgerabellodev.reskilling.parte01;

import javax.swing.*;

/**
 * Faça um programa que calcule e mostre a tabuada de um número digitado pelo usuário.
 * Exemplo:
 * Digite um número: 5
 * 5 × 5 = 25
 * 5 × 0 = 0
 * 5 × 6 = 30
 * 5 × 1 = 5
 * 5 × 7 = 35
 * 5 × 2 = 10
 * 5 × 8 = 40
 * 5 × 3 = 15
 * 5 × 9 = 45
 * 5 × 4 = 20
 * 5 × 10 = 50
 */
public class Exercicio13 {
    public static void main(String[] args) {


        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para obter a tabuada de multiplicação:"));
        System.out.println("Tabuada de multiplicação");
        for (int i = 0; i <= 10; i++) {
            int multi = numero * i;
            System.out.println(+numero + " x " + i + " = " + multi);
        }
    }
}

