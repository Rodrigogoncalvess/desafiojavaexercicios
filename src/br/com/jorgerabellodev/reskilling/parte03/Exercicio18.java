package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Foi feita uma pesquisa entre os habitantes de uma região. Foram coletados os dados de idade, sexo (M/F)
 * e salário. Faça um programa que calcule e mostre:
 * ■ ■ a média dos salários do grupo;
 * ■ ■ a maior e a menor idade do grupo;
 * ■ ■ a quantidade de mulheres com salário até R$ 200,00;
 * ■ ■ a idade e o sexo da pessoa que possui o menor salário.
 * Finalize a entrada de dados ao ser digitada uma idade negativa.
 */
public class Exercicio18 {
    public static void main(String[] args) {

        var idade = new int[11];
        var sexo = new String[11];
        var salario = new double[11];
        var mediaSalario = 0.0;
        var qtdFeminino = 0.0;
        var menorIdade = Integer.MAX_VALUE;
        var maiorIdade = 0;
        var decimal = new DecimalFormat("0.00");

        var teclado = new Scanner(System.in);
        try {
            for (int i = 1; i < idade.length; i++) {
                System.out.println("Informe sua idade: ");
                idade[i] = teclado.nextInt();
                if (idade[i] == 0) {
                    System.out.println("Programa finalizado!");
                    System.exit(0);
                }

                System.out.println("Informe seu sexo: \nM - Masculino \nF - Feminino");
                sexo[i] = teclado.next();
                while (!sexo[i].equals("M") && !sexo[i].equals("F")) {
                    System.out.println("Informe seu sexo: \nM - Masculino \nF - Feminino ");
                    sexo[i] = teclado.next();
                }
                System.out.println("Informe seu salário");
                salario[i] = teclado.nextDouble();
            }
            for (int i = 1; i < idade.length; i++) {
                mediaSalario += salario[i] / salario.length;

                if (idade[i] == 0) {
                    break;
                }
                if (idade[i] > maiorIdade) {
                    maiorIdade = idade[i];
                }
                if (idade[i] < menorIdade) {
                    menorIdade = idade[i];
                }
                if (salario[i] <= 200) {
                    System.out.println("Idade " + idade[i] + " da " + i + "° pessoa e seu sexo " + sexo[i]);
                }
            }
            System.out.println("Média dos salários do grupo: " + (decimal.format(mediaSalario)));
            System.out.println("Quantidade de mulheres com salário até R$ 200,00 = " + qtdFeminino);
            System.out.println("Menor idade do grupo: " + menorIdade);
            System.out.println("Maior idade do grupo: " + maiorIdade);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
