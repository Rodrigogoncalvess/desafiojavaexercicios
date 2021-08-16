package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;
import java.util.Scanner;

/**
 * Faça um programa para criar os arquivos a seguir:
 * ------------------------------------------------------------
 * CLIENTES             RECEBIMENTOS
 * ------------------------------------------------------------
 * codCliente           numDoc
 * nome                 valorDoc
 * endereco             dataEmissao
 * nome                 dataVencimento
 * codCliente
 * ------------------------------------------------------------
 */
public class Exercicio01 {


    public static void main(String[] args) throws IOException {

        ArquivoCliente arquivoCliente = new ArquivoCliente();

        int opcao;


        Scanner ler = new Scanner(System.in);


        System.out.println("1 - Criar arquivo CLIENTES");
        System.out.println("2 - Criar arquivo RECEBIMENTOS");
        opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                arquivoCliente.criarArquivo("CLIENTES", opcao);
                break;

            case 2:
                arquivoCliente.criarArquivo("RECEBIMENTOS", opcao);
                break;

            default:
                System.out.println("Error..");
                break;
        }
        while (opcao != 2) {
            System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
            opcao = ler.nextInt();
            if (opcao == 1) {

                break;
            } else if (opcao == 2) {
                System.out.println("Obrigado por usar o programa!");

                return;
            } else {
                System.out.println("Opção inválida");
            }
        }

    }


}


