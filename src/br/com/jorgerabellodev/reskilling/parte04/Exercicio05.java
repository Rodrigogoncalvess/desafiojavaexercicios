package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma escola deseja saber se existem alunos cursando, simultaneamente, as disciplinas Lógica e Linguagem de
 * Programação. Coloque os números das matrículas dos alunos que cursam Lógica em um vetor, quinze alunos.
 * Coloque os números das matrículas dos alunos que cursam Linguagem de Programação em outro vetor, dez
 * alunos. Mostre o número das matrículas que aparecem nos dois vetores.
 */
public class Exercicio05 {
    public static void main(String[] args) {

        var alunoLogica = new int[15];

        var alunoProgramacao = new int[10];

        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < alunoLogica.length; i++) {
                System.out.println("Informe a matricula do aluno cursando lógica: ");
                alunoLogica[i] = scanner.nextInt();
            }
            for (int j = 0; j < alunoProgramacao.length; j++) {
                System.out.println("Informe a matricula do aluno cursando programação: ");
                alunoProgramacao[j] = scanner.nextInt();
            }
            for (int i = 0; i < alunoLogica.length; i++) {
                for (int j = 0; j < alunoProgramacao.length; j++) {

                    if (alunoLogica[i] == alunoProgramacao[j]) {
                        System.out.println("Número das matrículas que aparecem nos dois vetores, disciplinas Lógica " + alunoLogica[i] + " disciplinas Linguagem de Programação " + alunoProgramacao[j]);
                    }
                }
            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}


