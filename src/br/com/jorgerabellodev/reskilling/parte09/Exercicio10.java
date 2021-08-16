package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que mostre todos os recebimentos com valor abaixo de um valor dado pelo usuário.
 */
public class Exercicio10 {
    public static void main(String[] args) throws IOException {

        ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();

        arquivoRecebimento.buscarValorAbaixo();
    }
}
