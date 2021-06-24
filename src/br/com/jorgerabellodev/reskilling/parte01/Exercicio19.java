package br.com.jorgerabellodev.reskilling.parte01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Sabe-se que, para iluminar de maneira correta os cômodos de uma casa, para cada m 2 , deve-se usar 18 W
 * de potência. Faça um programa que receba as duas dimensões de um cômodo (em metros), calcule e mostre
 * a sua área (em m 2 ) e a potência de iluminação que deverá ser utilizada.
 */
public class Exercicio19 {
    public static void main(String[] args) {

        final int walts = 18;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a largura do cômodo:");
            double largura = scanner.nextDouble();

            System.out.println("\nInforme a largura do cômodo:");
            double comprimento = scanner.nextDouble();
            double area = (largura * comprimento);
            double potencia = area * walts;

            System.out.println("\ndimensão do cômodo é: " + area + " m2");
            System.out.println("\nPara iluminar de maneira correta este cômodo, precisará utilizar " + potencia + " walts de potência.");
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Valor da área não pode obter letra ou simbolo.");
        }
    }
}
