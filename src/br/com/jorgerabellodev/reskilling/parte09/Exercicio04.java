package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que exclua clientes e, consequentemente, todos os seus recebimentos, dos arquivos criados
 * no Exercício 1.
 */
public class Exercicio04 {

    public static void main(String[] args) throws IOException {

        ArquivoCliente arquivoCliente = new ArquivoCliente();

        arquivoCliente.excluirCliente();

    }
}
