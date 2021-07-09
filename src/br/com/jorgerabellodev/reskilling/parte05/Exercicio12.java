package br.com.jorgerabellodev.reskilling.parte05;

import java.util.Scanner;

/**
 * O programa deverá calcular e mostrar:
 * ■ ■ a quantidade de alunos com idade entre 18 e 25 anos que fizeram mais de duas provas em determinada
 * disciplina cujo código é digitado pelo usuário. O usuário poderá digitar um código não cadastrado; nesse caso,
 * o programa deverá mostrar uma mensagem de erro;
 * <p>
 * ■ ■ uma listagem contendo o código dos alunos que fizeram menos que três provas em determinada disciplina,
 * seguido do código da disciplina;
 * <p>
 * ■ ■ a média de idade dos alunos que não fizeram nenhuma prova em alguma disciplina. Cuidado para não contar duas vezes o mesmo aluno.
 */
public class Exercicio12 {
    public static void main(String[] args) {

        int[] idadeAluno = new int[]{19, 18, 24, 25};
        int[] codigoAluno = new int[]{11, 22, 33, 44};
        int[] codigoDisciplina = new int[]{123, 234, 345, 345};
        int qtdAluno = 0;
        int[] qtdProva = new int[]{5, 0, 3, 5};
        int mediaIdadeAluno = 0;
        int qtdProvaNaoFeita = 0;
        int totalIdadeAluno = 0;
        int consultarDisciplina;
        boolean existeDisciplina = false;

        Scanner scanner = new Scanner((System.in));


        System.out.println("Digite o código da disciplina que deseja obter informações: ");
        consultarDisciplina = scanner.nextInt();

        for (int i = 0; i < codigoDisciplina.length; i++) {
            if (codigoDisciplina[i] == consultarDisciplina) {
                existeDisciplina = true;

            }
        }

        while (existeDisciplina == false) {

            System.out.println("Código inválido, digite novamente.");
            consultarDisciplina = scanner.nextInt();

            for (int i = 0; i < codigoDisciplina.length; i++) {
                if (codigoDisciplina[i] == consultarDisciplina) {
                    existeDisciplina = true;
                }
            }
        }
        for (int i = 0; i < codigoDisciplina.length; i++) {
            if ((consultarDisciplina == codigoDisciplina[i]) && (idadeAluno[i] >= 18 && idadeAluno[i] <= 25) && (qtdProva[i] >= 2)) {
                qtdAluno++;
            }
        }
        System.out.println("Disciplina consultada: " + consultarDisciplina);
        System.out.println("Quantidade de alunos com idade entre 18 e 25 anos que fizeram mais de duas provas: " + qtdAluno + "\n");


        for (int i = 0; i < idadeAluno.length; i++) {
            if (qtdProva[i] < 3) {
                System.out.println("Código dos alunos que fizeram menos que 3 provas: " + codigoAluno[i]);
                System.out.println("Código da disciplina: " + codigoDisciplina[i] + "\n");
            }
            if (qtdProva[i] == 0) {
                qtdProvaNaoFeita++;
                totalIdadeAluno += idadeAluno[i];
                mediaIdadeAluno = totalIdadeAluno / qtdProvaNaoFeita;
            }
        }
        System.out.println("Media das idades dos alunos que não fizeram prova: " + mediaIdadeAluno);
        System.out.println("Quantidade de alunos que não fizeram prova: " + qtdProvaNaoFeita);
    }
}

