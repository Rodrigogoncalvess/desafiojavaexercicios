package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Considere as informações a seguir:
 * ■ ■ Estilista (código do estilista, nome do estilista, salário).
 * ■ ■ Roupa (código da roupa, descrição da roupa, código do estilista, código da estação, ano).
 * ■ ■ Estação (código da estação, nome da estação).
 * Sabe-se que nessa indústria de confecção existem três estilistas. Faça um programa que:
 * a) crie uma rotina para cadastrá-los;
 * b) crie uma rotina para cadastrar as estações climáticas (sabendo que são duas: primavera-verão e outono-inverno);
 * c) crie uma rotina para cadastrar as roupas (lembre-se de que estilista e estação devem ter sido previamente cadastrados) — no máximo dez roupas por estação;
 * d) crie um relatório que mostre todas as roupas de determinada estação (informando, inclusive, o nome do estilista que a desenhou).
 */
public class Exercicio13 {
    static Scanner teclado = new Scanner(System.in);

    static ArrayList<Estilista> listaEstilista = new ArrayList<Estilista>();
    static ArrayList<Estacao> listaEstacao = new ArrayList<Estacao>();

    public static void main(String[] args) {
        boolean continuar = true;
        int opcaoMenu;

        Estilista estilista = new Estilista();
        Roupa roupa = new Roupa();
        Estacao estacao = new Estacao();

        while (continuar) {

            System.out.println("\nFerramenta de cadastro\n");
            System.out.println("1 - Cadastrar estilista");
            System.out.println("2 - Cadastrar estação");
            System.out.println("3 - Cadastrar roupa");
            System.out.println("4 - Relatório de roupas");
            System.out.println("5 - Sair do programa");
            System.out.println("\n\nInforme a opção desejada:\n");
            opcaoMenu = teclado.nextInt();

            switch (opcaoMenu) {
                case 1:
                    estilista.cadastrarEstilista();
                    break;
                case 2:
                    estacao.cadastrarEstacao();
                    break;
                case 3:
                    roupa.cadastrarRoupa();
                    break;

                case 4:
                    roupa.relatorioRoupa();
                    break;
                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
        System.out.println("Obrigado por usar o programa!");
    }

    static class Estilista {
        private static final AtomicInteger id = new AtomicInteger(0);
        int codEstilista;
        String nomeEstilista;
        Double salarioEstilista;

        public Estilista(int codEstilista, String nomeEstilista, Double salarioEstilista) {
            super();
            this.codEstilista = codEstilista;
            this.nomeEstilista = nomeEstilista;
            this.salarioEstilista = salarioEstilista;
        }

        public Estilista() {
        }

        public void cadastrarEstilista() {

            codEstilista = id.incrementAndGet();

            System.out.println("Informe o nome do estilista: ");
            nomeEstilista = teclado.next().concat(teclado.nextLine());

            System.out.println("Informe o salário do estilista: ");
            salarioEstilista = teclado.nextDouble();

            Estilista estilista = new Estilista(codEstilista, nomeEstilista, salarioEstilista);
            listaEstilista.add(estilista);

            System.out.println("Cadastro realizado!");

        }

        public int buscarEstilista(String nomeEstilista) {
            for (int i = 0; i < listaEstilista.size(); i++) {
                if (listaEstilista.get(i).nomeEstilista.equalsIgnoreCase(nomeEstilista)) {
                    return listaEstilista.get(i).codEstilista;

                }
            }
            return -1;

        }

        public String buscarNomeEstilista(int codEstilista) {
            for (int i = 0; i < listaEstilista.size(); i++) {
                if (listaEstilista.get(i).codEstilista == codEstilista) {
                    return listaEstilista.get(i).nomeEstilista;

                }
            }
            return "Ocorreu um erro!";

        }

    }

    static class Roupa {
        private static final AtomicInteger id = new AtomicInteger(0);
        int codRoupa;
        String descricaoRoupa;
        int codEstilista;
        int codEstacao;
        int ano;

        String tempNomeEstilista;
        String tempNomeEstacao;

        ArrayList<Roupa> listaRoupaPV = new ArrayList<Roupa>();
        ArrayList<Roupa> listaRoupaOI = new ArrayList<Roupa>();

        Estilista estilista = new Estilista();
        Estacao estacao = new Estacao();

        public Roupa(int codRoupa, String descricaoRoupa, int codEstilista, int codEstacao, int ano) {
            super();
            this.codRoupa = codRoupa;
            this.descricaoRoupa = descricaoRoupa;
            this.codEstilista = codEstilista;
            this.codEstacao = codEstacao;
            this.ano = ano;
        }

        public Roupa() {
        }

        public void cadastrarRoupa() {
            if ((listaEstilista.size()) > 0 && (listaEstacao.size() > 0)) {

                codRoupa = id.incrementAndGet();

                System.out.println("Informe o nome do estilista: ");
                tempNomeEstilista = teclado.next().concat(teclado.nextLine());
                codEstilista = estilista.buscarEstilista(tempNomeEstilista);

                while (codEstilista == -1) {
                    System.out.println("Estilista não existe na base de dados, digite novamente!");
                    System.out.println("Informe o nome do estilista: ");
                    tempNomeEstilista = teclado.next().concat(teclado.nextLine());
                    codEstilista = estilista.buscarEstilista(tempNomeEstilista);
                }

                System.out.println("Informe uma das opções: ");
                System.out.println("1 - primavera-verão");
                System.out.println("2 - outono-inverno");
                codEstacao = teclado.nextInt();

                while (!(codEstacao == 1) && !(codEstacao == 2)) {
                    System.out.println("Opção inválida!!");

                    System.out.println("1 - primavera-verão");
                    System.out.println("2 - outono-inverno");
                    codEstacao = teclado.nextInt();
                }

                if (quantidadeRoupaEstacaoPV() > 10 && codEstacao == 1) {
                    System.out.println("Limite de de roupa por estação (primavera-verão) atingido");
                    return;
                } else if (quantidadeRoupaEstacaoOI() > 10 && codEstacao == 2) {
                    System.out.println("Limite de de roupa por estação (outono-inverno) atingido");
                    return;
                }

                System.out.println("Informe a descrição da roupa: ");
                descricaoRoupa = teclado.next().concat(teclado.nextLine());

                System.out.println("Informe o ano da roupa: ");
                ano = teclado.nextInt();

                Roupa roupa = new Roupa(codRoupa, descricaoRoupa, codEstilista, codEstacao, ano);

                if (codEstacao == 1) {
                    listaRoupaPV.add(roupa);
                } else {
                    listaRoupaOI.add(roupa);
                }

            } else {
                System.out.println(
                        "Problema ao cadastrar a roupa, estação ou estilistas devem ser previamentes cadastrados");
            }

        }

        public int quantidadeRoupaEstacaoPV() {
            return listaRoupaPV.size();
        }

        public int quantidadeRoupaEstacaoOI() {
            return listaRoupaOI.size();
        }

        public void relatorioRoupa() {

            System.out.println("Informe a estação que deseja buscar o relatório de roupas");

            System.out.println("Informe uma das opções: ");
            System.out.println("1 - primavera-verão");
            System.out.println("2 - outono-inverno");
            codEstacao = teclado.nextInt();

            while (!(codEstacao == 1) && !(codEstacao == 2)) {
                System.out.println("Opção inválida!!");

                System.out.println("1 - primavera-verão");
                System.out.println("2 - outono-inverno");
                codEstacao = teclado.nextInt();
            }

            if (codEstacao == 1) {
                for (int i = 0; i < listaRoupaPV.size(); i++) {
                    tempNomeEstilista = estilista.buscarNomeEstilista(listaRoupaPV.get(i).codEstilista);
                    tempNomeEstacao = estacao.buscarNomeEstacao(listaRoupaPV.get(i).codEstacao);

                    System.out.println("Código do estilista: " + listaRoupaPV.get(i).codEstilista);
                    System.out.println("Nome do estilista: " + tempNomeEstilista);
                    System.out.println("Código do estação: " + listaRoupaPV.get(i).codEstacao);
                    System.out.println("Nome da estação: " + tempNomeEstacao);
                    System.out.println("Descrição da roupa: " + listaRoupaPV.get(i).descricaoRoupa);
                    System.out.println("Ano da roupa: " + listaRoupaPV.get(i).ano);
                }
            } else {
                for (int i = 0; i < listaRoupaOI.size(); i++) {
                    tempNomeEstilista = estilista.buscarNomeEstilista(listaRoupaOI.get(i).codEstilista);
                    tempNomeEstacao = estacao.buscarNomeEstacao(listaRoupaOI.get(i).codEstacao);

                    System.out.println("Código do estilista: " + listaRoupaOI.get(i).codEstilista);
                    System.out.println("Nome do estilista: " + tempNomeEstilista);
                    System.out.println("Código do estação: " + listaRoupaOI.get(i).codEstacao);
                    System.out.println("Nome da estação: " + tempNomeEstacao);
                    System.out.println("Descrição da roupa: " + listaRoupaOI.get(i).descricaoRoupa);
                    System.out.println("Ano da roupa: " + listaRoupaOI.get(i).ano);

                }
            }

        }
    }

    static class Estacao {
        private static final AtomicInteger id = new AtomicInteger(0);
        int codEstacao;
        String nomeEstacao;

        public Estacao(int codEstacao, String nomeEstacao) {
            super();
            this.codEstacao = codEstacao;
            this.nomeEstacao = nomeEstacao;
        }

        public Estacao() {
        }

        public void cadastrarEstacao() {
            codEstacao = id.incrementAndGet();

            System.out.println("Informe uma das opções: ");

            System.out.println("1 - primavera-verão");
            System.out.println("2 - outono-inverno");
            nomeEstacao = teclado.next();

            while (!nomeEstacao.equals("1") && !nomeEstacao.equals("2")) {
                System.out.println("Opção inválida!!");

                System.out.println("1 - primavera-verão");
                System.out.println("2 - outono-inverno");
                nomeEstacao = teclado.next();
            }

            if (nomeEstacao.equals("1"))
                nomeEstacao = "primavera-verão";
            else
                nomeEstacao = "outono-inverno";

            Estacao estacao = new Estacao(codEstacao, nomeEstacao);
            listaEstacao.add(estacao);

            System.out.println("Cadastro realizado!");

        }

        public String buscarNomeEstacao(int codEstacao) {
            for (int i = 0; i < listaEstacao.size(); i++) {
                if (listaEstacao.get(i).codEstacao == codEstacao) {
                    return listaEstacao.get(i).nomeEstacao;

                }
            }
            return "Ocorreu um erro!";
        }

    }
}

