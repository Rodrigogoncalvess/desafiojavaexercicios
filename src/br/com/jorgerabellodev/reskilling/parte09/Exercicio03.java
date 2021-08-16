package br.com.jorgerabellodev.reskilling.parte09;


import java.io.IOException;

/**
 * Faça um programa que inclua recebimentos no arquivo criado no Exercício 1, devendo verificar se o cliente
 * já se encontra cadastrado.
 */
public class Exercicio03 {
    public static void main(String[] args) throws IOException {


        ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();

        arquivoRecebimento.cadastrarRecebimentos();
    }
}


