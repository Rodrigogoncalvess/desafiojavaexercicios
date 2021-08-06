package br.com.jorgerabellodev.reskilling.parte08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Uma loja de eletrodomésticos está fazendo uma promoção entre seus 15 mil clientes. Todos os clientes
 * que gastarem mais de R$ 5.000,00 em compras passarão a ser considerados clientes vip, tendo 15% de
 * desconto em todas as suas compras posteriores. Esse valor é cumulativo, mas precisa atingir R$ 5.000,00
 * dentro de seis meses a partir da primeira compra ou será zerado. Faça um programa que:
 * <p>
 * a) cadastre os clientes dessa loja. Para cada cliente devem ser cadastrados: nome do cliente, CPF, RG, endereço,
 * data da primeira compra, total gasto desde sua primeira compra e um campo que diz se o cliente é vip ou
 * não. O campo que guarda o total gasto pelo cliente deve sempre iniciar com zero, e o campo em que diz se o
 * cliente é vip deve começar como FALSO;
 * b) atualize o total gasto por determinado cliente. Deve-se ler um RG e, caso este seja encontrado na lista de
 * clientes, deve-se entrar com um novo valor que atualizará o campo total gasto por esse cliente. Depois de
 * entrar com o novo total gasto, deve-se fazer um teste para verificar se o valor chegou a R$ 5.000,00. Em caso
 * positivo, o cliente passará a ser vip. Esse teste só será realizado caso o cliente ainda não seja vip;
 * c) teste se o total gasto de cada cliente não vip deve ser zerado. Se o tempo entre a data da primeira compra de
 * um cliente e a data atual exceder seis meses, o total gasto por esse cliente deverá ser zerado. Lembre-se de que
 * isso só vale para clientes não vip.
 */
public class Exercicio18 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        boolean continuar = true;
        int opcaoMenu;
        boolean continuarMenu = true;
        int opcaoMenuContinuar;

        Cliente cliente = new Cliente();


        while (continuar) {

            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar  cliente; \n2 - Todos os clientes que realizaram compras;\n3 - Atualizar gastos;\n4 - Todos clientes Vip;\n5 - Apagar saldo total acima de seis meses;");
                opcaoMenu = ler.nextInt();


                switch (opcaoMenu) {

                    case 1:
                        cliente.cadastrarCliente();
                        break;
                    case 2:
                        cliente.comprasEfetuadas();
                        break;
                    case 3:
                        cliente.atualizarGasto();
                        break;
                    case 4:
                        cliente.todosClientesVip();
                        break;
                    case 5:
                        cliente.verificarClientesComComprasSeisMeses();
                        break;
                }


                while (continuarMenu) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcaoMenuContinuar = ler.nextInt();
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

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Programa não contém letra ou simbolo.");
                break;
            }

        }
    }

    static class Cliente {
        String nomeCliente;
        long cpf;
        long rg;
        String endereco;
        String dataCompra;
        String ultimaDataCompra;
        Date dataConvertida;
        Date ultimaDataCompraConvertida;
        double valorTotalCompra;
        boolean continuar;
        final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;

        static ArrayList<Cliente> listaCliente = new ArrayList<>();
        static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");

        public Cliente(String nomeCliente, long cpf, long rg, String endereco, String dataCompra, double valorTotalCompra) {
            this.nomeCliente = nomeCliente;
            this.cpf = cpf;
            this.rg = rg;
            this.endereco = endereco;
            this.dataCompra = dataCompra;
            this.valorTotalCompra = valorTotalCompra;
        }

        public Cliente(String nomeCliente, long cpf, long rg, String endereco, String dataCompra, String ultimaDataCompra, double valorTotalCompra) {
            this.nomeCliente = nomeCliente;
            this.cpf = cpf;
            this.rg = rg;
            this.endereco = endereco;
            this.dataCompra = dataCompra;
            this.ultimaDataCompra = ultimaDataCompra;
            this.valorTotalCompra = valorTotalCompra;
        }

        public Cliente() {

        }

        public void cadastrarCliente() {
            try {
                System.out.println("Informe o nome do cliente");
                nomeCliente = ler.next();
                if (!existeCliente(nomeCliente)) {

                    System.out.println("Informe o número do CPF:");
                    cpf = ler.nextLong();

                    System.out.println("Informe o número do RG:");
                    rg = ler.nextInt();

                    System.out.println("Informe o endereço do cliente");
                    endereco = ler.next().concat(ler.nextLine());

                    System.out.println("Informe a data da compra");
                    dataCompra = ler.next();
                    continuar = validarData(dataCompra);

                    while (continuar) {
                        System.out.println("Informe a data da compra");
                        dataCompra = ler.next();
                        continuar = validarData(dataCompra);
                    }


                    System.out.println("Informe o valor da compra:");
                    valorTotalCompra = ler.nextDouble();

                    if (valorTotalCompra > 5000) {
                        System.out.println("Parabéns com esse valor da compra você se tornor cliente Vip!");
                    }


                    Cliente cliente = new Cliente(nomeCliente, cpf, rg, endereco, dataCompra, valorTotalCompra);
                    listaCliente.add(cliente);

                } else {
                    System.out.println("Cliente já existe no cadastro!");
                }
            } catch (InputMismatchException inputMismatchException) {
            }
        }

        public boolean existeCliente(String cliente) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).nomeCliente.equalsIgnoreCase(cliente)) {
                    return true;
                }
            }
            return false;
        }

        public void comprasEfetuadas() {
            int contador = 0;
            double totalCompra = 0;
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).rg == listaCliente.get(i).rg) {
                    contador += listaCliente.get(i).valorTotalCompra;
                }
                System.out.println("Cliente " + listaCliente.get(i).nomeCliente + " comprou R$ " + contador);
                contador = 0;
            }

        }

        public boolean validarData(String dataDaCompra) {
            try {
                formatoData.setLenient(false);
                dataConvertida = formatoData.parse(dataDaCompra);
            } catch (ParseException parseException) {
                System.out.println("Data foi digitada no formato errado, digite a da neste formato dd/MM/yy");
                return true;
            }
            return false;
        }

        public void atualizarGasto() {
            double somaValor;

            System.out.println("Informe o número do RG:");
            rg = ler.nextLong();

            if (existeRG(rg)) {
                for (int i = 0; i < listaCliente.size(); i++) {

                    if (listaCliente.get(i).rg == rg) {

                        System.out.println("Digite o valor da nova compra:");
                        valorTotalCompra = ler.nextDouble();
                        System.out.println("Digite a data da nova compra:");
                        ultimaDataCompra = ler.next();
                        continuar = validarData(ultimaDataCompra);

                        while (continuar) {
                            System.out.println("Digite a data da nova compra:");
                            ultimaDataCompra = ler.next();
                            continuar = validarData(ultimaDataCompra);
                        }

                        try {
                            dataConvertida = formatoData.parse(listaCliente.get(i).dataCompra);
                            ultimaDataCompraConvertida = formatoData.parse(ultimaDataCompra);
                            int numeroDeMeses = (int) ((ultimaDataCompraConvertida.getTime() - dataConvertida.getTime()) / MES_EM_MILISEGUNDOS);

                            if (numeroDeMeses < 6 && listaCliente.get(i).valorTotalCompra + valorTotalCompra > 5000) {
                                somaValor = listaCliente.get(i).valorTotalCompra + valorTotalCompra;
                                Cliente cliente = new Cliente(listaCliente.get(i).nomeCliente, listaCliente.get(i).cpf, listaCliente.get(i).rg, listaCliente.get(i).endereco, listaCliente.get(i).dataCompra, ultimaDataCompra, somaValor);
                                listaCliente.set(i, cliente);
                            } else if ((numeroDeMeses > 6 && listaCliente.get(i).valorTotalCompra > 5000)){
                                somaValor = listaCliente.get(i).valorTotalCompra + valorTotalCompra;
                                Cliente cliente = new Cliente(listaCliente.get(i).nomeCliente, listaCliente.get(i).cpf, listaCliente.get(i).rg, listaCliente.get(i).endereco, listaCliente.get(i).dataCompra, ultimaDataCompra, somaValor);
                                listaCliente.set(i, cliente);
                            }else{
                                somaValor = valorTotalCompra;
                                Cliente cliente = new Cliente(listaCliente.get(i).nomeCliente, listaCliente.get(i).cpf, listaCliente.get(i).rg, listaCliente.get(i).endereco, listaCliente.get(i).dataCompra, ultimaDataCompra, somaValor);
                                listaCliente.set(i, cliente);
                            }
                            System.out.println("Cliente " + listaCliente.get(i).nomeCliente + " total gasto " + somaValor + "primeira compra: " + listaCliente.get(i).dataCompra + " data da última compra " + ultimaDataCompra);

                            if (somaValor > 5000) {
                                System.out.println("Parabéns com essa compra e o total acumulado você se tornou cliente Vip!");
                                break;
                            }
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }

                    }
                }
            } else {
                System.out.println("RG não existe!");
            }

        }

        public boolean existeRG(long rg) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).rg == rg) {
                    return true;
                }
            }
            return false;
        }

        public boolean todosClientesVip() {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).valorTotalCompra > 5000) {
                    System.out.println("Cliente " + listaCliente.get(i).nomeCliente + " comprou um valor total de R$" + listaCliente.get(i).valorTotalCompra);
                }

            }
            return false;
        }

        public void verificarClientesComComprasSeisMeses() {

            double somaTotal;


            for (int i = 0; i < listaCliente.size(); i++) {
                try {
                    dataConvertida = formatoData.parse(listaCliente.get(i).dataCompra);
                    ultimaDataCompraConvertida = formatoData.parse(listaCliente.get(i).ultimaDataCompra);
                    int numeroDeMeses = (int) ((ultimaDataCompraConvertida.getTime() - dataConvertida.getTime()) / MES_EM_MILISEGUNDOS);
                    if (numeroDeMeses > 6 && listaCliente.get(i).valorTotalCompra <= 5000) {

                        somaTotal = 0.0;
                        Cliente cliente = new Cliente(listaCliente.get(i).nomeCliente, listaCliente.get(i).cpf, listaCliente.get(i).rg, listaCliente.get(i).endereco, listaCliente.get(i).dataCompra, ultimaDataCompra, somaTotal);
                        listaCliente.set(i, cliente);
                        System.out.println("Dados atualizados!!!!");

                    }

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        }
    }
}
