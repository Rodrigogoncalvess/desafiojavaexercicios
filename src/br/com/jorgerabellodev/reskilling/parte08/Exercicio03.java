package br.com.jorgerabellodev.reskilling.parte08;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Foi realizada uma pesquisa sobre algumas características físicas de 50 habitantes de certa região. De cada
 * habitante foram coletados os seguintes dados: sexo, altura, idade e cor dos olhos (A – azuis; V – verdes; ou C – castanhos).
 * Faça um programa que leia esses dados, armazene-os em um registro do tipo vetor e determine:
 * ■ ■ a média de idade das pessoas com olhos castanhos e altura superior a 1,60 m;
 * ■ ■ a maior idade entre os habitantes;
 * ■ ■ a quantidade de indivíduos do sexo feminino com idade entre 20 e 45 anos (inclusive) ou que tenham olhos verdes e altura inferior a 1,70 m;
 * ■ ■ o percentual de homens.
 */
public class Exercicio03 {
    public static void main(String[] args) {

        String[] sexo = new String[50];
        double[] altura = new double[sexo.length];
        int[] idade = new int[sexo.length];
        String[] corOlhos = new String[sexo.length];
        float somaIdade = 0;
        float contaIdade = 0;
        int mediaIdade;
        int maiorIdade = 0;
        int qtdMulher = 0;
        float qtdHomem = 0;
        float somaQuantidadeHomem = 0;
        float percentualHomem = 0;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < sexo.length; i++) {
            System.out.println("Informe seu sexo: \nM - Masculino \nF - Feminino");
            sexo[i] = scanner.next();
            while ((!sexo[i].equalsIgnoreCase("M")) && (!sexo[i].equalsIgnoreCase("F"))) {
                System.out.println("Necessário que informe seu sexo: \nM - Masculino \nF - Feminino");
                sexo[i] = scanner.next();
            }

            System.out.println("Informe sua altura:");
            altura[i] = scanner.nextDouble();
            if ((altura[i] < 0) || (altura[i] > 2.5)) {
                while (altura[i] < 0 || altura[i] > 2.5) {
                    System.out.println("Necessário informa a sua altura: \nAltura não pode ser superior a 2,5 e menor que 1 metro.");
                    altura[i] = scanner.nextDouble();
                }
            }
            System.out.println("Informe sua idade:");
            idade[i] = scanner.nextInt();
            if (idade[i] < 0) {
                while (idade[i] < 0) {
                    System.out.println("Idade não pode ser negativa, informe sua idade:");
                    idade[i] = scanner.nextInt();

                }
            }
            System.out.println("Informe a cor dos olhos: \nA - Azul\nV - Verde\nC - Castanho");
            corOlhos[i] = scanner.next();

            if (!corOlhos[i].equalsIgnoreCase("A") && !corOlhos[i].equalsIgnoreCase("V") && !corOlhos[i].equalsIgnoreCase("C")) {
                while (!corOlhos[i].equalsIgnoreCase("A") && !corOlhos[i].equalsIgnoreCase("V") && !corOlhos[i].equalsIgnoreCase("C")) {
                    System.out.println("Informe a cor dos olhos: \nA - Azul\nV - Verde\nC - Castanho");
                    corOlhos[i] = scanner.next();
                }

            }
        }
        for (int i = 0; i < sexo.length; i++) {
            if (altura[i] > 1.60 && corOlhos[i].equalsIgnoreCase("C")) {
                contaIdade++;
                somaIdade += idade[i];

            }
            if (idade[i] > maiorIdade) {
                maiorIdade = idade[i];
            }
            if ((idade[i] > 10) && (idade[i] < 45) && (corOlhos[i].equalsIgnoreCase("V")) && sexo[i].equalsIgnoreCase("F") && altura[i] < 1.70) {
                qtdMulher++;
            }
            if (sexo[i].equalsIgnoreCase("M")) {
                qtdHomem++;
            }
        }
        mediaIdade = (int) (somaIdade / contaIdade);
        somaQuantidadeHomem += qtdHomem;
        percentualHomem = (somaQuantidadeHomem / sexo.length) * 100;

        System.out.println("Média de idade das pessoas com olhos castanhos e altura superior a 1,60 m = " + mediaIdade + " anos");
        System.out.println("Maior idade entre os habitantes " + maiorIdade + " anos");
        System.out.println("Quantidade de indivíduos do sexo feminino com idade entre 20 e 45 anos (inclusive) ou que tenham olhos verdes e altura inferior a 1,70 m = " + qtdMulher);
        System.out.println("Percentual de homens " + decimalFormat.format(percentualHomem) + "%");

    }
}

