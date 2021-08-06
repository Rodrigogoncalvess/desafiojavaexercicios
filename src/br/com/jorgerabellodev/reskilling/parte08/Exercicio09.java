package br.com.jorgerabellodev.reskilling.parte08;

/**
 * Um funcionário recebe um salário fixo mais 6% de comissão sobre suas vendas. Crie um algoritmo que leia
 * o salário do funcionário, o valor total de suas vendas, calcule a comissão e o salário final. O programa deverá
 * mostrar todos os valores calculados.
 */
public class Exercicio09 {
    public static void main(String[] args) {

        double salario = 1000.0;
        double valorDaVenda = 300.0;
        final double comissao = 0.06;
        double comissaoDaVenda;
        double salarioFinal;

        comissaoDaVenda = valorDaVenda * comissao;
        salarioFinal = comissaoDaVenda + salario;

        System.out.println("Funcionário vai receber a quantia de R$ " + comissaoDaVenda + " de comissão referente a suas vendas");
        System.out.println("Salário final a receber é R$ " + salarioFinal);
    }
}
