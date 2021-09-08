package br.com.jorgerabellodev.reskilling.parte10.exercicio02;

import java.util.Scanner;

/**
 * Defina uma classe PESSOA com os seguintes atributos: nome e idade. Essa classe deve ter, também, um méto-
 * do para calcular a idade em meses. Carregue os atributos anteriores de uma pessoa, calcule e mostre:
 * a) a idade da pessoa em meses;
 * b) a idade que a pessoa terá em 2050 (outro método).
 */
public class Exercicio02 {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.println("Informe seu nome:");
        pessoa.nome = ler.next().concat(ler.nextLine());

        System.out.println("Informe a data de nascimento para obter o total de meses até a presenta data:");
        pessoa.idade = ler.next();


        pessoa.calcularIdadeEmMeses(pessoa.idade);

        pessoa.calcularAnoEmMeses(pessoa.idade);
    }


}