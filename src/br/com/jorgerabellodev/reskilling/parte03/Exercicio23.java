package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que apresente o menu de opções a seguir, que permita ao usuário escolher a opção
 * desejada, receba os dados necessários para executar a operação e mostre o resultado. Verifique a possibi-
 * lidade de opção inválida e não se preocupe com as restrições como salário inválido.
 * Menu de opções:
 * 1. Novo salário
 * 2. Férias
 * 3. Décimo terceiro
 * 4. Sair
 * Digite a opção desejada.
 * Na opção 1: receber o salário de um funcionário, calcular e mostrar o novo salário usando as regras a seguir:
 * ------------------------------------------------------------
 * SALÁRIOS                                   % DE AUMENTO
 * Até R$ 210,00                                15%
 * De R$ 210,00 a R$ 600,00 (inclusive)         10%
 * Acima de R$ 600,00                           5%
 * ------------------------------------------------------------
 */
public class Exercicio23 {
    public static void main(String[] args) {

        var salario = 0.0;
        var novoSalario = 0.0;
        var ferias = 0.0;
        var decimoTerceiro = 0.0;
        var aumento = 0.0;
        var opcao = 0;

        var teclado = new Scanner(System.in);

        try {
            while (opcao != 4) {
                System.out.println("Digite seu salário: ");
                salario = teclado.nextDouble();
                System.out.println("\nEscolha uma das opções para obter o resultado:\n" +
                        "1 - Novo salário;\n" +
                        "2 - Férias;\n" +
                        "3 - Décimo terceiro;\n" +
                        "4 - Sair");

                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        if (salario <= 210) {
                            novoSalario = salario / 100;
                            aumento = (novoSalario * 15) + salario;
                            System.out.println("Valor do novo salário: " + aumento);
                            break;
                        }
                        if (salario >= 211 && salario <= 600) {
                            novoSalario = salario / 100;
                            aumento = (novoSalario * 10) + salario;
                            System.out.println("Valor do novo salário: " + aumento);
                            break;
                        }
                        if (salario > 600) {
                            novoSalario = salario / 100;
                            aumento = (novoSalario * 5) + salario;
                            System.out.println("Valor do novo salário: " + aumento);
                            break;
                        }
                    case 2:
                        if (salario <= 210) {
                            ferias = salario / 100;
                            aumento = (ferias * 15) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                        if (salario >= 211 && salario <= 600) {
                            ferias = salario / 100;
                            aumento = (ferias * 10) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                        if (salario > 600) {
                            ferias = salario / 100;
                            aumento = (ferias * 5) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                    case 3:
                        if (salario <= 210) {
                            decimoTerceiro = salario / 100;
                            aumento = (decimoTerceiro * 15) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                        if (salario >= 211 && salario <= 600) {
                            decimoTerceiro = salario / 100;
                            aumento = (decimoTerceiro * 10) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                        if (salario > 600) {
                            decimoTerceiro = salario / 100;
                            aumento = (decimoTerceiro * 5) + salario;
                            System.out.println("Valor das férias: " + aumento);
                            break;
                        }
                    case 4:
                        System.out.println("Programa finalizado!");
                        break;
                    default:
                        System.out.println("Informe uma opção válida");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
