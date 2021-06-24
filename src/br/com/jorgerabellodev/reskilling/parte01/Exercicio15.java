package br.com.jorgerabellodev.reskilling.parte01;

import javax.swing.*;

/**
 * João recebeu seu salário e precisa pagar duas contas atrasadas. Em razão do atraso, ele deverá pagar
 * multa de 2% sobre cada conta. Faça um programa que calcule e mostre quanto restará do salário de
 * João.
 */
public class Exercicio15 {
    public static void main(String[] args) {

    try {

        int salario = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do seu salário:"));
        int conta1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor da primeira conta:"));
        int conta2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor da segunda conta:"));

         double multa=((conta1*0.02)+(conta2*0.02));
        double desconto=salario-multa;

        JOptionPane.showMessageDialog(null, "Desconto referente as duas contas: " + multa +
                "\nApós o desconto restará do salário a quantia: " + desconto );
    } catch (NumberFormatException i) {
        JOptionPane.showMessageDialog(null, "Programa não pode ser digitado letra ou símbolo: ");
    }
}
}

