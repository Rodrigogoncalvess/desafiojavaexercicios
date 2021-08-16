package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoEstacao {

    public static final String delimitador = ",";
    public static final String caminhoArquivoEstacao = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\ESTACAO";

    public static int codigoEstacao;
    public static String nomeEstacao;

    public static String[] vect;
    public static int tempCodigoEstacao;
    public static String tempNomeEstacao;


    Estacao estacao = new Estacao();

    static ArrayList<Estacao> tempListaArquivoEstacao = new ArrayList<>();

    public static Scanner ler = new Scanner(System.in);


    private static void cadastraNaListaEstacao(int tempCodigoEstacao, String tempNomeEstacao) {

        Estacao estacao = new Estacao(tempCodigoEstacao, tempNomeEstacao);
        tempListaArquivoEstacao.add(estacao);
    }

    public static void todasEstacoesTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoEstacao);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoEstacao, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigoEstacao = Integer.parseInt(vect[0]);
                tempNomeEstacao = vect[1];


                cadastraNaListaEstacao(tempCodigoEstacao, tempNomeEstacao);

                linha = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarEstacao() {

        while (true) {


            try {

                FileReader arq = new FileReader(caminhoArquivoEstacao);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoEstacao, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                System.out.println("Informe o código da estação: ");
                codigoEstacao = ler.nextInt();
                if (codigoEstacao <= 4) {

                    if (!existeCodigoEstacao(codigoEstacao)) {
                        System.out.println("Informe o nome da estaçao: ");
                        nomeEstacao = ler.next().concat(ler.nextLine());
                        if (!existeNomeEstacao(nomeEstacao)) {

                            escritorDeArquivos.append(codigoEstacao + delimitador + nomeEstacao + "\n");

                            escritorDeArquivos.close();

                        } else {
                            System.out.println("Nome de estação já se encontra cadastrado no sistema com outro código!");
                        }
                    } else {
                        System.out.println("Código já existe no sistema!");

                    }
                } else {
                    System.out.println("Código da estação é apenas de 1 a 4 não será possível realizar o cadastro com o código digitado! ");

                }

                int opcao = 0;
                while (opcao != 2) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcao = ler.nextInt();
                    if (opcao == 1) {

                        break;
                    } else if (opcao == 2) {
                        System.out.println("Obrigado por usar o programa de cadastro de estação climática!\n");

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

    private static void recadastrarNoArquivoEstacao() throws IOException {
        FileReader arq = new FileReader(caminhoArquivoEstacao);
        BufferedReader lerArq = new BufferedReader(arq);

        FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoEstacao, false);
        BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
        PrintWriter escritorDeArquivos = new PrintWriter(buffer);

        // Refaço o cabeçalho
        escritorDeArquivos
                .append("CódigoDaEstação" + delimitador + "NomeDaEstação \n");

        for (int i = 0; i < tempListaArquivoEstacao.size(); i++) {

            // De acordo com as posições da lista, recadastro um a um dependendo do I.
            escritorDeArquivos.append(tempListaArquivoEstacao.get(i).getCodigoEstaca() + delimitador
                    + tempListaArquivoEstacao.get(i).getNomeEstacao() + "\n");
        }

        escritorDeArquivos.close();

    }

    public static boolean existeCodigoEstacao(int codigoEstacao) {

        String caminho = caminhoArquivoEstacao;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodigoEstacao = Integer.parseInt(vect[0]);
                tempNomeEstacao = vect[1];


                linha = br.readLine();

                if (codigoEstacao == tempCodigoEstacao) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static boolean existeNomeEstacao(String nomeEstacao) {

        String caminho = caminhoArquivoEstacao;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodigoEstacao = Integer.parseInt(vect[0]);
                tempNomeEstacao = vect[1];


                if (tempNomeEstacao.equalsIgnoreCase(nomeEstacao)) {
                    return true;
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static void imprimirListaTemporaria() {

        for (int i = 0; i < tempListaArquivoEstacao.size(); i++) {
            System.out.println("Dados da lista: " + tempListaArquivoEstacao.get(i).getCodigoEstaca() + " Nome: "
                    + tempListaArquivoEstacao.get(i).getNomeEstacao());


        }


    }
}



