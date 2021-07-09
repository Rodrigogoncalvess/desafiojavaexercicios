package br.com.jorgerabellodev.reskilling.parte05;

/**
 * O programa deverá calcular e mostrar:
 * ■ ■ a quantidade de alunos com idade entre 18 e 25 anos que fizeram mais de duas provas em determinada
 * disciplina cujo código é digitado pelo usuário. O usuário poderá digitar um código não cadastrado; nesse caso,
 * o programa deverá mostrar uma mensagem de erro;
 * ■ ■ uma listagem contendo o código dos alunos que fizeram menos que três provas em determinada disciplina,
 * seguido do código da disciplina;
 * ■ ■ a média de idade dos alunos que não fizeram nenhuma prova em alguma disciplina. Cuidado para não contar duas vezes o mesmo aluno.
 */
public class Exercicio12 {
    public static void main(String[] args) {


        int[] vetor = {0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 10, 11, 12, 13, 14, 15};
        int cont = 0;
        int matriz[][] = new int[4][4];

        for (int col = 0; col < matriz.length; col++) {
            for (int lin = 0; lin < matriz.length; lin++) {
                matriz[lin][col] = vetor[cont];
                cont++;
            }
        }

        //Exibindo Valores
        for (int col = 0; col < matriz.length; col++) {
            for (int lin = 0; lin < matriz.length; lin++) {
                System.out.print(matriz[lin][col] + "\t");
            }
            System.out.println("");
        }
    }
}
