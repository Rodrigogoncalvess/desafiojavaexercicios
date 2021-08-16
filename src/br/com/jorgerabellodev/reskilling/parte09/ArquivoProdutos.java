package br.com.jorgerabellodev.reskilling.parte09;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoProdutos {

    public static final String delimitador = ",";
    public static final String caminhoArquivoProduto = "C:\\Users\\rodrigo.j.goncalves\\Desktop\\desafiojavaexercicios\\desafiojavaexercicios\\src\\br\\com\\jorgerabellodev\\reskilling\\parte09\\PRODUTOS.DAT";

    public static int codigo;
    public static String descricao;
    public static double preco;


    public static String[] vect;
    public static int tempCodigo;
    public static String tempDescricao;
    public static double tempPreco;


    static ArrayList<Produtos> tempListaArquivoProdutos = new ArrayList<>();


    public static Scanner ler = new Scanner(System.in);


    static void cadastraNaListaProduto(int tempCodigo, String tempDescricao, double tempPreco) {

        Produtos produtos = new Produtos(tempCodigo, tempDescricao, tempPreco);
        tempListaArquivoProdutos.add(produtos);
    }

    public static void todasProdutosTempararios() throws IOException {

        try {


            FileReader arq = new FileReader(caminhoArquivoProduto);
            BufferedReader br = new BufferedReader(arq);

            FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoProduto, true);
            BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);


            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigo = Integer.parseInt(vect[0]);
                tempDescricao = vect[1];
                tempPreco = Double.parseDouble(vect[2]);


                cadastraNaListaProduto(tempCodigo, tempDescricao, tempPreco);

                linha = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarProdutos() {

        while (true) {


            try {

                FileReader arq = new FileReader(caminhoArquivoProduto);
                BufferedReader lerArq = new BufferedReader(arq);

                FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoProduto, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);


                System.out.println("Informe o código do produto: ");
                codigo = ler.nextInt();


                if (!existeCodigoProduto(codigo)) {
                    System.out.println("Informe a descrição do produto: ");
                    descricao = ler.next().concat(ler.nextLine());

                    if (!existeDescricaoProduto(descricao)) {

                        System.out.println("Digite o valor do produto:");
                        preco = ler.nextInt();


                        escritorDeArquivos.append(codigo + delimitador + descricao + delimitador + preco + "\n");

                        escritorDeArquivos.close();


                    } else {
                        System.out.println("Descrição do produto já se encontra cadastrado no sistema com outro código!");
                    }
                } else {
                    System.out.println("Código informado já existe no sistema!");

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

    static boolean existeCodigoProduto(int codigo) {

        String caminho = caminhoArquivoProduto;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigo = Integer.parseInt(vect[0]);
                tempDescricao = vect[1];
                tempPreco = Double.parseDouble(vect[2]);

                linha = br.readLine();

                if (codigo == tempCodigo) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    static boolean existeDescricaoProduto(String descricao) {

        String caminho = caminhoArquivoProduto;


        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            linha = br.readLine();

            while (linha != null) {

                String[] vect = linha.split(",");
                tempCodigo = Integer.parseInt(vect[0]);
                tempDescricao = vect[1];
                tempPreco = Double.parseDouble(vect[2]);


                if (tempDescricao.equalsIgnoreCase(descricao)) {
                    return true;
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void buscarProdutoMaiorQueQuinhetos() {

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            if (tempListaArquivoProdutos.get(i).getPreco() > 500) {
                System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + tempListaArquivoProdutos.get(i).getPreco() + "\n");
            }
        }

    }

    public void aumentarPrecoEmQuinzePorcento() {
        double aumentarPreco;
        final double aumento = 0.15;

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {

            aumentarPreco = (tempListaArquivoProdutos.get(i).getPreco() * aumento) + tempListaArquivoProdutos.get(i).getPreco();
            System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + aumentarPreco + "\n");
        }
    }

    public void aumentarPrecoEmDezReais() {
        double aumentoPreco;
        final double aumento = 10;

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            if (tempListaArquivoProdutos.get(i).getPreco() > 100) {
                aumentoPreco = tempListaArquivoProdutos.get(i).getPreco() + aumento;
                System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + aumentoPreco + "\n");
            }
        }
    }

    public void buscarProdutoPorLetra() {

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            /*outra forma de fazer a pesquisa pela primeira letra */
//            char letra = tempListaArquivoProdutos.get(i).getDescricao().toUpperCase().charAt(0);
            if (tempListaArquivoProdutos.get(i).getDescricao().toUpperCase().startsWith("M")) {
//            if ( letra == 77) {
                System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + tempListaArquivoProdutos.get(i).getPreco() + "\n");
            }
        }

    }

    public void excluirProduto() {

        System.out.println("Digite código do produto:");
        codigo = ler.nextInt();


        if (existeCodigoProduto(codigo)) {

            try {

                FileReader fr = new FileReader(caminhoArquivoProduto);
                BufferedReader br = new BufferedReader(fr);

                String linha = br.readLine();
                linha = br.readLine();

                if (!linha.isEmpty()) {

                    while (linha != null) {

                        String[] vect = linha.split(",");
                        tempCodigo = Integer.parseInt(vect[0]);
                        tempDescricao = vect[1];
                        tempPreco = Double.parseDouble(vect[2]);

                        cadastraNaListaProduto(tempCodigo, tempDescricao, tempPreco);

                        linha = br.readLine();

                    }
                    deletarProdutoTemporario(codigo);
                    recadastrarNoArquivoProduto();

                    System.out.println("Produto excuído do cadastrado!");

                } else {
                    System.out.println("Lista está vázia!");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Código do Produto não existe no cadastro!");
        }

    }

    public void deletarProdutoTemporario(int codigo) {
        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            if (tempListaArquivoProdutos.get(i).getCodigo() == codigo) {
                tempListaArquivoProdutos.remove(i);
            }

        }
    }

    public void recadastrarNoArquivoProduto() throws IOException {
        FileReader arq = new FileReader(caminhoArquivoProduto);
        BufferedReader lerArq = new BufferedReader(arq);

        FileWriter criadorDeArquivos = new FileWriter(caminhoArquivoProduto, false);
        BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
        PrintWriter escritorDeArquivos = new PrintWriter(buffer);


        escritorDeArquivos
                .append("Código" + delimitador + "Descrição" + delimitador + "Preço\n");

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {

            escritorDeArquivos.append(tempListaArquivoProdutos.get(i).getCodigo() + delimitador
                    + tempListaArquivoProdutos.get(i).getDescricao() + delimitador + tempListaArquivoProdutos.get(i).getPreco() + "\n");
        }

        escritorDeArquivos.close();

    }

    public void consultarProdutoPrecoMenorQuinze() {
        final double valorMenor = 15.0;
        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            if (tempListaArquivoProdutos.get(i).getPreco() < valorMenor) {
                System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + tempListaArquivoProdutos.get(i).getPreco() + "\n");
            }
        }
    }

    public void buscarProdutoPorLetraDigitada() {
        char letraConvertida;
        int precoProduto;


        System.out.println("Digite uma letra para buscar todos produtos iniciado com a letra digitada:");
        descricao = ler.next();

        letraConvertida = descricao.toUpperCase().charAt(0);

        if (existeLetraDigitada(letraConvertida)) {


            System.out.println("Digite o 1° valor do documento:");
            tempPreco = ler.nextInt();

            System.out.println("Digite o 2° valor do documento:");
            precoProduto = ler.nextInt();

            for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
                if (tempListaArquivoProdutos.get(i).getPreco() > tempPreco && tempListaArquivoProdutos.get(i).getPreco() < precoProduto) {
                    System.out.println("Código : " + tempListaArquivoProdutos.get(i).getCodigo() +
                            "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() +
                            "\nValor Produto: " + tempListaArquivoProdutos.get(i).getPreco() + "\n");
                }
            }

        } else {
            System.out.println("Não existe nenhum produto cadastrado com a letra digitada!");
        }


    }


    static boolean existeLetraDigitada(char letraConvertida) {

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
            if (tempListaArquivoProdutos.get(i).getDescricao().toUpperCase().charAt(0) == letraConvertida) {
                return true;
            }
        }
        return false;
    }

    public void excluirProdutosComPrecoSuperiorDuzentos() {


        try {

            FileReader fr = new FileReader(caminhoArquivoProduto);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            linha = br.readLine();

            if (!linha.isEmpty()) {

                while (linha != null) {

                    String[] vect = linha.split(",");
                    tempCodigo = Integer.parseInt(vect[0]);
                    tempDescricao = vect[1];
                    tempPreco = Double.parseDouble(vect[2]);

                    cadastraNaListaProduto(tempCodigo, tempDescricao, tempPreco);

                    linha = br.readLine();

                    deletarValorMaiorQueDuzentos();


                }

                recadastrarNoArquivoProduto();


            } else {
                System.out.println("Lista está vázia!");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    static boolean deletarValorMaiorQueDuzentos() {

        for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {

            if (tempListaArquivoProdutos.get(i).getPreco() > 200) {
                System.out.println("Produto removido da lista:");
                System.out.println("Código do produto: " + tempListaArquivoProdutos.get(i).getCodigo() + "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() + "\nValor do Produto: " + tempListaArquivoProdutos.get(i).getPreco() + "\n");

                tempListaArquivoProdutos.remove(i);
                return true;
            }

        }
        return false;
    }

    public void percentualDesconto() {
        double desconto;
        double precoProduto;
        double valorAposdesconto;

        System.out.println("digite o percentual de desconto:");
        desconto = ler.nextDouble();
        if (desconto <= 0.20) {
            System.out.println("Digite o 1° valor do documento:");
            tempPreco = ler.nextInt();

            System.out.println("Digite o 2° valor do documento:");
            precoProduto = ler.nextInt();

            for (int i = 0; i < tempListaArquivoProdutos.size(); i++) {
                if (tempListaArquivoProdutos.get(i).getPreco() > tempPreco && tempListaArquivoProdutos.get(i).getPreco() < precoProduto) {
                    valorAposdesconto = tempListaArquivoProdutos.get(i).getPreco() - (tempListaArquivoProdutos.get(i).getPreco() * desconto);
                    System.out.println("Código : " + tempListaArquivoProdutos.get(i).getCodigo() +
                            "\nDescrição do produto: " + tempListaArquivoProdutos.get(i).getDescricao() +
                            "\nValor Produto: " + tempListaArquivoProdutos.get(i).getPreco() +
                            "\nDesconto de >>> " + desconto + " %" +
                            "\nValor do produto após o desconto: " + valorAposdesconto + "\n");
                }
            }

        } else {
            System.out.println("Desconto ultrapassou o percentual permitido que é de 20%!");
        }
    }
}