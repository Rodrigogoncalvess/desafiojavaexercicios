package br.com.jorgerabellodev.reskilling.parte09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Faça um programa para criar um arquivo chamado PRODUTOS.DAT , em que cada registro será composto
 * pelos seguintes campos: codigo , descricao e preco .
 */
public class Exercicio15 {

    public static final String delimitador = ",";
    public static final String caminhoArquivo = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\";


    public static void main(String[] args) throws IOException {
        int opcao;
        int opcaoNova = 0;

        Scanner ler = new Scanner(System.in);

        while (true) {

            System.out.println("Escolha uma opção: \n1 - Criar arquivo PRODUTOS;\n2 - Finalizar o programa.");


            opcao = ler.nextInt();


            switch (opcao) {

                case 1:
                    criarArquivo("PRODUTOS.DAT", opcao);
                    break;
                case 2:
                    System.out.println("Programa finalizado!");
                    return;


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

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminhoArquivo + nomeArquivo));

        if (opcao == 1) {
            buffWrite.append("Código" + delimitador + "Descrição" + delimitador + "Preço\n");

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivo);
            buffWrite.close();
            return;
        } else {
            System.out.println("Aconteceu um erro, arquivo nào foi criado..");
        }
    }


}
