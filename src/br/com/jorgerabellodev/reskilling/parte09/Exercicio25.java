package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para conceder um percentual de desconto, informado pelo usuário, aos produtos cujos preços estejam entre dois valores, também informados pelo usuário.
 */
public class Exercicio25 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();


        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.percentualDesconto();
    }
}
