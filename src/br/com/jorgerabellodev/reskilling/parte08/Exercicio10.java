package br.com.jorgerabellodev.reskilling.parte08;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Uma empresa armazena informações sobre as contas a receber de seus clientes. Cada uma dessas contas
 * tem as seguintes informações: número do documento, código do cliente, data de vencimento, data de
 * pagamento, valor da conta e juros. Faça um programa para cadastrar um documento. Se a data de paga-
 * mento for maior que a de vencimento, o programa deverá calcular o campo ‘juros’ da tabela documentos
 * (a cada dia de atraso, deve-se aplicar 0,02% de multa). O programa deverá ler informações sobre 15
 * documentos e, depois, mostrar todos os documentos lidos e o total geral a receber (valor das contas +
 * juros) e a média dos juros.
 */
public class Exercicio10 {

    static int[] numeroDocumento = new int[15];
    static int[] codigoCliente = new int[numeroDocumento.length];
    static Date dataVencimentoConvertida = null;
    static String dataVencimentoInserida;
    static Date dataPagamentoConvertida = null;
    static String dataPagamentoInserida;

    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");

    public static void main(String[] args) {

        String[] dataDeVencimento = new String[numeroDocumento.length];
        String[] dataDePagamento = new String[numeroDocumento.length];
        double[] valorDaCompra = new double[numeroDocumento.length];
        final double juros = 0.02;
        long dias;
        double valorDoJurosAPagar;
        double totalPagar = 0;
        boolean validarCodigo;
        int inserirCodigo = 0;
        boolean validarNumeroDocumento;
        int inserirNumeroDocumento = 0;
        boolean validarDataDigitada;
        double totalReceber = 0;
        double totalJuros = 0;
        double mediaJuros = 0;
        double totalCompras = 0;

        DecimalFormat format = new DecimalFormat("0.00");


        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < numeroDocumento.length; i++) {

            System.out.println("Informe o número do documento:");
            inserirNumeroDocumento = teclado.nextInt();
            validarNumeroDocumento = existeNumeroDocumento(inserirNumeroDocumento);
            while (validarNumeroDocumento) {
                System.out.println("Número do documento já existe, digite outro número do documento:");
                inserirNumeroDocumento = teclado.nextInt();
                validarNumeroDocumento = existeNumeroDocumento(inserirNumeroDocumento);
            }
            numeroDocumento[i] = inserirNumeroDocumento;

            System.out.println("Informe o código do cliente:");
            inserirCodigo = teclado.nextInt();
            validarCodigo = existeCodigo(inserirCodigo);
            while (validarCodigo) {
                System.out.println("Código do cliente já existe, informe outro código::");
                inserirCodigo = teclado.nextInt();
                validarCodigo = existeCodigo(inserirCodigo);
            }
            codigoCliente[i] = inserirCodigo;

            System.out.println("Informe o valor da compra:");
            valorDaCompra[i] = teclado.nextDouble();
            System.out.println("Informe a data do vencimento:");
            dataVencimentoInserida = teclado.next();
            validarDataDigitada = validarData(dataVencimentoInserida);

            while (validarDataDigitada) {
                System.out.println("Informe a data do vencimento:");
                dataVencimentoInserida = teclado.next();
                validarDataDigitada = validarData(dataVencimentoInserida);
            }

            dataDeVencimento[i] = dataVencimentoInserida;

            System.out.println("Informe a data de pagamento:");
            dataPagamentoInserida = teclado.next();
            validarDataDigitada = validarData(dataPagamentoInserida);

            while (validarDataDigitada) {
                System.out.println("Informe a data de pagamento:");
                dataPagamentoInserida = teclado.next();
                validarDataDigitada = validarData(dataPagamentoInserida);

            }
            dataDePagamento[i] = dataPagamentoInserida;

            try {
                dataVencimentoConvertida = formatoData.parse(dataDeVencimento[i]);
                dataPagamentoConvertida = formatoData.parse(dataDePagamento[i]);

            } catch (ParseException parseException) {
            }

            if (dataPagamentoConvertida.getTime() > dataVencimentoConvertida.getTime()) {
                dias = dataPagamentoConvertida.getTime() - dataVencimentoConvertida.getTime();
                TimeUnit tempo = TimeUnit.DAYS;
                long diferenca = tempo.convert(dias, TimeUnit.MILLISECONDS);

                valorDoJurosAPagar = valorDaCompra[i] * juros;
                totalPagar = diferenca * valorDoJurosAPagar;

                double jurosReceber = (totalPagar / valorDaCompra[i]) * 100;
                totalJuros += jurosReceber;


            }


            totalCompras += valorDaCompra[i];
            totalReceber = totalCompras + totalJuros;
            mediaJuros = (totalJuros / totalCompras) * 100;

        }
        for (int i = 0; i < numeroDocumento.length; i++) {
            System.out.println("Número do documento " + numeroDocumento[i] + " Valor da conta " + valorDaCompra[i]);
        }
        System.out.println("\nValor total das compras com os juros é " + totalReceber);
        System.out.println("Média de juros " + format.format(mediaJuros) + "%");
    }

    public static boolean existeCodigo(int codigo) {
        for (int i = 0; i < numeroDocumento.length; i++) {
            if (codigo == codigoCliente[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeNumeroDocumento(int numero) {
        for (int i = 0; i < numeroDocumento.length; i++) {
            if (numero == numeroDocumento[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarData(String dataVencimentoInserida) {
        try {
            formatoData.setLenient(false);
            dataVencimentoConvertida = formatoData.parse(dataVencimentoInserida);

        } catch (ParseException parseException) {
            System.out.println("Data foi digitada no formato errado, digite a da neste formato dd/MM/yy");
            return true;
        }
        return false;
    }
}