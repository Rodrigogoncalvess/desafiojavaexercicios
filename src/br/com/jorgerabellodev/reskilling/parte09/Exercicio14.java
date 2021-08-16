package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Faça um programa que apresente o seguinte menu de opções:
 * 1. Criar
 * 2. Incluir
 * 3. Mostrar
 * 4. Sair
 * Digite a opção desejada:
 * Na opção 1: criar um arquivo com os campos: numero, nome, nota1 e nota2 .
 * Na opção 2: incluir novos registros, onde o valor de número, nome, nota1 e nota2 são fornecidos pelo usuário (não podem ser gravados dois registros com o mesmo número).
 * Na opção 3: mostrar todos os registros cadastrados, calcular e apresentar a média das notas de cada registro.
 */
public class Exercicio14 {


    static Scanner ler = new Scanner(System.in);
    static final String caminhoArquivos = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\";
    static final String delimitador = ",";
    static final String caminhoArquivo = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\ARQUIVO";

    private static int numero;
    private static String nome;
    private static double nota1;
    private static double nota2;

    static String[] vect;
    static int tempNumero;
    static String tempNome;
    static double tempNota1;
    static double tempNota2;

    static ArrayList<Arquivo> tempListaArquivo = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int opcaoMenu = 0;
        boolean continuarMenu = true;
        int opcaoMenuContinuar;


        while (opcaoMenu != 4) {


            System.out.println("\nEscolha uma opçaõ: \n1 - Criar; \n2 - Incluir;\n3 - Mostrar;\n4 - Sair.");
            opcaoMenu = ler.nextInt();


            switch (opcaoMenu) {

                case 1:
                    criarArquivo("ARQUIVO", opcaoMenu);
                    break;
                case 2:
                    cadastrarArquivo();
                    break;
                case 3:
                    mostrar();

                    break;
                case 4:
                    System.out.println("Programa finalizado!");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;


            }
            while (continuarMenu) {
                System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                opcaoMenuContinuar = ler.nextInt();
                if (opcaoMenuContinuar == 1) {

                    break;
                } else if (opcaoMenuContinuar == 2) {
                    System.out.println("Obrigado por usar o programa!");

                    return;
                } else {
                    System.out.println("Opção inválida");
                }
            }
        }

    }


    static void criarArquivo(String nomeArquivo, int opcaoMenu) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminhoArquivos + nomeArquivo));

        if (opcaoMenu == 1) {
            buffWrite.append("Número " + delimitador + "Nome " + delimitador + "Nota1 " + delimitador + "Nota2 \n");

            System.out.println("Arquivo com o nome de " + nomeArquivo + " criado no local " + caminhoArquivos);
            buffWrite.close();
            return;
        }
    }

    static void cadastrarArquivo() {

        while (true) {

            try {

                FileReader arq = new FileReader(caminhoArquivo);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivo, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);

                System.out.println("Informe o número: ");
                numero = ler.nextInt();
                if (!existeNumero(numero)) {
                    System.out.println("Informe o nome : ");
                    nome = ler.next().concat(ler.nextLine());
                    System.out.println("Informe a nota n° 1: ");
                    nota1 = ler.nextDouble();

                    System.out.println("Informe a nota n° 2: ");
                    nota2 = ler.nextDouble();

                    escritorDeArquivos.append(numero + delimitador + nome + delimitador + nota1 + delimitador + nota2 + "\n");

                    escritorDeArquivos.close();

                } else {
                    System.out.println("Número já existe cadastrado no sistema!");
                }

                int opcao = 0;
                while (opcao != 2) {
                    System.out.println("\n\nDeseja continuar cadastrando no arquivo, digite uma opção: 1 - SIM / 2 - NÃO");
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

    static boolean existeNumero(int numero) {

        String caminho = caminhoArquivo;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();
            linha = br.readLine();

            while (linha != null) {

                vect = linha.split(",");
                tempNumero = Integer.parseInt(vect[0]);
                tempNome = vect[1];
                tempNota1 = Double.parseDouble(vect[2]);
                tempNota2 = Double.parseDouble(vect[3]);

                linha = br.readLine();

                if (numero == tempNumero) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    static void cadastraNaListaArquivo(int tempNumero, String tempNome, double tempNota1, double tempNota2) {

        Arquivo arquivo = new Arquivo(tempNumero, tempNome, tempNota1, tempNota2);
        tempListaArquivo.add(arquivo);
    }


    static void arquivoTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivo, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempNumero = Integer.parseInt(vect[0]);
                tempNome = vect[1];
                tempNota1 = Double.parseDouble(vect[2]);
                tempNota2 = Double.parseDouble(vect[3]);


                cadastraNaListaArquivo(tempNumero, tempNome, tempNota1, tempNota2);

                linha = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void mostrar() throws IOException {
        double media;
        arquivoTempararios();
        for (int i = 0; i < tempListaArquivo.size(); i++) {
            System.out.println("Número: " + tempListaArquivo.get(i).getNumero() + "\nNome: " + tempListaArquivo.get(i).getNome() + "\nNota 1: " + tempListaArquivo.get(i).getNota1() + "\nNota 2: " + tempListaArquivo.get(i).getNota2());
            if (tempListaArquivo.get(i).getNumero() == tempListaArquivo.get(i).getNumero()) {
                media = (tempListaArquivo.get(i).getNota1() + tempListaArquivo.get(i).getNota2()) / 2;
                System.out.println(tempListaArquivo.get(i).getNome() + " teve a média: " + media + "\n");
            }
        }

    }
}

