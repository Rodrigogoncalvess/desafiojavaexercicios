package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoEstilista {


    public static final String caminhoArquivoEstilista = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\ESTILISTA";

    public static int codigoEstilista;
    public static String nomeEstilista;
    public static double salario;

    public static String[] vect;
    public static int tempCodigoEstilista;
    public static String tempNomeEstilista;
    public static double tempSalario;

    static ArrayList<Estilista> tempListaArquivoEstilista = new ArrayList<>();

    public static Scanner ler = new Scanner(System.in);

    static ArquivoEstacao arquivoEstacao = new ArquivoEstacao();


    private static void cadastraNaListaEstilista(int tempCodigoEstilista, String tempNomeEstilista, double tempSalario) {

        Estilista estilista = new Estilista(tempCodigoEstilista, tempNomeEstilista, tempSalario);
        tempListaArquivoEstilista.add(estilista);
    }

    public static void todosEstilistasTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoEstilista);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoEstilista, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodigoEstilista = Integer.parseInt(vect[0]);
                tempNomeEstilista = vect[1];
                tempSalario = Double.parseDouble(vect[2]);


                cadastraNaListaEstilista(tempCodigoEstilista, tempNomeEstilista, tempSalario);

                linha = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarEstilista() {

        while (true) {


            try {

                FileReader arq = new FileReader(caminhoArquivoEstilista);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoEstilista, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                System.out.println("Informe o código do estilista: ");
                codigoEstilista = ler.nextInt();

                if (!existeCodigoEstilista(codigoEstilista)) {
                    System.out.println("Informe o nome do estilista: ");
                    nomeEstilista = ler.next().concat(ler.nextLine());
                    if (!existeNomeEstilista(nomeEstilista)) {

                        System.out.println("Informe o salário do estilista:");
                        salario = ler.nextDouble();

                        escritorDeArquivos.append(codigoEstilista + arquivoEstacao.delimitador + nomeEstilista + arquivoEstacao.delimitador + salario + "\n");

                        escritorDeArquivos.close();

                    } else {
                        System.out.println("Nome do estilista já se encontra cadastrado no sistema com outro código!");
                    }
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
                        System.out.println("Obrigado por usar o programa de cadastro de estilista!\n");

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

    public static boolean existeCodigoEstilista(int codigoEstilista) {

        String caminho = caminhoArquivoEstilista;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodigoEstilista = Integer.parseInt(vect[0]);
                tempNomeEstilista = vect[1];
                tempSalario = Double.parseDouble(vect[2]);


                linha = br.readLine();

                if (codigoEstilista == tempCodigoEstilista) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static boolean existeNomeEstilista(String nomeEstilista) {

        String caminho = caminhoArquivoEstilista;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempCodigoEstilista = Integer.parseInt(vect[0]);
                tempNomeEstilista = vect[1];
                tempSalario = Double.parseDouble(vect[2]);


                if (tempNomeEstilista.equalsIgnoreCase(nomeEstilista)) {
                    return true;
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void buscarEstilistaPorCodigo(int codigoEstilista) {
        for (int i = 0; i < tempListaArquivoEstilista.size(); i++) {
            if (tempListaArquivoEstilista.get(i).getCodigoEstilista() == codigoEstilista) {
                System.out.println("Nome estilista: " + tempListaArquivoEstilista.get(i).getNomeEstilista());

            }

        }

    }


}
