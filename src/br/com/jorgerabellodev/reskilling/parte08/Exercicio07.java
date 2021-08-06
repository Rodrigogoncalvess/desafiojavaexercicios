package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Considere que exista um registro com os seguintes atributos: codigo_cliente e nome_cliente e outro
 * registro com os seguintes atributos: N o _conta , valor_compra , codigo_cliente . Faça um programa
 * que:
 * ■ ■ inclua clientes, não permitindo que dois clientes possuam o mesmo código;
 * ■ ■ inclua contas, verificando se o código do cliente informado já está cadastrado. Caso não esteja, não deverá permitir a inclusão;
 * ■ ■ remova determinado cliente. Antes de executar a remoção, deverá verificar se ele não está vinculado
 * a alguma conta. Se possuir, deverá mostrar a mensagem Exclusão não permitida. Caso contrário, deverá proceder à exclusão.
 */
public class Exercicio07 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {


        int opcaoMenu;
        int opcaoMenuContinuar;

        Clientes clientes = new Clientes();
        Contas contas = new Contas();

        while (true) {


            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar cliente;\n2 - Cadastrar conta;  \n3 - Remover conta;\n4 - Todos clientes cadastrados.");
                opcaoMenu = ler.nextInt();

                if (opcaoMenu <= 4) {

                    switch (opcaoMenu) {

                        case 1:
                            clientes.cadastrarCliente();
                            break;
                        case 2:
                            contas.cadastrarConta();

                            break;
                        case 3:
                            contas.removerCadastroCliente();
                            break;
                        case 4:
                            contas.todoClientesCadastrados();
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

    static class Clientes {
        int codigoCliente;
        String nomeCliente;

        static ArrayList<Clientes> listaClientes = new ArrayList<>();

        public Clientes(int codigoCliente, String nomeCliente) {
            this.codigoCliente = codigoCliente;
            this.nomeCliente = nomeCliente;
        }

        public Clientes() {
        }


        public void cadastrarCliente() {
            System.out.println("Informe um código:");
            codigoCliente = ler.nextInt();

            if (!validarCodigoCliente(codigoCliente)) {


                System.out.println("Informe o nome do cliente:");
                nomeCliente = ler.next().concat(ler.nextLine());
                if (!validarCliente(nomeCliente)) {

                    Clientes clientes = new Clientes(codigoCliente, nomeCliente);
                    listaClientes.add(clientes);
                } else {
                    System.out.println("Nome do cliente já existe em nosso cadastro!");
                }
            } else {
                System.out.println("Código informado já existe cadastrado em nome de outro cliente!");
            }

        }

        public boolean validarCodigoCliente(int codigoCliente) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).codigoCliente == codigoCliente) {
                    return true;
                }
            }
            return false;
        }

        public boolean validarCliente(String nomeCliente) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).nomeCliente.equalsIgnoreCase(nomeCliente)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Contas {
        int numeroConta;
        double valorCompra;
        int codigoCliente;


        Clientes clientes = new Clientes();

        static final AtomicInteger gerenciadorDeConta = new AtomicInteger(0);
        static ArrayList<Contas> listaContas = new ArrayList<>();

        public Contas(int numeroConta, double valorCompra, int codigoCliente) {
            this.numeroConta = numeroConta;
            this.valorCompra = valorCompra;
            this.codigoCliente = codigoCliente;

        }

        public Contas() {
        }

        public void cadastrarConta() {

            System.out.println("Informe o código do cliente:");
            codigoCliente = ler.nextInt();
            if (clientes.validarCodigoCliente(codigoCliente)) {

                numeroConta = gerenciadorDeConta.incrementAndGet();

                System.out.println("Infomre o valor da compra:");
                valorCompra = ler.nextDouble();

                Contas contas = new Contas(numeroConta, valorCompra, codigoCliente);
                listaContas.add(contas);
            } else {
                System.out.println("Código informado não existe no cadastro!");
            }

        }

        public void removerCadastroCliente() {

            System.out.println("Informe o código do cliente:");
            int codigoClienteDigitado = ler.nextInt();

            if (!existeConta(codigoClienteDigitado)) {
                try {
                    for (int i = 0; i < clientes.listaClientes.size(); i++) {

                        if (clientes.listaClientes.get(i).codigoCliente == codigoClienteDigitado) {
                            clientes.listaClientes.remove(i);
                            System.out.println("Cliente removido!");
                        }
                    }

                } catch (RuntimeException runtimeException) {

                }

            } else {
                System.out.println("Exclusão não permitido, cliente possui conta em aberto!");
            }

        }

        public static boolean existeConta(int codigoClienteDigitado) {

            if (!listaContas.isEmpty()) {
                for (int i = 0; i < listaContas.size(); i++) {

                    if (listaContas.get(i).codigoCliente == codigoClienteDigitado) {
                        return true;
                    }
                }
            }
            return false;

        }

        public void todoClientesCadastrados() {
            if (!Clientes.listaClientes.isEmpty()) {
                for (int i = 0; i < Clientes.listaClientes.size(); i++) {
                    System.out.println("Código do cliente: " + Clientes.listaClientes.get(i).codigoCliente);
                    System.out.println("Nome do cliente: " + Clientes.listaClientes.get(i).nomeCliente);
                }
            } else {
                System.out.println("Não existe nenhum cliente cadastrado no sistema!");
            }
        }
    }


}
