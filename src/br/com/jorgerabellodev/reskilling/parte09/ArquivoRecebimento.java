package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ArquivoRecebimento {

    private static int numDoc;
    private static double valorDoc;
    private static String dataEmissao;
    private static Date dataEmissaoConvertida;
    private static String dataVencimento;
    private static Date dataVencimentoConvertida;
    private static int codCliente;

    public static int opcao;
    public static final String delimitador = ",";


    public static String[] vect;
    public static int tempCodCliente;
    public static int tempNumDoc;
    public static double tempValorDoc;
    public static String tempDataEmissao;
    public static String tempDataVencimento;

    public static boolean validarDataDigitada;

    public static Scanner ler = new Scanner(System.in);
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");


    public static final String caminhoArquivoRecebimentos = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\RECEBIMENTOS";
    static Random geradorDeNumero = new Random();


    static ArquivoCliente arquivoCliente = new ArquivoCliente();
    static ArrayList<Recebimento> tempListaRecebimento = new ArrayList<>();


    public static boolean validarData(String dataInserida) {
        try {
            formatoData.setLenient(false);
            dataVencimentoConvertida = formatoData.parse(dataInserida);
        } catch (ParseException parseException) {
            System.out.println("Data foi digitada no formato errado, digite a data neste formato dd/MM/yy");
            return true;
        }
        return false;

    }


    public static void cadastrarRecebimentos() {

        int codigo;


        System.out.println("Informe o código do cliente:");
        codigo = ler.nextInt();
        if (arquivoCliente.existeCodigo(codigo)) {

            while (true) {
                try {

                    FileReader arq = new FileReader(caminhoArquivoRecebimentos);
                    BufferedReader br = new BufferedReader(arq);

                    FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRecebimentos, true);
                    BufferedWriter bw = new BufferedWriter(criadorDeArquivos);
                    PrintWriter escritorDeArquivos = new PrintWriter(bw);

                    numDoc = geradorDeNumero.nextInt(100);

                    System.out.println("Informe o valor do documento: ");
                    valorDoc = ler.nextDouble();

                    System.out.println("Informe a data de emissão:");
                    dataEmissao = ler.next().concat(ler.nextLine());
                    validarDataDigitada = validarData(dataEmissao);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de emissão no formato (10/02/21):");
                        dataEmissao = ler.next().concat(ler.nextLine());
                        validarDataDigitada = validarData(dataEmissao);
                    }


                    System.out.println("Informe a data de vencimento:");
                    dataVencimento = ler.next().concat(ler.nextLine());
                    validarDataDigitada = validarData(dataVencimento);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de vencimento:");
                        dataVencimento = ler.next().concat(ler.nextLine());
                        validarDataDigitada = validarData(dataVencimento);

                    }

                    try {
                        dataEmissaoConvertida = formatoData.parse(dataEmissao);
                        dataVencimentoConvertida = formatoData.parse(dataVencimento);

                    } catch (
                            ParseException parseException) {
                    }


                    escritorDeArquivos.append(numDoc + delimitador + valorDoc + delimitador + dataEmissao + delimitador + dataVencimento + delimitador + codigo + "\n");

                    escritorDeArquivos.close();


                    int opcao = 0;
                    while (opcao != 2) {
                        System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                        opcao = ler.nextInt();
                        if (opcao == 1) {
                            System.out.println("Informe o código do cliente:");
                            codigo = ler.nextInt();
                            break;
                        } else if (opcao == 2) {
                            System.out.println("Obrigado por usar o programa");

                            return;
                        } else {
                            System.out.println("Opção inválida");
                        }
                    }

                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                }

                System.out.println();
            }
        } else {
            System.out.println("Código do cliente ainda não foi cadastrado!");
        }
    }

    public static boolean existeCodigoClienteRecebimento(int codCliente) {


        String caminho = caminhoArquivoRecebimentos;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();
            linha = br.readLine();


            while (linha != null) {

                String[] vect = linha.split(",");
                numDoc = Integer.parseInt(vect[0]);
                valorDoc = Double.parseDouble(vect[1]);
                dataEmissao = vect[2];
                dataVencimento = vect[3];
                tempCodCliente = Integer.parseInt(vect[4]);

                linha = br.readLine();


                if (codCliente == tempCodCliente) {
                    return true;
                }
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static void excluirRecebimento(int codCliente) throws IOException {


        if (existeCodigoClienteRecebimento(codCliente)) {

            try {

                FileReader fr = new FileReader(caminhoArquivoRecebimentos);
                BufferedReader br = new BufferedReader(fr);


                String linha = br.readLine();

                linha = br.readLine();

                if (!linha.isEmpty()) {

                    while (linha != null) {

                        String[] vect = linha.split(",");
                        tempNumDoc = Integer.parseInt(vect[0]);
                        tempValorDoc = Double.parseDouble(vect[1]);
                        tempDataEmissao = vect[2];
                        tempDataVencimento = vect[3];
                        tempCodCliente = Integer.parseInt(vect[4]);

                        cadastrarNaListaRecebimento(tempNumDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, tempCodCliente);

                        linha = br.readLine();

                        deletarRecebimentoTemporario(codCliente);
                    }

                    recadastrarNoArquivoRecebimento();

                    System.out.println("Cliente excluído do arquivo de recebimento!");

                } else {
                    System.out.println("Lista está vázia!");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Código do cliente não existe no cadastro de recebimentos!");
        }


    }


    private static void cadastrarNaListaRecebimento(int numDoc, double valorDoc, String dataEmissao, String dataVencimento, int codCliente) {
        Recebimento recebimento = new Recebimento(numDoc, valorDoc, dataEmissao, dataVencimento, codCliente);
        tempListaRecebimento.add(recebimento);

    }

    private static void recadastrarNoArquivoRecebimento() throws IOException {
        FileReader arq = new FileReader(caminhoArquivoRecebimentos);
        BufferedReader lerArq = new BufferedReader(arq);

        FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRecebimentos, false);
        BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
        PrintWriter escritorDeArquivos = new PrintWriter(buffer);

        // Refaço o cabeçalho
        escritorDeArquivos
                .append("Num Doc" + delimitador + "Valor Doc" + delimitador + "Data da emissão" + delimitador
                        + "Data Vencimento" + delimitador + "Código do Cliente\n");

        for (int i = 0; i < tempListaRecebimento.size(); i++) {


            escritorDeArquivos.append(tempListaRecebimento.get(i).getNumDoc() + delimitador
                    + tempListaRecebimento.get(i).getValorDoc() + delimitador + tempListaRecebimento.get(i).getDataEmissao()
                    + delimitador + tempListaRecebimento.get(i).getDataVencimento() + delimitador + tempListaRecebimento.get(i).getCodCliente() + "\n");
        }

        escritorDeArquivos.close();

    }

    private static void deletarRecebimentoTemporario(int codCliente) {
        for (int i = 0; i < tempListaRecebimento.size(); i++) {
            if (tempListaRecebimento.get(i).getCodCliente() == codCliente) {
                tempListaRecebimento.remove(i);
            }

        }

    }

    public static boolean existeNumeroDocumento(int codCliente) {

        String caminho = caminhoArquivoRecebimentos;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();
            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempNumDoc = Integer.parseInt(vect[0]);
                tempValorDoc = Double.parseDouble(vect[1]);
                tempDataEmissao = vect[2];
                tempDataVencimento = vect[3];
                tempCodCliente = Integer.parseInt(vect[4]);


                linha = br.readLine();


                if (codCliente == tempCodCliente) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    private static void alterarCadstroDeRcebimentoTemporario(int tempNumDoc, double tempValorDoc, String tempDataEmissao, String tempDataVencimento, int tempCodCliente) {
        for (int i = 0; i < tempListaRecebimento.size(); i++) {
            if (tempListaRecebimento.get(i).getNumDoc() == numDoc) {

                Recebimento recebimento = new Recebimento(tempNumDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, tempCodCliente);
                tempListaRecebimento.set(i, recebimento);

            }

        }

    }


    public static void alterarRecebimentoDoCliente() throws IOException {

        System.out.println("Digite o número do documento:");
        numDoc = ler.nextInt();

        if (!existeNumeroDocumento(numDoc)) {

            System.out.println("Digite o código do cliente:");
            codCliente = ler.nextInt();

            if (existeCodigoClienteRecebimento(codCliente)) {

                try {


                    FileReader arq = new FileReader(caminhoArquivoRecebimentos);
                    BufferedReader br = new BufferedReader(arq);

                    FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRecebimentos, true);
                    BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                    PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                    String linha = br.readLine();

                    linha = br.readLine();

                    while (linha != null) {

                        String[] vect = linha.split(",");
                        tempNumDoc = Integer.parseInt(vect[0]);
                        tempValorDoc = Double.parseDouble(vect[1]);
                        tempDataEmissao = vect[2];
                        tempDataVencimento = vect[3];
                        tempCodCliente = Integer.parseInt(vect[4]);

                        cadastrarNaListaRecebimento(tempNumDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, tempCodCliente);

                        linha = br.readLine();

                    }
                    deletarRecebimentoTemporario(codCliente);

                    System.out.println("Informe o valor do documento: ");
                    tempValorDoc = ler.nextDouble();


                    System.out.println("Informe a data de emissão:");
                    tempDataEmissao = ler.next().concat(ler.nextLine());
                    validarDataDigitada = validarData(tempDataEmissao);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de emissão no formato (10/02/21):");
                        tempDataEmissao = ler.next().concat(ler.nextLine());
                        validarDataDigitada = validarData(tempDataEmissao);
                    }


                    System.out.println("Informe a data de vencimento:");
                    tempDataVencimento = ler.next().concat(ler.nextLine());
                    validarDataDigitada = validarData(tempDataVencimento);

                    while (validarDataDigitada) {
                        System.out.println("Informe a data de vencimento no formato (10/02/21):");
                        tempDataVencimento = ler.next().concat(ler.nextLine());
                        validarDataDigitada = validarData(tempDataVencimento);

                    }

                    try {
                        dataEmissaoConvertida = formatoData.parse(tempDataEmissao);
                        dataVencimentoConvertida = formatoData.parse(tempDataVencimento);

                    } catch (
                            ParseException parseException) {
                    }


                    recadastrarNoArquivoRecebimento();

                    alterarCadstroDeRcebimentoTemporario(numDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, codCliente);

                    escritorDeArquivos.append(numDoc + delimitador + tempValorDoc + delimitador + tempDataEmissao + delimitador + tempDataVencimento + delimitador + codCliente + "\n");


                    escritorDeArquivos.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Código do cliente não existe no cadastro!");
            }
        } else {
            System.out.println("Número de documento não existe no cadastro!");
        }


    }

    public static void todosRecebimentosTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoRecebimentos);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRecebimentos, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
            PrintWriter escritorDeArquivos = new PrintWriter(buffer);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempNumDoc = Integer.parseInt(vect[0]);
                tempValorDoc = Double.parseDouble(vect[1]);
                tempDataEmissao = vect[2];
                tempDataVencimento = vect[3];
                tempCodCliente = Integer.parseInt(vect[4]);

                cadastrarNaListaRecebimento(tempNumDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, tempCodCliente);

                linha = br.readLine();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void buscarDataVencimento() throws IOException {
        String nomeCliente;
        long dias;
        long diferenca;
        boolean existeData = false;

        todosRecebimentosTempararios();
        arquivoCliente.todosClientesTempararios();

        System.out.println("Digite a data do vencimento:");
        tempDataVencimento = ler.next().concat(ler.nextLine());
        validarDataDigitada = validarData(tempDataVencimento);

        while (validarDataDigitada) {
            System.out.println("Informe a data de emissão no formato (10/02/21):");
            tempDataVencimento = ler.next().concat(ler.nextLine());
            validarDataDigitada = validarData(tempDataVencimento);
        }

        try {
            dataVencimentoConvertida = formatoData.parse(tempDataVencimento);

        } catch (
                ParseException parseException) {
        }


        for (int i = 0; i < tempListaRecebimento.size(); i++) {

            if (tempListaRecebimento.get(i).getDataVencimento().equals(tempDataVencimento)) {
                nomeCliente = arquivoCliente.buscarNomeCliente(tempCodCliente);

                try {
                    dataEmissaoConvertida = formatoData.parse(tempListaRecebimento.get(i).getDataEmissao());
                    dataVencimentoConvertida = formatoData.parse(tempListaRecebimento.get(i).getDataVencimento());
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

    public static void recebimentosPorCliente() throws IOException {

        todosRecebimentosTempararios();

        System.out.println("Digite o código do cliente:");
        tempCodCliente = ler.nextInt();
        if (arquivoCliente.existeCodigo(tempCodCliente)) {

            for (int i = 0; i < tempListaRecebimento.size(); i++) {
                if (tempListaRecebimento.get(i).getCodCliente() == tempCodCliente) {
                    System.out.println("Código do cliente: " + tempListaRecebimento.get(i).getCodCliente() +
                            "\nNúmero documento: " + tempListaRecebimento.get(i).getNumDoc() +
                            "\nValor documento: " + tempListaRecebimento.get(i).getValorDoc() +
                            "\nData da emissão: " + tempListaRecebimento.get(i).getDataEmissao() +
                            "\nData do vencimento: " + tempListaRecebimento.get(i).getDataVencimento() + "\n");
                }
            }
        } else {
            System.out.println("Código informado não existe no cadastro!");
        }


    }

    public static void buscarValorAcima() throws IOException {

        todosRecebimentosTempararios();

        System.out.println("Digite o valor do documento para obter todos que estão com o valor acima do que foi digitado:");
        tempValorDoc = ler.nextInt();

        for (int i = 0; i < tempListaRecebimento.size(); i++) {
            if (tempListaRecebimento.get(i).getValorDoc() > tempValorDoc) {
                System.out.println("Código do cliente: " + tempListaRecebimento.get(i).getCodCliente() +
                        "\nNúmero documento: " + tempListaRecebimento.get(i).getNumDoc() +
                        "\nValor documento: " + tempListaRecebimento.get(i).getValorDoc() +
                        "\nData da emissão: " + tempListaRecebimento.get(i).getDataEmissao() +
                        "\nData do vencimento: " + tempListaRecebimento.get(i).getDataVencimento() + "\n");
            }
        }

    }

    public static void buscarValorAbaixo() throws IOException {

        todosRecebimentosTempararios();

        System.out.println("Digite o valor do documento para obter todos que estão com o valor abaixo do que foi digitado:");
        tempValorDoc = ler.nextInt();

        for (int i = 0; i < tempListaRecebimento.size(); i++) {
            if (tempListaRecebimento.get(i).getValorDoc() < tempValorDoc) {
                System.out.println("Código do cliente: " + tempListaRecebimento.get(i).getCodCliente() +
                        "\nNúmero documento: " + tempListaRecebimento.get(i).getNumDoc() +
                        "\nValor documento: " + tempListaRecebimento.get(i).getValorDoc() +
                        "\nData da emissão: " + tempListaRecebimento.get(i).getDataEmissao() +
                        "\nData do vencimento: " + tempListaRecebimento.get(i).getDataVencimento() + "\n");
            }
        }

    }

    public static void buscarValorEntreDoisValores() throws IOException {

        int valorDoc;

        todosRecebimentosTempararios();

        System.out.println("Digite o 1° valor do documento:");
        tempValorDoc = ler.nextInt();

        System.out.println("Digite o 2° valor do documento:");
        valorDoc = ler.nextInt();

        for (int i = 0; i < tempListaRecebimento.size(); i++) {
            if (tempListaRecebimento.get(i).getValorDoc() > tempValorDoc && tempListaRecebimento.get(i).getValorDoc() < valorDoc) {
                System.out.println("Código do cliente: " + tempListaRecebimento.get(i).getCodCliente() +
                        "\nNúmero documento: " + tempListaRecebimento.get(i).getNumDoc() +
                        "\nValor documento: " + tempListaRecebimento.get(i).getValorDoc() +
                        "\nData da emissão: " + tempListaRecebimento.get(i).getDataEmissao() +
                        "\nData do vencimento: " + tempListaRecebimento.get(i).getDataVencimento() + "\n");
            }
        }

    }


}


