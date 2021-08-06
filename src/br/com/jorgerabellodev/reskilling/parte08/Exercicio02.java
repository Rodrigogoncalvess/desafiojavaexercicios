package br.com.jorgerabellodev.reskilling.parte08;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados sobre salário,
 * idade e número de filhos. Faça um programa que leia esses dados de 20 pessoas, calcule e mostre:
 * ■ ■ a média de salário da população;
 * ■ ■ a média do número de filhos;
 * ■ ■ o maior salário;
 * ■ ■ o percentual de mulheres com salário superior a R$ 1.000,00.
 */
public class Exercicio02 {
    public static void main(String[] args) {

        int[] pessoa = new int[20];
        String[] sexo = new String[pessoa.length];
        double[] salario = new double[pessoa.length];
        int[] idade = new int[pessoa.length];
        int[] filho = new int[pessoa.length];
        double mediaSalario = 0;
        int mediaFilhos = 0;
        double maiorSalario = 0.0;
        double contadorMedia = 0.0;
        double contador = 0.0;
        double percentualMulher = 0.0;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(in);

        for (int i = 0; i < pessoa.length; i++) {
            System.out.println("Informe seu  sexo: \nM - Masculino \nF - Feminino ");
            sexo[i] = scanner.next();


            while ((!sexo[i].equalsIgnoreCase("M")) && (!sexo[i].equalsIgnoreCase("F"))) {
                System.out.println("Informe seu  sexo para continuar com a operação: \nM - Masculino \nF - Feminino ");
                sexo[i] = scanner.next();
            }

            System.out.println("Informe seu salário: ");
            salario[i] = scanner.nextDouble();

            if (salario[i] < 0) {
                while (salario[i] < 0) {
                    System.out.println("Salário não pode ser negativo, informe um valor válido: ");
                    salario[i] = scanner.nextDouble();
                }
            }
        }
        for (int i = 0; i < pessoa.length; i++) {
            contador++;
            mediaSalario += salario[i] / pessoa.length;
            mediaFilhos += filho[i] / pessoa.length;


            if (salario[i] > maiorSalario) {
                maiorSalario = salario[i];
            }
            if (salario[i] > 1000 && sexo[i].equalsIgnoreCase("f")) {
                contadorMedia++;

            }
        }

        percentualMulher = (contadorMedia / contador) * 100;

        System.out.println("Quantidade de mulheres com salário superior a R$ 1.000,00 " + decimalFormat.format(percentualMulher) + "%");
        System.out.println("Média de salário da população: " + decimalFormat.format(mediaSalario));
        System.out.println("Média do número de filhos: " + mediaFilhos);
        System.out.println("Maior salário: " + maiorSalario);
    }

}
