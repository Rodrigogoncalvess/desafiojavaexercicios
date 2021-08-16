package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para aumentar os preços dos produtos em R$ 10,00, mas apenas daqueles que já custam mais de R$ 100,00.
 */
public class Exercicio19 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.aumentarPrecoEmDezReais();
    }
}
