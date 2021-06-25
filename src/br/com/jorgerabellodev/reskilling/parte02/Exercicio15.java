package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma agência bancária possui dois tipos de investimentos, conforme o quadro a seguir. Faça um pro-
 * grama que receba o tipo de investimento e seu valor, calcule e mostre o valor corrigido após um mês de
 * investimento, de acordo com o tipo de investimento.
 * ------------------------------------------------------------
 * TIPO         DESCRIÇÃO                   RENDIMENTO MENSAL
 * ------------------------------------------------------------
 * 1            Poupança                        3%
 * 2            Fundos de renda fixa            4%
 * ------------------------------------------------------------
 */
public class Exercicio15 {
    public static void main(String[] args) {

        double valor;

        Scanner scanner = new Scanner(System.in);

        int investimento = 0;
        try {

            while (investimento != 3 && investimento >= 0) {
                System.out.println("\nDigite a opção desejada para realizar seu investimento:\n\n" + "Opção 1 Poupança " + "\n"
                        + "Opção 2 Fundos de renda fixa" + "\nOpção 0 Sair");
                investimento = scanner.nextInt();


                switch (investimento) {

                    case 1:
                        System.out.println("Digite o valor para saber o rendimento mensal: ");
                        valor = scanner.nextDouble();
                        valor *= 0.03;
                        System.out.println("Rendimento mensal é: " + valor);
                        break;

                    case 2:
                        System.out.println("Digite o valor para saber o rendimento mensal: ");
                        valor = scanner.nextDouble();
                        valor *= 0.04;
                        System.out.println("Rendimento mensal é: " + valor);
                        break;
                    case 0:
                        System.out.println("\n" + "Finalizado");
                        return;

                    default:
                        System.out.println("\nOpção inválida\n");
                        break;
                }
            }

        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo. ");
        }
    }
}
