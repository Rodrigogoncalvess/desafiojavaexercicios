package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba o nome e duas notas de seis alunos e mostre o relatório a seguir. Relatório
 * de notas:
 * ------------------------------------------------------------
 * ALUNO        1 PROVA     2 PROVA     MEDIA       SITUAÇÃO
 * ------------------------------------------------------------
 * Carlos       8           9           8,5         Aprovado
 * Pedro        4           5           4,5         Reprovado
 * ------------------------------------------------------------
 * ■ ■ média da classe = ?
 * ■ ■ percentual de alunos aprovados = ?%
 * ■ ■ percentual de alunos de exame = ?%
 * ■ ■ percentual de alunos reprovados = ?%
 */
public class Exercicio14 {
    public static void main(String[] args) {

        var nomeAluno = new String[6];
        var primeiraNota = new double[6];
        var segundaNota = new double[6];
        var somatorioDasNotas = 0.0;
        var mediaClasse = 0.0;
        var mediaAluno = 0.0;
        var aprovados = 0.0;
        var reprovados = 0.0;
        var percentualDeAprovados = 0.0;
        var percentualDeReprovados = 0.0;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < nomeAluno.length; i++) {
                System.out.println("Digite o nome do aluno: ");
                nomeAluno[i] = scanner.next();

                System.out.println("Digite a 1° nota do " + nomeAluno[i] + " : ");
                primeiraNota[i] = scanner.nextFloat();

                System.out.println("Digite a 2° nota do " + nomeAluno[i] + " : ");
                segundaNota[i] = scanner.nextFloat();
            }
            for (int i = 0; i < nomeAluno.length; i++) {
                somatorioDasNotas = (primeiraNota[i] + segundaNota[i]) / 2;
                if (somatorioDasNotas >= 8.5) {
                    aprovados++;

                    System.out.println(percentualDeAprovados);
                    System.out.println("Aluno " + nomeAluno[i] + " Aprovado!");
                } else {
                    reprovados++;
                    System.out.println("Aluno " + nomeAluno[i] + "  Reprovado!");
                }
            }
            for (int i = 0; i < nomeAluno.length; i++) {
                mediaAluno = (primeiraNota[i] + segundaNota[i]) / 2;
                mediaClasse = mediaAluno / nomeAluno.length;
            }
            percentualDeAprovados = (aprovados / nomeAluno.length) * 100;
            percentualDeReprovados = (reprovados / nomeAluno.length) * 100;

            System.out.printf("média da classe: %.2f", mediaClasse);
            System.out.println("Percentual de alunos aprovados = " + percentualDeAprovados + "%");
            System.out.println("Percentual de alunos de exame =" + percentualDeReprovados + "%");
            System.out.println("Percentual de alunos reprovados = " + percentualDeReprovados + "%");

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
