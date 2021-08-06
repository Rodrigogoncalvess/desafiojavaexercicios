package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Um banco está informatizando seus controles de clientes e contas. Sobre cada cliente dispõe-se dos se-
 * guintes dados: nome, idade, endereço, número de suas contas (15 no máximo) e CPF_CNPJ. As contas
 * válidas têm número diferente de zero. Cada conta possui um só cliente. As informações das contas são as
 * seguintes: número da conta, cliente e saldo atual. (Se existem 12 clientes com quatro contas no máximo,
 * então devem existir 48 contas.)
 * Crie um programa que:
 * a) cadastre os clientes e suas contas;
 * b) mostre todas as contas cadastradas;
 * c) mostre todas as contas de determinado cliente (identificadas pelo código);
 * d) mostre o somatório das contas de determinado cliente;
 * e) mostre todas as contas com saldo negativo;
 * f) mostre o ativo bancário (soma de todos os saldos).
 */
public class Exercicio17 {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {


        int opcaoMenu;
        int opcaoMenuContinuar;

        Clientes clientes = new Clientes();
        Contas contas = new Contas();

        while (true) {


            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar  clientes;\n2 - Cadastrar contas;  \n3 - Todas as contas cadastradas;" +
                        "\n4 - Todas as contas de determinado cliente;\n5 - Somatório das contas de determinado cliente;\n6 - Todas as contas com saldo negativo;\n7 - Ativo bancário (soma de todos os saldos).");
                opcaoMenu = ler.nextInt();

                if (opcaoMenu <= 7) {

                    switch (opcaoMenu) {

                        case 1:
                            clientes.cadastrarCliente();
                            break;
                        case 2:
                            contas.cadastrarConta();
                            break;
                        case 3:
                            contas.todasContasExistentes();
                            break;
                        case 4:
                            contas.todasContasDeUmCliente();
                            break;
                        case 5:
                            contas.somatorioTotalDasContasDeUmCliente();
                            break;
                        case 6:
                            contas.todasContasNegativas();
                            break;
                        case 7:
                            contas.somatorioTotalDasContas();
                            break;
                    }
                } else {
                    System.out.println("Opção inválida, digite uma opção válida.");
                }

                while (true) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcaoMenuContinuar = ler.nextInt();
                    if (opcaoMenuContinuar == 1) {

                        break;
                    } else if (opcaoMenuContinuar == 2) {
                        System.out.println("Obrigado por usar o programa!");

                        return;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Programa não contém letra ou simbolo.");
                break;
            }
        }

    }

    public static class Clientes {
        String nome;
        int idade;
        String endereco;
        int numeroConta;
        long cpfOuCnpj;


        static ArrayList<Clientes> listaClientes = new ArrayList<>();


        public Clientes(String nome, int idade, String endereco, int numeroConta, long cpfOuCnpj) {
            this.nome = nome;
            this.idade = idade;
            this.endereco = endereco;
            this.numeroConta = numeroConta;
            this.cpfOuCnpj = cpfOuCnpj;
        }

        public Clientes() {

        }

        public void cadastrarCliente() {
            System.out.println("Informe nome do cliente:");
            nome = ler.next().concat(ler.nextLine());
            if (!validarCliente(nome)) {

                System.out.println("Informe a idade:");
                idade = ler.nextInt();

                System.out.println("Informe o endereço:");
                endereco = ler.next().concat(ler.nextLine());


                System.out.println("Informe o CPF ou CNPJ");
                cpfOuCnpj = ler.nextLong();

                Clientes clientes = new Clientes(nome, idade, endereco, numeroConta, cpfOuCnpj);
                listaClientes.add(clientes);
            } else {
                System.out.println("Nome do cliente já se encontra cadastrado no sistema!");
            }

        }

        public boolean validarCliente(String nome) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).nome.equalsIgnoreCase(nome)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static class Contas {
        int numeroConta;
        String cliente;
        double saldo = 0;
        Clientes clientes = new Clientes();

        Random geradorDeConta = new Random();

        static ArrayList<Contas> listaContas = new ArrayList<>();

        public Contas(int numeroConta, String cliente, double saldo) {
            this.numeroConta = numeroConta;
            this.cliente = cliente;
            this.saldo = saldo;

        }

        public Contas() {
        }

        public void cadastrarConta() {

            System.out.println("Informe nome do cliente criar a conta:");
            cliente = ler.next().concat(ler.nextLine());

            if (clientes.validarCliente(cliente)) {

                numeroConta = geradorDeConta.nextInt(1000);

                if (!validarConta(numeroConta)) {

                    if (validarQuantidadeDeConta(cliente)) {
                        System.out.println("Informe o saldo da conta:");
                        saldo = ler.nextDouble();

                        Contas contas = new Contas(numeroConta, cliente, saldo);
                        listaContas.add(contas);
                    } else {
                        System.out.println("Limite máximo de conta por cliente é 4!");
                    }
                } else {
                    System.out.println("Número de conta já existe, não será possível realizar cadastro!");

                }
            } else {
                System.out.println("Cliente ainda não se encontra cadastrado no sistema!");
            }

        }

        public boolean validarConta(int numeroConta) {
            for (int i = 0; i < listaContas.size(); i++) {
                if (listaContas.get(i).numeroConta == numeroConta) {
                    return true;
                }
            }
            return false;
        }

        public boolean validarQuantidadeDeConta(String cliente) {
            int contador = 0;
            int totalDeConta = 0;
            for (int i = 0; i < listaContas.size(); i++) {

                if (listaContas.get(i).cliente.equalsIgnoreCase(cliente)) {
                    contador++;
                }
            }
            totalDeConta += contador;
            if (totalDeConta < 4) {

                return true;

            }
            return false;
        }

        public void todasContasDeUmCliente() {
            String nomeDigitado;
            System.out.println("Informe o nome do cliente para verificar suas contas:");
            nomeDigitado = ler.next().concat(ler.nextLine());

            if (clientes.validarCliente(nomeDigitado)) {

                for (int i = 0; i < listaContas.size(); i++) {
                    if (listaContas.get(i).cliente.equalsIgnoreCase(nomeDigitado)) {
                        System.out.println("N° da conta >>> " + listaContas.get(i).numeroConta);
                        System.out.println("Nome do cliente >>> " + listaContas.get(i).cliente);
                        System.out.println("Saldo da conta >>> " + listaContas.get(i).saldo);
                    }
                }
            } else {
                System.out.println("Não existe conta cadastra no nome digitado!");
            }
        }

        public void todasContasExistentes() {

            for (int i = 0; i < listaContas.size(); i++) {
                System.out.println("N° da conta >>> " + listaContas.get(i).numeroConta);
                System.out.println("Nome do cliente >>> " + listaContas.get(i).cliente);
                System.out.println("Saldo da conta >>> " + listaContas.get(i).saldo);

            }
        }

        public void somatorioTotalDasContasDeUmCliente() {
            String nomeDigitado;
            double soma = 0;
            double somaTotal = 0;

            System.out.println("Informe o nome do cliente para verificar saldo total de suas contas:");
            nomeDigitado = ler.next();

            if (clientes.validarCliente(nomeDigitado)) {

                for (int i = 0; i < listaContas.size(); i++) {
                    if (listaContas.get(i).cliente.equalsIgnoreCase(nomeDigitado)) {
                        soma += listaContas.get(i).saldo;

                    }
                    somaTotal = soma;
                }

                System.out.println("Somatório de todas as contas do cliente que foi pesquisado  >>> " + somaTotal);

            } else {
                System.out.println("Não existe conta cadastra no nome digitado!");
            }
        }

        public void todasContasNegativas() {


            if (validarContasNegativas()) {
                for (int i = 0; i < listaContas.size(); i++) {
                    if (listaContas.get(i).saldo < 0) {
                        System.out.println("N° da conta >>> " + listaContas.get(i).numeroConta);
                        System.out.println("Nome do cliente >>> " + listaContas.get(i).cliente);
                        System.out.println("Saldo da conta >>> " + listaContas.get(i).saldo);
                    }
                }
            } else {
                System.out.println("Não existe nenhuma conta negativa no momento da pesquisa!");
            }

        }

        public boolean validarContasNegativas() {
            for (int i = 0; i < listaContas.size(); i++) {
                if (listaContas.get(i).saldo < 0) {

                    return true;
                }
            }
            return false;
        }

        public void somatorioTotalDasContas() {
            double soma = 0;
            double somaTotal = 0;


            for (int i = 0; i < listaContas.size(); i++) {
                if (listaContas.get(i).saldo >= 0) {
                    soma = listaContas.get(i).saldo;
                    somaTotal += soma;
                }
            }

            System.out.println("Somatório de todas as contas existentes  >>> " + somaTotal);
        }
    }


}


