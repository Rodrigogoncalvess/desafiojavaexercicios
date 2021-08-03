package br.com.jorgerabellodev.reskilling.parte08;

import java.util.Scanner;

/**
 * Faça um programa que leia o código, a descrição, o valor unitário e a quantidade em estoque dos 50 produtos
 * comercializados por uma papelaria. Essas informações devem ser armazenadas em um registro do tipo vetor
 * em ordem crescente de código. Depois da leitura, o programa deverá:
 * ■ ■ realizar uma rotina que permita alterar a descrição, o valor unitário e a quantidade em estoque de determinado produto, que deverá ser localizado por meio da informação de seu código;
 * ■ ■ realizar uma rotina que mostre todos os produtos cuja descrição comece com determinada letra (informada pelo usuário);
 * ■ ■ mostrar todos os produtos com quantidade em estoque inferior a cinco unidades.
 */
public class Exercicio05 {
    static int[] codigo = new int[50];
    static String[] descricao = new String[codigo.length];

    public static void main(String[] args) {


        double[] valorUnitario = new double[codigo.length];
        int[] qtdEstoque = new int[codigo.length];
        int inserirCodigo;
        int posicaoDescricaoProduto;
        int buscarCodigo;
        boolean codigoExiste;
        boolean descricaoExiste;
        String buscaPorProduto;
        String descricaoDoprodutoDigitado;


        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao <= 6) {
            System.out.println("Digite uma das opções abaixo:\n1 - Cadastrar novo produto\n2 - Todos os produtos\n3 - Alterar descrição produto" +
                    "\n4 - Alterar o valor do produto\n5 - Alterar a quantidade do produto\n6 - Estoque produto menor que 5 unidades.");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    for (int i = 0; i < codigo.length; i++) {
                        System.out.println("Informe o código do produto:");
                        inserirCodigo = scanner.nextInt();

                        codigoExiste = validarCodigoProduto(inserirCodigo);

                        while (codigoExiste) {
                            System.out.println("Código já exite, digite novamente o código:");
                            inserirCodigo = scanner.nextInt();
                            codigoExiste = validarCodigoProduto(inserirCodigo);
                        }
                        codigo[i] = inserirCodigo;

                        System.out.println("Informe a descrição do produto :");
                        descricaoDoprodutoDigitado = scanner.next();

                        descricaoExiste = validarDescricaoProduto(descricaoDoprodutoDigitado);

                        while (descricaoExiste) {
                            System.out.println("Produto já existe com outro código, cadastre outro produto:");
                            descricaoDoprodutoDigitado = scanner.next();

                            descricaoExiste = validarDescricaoProduto(descricaoDoprodutoDigitado);

                        }
                        descricao[i] = descricaoDoprodutoDigitado;


                        System.out.println("Informe o valor do produto:");
                        valorUnitario[i] = scanner.nextDouble();

                        System.out.println("Informe a quantidade do produto:");
                        qtdEstoque[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    System.out.println("Digite o produto que deseja pesquisa:");
                    buscaPorProduto = scanner.next();

                    posicaoDescricaoProduto = descricaoProduto(buscaPorProduto);

                    if (posicaoDescricaoProduto != -1) {
                        System.out.println("Código do produto " + codigo[posicaoDescricaoProduto] + " -> Descrição: " + descricao[posicaoDescricaoProduto] + " -> Valor unitário: " + valorUnitario[posicaoDescricaoProduto] + " -> Quantidade em estoque: " + qtdEstoque[posicaoDescricaoProduto]);

                    } else {
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Digite o código do produto para alterar a descrição:");
                    buscarCodigo = scanner.nextInt();

                    for (int i = 0; i < codigo.length; i++) {
                        if (buscarCodigo == codigo[i]) {
                            System.out.println("Altere a descrição do produto");
                            descricao[i] = scanner.next();
                            break;
                        } else {
                            System.out.println("Código não existe!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o código do produto para alterar o valor:");
                    buscarCodigo = scanner.nextInt();

                    for (int i = 0; i < codigo.length; i++) {
                        if (buscarCodigo == codigo[i]) {
                            System.out.println("Altere o valor do produto");
                            valorUnitario[i] = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Código não existe!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite o código do produto para alterar o estoque:");
                    buscarCodigo = scanner.nextInt();

                    for (int i = 0; i < codigo.length; i++) {
                        if (buscarCodigo == codigo[i]) {
                            System.out.println("Altere o estoque do produto");
                            descricao[i] = scanner.next();
                            break;
                        } else {
                            System.out.println("Código não existe!");
                            break;
                        }
                    }
                    break;

                case 6:
                    for (int i = 0; i < codigo.length; i++) {
                        if (qtdEstoque[i] < 5) {
                            System.out.println("Código do produto " + codigo[i] + " -> Descrição: " + descricao[i] + " -> Valor unitário: " + valorUnitario[i] + " -> Quantidade em estoque: " + qtdEstoque[i]);

                        }
                    }
                    break;
            }
        }
    }

    public static int descricaoProduto(String nomeProduto) {
        for (int i = 0; i < descricao.length; i++) {
            if (descricao[i].startsWith(nomeProduto)) {
                return i;
            }

        }
        return 0;
    }

    public static boolean validarCodigoProduto(int codigoProduto) {
        for (int i = 0; i < codigo.length; i++) {
            if (codigoProduto == codigo[i]) {
                return true;
            }

        }
        return false;
    }

    public static boolean validarDescricaoProduto(String descricaoProduto) {
        for (int i = 0; i < descricao.length; i++) {
            if (descricaoProduto.equalsIgnoreCase(descricao[i])) {
                return true;
            }

        }
        return false;
    }
}
