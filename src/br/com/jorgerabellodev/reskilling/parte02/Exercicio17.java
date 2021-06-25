package br.com.jorgerabellodev.reskilling.parte02;

import java.util.Scanner;

/**
 * Faça um programa que verifique a validade de uma senha fornecida pelo usuário. A senha é 4531. O
 * programa deve mostrar uma mensagem de permissão de acesso ou não.
 */
public class Exercicio17 {
    public static void main(String[] args) {


        final String senha = "4531";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigite senha");
            String senhaDigitada = scanner.nextLine();
            if (senha.equals(senhaDigitada)) {
                System.out.println("ACESSO CONCEDIDO");
                break;
            }
            System.out.println("ACESSO NEGADO");
        }

    }
}

