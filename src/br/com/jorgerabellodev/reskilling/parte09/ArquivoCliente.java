package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoCliente {

    public static int opcao;
    public static final String delimitador = ",";


    public static String[] vect;
    public static int tempCodCliente;
    public static String tempNome;
    public static String tempEndereco;
    public static String tempNome2;


    public static Scanner ler = new Scanner(System.in);
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    private static int codCliente;
    private static String nome;
    private static String endereco;
    private static String nome2;

    public static final String caminhoArquivo = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\";
    public static final String caminhoArquivoCliente = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\CLIENTES";

    //    Cliente cliente = new Cliente();
    static ArquivoRecebimento arquivoRecebimento = new ArquivoRecebimento();
    static ArrayList<Cliente> tempListaCliente = new ArrayList<Cliente>();


    public static void criarArquivo(String nomeArquivo, int opcao) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminhoArquivo + nomeArquivo));

        if (opcao == 1) {
            buffWrite.append("CodCliente" + delimitador + "Nome" + delimitador + "Endereço" + delimitador + "Nome\n");

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivo);
            buffWrite.close();

        } else if (opcao == 2) {

            buffWrite.append("Num Doc" + delimitador + "Valor Doc" + delimitador + "Data da emissão" + delimitador
                    + "Data Vencimento" + delimitador + "Código do Cliente\n");

            buffWrite.close();

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivo);

        } else {
            System.out.println("Aconteceu um erro, arquivo nào foi criado..");
        }

    }

    public static void cadastrarCliente() {

        while (true) {

            try {

                FileReader arq = new FileReader(caminhoArquivoCliente);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoCliente, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);

                System.out.println("Informe o código do cliente: ");
                codCliente = ler.nextInt();
                if (!existeCodigo(codCliente)) {
                    System.out.println("Informe o nome do cliente: ");
                    nome = ler.next();
                    System.out.println("Informe o endereco do cliente: ");
                    endereco = ler.next();
                    System.out.println("Informe o nome2 do cliente: ");
                    nome2 = ler.next();

                    escritorDeArquivos.append(
                            codCliente + delimitador + nome + delimitador + endereco + delimitador + nome2 + "\n");

                    escritorDeArquivos.close();

                } else {
                    System.out.println("Código já existe no sistema!");
                }

                int opcao = 0;
                while (opcao != 2) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcao = ler.nextInt();
                    if (opcao == 1) {

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

    }

    public static boolean existeCodigo(int codCliente) {

        String caminho = caminhoArquivoCliente;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();
            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodCliente = Integer.parseInt(vect[0]);
                tempNome = vect[1];
                tempEndereco = vect[2];
                tempNome2 = vect[3];

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

    public static void excluirCliente() throws IOException {

        System.out.println("Digite código do cliente:");
        codCliente = ler.nextInt();

        if (existeCodigo(codCliente)) {

            try {

                FileReader fr = new FileReader(caminhoArquivoCliente);
                BufferedReader br = new BufferedReader(fr);


                String linha = br.readLine();

                linha = br.readLine();

                if (!linha.isEmpty()) {

                    while (linha != null) {

                        String[] vect = linha.split(",");
                        tempCodCliente = Integer.parseInt(vect[0]);
                        tempNome = vect[1];
                        tempEndereco = vect[2];
                        tempNome2 = vect[3];


                        cadastrarNaListaCliente(tempCodCliente, tempNome, tempEndereco, tempNome2);

                        linha = br.readLine();

                    }

                    deletarClienteTemporario(codCliente);

                    recadastrarNoArquivoCliente();
                    System.out.println("Cliente excluído no cadastro de cliente!");

                } else {
                    System.out.println("Lista está vázia!");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            arquivoRecebimento.excluirRecebimento(codCliente);
        } else {
            System.out.println("Código do cliente não existe no cadastro!");
        }


    }

    private static void recadastrarNoArquivoCliente() throws IOException {
        FileReader arq = new FileReader(caminhoArquivoCliente);
        BufferedReader lerArq = new BufferedReader(arq);

        FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoCliente, false);
        BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
        PrintWriter escritorDeArquivos = new PrintWriter(buffer);


        escritorDeArquivos.append("CodCliente" + delimitador + "Nome" + delimitador + "Endereço" + delimitador + "Nome\n");

        for (int i = 0; i < tempListaCliente.size(); i++) {

            escritorDeArquivos.append(tempListaCliente.get(i).getCodCliente() + delimitador
                    + tempListaCliente.get(i).getNome() + delimitador + tempListaCliente.get(i).getEndereco()
                    + delimitador + tempListaCliente.get(i).getNome2() + "\n");
        }

        escritorDeArquivos.close();

    }

    private static void deletarClienteTemporario(int codCliente) {
        for (int i = 0; i < tempListaCliente.size(); i++) {
            if (tempListaCliente.get(i).getCodCliente() == codCliente) {
                tempListaCliente.remove(i);
            }

        }
    }

    private static void alterarCadstroClienteTemporario(int tempCodCliente, String tempNome, String tempEndereco, String
            tempNome2) {
        for (int i = 0; i < tempListaCliente.size(); i++) {
            if (tempListaCliente.get(i).getCodCliente() == codCliente) {

                Cliente cliente = new Cliente(tempCodCliente, tempNome, tempEndereco, tempNome2);
                tempListaCliente.set(i, cliente);

            }

        }

    }

    private static void imprimirListaTemporaria() {
        for (int i = 0; i < tempListaCliente.size(); i++) {
            System.out.println("Dados da lista: " + tempListaCliente.get(i).getCodCliente() + " Nome: "
                    + tempListaCliente.get(i).getNome());

        }

    }

    private static void cadastrarNaListaCliente(int tempCodCliente, String tempNome, String tempendereco, String
            tempNome2) {
        // Vai receber os dados dos vetores para cadastrar, um a um.
        Cliente cliente = new Cliente(tempCodCliente, tempNome, tempendereco, tempNome2);
        tempListaCliente.add(cliente);
    }

    public static void alterarCadastroCliente() throws IOException {

        System.out.println("Digite código do cliente:");
        codCliente = ler.nextInt();

        if (existeCodigo(codCliente)) {

            try {


                FileReader arq = new FileReader(caminhoArquivoCliente);
                BufferedReader br = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoCliente, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                String linha = br.readLine();

                linha = br.readLine();

                while (linha != null) {

                    String[] vect = linha.split(",");
                    tempCodCliente = Integer.parseInt(vect[0]);
                    tempNome = vect[1];
                    tempEndereco = vect[2];
                    tempNome2 = vect[3];


                    cadastrarNaListaCliente(tempCodCliente, tempNome, tempEndereco, tempNome2);

                    linha = br.readLine();

                }
                deletarClienteTemporario(codCliente);

                System.out.println("Informe o endereco novo do cliente: ");
                tempEndereco = ler.next().concat(ler.nextLine());

                recadastrarNoArquivoCliente();

                alterarCadstroClienteTemporario(codCliente, tempNome, tempEndereco, tempNome2);

                escritorDeArquivos.append(codCliente + delimitador + tempNome + delimitador + tempEndereco + delimitador + tempNome2 + "\n");


                escritorDeArquivos.close();
                System.out.println("Cadastro atualizado com sucesso!");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Código do cliente não existe no cadastro!");
        }


    }

    public static String buscarNomeCliente(int codCliente) {

        for (int i = 0; i < tempListaCliente.size(); i++) {
            if (tempListaCliente.get(i).getCodCliente() == codCliente) {
                return tempListaCliente.get(i).getNome();
            }
        }
        return "Ocorreu um error!";
    }

    public static void todosClientesTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoCliente);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoCliente, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
            PrintWriter escritorDeArquivos = new PrintWriter(buffer);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodCliente = Integer.parseInt(vect[0]);
                tempNome = vect[1];
                tempEndereco = vect[2];
                tempNome2 = vect[3];


                cadastrarNaListaCliente(tempCodCliente, tempNome, tempEndereco, tempNome2);

                linha = br.readLine();

            }


//                alterarCadstroDeRcebimentoTemporario(tempNumDoc, tempValorDoc, tempDataEmissao, tempDataVencimento, tempCodCliente);

//            escritorDeArquivos.append(tempNumDoc + delimitador + tempValorDoc + delimitador + tempDataEmissao + delimitador + tempDataVencimento + delimitador + codCliente + "\n");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

