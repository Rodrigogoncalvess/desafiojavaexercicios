package br.com.jorgerabellodev.reskilling.parte10.exercicio03;

import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.jorgerabellodev.reskilling.parte10.exercicio03.Cliente.clienteList;

/**
 * Defina uma classe denominada PRODUTO com os seguintes atributos: número do produto e preço do pro-
 * duto. Essa classe deve possuir, também, um método para calcular o valor do desconto, ou seja, produtos com
 * preço superior a R$ 100,00 possuem desconto de 15% e os demais produtos têm desconto de 5%.
 * Defina uma classe CLIENTE com os seguintes atributos: número do cliente, nome do cliente e sexo do
 * cliente. Essa classe deve possuir, também, um método para calcular o desconto adicional, ou seja, clientes
 * do sexo feminino (F ou f) têm um desconto adicional de 5% sobre o preço do produto e os demais clientes
 * (M ou m) não possuem esse desconto.
 * Defina uma classe denominada COMPRA com os seguintes atributos: número do produto, número
 * do cliente, quantidade e valor total. Essa classe deve possuir ainda um método para calcular o valor total,
 * ou seja, a quantidade multiplicada pelo preço final. O preço final é o preço do produto menos o desconto
 * adicional, quando este existe.
 * Faça um programa que carregue três produtos validando apenas o preço para que este esteja entre R$
 * 20,00 e R$ 350,00. Carregue três clientes validando para que o sexo seja M, m, F ou f. E, por fim, carregue
 * uma compra digitando um número do produto, um número do cliente e a quantidade comprada do produto
 * e calculando o valor total (método da classe COMPRA). Suponha sempre a digitação de dados válidos.
 */
public class Exercicio03 {
    public static void main(String[] args) {

        int contadorProduto = 0;
        int contadorCliente = 0;

        Scanner ler = new Scanner(System.in);

        Produto produto = new Produto();
        Cliente cliente = new Cliente();
        Compra compra = new Compra();


        do {
            try {
                System.out.println("Informe o número do produto:");
                int numeroProduto = ler.nextInt();

                System.out.println("Informe o valor do produto");
                double precoProduto = ler.nextDouble();

                while (!produto.validarPreco(precoProduto)) {
                    System.out.println("Preço do produto não pode ser menor R$ 20,00 e nem maior que R$350,00, favor informar o valor do produto:");
                    precoProduto = ler.nextDouble();
                }
                Produto produtos = new Produto(numeroProduto, precoProduto);
                produto.produtoList.add(produtos);

                contadorProduto++;

            } catch (InputMismatchException e) {
                System.out.println("Programa não pode ser digitado letra ou simbolo!");
                return;
            }

        } while (contadorProduto < 3);


        do {
            try {
                System.out.println("Digite o número do cliente:");
                int numeroCliente = ler.nextInt();
                boolean validarNumeroCliente = cliente.validarNumeroCliente(numeroCliente, clienteList);

                while (validarNumeroCliente) {
                    System.out.println("Digite o número do cliente válido:");
                    numeroCliente = ler.nextInt();
                    validarNumeroCliente = cliente.validarNumeroCliente(numeroCliente, clienteList);
                }

                System.out.println("Digite o nome do cliente:");
                String nomeCliente = ler.next().concat(ler.nextLine()).toUpperCase();
                boolean validarNomeCliente = cliente.validarNomeCliente(nomeCliente, clienteList);

                while (validarNomeCliente) {

                    System.out.println("Digite o nome do cliente válido:");
                    nomeCliente = ler.next().concat(ler.nextLine()).toUpperCase();
                    validarNomeCliente = cliente.validarNomeCliente(nomeCliente, clienteList);

                }

                System.out.println("Digite  a letra inicial do sexo do cliente:");
                String sexoCliente = ler.next().toUpperCase();
                char primeiraLetra = sexoCliente.charAt(0);

                if (primeiraLetra == 'M' && sexoCliente.equalsIgnoreCase("M") || primeiraLetra == 'F' && sexoCliente.equalsIgnoreCase("F")) {

                    Cliente clientes = new Cliente(numeroCliente, nomeCliente, sexoCliente);
                    clienteList.add(clientes);
                    contadorCliente++;

                } else {
                    System.err.println("Letra não foi digitada correta!\nDigite neste formato\nM = Masculino \nF = Feminino");
                }
            } catch (InputMismatchException e) {
                System.out.println("Programa não pode ser digitado letra ou simbolo!");
                return;
            }

        } while (contadorCliente < 3);

        try {
            System.out.println("Digite o número do produto que deseja compra: ");
            int numeroProduto = ler.nextInt();

            while (!compra.existeProduto(numeroProduto)) {
                System.out.println("Digite o número do produto que deseja compra que possua no estoque: ");
                numeroProduto = ler.nextInt();
            }

            System.out.println("Digite o número do cliente:");
            int numeroCliente = ler.nextInt();

            while (!compra.existeCliente(numeroCliente)) {
                System.out.println("Número do cliente informado não existe no cadastro , digite um número válido:");
                numeroCliente = ler.nextInt();
            }

            System.out.println("Informe a quantidade que deseja compra:");
            int quantidadeAComprar = ler.nextInt();


            double descontoProduto = compra.descontoValorTotal(numeroProduto, quantidadeAComprar);
            double descontoAdicional = cliente.calcularDescontoAdicional(numeroCliente, quantidadeAComprar, numeroProduto);
            double valorTotal = compra.valorTotalCompra(numeroProduto, quantidadeAComprar);

            System.out.println("Valor total da compra já com os descontos: " + (valorTotal - (descontoProduto + descontoAdicional)));

        } catch (InputMismatchException e) {
            System.out.println("Programa não pode ser digitado letra ou simbolo!");
            return;
        }

    }
}
