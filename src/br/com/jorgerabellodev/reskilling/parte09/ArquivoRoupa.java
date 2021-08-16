package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoRoupa {

    public static final String caminhoArquivoRoupa = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\ROUPA";

    public static int codigoRoupa;
    public static String descricaoRoupa;
    public static int codigoEstilista;
    public static int codigoEstacao;
    public static int ano;


    public static String[] vect;
    public static int tempCodigoRoupa;
    public static String tempDescricaoRoupa;
    public static int tempCodigoEstilista;
    public static int tempCodigoEstacao;
    public static int tempAno;


    static ArrayList<Roupa> tempListaArquivoRoupa = new ArrayList<>();


    public static Scanner ler = new Scanner(System.in);

    static ArquivoEstacao arquivoEstacao = new ArquivoEstacao();
    static ArquivoEstilista arquivoEstilista = new ArquivoEstilista();

    static Estilista estilista = new Estilista();

    private static void cadastraNaListaRoupa(int tempCodigoRoupa, String tempDescricaoRoupa, int tempCodigoEstilista, int tempCodigoEstacao, int tempAno) {

        Roupa roupa = new Roupa(tempCodigoRoupa, tempDescricaoRoupa, tempCodigoEstilista, tempCodigoEstacao, tempAno);
        tempListaArquivoRoupa.add(roupa);
    }


    public static void todasRoupasTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoRoupa);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRoupa, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigoRoupa = Integer.parseInt(vect[0]);
                tempDescricaoRoupa = vect[1];
                tempCodigoEstilista = Integer.parseInt(vect[2]);
                tempCodigoEstacao = Integer.parseInt(vect[3]);
                tempAno = Integer.parseInt(vect[4]);


                cadastraNaListaRoupa(tempCodigoRoupa, tempDescricaoRoupa, tempCodigoEstilista, tempCodigoEstacao, tempAno);

                linha = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarRoupa() {

        while (true) {


            try {

                FileReader arq = new FileReader(caminhoArquivoRoupa);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoRoupa, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                System.out.println("Informe o código da roupa: ");
                codigoRoupa = ler.nextInt();


                if (!existeCodigoRoupa(codigoRoupa)) {
                    System.out.println("Informe a descrição da roupa: ");
                    descricaoRoupa = ler.next().concat(ler.nextLine());

                    if (!existeDescricaoRoupa(descricaoRoupa)) {

                        System.out.println("Digite o código do estilista:");
                        codigoEstilista = ler.nextInt();

                        if (arquivoEstilista.existeCodigoEstilista(codigoEstilista)) {

                            System.out.println("Digite o código da estação climática:");
                            codigoEstacao = ler.nextInt();

                            if (arquivoEstacao.existeCodigoEstacao(codigoEstacao)) {

                                System.out.println("Digite o ano:");
                                ano = ler.nextInt();

                                escritorDeArquivos.append(codigoRoupa + arquivoEstacao.delimitador + descricaoRoupa + arquivoEstacao.delimitador +
                                        codigoEstilista + arquivoEstacao.delimitador + codigoEstacao + arquivoEstacao.delimitador + ano + "\n");

                                escritorDeArquivos.close();
                            } else {
                                System.out.println("Código da estação climática informado não existe no cadastro!");
                            }
                        } else {
                            System.out.println("Código do estilista informado não existe no cadastro!");
                        }

                    } else {
                        System.out.println("Descrição da roupa já se encontra cadastrado no sistema com outro código!");
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
                        System.out.println("Obrigado por usar o programa!");

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

    public static boolean existeCodigoRoupa(int codigoRoupa) {

        String caminho = caminhoArquivoRoupa;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigoRoupa = Integer.parseInt(vect[0]);
                tempDescricaoRoupa = vect[1];
                tempCodigoEstilista = Integer.parseInt(vect[2]);
                tempCodigoEstacao = Integer.parseInt(vect[3]);
                tempAno = Integer.parseInt(vect[4]);

                linha = br.readLine();

                if (codigoRoupa == tempCodigoRoupa) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static boolean existeDescricaoRoupa(String descricaoRoupa) {

        String caminho = caminhoArquivoRoupa;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigoRoupa = Integer.parseInt(vect[0]);
                tempDescricaoRoupa = vect[1];
                tempCodigoEstilista = Integer.parseInt(vect[2]);
                tempCodigoEstacao = Integer.parseInt(vect[3]);
                tempAno = Integer.parseInt(vect[4]);


                if (tempDescricaoRoupa.equalsIgnoreCase(descricaoRoupa)) {
                    return true;
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static void todasRoupasEstacao() throws IOException {

        System.out.println("Digite o código da estação que deseja obter o relatório completo:");
        codigoEstacao = ler.nextInt();

        if (arquivoEstacao.existeCodigoEstacao(codigoEstacao)) {

            for (int i = 0; i < tempListaArquivoRoupa.size(); i++) {
                if (tempListaArquivoRoupa.get(i).getCodigoEstacao() == codigoEstacao) {
                       /*  rrrrrrrrrrrrrrrrrrrrrrrrrr */
                    arquivoEstilista.buscarEstilistaPorCodigo(tempListaArquivoRoupa.get(i).getCodigoEstilista());
                    System.out.println("Descrição da roupa: " + tempListaArquivoRoupa.get(i).getDescricaoRoupa()+"\n");


                }
            }
        } else {
            System.out.println("Não possui nenhuma roupa cadastrada nesta estação!");

        }


    }

}
