package br.com.jorgerabellodev.reskilling.parte06;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Crie um programa que receba o número dos 10 alunos de uma sala, armazenando-os em um vetor, junto
 * com as notas obtidas ao longo do semestre (foram realizadas quatro avaliações). Elabore sub-rotinas para:
 * ■ ■ determinar e mostrar a média aritmética de todos os alunos;
 * ■ ■ indicar os números dos alunos que deverão fazer recuperação, ou seja, aqueles com média inferior a 6.
 * OBS: Todas as mensagens deverão ser mostradas no programa principal.
 */
public class Exercicio25 {

    static double[] aluno = new double[10];

    public static void main(String[] args) {

        SubRotina subRotina = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < aluno.length; i++) {
            System.out.println((i + 1) + "° Aluno, digite o somatório das suas 4 avaliações:");
            aluno[i] = scanner.nextDouble();

            while (aluno[i] > 40) {
                System.out.println("O somatório não pode ultrapassar o valor de 40, digite novamente o valor. ");
                aluno[i] = scanner.nextDouble();
            }
        }
        subRotina.mediaAritmetica();

    }

    static class SubRotina {
        public void mediaAritmetica() {

            DecimalFormat decimalFormat = new DecimalFormat("0.00");

            double soma = 0;
            double media = 0.0;
            double notaAluno;
            int numeroAluno = 0;

            for (double num : aluno) {

                soma += num;
                media = soma / aluno.length;
            }
            System.out.println("\nMédia aritmética de todos os alunos " + decimalFormat.format(media));

            for (int i = 0; i < aluno.length; i++) {

                notaAluno = aluno[i];
                notaAluno /= 4;
                if (notaAluno < 6) {
                    numeroAluno++;
                }
            }
            System.out.println("\nQuantidade de alunos que deverão fazer recuperação: " + numeroAluno);

        }
    }
}
