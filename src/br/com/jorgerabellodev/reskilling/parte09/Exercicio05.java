package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa que altere o cadastro de clientes do Exercício 1. O usuário deve informar o código do
 * cliente que será alterado.
 */
public class Exercicio05 {

    public static void main(String[] args) throws IOException {

        ArquivoCliente arquivoCliente = new ArquivoCliente();

        arquivoCliente.alterarCadastroCliente();

    }

}
