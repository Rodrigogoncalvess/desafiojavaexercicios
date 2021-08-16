package br.com.jorgerabellodev.reskilling.parte09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Faça um programa para criar os arquivos a seguir:
 * ■ ■ Estilista (código do estilista, nome do estilista, salário).
 * ■ ■ Roupa (código da roupa, descrição da roupa, código do estilista, código da estação, ano).
 * ■ ■ Estação (código da estação, nome da estação).
 */
public class Exercicio12 {


    public static final String caminhoArquivos = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\";

    static ArquivoEstacao arquivoEstacao = new ArquivoEstacao();

    public static void main(String[] args) throws IOException {
        int opcao;
        int opcaoNova = 0;

        Scanner ler = new Scanner(System.in);

        while (true) {

            System.out.println("1 - Criar arquivo ESTILISTA");
            System.out.println("2 - Criar arquivo ROUPA");
            System.out.println("3 - Criar arquivo ESTACAO");
            opcao = ler.nextInt();


            switch (opcao) {

                case 1:
                    criarArquivo("ESTILISTA", opcao);
                    break;

                case 2:
                    criarArquivo("ROUPA", opcao);
                    break;

                case 3:
                    criarArquivo("ESTACAO", opcao);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            while (opcaoNova != 2) {
                System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                opcaoNova = ler.nextInt();

                if (opcaoNova == 1) {

                    break;
                } else if (opcaoNova == 2) {
                    System.out.println("Obrigado por usar o programa!");

                    return;
                } else {
                    System.out.println("Opção inválida");
                }
                break;
            }
        }
    }

    static void criarArquivo(String nomeArquivo, int opcao) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminhoArquivos + nomeArquivo));

        if (opcao == 1) {
            buffWrite.append("CódigoDoEstilista" + arquivoEstacao.delimitador + "NomeDoEstilista" + arquivoEstacao.delimitador + "Salário\n");

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivos);
            buffWrite.close();
            return;
        } else if (opcao == 2) {
            buffWrite.append("CódigoDaRoupa" + arquivoEstacao.delimitador + "DescriçãoDaRoupa" + arquivoEstacao.delimitador + "código do estilista" + arquivoEstacao.delimitador + "Código da estação" + arquivoEstacao.delimitador + "Ano\n");

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivos);
            buffWrite.close();
            return;
        } else if (opcao == 3) {

            buffWrite.append("CódigoDaEstação" + arquivoEstacao.delimitador + "NomeDaEstação\n");

            buffWrite.close();

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivos);
            return;
        } else {
            System.out.println("Aconteceu um erro, arquivo nào foi criado..");
        }
    }
}


