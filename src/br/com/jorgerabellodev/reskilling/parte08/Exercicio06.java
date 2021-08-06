package br.com.jorgerabellodev.reskilling.parte08;

import java.util.Scanner;

/**
 * Leia as informações a seguir:
 * ------------------------------------------------------------
 * CLIENTE                  CONTA BANCÁRIA
 * ------------------------------------------------------------
 * Número do cliente        Número da conta
 * Nome                     Número do cliente
 * Telefone                 Saldo
 * Endereço
 * ------------------------------------------------------------
 * Crie um programa que faça o cadastramento de contas, verificando se o número do cliente titular da
 * conta já foi previamente cadastrado. Se existir, deverá permitir a inclusão. Caso contrário, deverá mostrar a
 * mensagem Cliente não cadastrado e abrir uma tela que permita o cadastramento. O programa deverá mostrar, ao final, todas as contas cadastradas.
 */
public class Exercicio06 {

    static int[] numeroDoCliente = new int[2];
    static int[] numeroDaConta = new int[numeroDoCliente.length];
    static String[] nome = new String[numeroDoCliente.length];
    static long[] telefone = new long[numeroDoCliente.length];

    public static void main(String[] args) {


        int cadastroCliente;


        String[] endereco = new String[numeroDoCliente.length];

        int validarConta;
        int validarCadastro;
        int validarCliente;
        boolean existente;
        boolean existeConta;
        boolean existeCliente;
        boolean existeCadastro;
        String inserirNome;
        boolean existeNome;
        long inserirTelefone;
        boolean validarTelefone;
        double saldo;

        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < numeroDaConta.length; i++) {

            System.out.println("Cadastrar o número do cliente:");
            cadastroCliente = scanner.nextInt();

            existente = validarNumeroConta(cadastroCliente);

            while (existente) {
                System.out.println("Cadastro do cliente já existe, digite novamente número do cliente!");
                cadastroCliente = scanner.nextInt();
                existente = validarNumeroConta(cadastroCliente);

            }
            numeroDoCliente[i] = cadastroCliente;
        }

        for (int i = 0; i < numeroDaConta.length; i++) {

            System.out.println("Cadastramento de conta");
            validarConta = scanner.nextInt();

            existeConta = preCadastro(validarConta);
            existeCadastro = validarCadastro(validarConta);
            existeCliente = existeCadastro(validarConta);

            while (existeCliente) {
                System.out.println("Conta já foi cadastrada, digite uma outra conta válida: ");
                validarCliente = scanner.nextInt();
                existeCliente = existeCadastro(validarCliente);
            }

            while (existeCadastro) {
                System.out.println("Conta já cadastrada, digite uma conta para realizado o cadastro: ");
                validarCadastro = scanner.nextInt();
                existeCadastro = validarCadastro(validarCadastro);
            }

            while (existeConta) {
                System.out.println("Conta ainda não foi cadastrada, digite uma conta válida: ");
                cadastroCliente = scanner.nextInt();
                existeConta = preCadastro(cadastroCliente);

            }


            numeroDaConta[i] = validarConta;

            System.out.println("Informe nome: ");
            inserirNome = scanner.next();
            existeNome = nomeExiste(inserirNome);

            while (existeNome) {
                System.out.println("Nome do cliente já cadastrado, digite outro nome para conta desejada:");
                inserirNome = scanner.next();
                existeNome = nomeExiste(inserirNome);
            }
            nome[i] = inserirNome;

            System.out.println("Informe seu telefone:");
            inserirTelefone = scanner.nextLong();
            validarTelefone = validarNumeroTelefone(inserirTelefone);

            while (!validarTelefone) {
                System.out.println("Número de telefone precisa conter 11 digito, sendo DDD + número:");
                inserirTelefone = scanner.nextLong();
                validarTelefone = validarNumeroTelefone(inserirTelefone);
            }
            telefone[i] = inserirTelefone;

            System.out.println("Informe seu endereço:");
            endereco[i] = scanner.next();
        }
        for (int i = 0; i < numeroDaConta.length; i++) {

            System.out.println("\nNumero da conta: " + numeroDaConta[i]);
            System.out.println("Nome do cliente: " + nome[i]);
            System.out.println("Telefone de contato: " + telefone[i]);
            System.out.println("Endereço do cliente: " + endereco[i]);
        }
    }

    public static boolean validarNumeroConta(int numeroDigitado) {
        for (int i = 0; i < numeroDoCliente.length; i++) {
            if (numeroDigitado == numeroDoCliente[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean preCadastro(int cadastroConta) {
        for (int i = 0; i < numeroDoCliente.length; i++) {
            if (cadastroConta == numeroDoCliente[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarCadastro(int cadastroContaValida) {
        for (int i = 0; i < numeroDoCliente.length; i++) {
            if (cadastroContaValida == numeroDaConta[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeCadastro(int clienteExiste) {
        for (int i = 0; i < numeroDoCliente.length; i++) {
            if (clienteExiste == numeroDaConta[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean nomeExiste(String nomeCliente) {
        for (int i = 0; i < numeroDoCliente.length; i++) {
            if (nomeCliente.equalsIgnoreCase(nome[i])) {
                return true;
            }

        }
        return false;
    }

    public static boolean validarNumeroTelefone(long numero) {
        String numeroTeporario = Long.toString(numero);

        if (numeroTeporario.length() == 11) {
            return true;
        } else {
            return false;
        }
    }

}




