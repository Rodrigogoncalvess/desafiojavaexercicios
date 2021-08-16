package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para consultar os produtos com preços inferiores a R$ 15,00.
 */
public class Exercicio22 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.consultarProdutoPrecoMenorQuinze();

    }

}
