package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para consultar todos os produtos com nomes iniciados por uma letra digitada pelo
 * usuário e com preços entre dois valores também fornecidos pelo usuário.
 */
public class Exercicio23 {
    public static void main(String[] args) throws IOException {

        ArquivoProdutos arquivoProdutos = new ArquivoProdutos();

        arquivoProdutos.todasProdutosTempararios();

        arquivoProdutos.buscarProdutoPorLetraDigitada();


    }


}
