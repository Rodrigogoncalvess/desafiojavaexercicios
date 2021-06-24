package br.com.jorgerabellodev.reskilling.parte01;

import javax.swing.*;
import java.util.InputMismatchException;

/**
 * Faça um programa que receba o ano de nascimento de uma pessoa e o ano atual, calcule e mostre:
 * a) a idade dessa pessoa em anos;
 * b) a idade dessa pessoa em meses;
 * c) a idade dessa pessoa em dias;
 * d) a idade dessa pessoa em semanas.
 */
public class Exercicio14 {
    public static void main(String[] args) {

        try {
            int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do seu nascimento:"));
            int anoAtual = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano atual:"));

            int idade = anoAtual - anoNascimento;
            int meses = idade * 12;
            int dias = idade * 365;
            int semanas = dias / 7;
            JOptionPane.showMessageDialog(null, "Idade dessa pessoa em anos: " + idade +
                    "\nIdade dessa pessoa em meses: " + meses + "\nIdade dessa pessoa em dias: " + dias +
                    "\nIdade dessa pessoa em semanas: " + semanas);
        } catch (NumberFormatException i) {
            JOptionPane.showMessageDialog(null, "Programa não pode ser digitado letra ou símbolo: ");
        }
    }
}


