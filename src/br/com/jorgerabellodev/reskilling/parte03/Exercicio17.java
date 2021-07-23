package br.com.jorgerabellodev.reskilling.parte03;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Foi feita uma pesquisa sobre a audiência de canal de TV em várias casas de uma cidade, em determinado
 * dia. Para cada casa consultada foi fornecido o número do canal (4, 5, 7, 12) e o número de pessoas que
 * estavam assistindo àquele canal. Se a televisão estivesse desligada, nada era anotado, ou seja, essa casa
 * não entrava na pesquisa. Faça um programa que:
 * ■ ■ leia um número indeterminado de dados (número do canal e número de pessoas que estavam assistindo); e
 * ■ ■ calcule e mostre a porcentagem de audiência de cada canal.
 * Para encerrar a entrada de dados, digite o número do canal ZERO.
 */
public class Exercicio17 {
    public static void main(String[] args) {

        int canal = 0;
        int pessoa = 0;
        int canal4 = 0;
        int canal5 = 0;
        int canal7 = 0;
        int canal12 = 0;
        double audiencia4;
        double audiencia5;
        double audiencia7;
        double audiencia12;
        double totalPessoas;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Escolha uma opção do programa:\n0 - Encerrar o programa \n1 - Iníciar pesquisa");
            canal = teclado.nextInt();

            if (canal > 1) {

                System.out.println("\nOpção inválida, escolha uma das opções abaixo:\n0 - Encerrar o programa \n1 - Iníciar pesquisa");
                canal = teclado.nextInt();
            }

            while (canal != 0) {
                System.out.println("\nEscolha uma opção:\n0 - Finalizar o programa;\n1 - Obter o percentual de audiência de cada canal;\nDigite o canal para seguir com a pesquisa:");
                canal = teclado.nextInt();


                if ((canal == 4)) {
                    System.out.println("Informe a quantidade de pessoas assistindo o canal digitado");
                    pessoa = teclado.nextInt();
                    canal4 += pessoa;


                } else if ((canal == 5)) {
                    System.out.println("Informe a quantidade de pessoas assistindo o canal digitado");
                    pessoa = teclado.nextInt();
                    canal5 += pessoa;

                } else if ((canal == 7)) {
                    System.out.println("Informe a quantidade de pessoas assistindo o canal digitado");
                    pessoa = teclado.nextInt();
                    canal7 += pessoa;

                } else if ((canal == 12)) {
                    System.out.println("Informe a quantidade de pessoas assistindo o canal digitado");
                    pessoa = teclado.nextInt();
                    canal12 += pessoa;


                } else if (canal == 1) {
                    totalPessoas = (canal4 + canal5 + canal7 + canal12);
                    audiencia4 = ((canal4 / totalPessoas) * 100);
                    audiencia5 = ((canal5 / totalPessoas) * 100);
                    audiencia7 = ((canal7 / totalPessoas) * 100);
                    audiencia12 = ((canal12 / totalPessoas) * 100);

                    System.out.println("\nPorcentagem de audiência do canal 4: " + decimalFormat.format(audiencia4) + "%");
                    System.out.println("Porcentagem de audiência do canal 5: " + decimalFormat.format(audiencia5) + "%");
                    System.out.println("Porcentagem de audiência do canal 7: " + decimalFormat.format(audiencia7) + "%");
                    System.out.println("Porcentagem de audiência do canal 12: " + decimalFormat.format(audiencia12) + "%");

                } else if ((canal >= 2 && canal < 4) || (canal == 6) || (canal >= 8 && canal < 12) || (canal > 12)) {
                    System.out.println("Canal inválido, digite um canal válido!");
                }
            }
            System.out.println("Programa finalizado!");

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Programa não pode ter letra ou simbolo!");
        }
    }
}
