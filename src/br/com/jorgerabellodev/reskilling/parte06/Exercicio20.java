package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * A prefeitura de uma cidade fez uma pesquisa entre seus habitantes, coletando dados sobre o salário e o
 * número de filhos. Faça uma sub-rotina que leia esses dados para um número não determinado de pessoas
 * e retorne a média de salário da população, a média do número de filhos, o maior salário e o percentual
 * de pessoas com salário inferior a R$ 380,00.
 */
public class Exercicio20 {
    public static void main(String[] args) {

        double salario = 0.0;
        int numeroFilho;
        int somaFilho = 0;
        int mediaFilho;
        int pessoa = 0;
        double somaSalario = 0.0;
        double mediaSalario;
        double maiorSalario = 0.0;
        double salarioInferior = 0;
        double percentualSalario = 0.0;

        Scanner scanner = new Scanner(System.in);


        while (pessoa != -1) {
            System.out.println("\nInforme seu salário: ");
            salario = scanner.nextInt();

            System.out.println("Informe quantidade de filhos : ");
            numeroFilho = scanner.nextInt();

            pessoa++;
            somaSalario += salario;
            mediaSalario = somaSalario / pessoa;

            somaFilho += numeroFilho;
            mediaFilho = somaFilho / pessoa;

            if (salario > maiorSalario) {
                maiorSalario = salario;
            }
            if (salario < 380) {
                salarioInferior++;

            }
            percentualSalario=(salarioInferior/pessoa)*100;

            System.out.println("Quantidade de pessoas entrevistada: " + pessoa);
            System.out.println("Média de salário da população: " + mediaSalario);
            System.out.println("Média de filhos da população: " + mediaFilho);
            System.out.println("Maior salário: " + maiorSalario);
            System.out.println("Percentual de pessoas com salário inferior a R$ 380,00: " + percentualSalario+"%");


        }
    }

}
