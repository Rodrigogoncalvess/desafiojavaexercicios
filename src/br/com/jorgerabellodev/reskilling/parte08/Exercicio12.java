package br.com.jorgerabellodev.reskilling.parte08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Observe os registros a seguir:
 * ------------------------------------------------------------
 * CLIENTE              RECEBIMENTOS
 * ------------------------------------------------------------
 * codCliente           numDoc
 * nome                 valorDoc
 * endereco             dataEmissao
 * fone                 dataVencimento
 * codCliente
 * ------------------------------------------------------------
 * Faça um programa que:
 * a) inclua recebimentos (o programa deve verificar se o cliente já se encontra cadastrado);
 * b) altere o cadastro de clientes (o usuário deve informar o código do cliente que será alterado);
 * c) mostre todos os recebimentos com data de vencimento dentro de um período qualquer. Não esqueça de mos-
 * trar também o nome do cliente e o total de dias em atraso (quando não houver atraso, o programa deverá
 * mostrar zero);
 * d) considere que poderão ser cadastrados no máximo três recebimentos para cada cliente.
 */
public class Exercicio12 {

    static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    static ArrayList<Recebimentos> listaDocumento = new ArrayList<Recebimentos>();
    static Scanner teclado = new Scanner(System.in);
    static boolean continuar = true;
    static boolean continuarMenu = true;
    static int opcaoMenu;


    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");

    public static void main(String[] args) {

        int opcaoMenuContinuar;
        Cliente cliente = new Cliente();
        Recebimentos recebimentos = new Recebimentos();


        while (continuar) {
            System.out.println("Informe a opção desejada:\n1 - Cadastra cliente;\n2 - Incluir recebimento;\n3 - Alterar cadastro;\n4 - Bucasr data de vencimento");
            opcaoMenu = teclado.nextInt();

            switch (opcaoMenu) {
                case 1:
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    recebimentos.cadastrarRecibo();
                    break;

                case 3:
                    cliente.alterarCadastro();
                    break;

                case 4:
                    recebimentos.buscarDataVencimento();
                    break;
            }

            while (continuarMenu) {

                System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                opcaoMenuContinuar = teclado.nextInt();


                if (opcaoMenuContinuar == 1) {
                    continuar = true;
                    break;
                } else if (opcaoMenuContinuar == 2) {
                    System.out.println("Obrigado por usar o programa");
                    continuar = false;
                    return;
                } else {
                    System.out.println("Opção inválida");

                }
            }
        }

    }


    static class Cliente {
        int codCliente;
        String nome;
        String endereco;
        String fone;

        public Cliente(int codCliente, String nome, String endereco, String fone) {
            this.codCliente = codCliente;
            this.nome = nome;
            this.endereco = endereco;
            this.fone = fone;

        }

        public Cliente() {

        }

        public void cadastrarCliente() {

            try {
                System.out.println("Informe o código do cliente:");
                codCliente = teclado.nextInt();
                if (!existeCliente(codCliente)) {

                    System.out.println("Informe nome do cliente:");
                    nome = teclado.next().concat(teclado.nextLine());

                    System.out.println("Informe o endereço:");
                    endereco = teclado.next().concat(teclado.nextLine());

                    System.out.println("Informe o número telefone:");
                    fone = teclado.next().concat(teclado.nextLine());


                    Cliente cliente = new Cliente(codCliente, nome, endereco, fone);
                    listaCliente.add(cliente);

                } else {
                    System.out.println("Código do cliente já existe!");
                }
            } catch (InputMismatchException inputMismatchException) {
            }
            return;
        }

        public void alterarCadastro() {

            System.out.println("Informe o código do cliente para realizar a atualização:");
            codCliente = teclado.nextInt();

            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).codCliente == codCliente) {

                    System.out.println("Informe o endereço:");
                    endereco = teclado.next().concat(teclado.nextLine());

                    System.out.println("Informe o número telefone:");
                    fone = teclado.next().concat(teclado.nextLine());

                    Cliente cliente = new Cliente(listaCliente.get(i).codCliente, listaCliente.get(i).nome, endereco, fone);
                    listaCliente.set(i, cliente);
                    return;
                }

            }
            System.out.println("Código do cliente não existe!");
        }

        public String buscarNomeCliente(int codCliente) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).codCliente == codCliente) {
                    return listaCliente.get(i).nome;
                }
            }
            return "Ocorreu um error!";
        }

        public boolean existeCliente(int codCliente) {

            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).codCliente == codCliente) {
                    return true;
                }

            }
            return false;
        }
    }

    static class Recebimentos {
        int numDocumento;
        double valorDoc;
        String dataEmissao;
        Date dataEmissaoConvertida;
        String dataVencimento;
        Date dataVencimentoConvertida;
        int codCliente;
        boolean validarDataDigitada;
        Cliente cliente = new Cliente();

        public Recebimentos(int numDocumento, double valorDoc, String dataEmissao, String dataVencimento, int codCliente) {
            this.numDocumento = numDocumento;
            this.valorDoc = valorDoc;
            this.dataEmissao = dataEmissao;
            this.dataVencimento = dataVencimento;
            this.codCliente = codCliente;
        }

        public Recebimentos() {

        }

        public void cadastrarRecibo() {

            System.out.println("Informe o código do cliente:");
            codCliente = teclado.nextInt();
            if (quantidadeReciboPorCliente(codCliente) < 3) {

                if (cliente.existeCliente(codCliente)) {
                    System.out.println("Informe o número do documento:");
                    numDocumento = teclado.nextInt();

                    System.out.println("Informe o valor do documento:");
                    valorDoc = teclado.nextDouble();

                    System.out.println("Informe a data de emissão:");
                    dataEmissao = teclado.next().concat(teclado.nextLine());
                    validarDataDigitada = validarData(dataEmissao);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de emissão no formato (10/02/21):");
                        dataEmissao = teclado.next().concat(teclado.nextLine());
                        validarDataDigitada = validarData(dataEmissao);
                    }


                    System.out.println("Informe a data de vencimento:");
                    dataVencimento = teclado.next().concat(teclado.nextLine());
                    validarDataDigitada = validarData(dataVencimento);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de vencimento:");
                        dataVencimento = teclado.next().concat(teclado.nextLine());
                        validarDataDigitada = validarData(dataVencimento);

                    }

                    try {
                        dataEmissaoConvertida = formatoData.parse(dataEmissao);
                        dataVencimentoConvertida = formatoData.parse(dataVencimento);

                    } catch (
                            ParseException parseException) {
                    }

                    Recebimentos recebimentos = new Recebimentos(numDocumento, valorDoc, dataEmissao, dataVencimento, codCliente);
                    listaDocumento.add(recebimentos);


                } else {
                    System.out.println("Cliente ainda não existe!");
                }
            } else {
                System.out.println("Limite máximo de cadastro de recibo atingido!");
            }

        }

        public boolean validarData(String dataVencimentoInserida) {
            try {
                formatoData.setLenient(false);
                dataVencimentoConvertida = formatoData.parse(dataVencimentoInserida);
            } catch (ParseException parseException) {
                System.out.println("Data foi digitada no formato errado, digite a da neste formato dd/MM/yy");
                return true;
            }
            return false;

        }

        public void buscarDataVencimento() {
            String nomeCliente;
            long dias;
            long diferenca;
            boolean existeData = false;

            System.out.println("Digite a data do vencimento:");
            dataVencimento = teclado.next().concat(teclado.nextLine());

            for (int i = 0; i < listaDocumento.size(); i++) {
                if (listaDocumento.get(i).dataVencimento.equals(dataVencimento)) {
                    nomeCliente = cliente.buscarNomeCliente(listaDocumento.get(i).codCliente);

                    try {
                        dataEmissaoConvertida = formatoData.parse(listaDocumento.get(i).dataEmissao);
                        dataVencimentoConvertida = formatoData.parse(listaDocumento.get(i).dataVencimento);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }

                    if (dataEmissaoConvertida.getTime() >= dataVencimentoConvertida.getTime()) {
                        dias = dataEmissaoConvertida.getTime() - dataVencimentoConvertida.getTime();
                        TimeUnit tempo = TimeUnit.DAYS;
                        diferenca = tempo.convert(dias, TimeUnit.MILLISECONDS);
                        System.out.println("Nome do cliente: " + nomeCliente + "\nTotal de dias em atraso: " + diferenca);

                    }

                    existeData = true;
                }
            }
            if (existeData == false) {
                System.out.println("Nenhum recibo encontrado nesta data!");
            }

        }

        public int quantidadeReciboPorCliente(int codCliente) {
            int contator = 0;
            for (int i = 0; i < listaDocumento.size(); i++) {
                if (listaDocumento.get(i).codCliente == codCliente) {
                    contator++;
                }

            }
            return contator;
        }

    }
}

