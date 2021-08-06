package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Um restaurante deseja criar um controle de qualidade sobre os pratos que oferece a seus clientes. Dessa
 * maneira, quer cadastrar algumas informações sobre as receitas, os ingredientes e os cozinheiros.
 * As informações necessárias são descritas a seguir:
 * <p>
 * Receita(codigo da receita, nome da receita, total de calorias a cada 100g, codigo_ cozinheiro)
 * Ingredientes (codigo do ingrediente, descricao)
 * Ingredientes/Receita(codigo do ingrediente, codigo da receita, quantidade, unidade de medida)
 * <p>
 * Crie um programa que:
 * ■ ■ cadastre os cozinheiros (existem apenas três nesse restaurante);
 * ■ ■ cadastre os ingredientes (existem no máximo 15);
 * ■ ■ cadastre as receitas (existem 20 receitas que utilizam no máximo três ingredientes cada);
 * ■ ■ mostre todas as receitas de determinado cozinheiro;
 * ■ ■ mostre todas as receitas cujo total de calorias esteja dentro de um intervalo especificado;
 * ■ ■ mostre o total de receitas elaboradas por cada um dos cozinheiros.
 */
public class Exercicio15 {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        boolean continuar = true;
        int opcaoMenu;
        boolean continuarMenu = true;
        int opcaoMenuContinuar;


        Cozinheiro cozinheiro = new Cozinheiro();
        Ingredientes ingredientes = new Ingredientes();
        Receita receita = new Receita();

        while (continuar) {

            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar  cozinheiro; \n2 - Cadastrar ingredientes;\n3 - Cadastrar receita;\n4 - Todas receita de um cozinheiro;\n5 - Todas as receitas cujo calorias está abaixo do intervalo especificado;\n6 - Total de receitas elaboradas por cada um dos cozinheiros");
                opcaoMenu = ler.nextInt();


                switch (opcaoMenu) {

                    case 1:
                        cozinheiro.cadastraCozinheiro();
                        break;
                    case 2:
                        ingredientes.cadastrarIngrediente();
                        break;
                    case 3:
                        receita.cadastrarReceita();
                        break;
                    case 4:
                        receita.todasReceitasDoCozineiro();
                        break;
                    case 5:
                        receita.intervaloDeCalorias();
                        break;
                    case 6:
                        receita.totalDeReceitasElaboradas();
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

    public static class Cozinheiro {
        int codigoCozinheiro;
        String nome;

        static final AtomicInteger idCozinheiro = new AtomicInteger(0);
        static ArrayList<Cozinheiro> listaCozinheiro = new ArrayList<>();

        public Cozinheiro(int codigoCozinheiro, String nome) {
            this.codigoCozinheiro = codigoCozinheiro;
            this.nome = nome;
        }

        public Cozinheiro() {

        }

        public void cadastraCozinheiro() {

            codigoCozinheiro = idCozinheiro.incrementAndGet();


            System.out.println("Informe o nome do cozinheiro");
            nome = ler.next();
            if (listaCozinheiro.size() < 3) {

                if (!validarCozinheiro(nome)) {
                    Cozinheiro cozinheiro = new Cozinheiro(codigoCozinheiro, nome);
                    listaCozinheiro.add(cozinheiro);
                } else {
                    System.out.println("Cozinheiro já se encontra cadstrado no sistema!");
                }
            } else {
                System.out.println("Não foi possível realizar o cadastro do cozinheiro, limite máximo para cadastro são 3!");
            }

        }

        public boolean validarCozinheiro(String nome) {
            for (int i = 0; i < listaCozinheiro.size(); i++) {
                if (listaCozinheiro.get(i).nome.equalsIgnoreCase(nome)) {
                    return true;
                }

            }
            return false;
        }

        public boolean validarCodigoDoCozinheiro(int codigoCozinheiro) {
            for (int i = 0; i < listaCozinheiro.size(); i++) {
                if (listaCozinheiro.get(i).codigoCozinheiro == codigoCozinheiro) {
                    return true;
                }

            }
            return false;
        }

    }

    public static class Receita {
        int codigoReceita;
        String nomeReceita;
        double calorias;
        int codigoCozinheiro;
        Ingredientes ingredientes = new Ingredientes();
        Cozinheiro cozinheiro = new Cozinheiro();


        public Receita(int codigoReceita, String nomeReceita, double calorias, String descricao, int codigoCozinheiro) {
            this.codigoReceita = codigoReceita;
            this.nomeReceita = nomeReceita;
            this.calorias = calorias;
            this.ingredientes.descricao = descricao;

            this.codigoCozinheiro = codigoCozinheiro;
        }


        public Receita() {
        }

        static ArrayList<Receita> listaReceita = new ArrayList<>();
        static final AtomicInteger idReceita = new AtomicInteger(0);


        public void cadastrarReceita() {


            codigoReceita = idReceita.incrementAndGet();


            if (quantidadeReceita()) {

                System.out.println("Informe o nome da receita");
                nomeReceita = ler.next();
                if (!validarNomeReceita(nomeReceita)) {

                    System.out.println("Informe o código do cozinheiro:");
                    codigoCozinheiro = ler.nextInt();

                    if (cozinheiro.validarCodigoDoCozinheiro(codigoCozinheiro)) {

                        for (int j = 0; j < 3; j++) {
                            System.out.println("Informe o " + (j + 1) + "° ingrediente da receita:");
                            ingredientes.descricao = ler.next();

                            while (!ingredientes.validarIngrediente(ingredientes.descricao)) {
                                System.out.println("Ingrediente digitado não existe em nosso cadastro!\nInforme o " + (j + 1) + "° ingrediente da receita:");
                                ingredientes.descricao = ler.next();

                            }


                        }
                        System.out.println("Informe a calorias da receita:");
                        calorias = ler.nextDouble();

                        Receita receita = new Receita(codigoReceita, nomeReceita, calorias, ingredientes.descricao, codigoCozinheiro);
                        listaReceita.add(receita);


                    } else {
                        System.out.println("Código do cozinheiro não existe!");
                    }
                } else {
                    System.out.println("Nome de receita já existe!");

                }

            } else {
                System.out.println("Limite de cadastro de 20 receitas com 3 ingredientes já foi preenchido!");
            }
        }

        public boolean quantidadeReceita() {
            if (codigoReceita < 20) {
                return true;
            }
            return false;
        }

        public boolean validarNomeReceita(String nomeReceita) {
            for (int i = 0; i < listaReceita.size(); i++) {
                if (listaReceita.get(i).nomeReceita.equalsIgnoreCase(nomeReceita)) {
                    return true;
                }
            }
            return false;
        }

        public void todasReceitasDoCozineiro() {
            System.out.println("Informe o nome do cozinheiro:");
            cozinheiro.nome = ler.next();

            if (cozinheiro.validarCozinheiro(cozinheiro.nome)) {
                if (cozinheiro.nome.equalsIgnoreCase(cozinheiro.nome)) {

                    for (int i = 0; i < listaReceita.size(); i++) {

                        System.out.println("Nome da receita: " + listaReceita.get(i).nomeReceita);

                    }
                }
            } else {
                System.out.println("Cozinheiro não existe no cadastro!");
            }
        }

        public void intervaloDeCalorias() {
            double inicio;
            double fim;
            boolean existe = false;

            System.out.println("Informe primeira faixa de calorias");
            inicio = ler.nextDouble();

            System.out.println("Informe segunda faixa de calorias");
            fim = ler.nextDouble();

            while (inicio > fim) {

                System.out.println("Segunda faixa deve ser maior que a primeira");

                System.out.println("Informe segunda faixa de calorias");
                fim = ler.nextDouble();
            }

            for (int i = 0; i < listaReceita.size(); i++) {
                if (listaReceita.get(i).calorias >= inicio && listaReceita.get(i).calorias <= fim) {

                    System.out.println("Nome da receita que teve menos calorias: " + listaReceita.get(i).nomeReceita);
                    existe = true;
                }
            }
            if (!existe) {
                System.out.println("Não existe faxia especificada de calorias");

            }
        }

        public void totalDeReceitasElaboradas() {
            int contador1 = 0;
            int somaContador1 = 0;
            String nome1 = "";
            int contador2 = 0;
            int somaContador2 = 0;
            String nome2 = "";
            int contador3 = 0;
            int somaContador3 = 0;
            String nome3 = "";


            for (int i = 0; i < listaReceita.size(); i++) {

                if (listaReceita.get(i).codigoCozinheiro == 1) {
                    contador1++;
                    nome1 = Cozinheiro.listaCozinheiro.get(0).nome;
                }

                if (listaReceita.get(i).codigoCozinheiro == 2) {
                    contador2++;
                    nome2 = Cozinheiro.listaCozinheiro.get(1).nome;
                }

                if (listaReceita.get(i).codigoCozinheiro == 3) {
                    contador3++;
                    nome3 = Cozinheiro.listaCozinheiro.get(2).nome;

                }
            }
            somaContador1 += contador1;
            somaContador3 += contador3;
            somaContador2 += contador2;

            if (cozinheiro.validarCozinheiro(nome1)) {
                System.out.println("Total de receita feita pelo " + nome1 + " foi: " + somaContador1);
            }
            if (cozinheiro.validarCozinheiro(nome2)) {
                System.out.println("Total de receita feita pelo " + nome2 + " foi: " + somaContador2);
            }
            if (cozinheiro.validarCozinheiro(nome3)) {
                System.out.println("Total de receita feita pelo " + nome3 + " foi: " + somaContador3);
            }
        }


    }

    public static class Ingredientes {
        int codigoIngrediente;
        String descricao;

        public static ArrayList<Ingredientes> listaIngredientes = new ArrayList<>();
        static final AtomicInteger idIngrediente = new AtomicInteger(0);

        public Ingredientes(int codigoIngrediente, String descricao) {
            this.codigoIngrediente = codigoIngrediente;
            this.descricao = descricao;
        }

        public Ingredientes() {
        }

        public void cadastrarIngrediente() {

            codigoIngrediente = idIngrediente.incrementAndGet();

            System.out.println("Informe o nome do ingrediente");
            descricao = ler.next();

            if (listaIngredientes.size() < 15) {

                if (!validarIngrediente(descricao)) {
                    Ingredientes ingredientes = new Ingredientes(codigoIngrediente, descricao);
                    listaIngredientes.add(ingredientes);
                } else {
                    System.out.println("Ingrediente já se encontra cadstrado no sistema!");
                }
            } else {
                System.out.println("Não foi possível realizar o cadastro do ingrediente, limite máximo para cadastro são 15!");
            }

        }

        public boolean validarIngrediente(String descricao) {
            for (int i = 0; i < listaIngredientes.size(); i++) {
                if (listaIngredientes.get(i).descricao.equalsIgnoreCase(descricao)) {
                    return true;
                }

            }
            return false;
        }

    }

}
