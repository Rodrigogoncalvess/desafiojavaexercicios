package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com os nomes de sete alunos e carregue outro vetor com a média
 * final desses alunos. Calcule e mostre:
 * ■ ■ o nome do aluno com maior média (desconsiderar empates);
 * ■ ■ para cada aluno não aprovado, isto é, com média menor que 7, mostrar quanto esse aluno precisa tirar
 * na prova de exame final para ser aprovado. Considerar que a média para aprovação no exame é 5.
 */
public class Exercicio08 {
    public static void main(String[] args) {

        var aluno = new String[3];
        var media = new double[3];
        var maior = 0.0;
        var mediaAluno = 0.0;
        var indiceMaior = 0;
        var indiceMenor = 0;


        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < aluno.length; i++) {
                System.out.println("Informe o nome do aluno: ");
                aluno[i] = scanner.next();

                System.out.println("Informe a média final do aluno: ");
                media[i] = scanner.nextFloat();

            }
            for (int i = 0; i < aluno.length; i++) {
                mediaAluno = media[i];
                if (mediaAluno > maior) {
                    maior = mediaAluno;
                    indiceMaior = i;

                }if (mediaAluno < 7) {
                        indiceMenor = i;
                    System.out.println("Aluno não aprovado " + aluno[indiceMenor] + ", média para aprovação no exame final é 5");
                }
            }
            System.out.println(aluno[indiceMaior] + " teve a maior média: " + maior);
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}

