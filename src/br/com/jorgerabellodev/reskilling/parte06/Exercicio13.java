package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Foi realizada uma pesquisa entre 15 habitantes de uma região. Os dados coletados de cada habitante
 * foram: idade, sexo, salário e número de filhos.
 * Faça uma sub-rotina que leia esses dados armazenando-os em vetores. Depois, crie sub-rotinas que
 * recebam esses vetores como parâmetro e retornem a média de salário entre os habitantes, a menor e a
 * maior idade do grupo e a quantidade de mulheres com três filhos que recebem até R$ 500,00 (utilize
 * uma sub-rotina para cada cálculo).
 */
public class Exercicio13 {

    static int[] idade = new int[15];
    static double[] salario = new double[idade.length];
    static String[] sexo = new String[idade.length];
    static int[] numeroFilho = new int[idade.length];


    public static void main(String[] args) {


        SubRotina subRotina = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < idade.length; i++) {

            System.out.println("Informe sua idade: ");
            idade[i] = scanner.nextInt();

            System.out.println("Informe seu sexo: ");
            sexo[i] = scanner.next();

            while (!sexo[i].equalsIgnoreCase("masculino") && !sexo[i].equalsIgnoreCase("feminino")) {
                System.out.println("Informe seu sexo: ");
                sexo[i] = scanner.next();
            }

            System.out.println("Informe seu salário: ");
            salario[i] = scanner.nextDouble();

            System.out.println("Informe a quantidade de filhos: ");
            numeroFilho[i] = scanner.nextInt();


        }
        subRotina.calculoMediaSalario(salario);
        subRotina.calculoIdade(idade);
        subRotina.calculoFilho(numeroFilho);

    }

    static class SubRotina {

        public void calculoMediaSalario(double[] vetorSalario) {
            double somaSalario = 0.0;
            double mediaSalario = 0.0;

            for (int i = 0; i < vetorSalario.length; i++) {
                somaSalario += vetorSalario[i];
                mediaSalario = somaSalario / vetorSalario.length;
            }
            System.out.println("Média de salário entre os habitantes: " + mediaSalario);

        }

        public void calculoIdade(int[] vetorIdade) {
            int idadeMaior = 0;
            int idadeMenor = Integer.MAX_VALUE;

            for (int i = 0; i < vetorIdade.length; i++) {
                if (vetorIdade[i] > idadeMaior) {
                    idadeMaior = vetorIdade[i];
                }
                if (vetorIdade[i] < idadeMenor) {
                    idadeMenor = vetorIdade[i];
                }
            }
            System.out.println("Maior idade do grupo: " + idadeMaior);
            System.out.println("Menor idade do grupo: " + idadeMenor);

        }

        public void calculoFilho(int[] vetorFilho) {
            int qtdMulheres = 0;
            for (int i = 0; i < vetorFilho.length; i++) {
                if (!sexo.equals("feminino") && (numeroFilho[i] == 3) && (salario[i] <= 500))
                    qtdMulheres++;
            }
            System.out.println("Quantidade de mulheres com três filhos que recebem até R$ 500,00: " + qtdMulheres);
        }
    }
}

