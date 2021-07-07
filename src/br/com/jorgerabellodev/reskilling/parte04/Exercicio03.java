package br.com.jorgerabellodev.reskilling.parte04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa para controlar o estoque de mercadorias de uma empresa. Inicialmente, o programa de-
 * verá preencher dois vetores com dez posições cada, onde o primeiro corresponde ao código do produto e o
 * segundo, ao total desse produto em estoque. Logo após, o programa deverá ler um conjunto indeterminado
 * de dados contendo o código de um cliente e o código do produto que ele deseja comprar, juntamente com a
 * quantidade. Código do cliente igual a zero indica fim do programa. O programa deverá verificar:
 * ■ ■ se o código do produto solicitado existe. Se existir, tentar atender ao pedido; caso contrário, exibir
 * mensagem Código inexistente;
 * ■ ■ cada pedido feito por um cliente só pode ser atendido integralmente. Caso isso não seja possível,
 * escrever a mensagem Não temos estoque suficiente dessa mercadoria. Se puder atendê-lo, escrever
 * a mensagem Pedido atendido. Obrigado e volte sempre;
 * ■ ■ efetuar a atualização do estoque somente se o pedido for atendido integralmente;
 * ■ ■ no final do programa, escrever os códigos dos produtos com seus respectivos estoques já atualizados.
 */
public class Exercicio03 {

    private static int[] codigo = new int[2];
    private static int codigoProduto;
    private static boolean existeProduto = false;

    public static void main(String[] args) {


        var totalProdutoEstoque = new int[2];
        var codigoCliente = 0;
        var saldoProduto = 0;
        var qtdCompraProduto = 0;
        var total = 0;

        Validadora valida = new Validadora();

        Scanner scan = new Scanner(System.in);
        try {
            for (int i = 0; i < codigo.length; i++) {

                System.out.println("cadastre o código do produto: ");
                codigo[i] = scan.nextInt();

                System.out.println("Informe a quantidade do produto em estoque: ");
                totalProdutoEstoque[i] = scan.nextInt();
            }

            System.out.println("Cliente informe seu código:");
            codigoCliente = scan.nextInt();

            if (codigoCliente == 0) {
                System.out.println("Programa finalizado");
                return;
            }
            do {

                System.out.println("Informe o código do produto que deseja comprar: ");
                codigoProduto = scan.nextInt();

                existeProduto = valida.existe(codigoProduto);

                if (existeProduto == false) {
                    System.out.println("Código nào existe, tente novamente");
                }

            } while (existeProduto == false);


            System.out.println("Informe a quantidade do produto que deseja comprar: ");
            qtdCompraProduto = scan.nextInt();

            for (int i = 0; i < codigo.length; i++) {
                if (codigo[i] == codigoProduto) {
                    if (totalProdutoEstoque[i] >= qtdCompraProduto) {
                        totalProdutoEstoque[i] -= qtdCompraProduto;
                        System.out.println("Pedido atendido, Obrigado e volte sempre! \n" +
                                "Saldo em estoque: " + totalProdutoEstoque[i]);
                    } else {
                        System.out.println("Não temos estoque suficiente dessa mercadoria!");
                    }
                }
            }
            for (int i = 0; i < codigo.length; i++) {
                System.out.println("O produto com o código " + codigo[i] + " possui saldo em estoque de: " + totalProdutoEstoque[i]);

            }
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }

    static class Validadora {

        public boolean existe(int codigoProduto) {

            for (int i = 0; i < codigo.length; i++) {

                if (codigoProduto == codigo[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}


