package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Random;
import java.util.Scanner;

/**
 * Elabore um programa que: receba a idade de oito alunos e armazene-as em um vetor; armazene o código
 * de cinco disciplinas em outro vetor;
 * <p>
 * armazene em uma matriz a quantidade de provas que cada aluno fez
 * em cada disciplina.
 */
public class Exercicio11 {
    public static void main(String[] args) {


        var idadeAluno = new int[8];
        var codigoDisciplina = new int[]{111, 222, 333, 444, 555};
        var qtdProva = new int[]{1, 2, 3, 4, 5};
        var prova = 0;
        var codigo = 0;
        var matriz = new int[8][2];

        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();

        for (int i = 0; i < idadeAluno.length ; i++) {
            System.out.println("Informe a idade do aluno: ");
            idadeAluno[i]= scanner.nextInt();

        }

        for (int i = 0; i < idadeAluno.length; i++) {
            codigo = gerador.nextInt(5);
            matriz[i][0] = codigoDisciplina[codigo];

            System.out.println("\nAluno com idade " + idadeAluno[i] + " anos na disciplina: " + matriz[i][0]);


            for (int j = 1; j < matriz[i].length; j++) {
                prova = gerador.nextInt(5);
                matriz[i][j] = qtdProva[prova];

                System.out.println("Total de prova que foi realizada: " + matriz[i][j]);
            }
        }

    }
}
