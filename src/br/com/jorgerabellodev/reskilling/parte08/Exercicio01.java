package br.com.jorgerabellodev.reskilling.parte08;

import java.util.Scanner;

/**
 * Uma empresa deseja controlar as vendas realizadas por seus vendedores a cada mês, durante um ano inteiro.
 * Sabe-se que nessa empresa existem quatro vendedores.
 * É importante que esse controle seja automatizado, porque muitas consultas devem ser respondidas
 * imediatamente. O gerente necessita de um meio para cadastrar as vendas de todos os vendedores e,
 * depois, precisa ver um menu contendo as seguintes opções:
 * 1. Cadastrar vendedor.
 * 2. Cadastrar venda.
 * 3. Consultar as vendas de um funcionário em determinado mês.
 * 4. Consultar o total das vendas de determinado vendedor.
 * 5. Mostrar o número do vendedor que mais vendeu em determinado mês.
 * 6. Mostrar o número do mês com mais vendas.
 * 7. Finalizar o programa.
 * Na opção 1: devem ser cadastrados vendedores, e não pode haver dois vendedores com o mesmo có-
 * digo.
 * Na opção 2: devem ser cadastradas vendas, informado o código do vendedor e o mês das vendas, mas
 * não podem existir duas vendas para o mesmo vendedor no mesmo mês.
 * Na opção 3: deve ser informado o número do vendedor e o número do mês que se deseja consultar,
 * para, então, descobrir e mostrar esse valor.
 * Na opção 4: deve ser informado o número do vendedor desejado, calculado e mostrado o total de suas
 * vendas.
 * Na opção 5: deve ser informado o número do mês que se deseja pesquisar, para então descobrir e mos-
 * trar o número do vendedor que mais vendeu nesse mês.
 * Na opção 6: deve ser descoberto e mostrado o mês com maior venda.
 * Na opção 7: o programa termina.
 */
public class Exercicio01 {

    static int[] vendedor = new int[]{11, 22};
    static int[][] controleVenda = new int[15][3];
    static int contadorControleValorVenda = 0;

    public static void main(String[] args) {

        int mes = 0;
        int consultaMes = 0;
        double valorVenda = 0.0;
        int codigoVendedor = 0;
        int opcao = 0;
        int valor;
        boolean controle = false;
        boolean controleMes = false;
        boolean controleVendaMes = false;
        boolean controleValorVenda = false;

        Scanner scanner = new Scanner(System.in);

        while (opcao != 7) {
            System.out.println("\nDigite uma das opções abaixo:" + "\n1 - Cadastrar um vendedor"
                    + "\n2 - Cadastrar venda" + "\n3 - Consultar as vendas de um funcionário em determinado mês"
                    + "\n4 - Consultar o total das vendas de determinado vendedor"
                    + "\n5 - Mostrar o número do vendedor que mais vendeu em determinado mês"
                    + "\n6 - Mostrar o número do mês com mais vendas" + "\n7 - Finalizar o programa");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    for (int i = 0; i < vendedor.length; i++) {
                        System.out.println("Informe o código do " + (i + 1) + "° vendendor");
                        codigoVendedor = scanner.nextInt();

                        if (existeVendedor(codigoVendedor, vendedor)) {
                            System.out.println("Vendedor ja está cadastrado.");
                        } else {
                            vendedor[i] = codigoVendedor;
                            System.out.println("Vendedor cadastrado.");
                        }
                    }
                    break;
                case 2:
                    while (controle == false) {
                        System.out.println("Informe o código do vendendor");
                        codigoVendedor = scanner.nextInt();
                        controle = existeVendedor(codigoVendedor, vendedor);

                        if (controle == true) {

                            while (controleMes == false) {
                                System.out.println("Informe o mês da venda: ");
                                mes = scanner.nextInt();
                                controleMes = existeMes(mes);

                                if (controleMes == true) {
                                    controleVendaMes = existeVendaMes(codigoVendedor, mes);
                                    if (controleVendaMes == true) {

                                        while (controleVendaMes == true) {
                                            System.out.println("Você ja possui duas vendas no mes: " + mes);
                                            System.out.println("Informe um outro mês:");
                                            mes = scanner.nextInt();
                                            controleMes = existeMes(mes);
                                            controleVendaMes = existeVendaMes(codigoVendedor, mes);
                                        }
                                    }

                                } else {
                                    System.out.println("Mês inválido");
                                }
                            }

                            while (controleValorVenda == false) {
                                System.out.println("Cadastre o valor da venda:");
                                valorVenda = scanner.nextDouble();
                                controleValorVenda = validarValorVenda(valorVenda);
                            }

                            controlarVenda(codigoVendedor, mes, valorVenda);

                            for (int i = 0; i < controleVenda.length; i++) {

                                for (int j = 0; j < controleVenda[i].length; j++) {
                                    System.out.println("Valores da matriz dentro do case: " + controleVenda[i][j]);
                                }
                            }

                        } else {

                            System.out.println("Código do vendendor inválido!!");
                        }
                    }
                    controle = controleMes = controleValorVenda = false;

                    break;
                case 3:
                    System.out.println("Informe o código do vendendor");
                    codigoVendedor = scanner.nextInt();
                    System.out.println("Informe o mês para devida consulta:");
                    consultaMes = scanner.nextInt();

                    valor = (int) verificarVendaMes(codigoVendedor, consultaMes);
                    if (valor == 0) {
                        System.out.println("Nao existe venda o mês informado!");
                    }
                    System.out.println("valor mes: " + verificarVendaMes(codigoVendedor, consultaMes));
                    break;

                case 4:
                    System.out.println("Informe o código do vendendor");
                    codigoVendedor = scanner.nextInt();

                    TotalVendaVendedor(codigoVendedor);

                    break;

                case 5:
                    System.out.println("Informe o mês para devida consulta:");
                    consultaMes = scanner.nextInt();
                    maiorVendaVendedor(consultaMes);

                    break;
                case 6:
                    maiorVendaMes();
                    break;

                case 7:
                    System.out.println("Programa finalizado!");
                default:
            }
        }
    }

    private static boolean existeVendedor(int codigoVendedor, int[] vendedorArray) {
        for (int i = 0; i < vendedorArray.length; i++) {
            if (codigoVendedor == vendedorArray[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean existeMes(int mesInformado) {
        for (int i = 1; i <= 12; i++) {
            if (mesInformado == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean existeVendaMes(int codigoVendedor, int mes) {

        int qtdMeses = 0;
        for (int i = 0; i < controleVenda.length; i++) {
            for (int j = 0; j < controleVenda.length; j++) {
                if (controleVenda[i][0] == codigoVendedor && controleVenda[j][1] == mes) {
                    qtdMeses++;

                    if (qtdMeses > 2) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private static boolean validarValorVenda(double valorVenda) {
        if (valorVenda < 0.0) {
            System.out.println("Não é possível ter uma venda negativa!");
            return false;
        }
        return true;
    }

    private static void controlarVenda(int codigoVendedor, int mesVenda, double valorVenda) {

        if (controleVenda[contadorControleValorVenda][0] == 0) {
            controleVenda[contadorControleValorVenda][0] = codigoVendedor;
            controleVenda[contadorControleValorVenda][1] = mesVenda;
            controleVenda[contadorControleValorVenda][2] = (int) valorVenda;
        }
        contadorControleValorVenda++;
    }

    private static double verificarVendaMes(int codigoVendedor, int mesVenda) {

        double valorMes = 0;

        for (int i = 0; i < controleVenda.length; i++) {
            if (controleVenda[i][0] == codigoVendedor) {
                for (int j = 0; j < controleVenda[i].length; j++) {
                    if (controleVenda[i][1] == mesVenda) {
                        valorMes = controleVenda[i][2];
                    }
                }
            }
        }

        return valorMes;
    }

    private static void TotalVendaVendedor(int codigoVendedor) {
        double somaTotal = 0;
        for (int i = 0; i < controleVenda.length; i++) {
            if (controleVenda[i][0] == codigoVendedor) {
                somaTotal += controleVenda[i][2];

            }
        }
        System.out.println("Soma total das vendas: " + somaTotal);
    }

    private static void maiorVendaVendedor(int consultaMes) {
        double venda;
        int codigo = 0;
        double vendaTotal;
        double maiorVenda = 0;

        for (int i = 0; i < controleVenda.length; i++) {
            vendaTotal = 0;
            if (controleVenda[i][1] == consultaMes) {
                for (int j = 0; j < controleVenda.length; j++) {
                    if (controleVenda[i][0] == controleVenda[j][0]) {
                        venda = controleVenda[j][2];
                        codigo = controleVenda[j][0];
                        vendaTotal += venda;

                    }

                }
            }
            if (vendaTotal > maiorVenda) {
                maiorVenda = vendaTotal;

            }
        }
        System.out.println("Vendendor que mais vendeu no mês informado foi do código " + codigo
                + " com um valor total de R$: " + maiorVenda);

    }

    public static void maiorVendaMes() {

        int maiorVenda = 0;
        int somaVenda = 0;

        int contadorVenda;

        for (int i = 0; i < controleVenda[i][1]; i++) {

            contadorVenda = 0;

            for (int j = 0; j < controleVenda[j][2]; j++) {
                contadorVenda++;

                somaVenda = controleVenda[j][1];

            }

            if (contadorVenda > maiorVenda) {
                maiorVenda = contadorVenda;
            }

        }
        System.out.println("Mês " + somaVenda + " teve a maior quantidade de vendas " + maiorVenda);

    }

}





