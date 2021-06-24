package br.com.jorgerabellodev.reskilling.parte01;

import javax.swing.*;

/**
 * Faça um programa que receba uma temperatura em Celsius, calcule e mostre essa temperatura em
 * Fahrenheit. Sabe-se que F = 180*(C + 32)/100.
 */
public class Exercicio18 {
    public static void main(String[] args) {

        try {
            double grauCelsius = Double.parseDouble(JOptionPane.showInputDialog("Informe a temperatura em graus Celsius"));

            if (grauCelsius <= 0) {
                JOptionPane.showMessageDialog(null, "Não é possível realizar a conversão com apenas o valor 0. ");
            } else {
                double grauFahrenheit = (grauCelsius * 9 / 5) + 32;
                JOptionPane.showMessageDialog(null, "Conversão para graus Fahrenheit é : " + grauFahrenheit);
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Não pode obter letra ou simbolo para a conversão.");
        }
    }
}
