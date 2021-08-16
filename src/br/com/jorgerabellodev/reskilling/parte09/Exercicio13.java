package br.com.jorgerabellodev.reskilling.parte09;

import java.io.IOException;

/**
 * Faça um programa para:
 * ■ ■ Cadastrar as estações climáticas, por exemplo, primavera-verão e outono-inverno.
 * ■ ■ Cadastrar os estilistas.
 * ■ ■ Cadastrar as roupas. Lembre-se de que estilista e estação devem ter sido previamente cadastrados.
 * ■ ■ Mostrar um relatório de todas as roupas de determinada estação, informando, inclusive, o nome do estilista que as desenhou.
 */
public class Exercicio13 {
    public static void main(String[] args) throws IOException {

        ArquivoEstacao arquivoEstacao = new ArquivoEstacao();
        ArquivoEstilista arquivoEstilista = new ArquivoEstilista();
        ArquivoRoupa arquivoRoupa = new ArquivoRoupa();

        arquivoEstacao.cadastrarEstacao();

        arquivoEstilista.cadastrarEstilista();

        arquivoRoupa.cadastrarRoupa();

        arquivoRoupa.todasRoupasTempararios();

        arquivoEstilista.todosEstilistasTempararios();

        arquivoRoupa.todasRoupasEstacao();
    }

}
