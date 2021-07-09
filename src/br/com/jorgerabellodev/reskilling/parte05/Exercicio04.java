package br.com.jorgerabellodev.reskilling.parte05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que receba:
 * ■ ■ as notas de 15 alunos em cinco provas diferentes e armazene-as em uma matriz 15 x 5;
 * ■ ■ os nomes dos 15 alunos e armazene-os em um vetor de 15 posições.
 * O programa deverá calcular e mostrar:
 * ■ ■ para cada aluno, o nome, a média aritmética das cinco provas e a situação (aprovado, reprovado ou exame);
 * ■ ■ a média da classe.
 */
public class Exercicio04 {
    public static void main(String[] args) {

        var nome = new String[15];
        var prova = new double[nome.length][5];
        var soma = 0.0;
        var media = 0.0;
        var mediaClasse = 0.0;
        var qtdProva = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < nome.length; i++) {
                System.out.println("Informe o nome do aluno: ");
                nome[i] = scanner.next();
                for (int j = 0; j < prova[i].length; j++) {
                    System.out.println("Informe a " + (j + 1) + "° nota do aluno:");
                    prova[i][j] = scanner.nextDouble();
                }
            }

            for (int i = 0; i < prova.length; i++) {
                soma = 0;
                qtdProva = 0;
                for (int j = 0; j < prova[i].length; j++) {
                    soma += prova[i][j];
                    qtdProva++;
                }
                media = soma / qtdProva;

                System.out.println("\nSoma das notas dos aluno " + nome[i] + " : " + soma);
                System.out.println("Média do aluno " + nome[i] + " é: " + media);
                if (media < 7) {
                    System.out.println("Aluno " + nome[i] + " Reprovado");

                } else if ((media > 5) && (media < 7)) {
                    System.out.println("Aluno " + nome[i] + " Exame");

                } else {
                    System.out.println("Aluno " + nome[i] + " Aprovado");
                }
                mediaClasse += soma / prova.length / qtdProva;
            }

            System.out.println("A média da classe da é: " + mediaClasse);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

