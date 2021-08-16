package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que mostre todos os recebimentos com valor entre dois valores dados pelo usuário.
 */
public class Exercicio11 {
    public static void main(String[] args) throws IOException {

        ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();

        arquivoRecebimento.buscarValorEntreDoisValores();
    }
}
