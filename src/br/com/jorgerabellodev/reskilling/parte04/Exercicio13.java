package br.com.jorgerabellodev.reskilling.parte04;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o nome e a nota de oito alunos e mostre o relatório a seguir:
 * Digite o nome do 1 o aluno: Carlos
 * Digite a nota do Carlos: 8
 * Digite o nome do 2 o aluno: Pedro
 * Digite a nota do Pedro: 5
 * Relatórios de notas
 * Carlos 8.0
 * Pedro 5.0
 * ..
 * ..
 * ..
 * Média da classe = ??
 */
public class Exercicio13 {
    public static void main(String[] args) {

        var nomeAluno = new String[9];
        var nota = new double[9];
        var somatorioDasNotas = 0.0;
        var mediaClasse = 0.0;
        var relatorioDaClasse = new String[9];
        var decimal = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 1; i < nomeAluno.length; i++) {
                System.out.println("Digite o nome do " + i + "° aluno: ");
                nomeAluno[i] = scanner.next();

                System.out.println("Digite a nota do " + nomeAluno[i] + " : ");
                nota[i] = scanner.nextFloat();
            }
            for (int i = 1; i < nomeAluno.length; i++) {
                relatorioDaClasse[i] = nomeAluno[i];
                System.out.println(relatorioDaClasse[i] + " " + (decimal.format(nota[i])));
            }
            for (int i = 1; i < nomeAluno.length; i++) {
                somatorioDasNotas += nota[i];
            }
            mediaClasse = (somatorioDasNotas / 2);
            System.out.printf("Média da classe é :%.2f", mediaClasse);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
