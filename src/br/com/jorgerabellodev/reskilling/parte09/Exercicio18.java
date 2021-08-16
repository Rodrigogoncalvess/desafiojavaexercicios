package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para aumentar os preços de todos os produtos em 15%.
 */
public class Exercicio18 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.aumentarPrecoEmQuinzePorcento();
    }
}
