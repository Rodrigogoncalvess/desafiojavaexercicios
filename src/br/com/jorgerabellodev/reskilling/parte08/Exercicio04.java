package br.com.jorgerabellodev.reskilling.parte08;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Foi realizada uma pesquisa entre 20 habitantes de uma cidade. De cada habitante foram coletados estes dados:
 * idade, sexo, renda familiar e número de filhos. Faça um programa que leia esses dados, armazenando-os em
 * um vetor, calcule e mostre a média de salário entre os habitantes, a menor e a maior idade do grupo e a quantidade
 * de mulheres com mais de dois filhos e com renda familiar inferior a R$ 600,00.
 */
public class Exercicio04 {
    public static void main(String[] args) {

        int[] idade = new int[20];
        String[] sexo = new String[idade.length];
        double[] rendaFamiliar = new double[idade.length];
        int[] filho = new int[idade.length];
        double mediaSalario = 0.0;
        int maiorIdade = 0;
        int menorIdade = Integer.MAX_VALUE;
        int qtdMulherDoisFilhos = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < idade.length; i++) {
                System.out.println("Informe sua idade:");
                idade[i] = scanner.nextInt();

                if (idade[i] < 0) {
                    while (idade[i] < 0) {
                        System.out.println("Idade não pode ser negativa, necessário que informe  idade válida:");
                        idade[i] = scanner.nextInt();
                    }
                }
                System.out.println("Informe seu sexo:\nM - Masculino\nF - Feminino");
                sexo[i] = scanner.next();

                while (!sexo[i].equalsIgnoreCase("M") && !sexo[i].equalsIgnoreCase("F")) {
                    System.out.println("Informe uma das opções abaixo:\nM - Masculino\nF - Feminino");
                    sexo[i] = scanner.next();
                }
                System.out.println("Informe sua renda familiar:");
                rendaFamiliar[i] = scanner.nextDouble();
                if (rendaFamiliar[i] < 0) {
                    while (rendaFamiliar[i] < 0) {
                        System.out.println("Renda não pode ser valor negativa, necessário que informe o valor da renda:");
                        rendaFamiliar[i] = scanner.nextDouble();
                    }
                }
                System.out.println("Informe a quantidade de filhos:");
                filho[i] = scanner.nextInt();
                if (filho[i] < 0) {
                    while (filho[i] < 0) {
                        System.out.println("Quantidade de filhos não pode ser número negativo, digite novamente:");
                        filho[i] = scanner.nextInt();
                    }
                }
            }
            for (int i = 0; i < idade.length; i++) {
                mediaSalario += rendaFamiliar[i] / idade.length;

                if (idade[i] > maiorIdade) {
                    maiorIdade = idade[i];
                }
                if (idade[i] < menorIdade) {
                    menorIdade = idade[i];
                }
                if (filho[i] > 2 && sexo[i].equalsIgnoreCase("F") && rendaFamiliar[i] < 600) {
                    qtdMulherDoisFilhos++;
                }
            }

            System.out.println("Média de salário entre os habitantes: " + mediaSalario);
            System.out.println("Maior idade da pesquisa realizada: " + maiorIdade + " anos");
            System.out.println("Menor idade da pesquisa realizada: " + menorIdade + " anos");
            System.out.println("Quantidade de mulheres com mais de dois filhos e com renda familiar inferior a R$ 600,00 são " + qtdMulherDoisFilhos + " pessoas");
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo!");
        }
    }
}

