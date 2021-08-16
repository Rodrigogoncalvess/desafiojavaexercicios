package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que mostre todos os recebimentos com data de vencimento dentro de um período qual-
 * quer. Não se esqueça de mostrar também o nome do cliente e o total de dias em atraso. Quando não houver
 * atraso, mostrar zero.
 */
public class Exercicio07 {
    public static void main(String[] args) throws IOException {

        ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();

        arquivoRecebimento.buscarDataVencimento();

    }
}
