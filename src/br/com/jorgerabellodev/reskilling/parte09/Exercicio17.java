package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para consultar a descrição de todos os produtos que possuem preço superior a R$ 500,00.
 */
public class Exercicio17 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.buscarProdutoMaiorQueQuinhetos();
    }
}
