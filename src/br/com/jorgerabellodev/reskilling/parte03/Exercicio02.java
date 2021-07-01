package br.com.jorgerabellodev.reskilling.parte03;

/**
 * Uma companhia de teatro deseja montar uma série de espetáculos. A direção calcula que, a
 * R$ 5,00 o ingresso, serão vendidos 120 ingressos, e que as despesas serão de R$ 200,00. Diminuindo-se em
 * R$ 0,50 o preço dos ingressos, espera-se que as vendas aumentem em 26 ingressos. Faça um programa que
 * escreva uma tabela de valores de lucros esperados em função do preço do ingresso, fazendo-se variar esse pre-
 * ço de R$ 5,00 a R$ 1,00, de R$ 0,50 em R$ 0,50. Escreva, ainda, para cada novo preço de ingresso, o lucro
 * máximo esperado, o preço do ingresso e a quantidade de ingressos vendidos para a obtenção desse lucro.
 */
public class Exercicio02 {
    public static void main(String[] args) {

        var valorIngreso = 5.0;
        var valorDespesa = 200.0;
        var qtdIngresso = 120;
        var aumentoQtdIngresso = 26;
        var descontoValorIngresso = 0.5;
        var valorAtual = valorIngreso;

        while (valorAtual >= 1 && valorAtual <= 5) {
            System.out.println("\nLucro esperado a cada R$ 0,50 de desconto: " + ((valorAtual * qtdIngresso) - valorDespesa));
            valorAtual -= descontoValorIngresso;
            System.out.println("Quantidade de infgresso vendido: "+( qtdIngresso += aumentoQtdIngresso));

        }
    }
}
