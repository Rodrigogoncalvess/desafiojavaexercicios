package br.com.jorgerabellodev.reskilling.parte06;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Crie uma sub-rotina que receba como parâmetro a altura (alt) e o sexo de uma pessoa e retorne seu peso ideal.
 * Para homens, deverá calcular o peso ideal usando a fórmula: peso ideal = 72.7 *alt − 58; para mulheres: peso
 * ideal = 62.1 * alt − 44.7.
 */
public class Exercicio06 {

    static double altura;
    static String sexo;
    static double pesoIdeal;

    static final double calculoHomem1 = 72.7;
    static final double calculoHomem2 = 58;
    static final double calculoFemino1 = 62.1;
    static final double calculoFemino2 = 44.7;

    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        SubRotina subRotina = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe sua altura:");
            altura = scanner.nextDouble();

            System.out.println("Informe seu sexo:");
            sexo = scanner.next();

            while ((!sexo.equalsIgnoreCase("Masculino")) && (!sexo.equalsIgnoreCase("Feminino"))) {
                System.out.println("Digite um sexo válido , sendo masculino ou feminino.");
                sexo = scanner.next();

            }

            System.out.println("Seu peso ideal é " + decimalFormat.format(subRotina.pesoSexo(sexo, altura)));

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }


    static class SubRotina {
        public double pesoSexo(String sexo, double altura) {

            if (sexo.equalsIgnoreCase("MASCULINO")) {

                pesoIdeal = (calculoHomem1 * altura) - calculoHomem2;
            }
            if (sexo.equalsIgnoreCase("FEMININO")) {

                pesoIdeal = (calculoFemino1 * altura) - calculoFemino2;
            }

            return pesoIdeal;
        }

    }
}