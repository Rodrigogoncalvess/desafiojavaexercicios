package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que altere um recebimento de um cliente, ou seja, o usuário informa o número do docu-
 * mento e o número do cliente e faz as alterações desejadas.
 */
public class Exercicio06 {
    public static void main(String[] args) throws IOException {

        ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();

        arquivoRecebimento.alterarRecebimentoDoCliente();

    }
}
