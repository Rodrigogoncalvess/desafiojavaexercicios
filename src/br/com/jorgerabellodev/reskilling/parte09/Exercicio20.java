package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para consultar todos os produtos cujos nomes comecem pela letra M.
 */
public class Exercicio20 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.buscarProdutoPorLetra();
    }
}
