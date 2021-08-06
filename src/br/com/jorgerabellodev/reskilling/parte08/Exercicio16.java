package br.com.jorgerabellodev.reskilling.parte08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * O acervo de uma biblioteca precisa ser informatizado. Para tanto, as principais informações das obras
 * foram assim estruturadas:
 * Obra(numero do tombo, numero do exemplar, data compra)
 * Tombo(numero do tombo, nome da obra, nome do autor, nome da editora, codigo da area)
 * <p>
 * Sabe-se que existem 20 tombos e, para cada um, há no máximo três exemplares.
 * Defina vetores de registro para armazenar tais informações.
 * Defina o menu de opções a seguir:
 * <p>
 * 1. Cadastrar tombos.
 * 2. Cadastrar obras.
 * 3. Mostrar obras por área.
 * 4. Mostrar obras por autor.
 * 5. Mostrar obras por editora.
 * 6. Encerrar o programa.
 * <p>
 * Existem três áreas: 1 — exatas; 2 — humanas e sociais; e 3 — biomédicas.
 */
public class Exercicio16 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {


        int opcaoMenu;
        int opcaoMenuContinuar;

        Tombo tombo = new Tombo();
        Obra obra = new Obra();

        while (true) {


            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar  tombos; \n2 - Cadastrar obras;\n3 - Mostrar obra por área;\n4 - Mostrar obras por autor;\n5 - Mostrar obras por editora;\n6 - Encerrar o programa");
                opcaoMenu = ler.nextInt();

                if (opcaoMenu <= 6) {

                    switch (opcaoMenu) {

                        case 1:
                            tombo.cadastrarTombo();
                            break;
                        case 2:
                            obra.cadastrarTombo();
                            break;
                        case 3:
                            tombo.obrasPorArea();
                            break;
                        case 4:
                            tombo.obrasPorAutor();
                            break;
                        case 5:
                            tombo.obrasPorEditora();
                            break;
                        case 6:
                            System.out.println("Programa finalizado!");
                            return;
                    }
                } else {
                    System.out.println("Opção inválida, digite uma opção válida.");
                }

                while (true) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcaoMenuContinuar = ler.nextInt();
                    if (opcaoMenuContinuar == 1) {

                        break;
                    } else if (opcaoMenuContinuar == 2) {
                        System.out.println("Obrigado por usar o programa!");

                        return;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Programa não contém letra ou simbolo.");
                break;
            }
        }

    }

    public static class Obra {
        int numeroTombo;
        int numeroDeExemplar;
        String dataCompra;
        Date dataFormatada;
        boolean validarDataDigitada;
        Tombo tombo = new Tombo();

        static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
        static ArrayList<Obra> listaObra = new ArrayList<>();

        public Obra(int numeroTombo, int numeroDeExemplar, String dataCompra) {
            this.numeroTombo = numeroTombo;
            this.numeroDeExemplar = numeroDeExemplar;
            this.dataCompra = dataCompra;
        }

        public Obra() {
        }

        public void cadastrarTombo() {
            int contador;
            int soma = 0;
            int somaTotal = 0;
            System.out.println("Informe o número do tombo:");
            numeroTombo = ler.nextInt();


            if (tombo.validarNumeroTombo(numeroTombo)) {


                System.out.println("Informe o número de exemplares:");
                numeroDeExemplar = ler.nextInt();

                for (int i = 0; i < listaObra.size(); i++) {
                    if (listaObra.get(i).numeroTombo == numeroTombo) {
                        contador = listaObra.get(i).numeroDeExemplar;
                        soma += contador;
                    }
                    somaTotal = soma + numeroDeExemplar;
                }
                if (somaTotal <= 3) {

                    if (numeroDeExemplar <= 3) {


                        System.out.println("Informe a data da compra:");
                        dataCompra = ler.next();
                        validarDataDigitada = validarData(dataCompra);

                        while (validarDataDigitada) {
                            System.out.println("Informe a data da compra:");
                            dataCompra = ler.next().concat(ler.nextLine());
                            validarDataDigitada = validarData(dataCompra);

                        }
                        try {
                            dataFormatada = formatoData.parse(dataCompra);

                        } catch (
                                ParseException parseException) {
                        }
                        Obra obra = new Obra(numeroTombo, numeroDeExemplar, dataCompra);
                        listaObra.add(obra);
                    } else {
                        System.out.println("Não será possível realizar o cadastro deste exemplar por ser um quantidade superior ao limite máximo de 3 permitido.");
                    }

                    } else {
                        System.out.println("Não será possível realizar o cadastro deste exemplar por ter atingindo o limite máximo de 3 por tombo.");

                    }

                } else {
                    System.out.println("Número de tombo não existe!");
                }

            }

            public boolean validarData (String dataCompra){
                try {
                    formatoData.setLenient(false);
                    dataFormatada = formatoData.parse(dataCompra);
                } catch (ParseException parseException) {
                    System.out.println("Data foi digitada no formato errado, digite a da neste formato dd/MM/yy");
                    return true;
                }
                return false;

            }


        }

        public static class Tombo {
            int numeroTombo;
            String nomeDaObra;
            String nomeDoAutor;
            String nomeDaEditora;
            int codigoArea;


            static final AtomicInteger idTombo = new AtomicInteger(0);
            static ArrayList<Tombo> listaTombo = new ArrayList<>();

            public Tombo(int numeroTombo, String nomeDaObra, String nomeDoAutor, String nomeDaEditora, int codigoArea) {
                this.numeroTombo = numeroTombo;
                this.nomeDaObra = nomeDaObra;
                this.nomeDoAutor = nomeDoAutor;
                this.nomeDaEditora = nomeDaEditora;
                this.codigoArea = codigoArea;
            }

            public Tombo() {

            }


            public void cadastrarTombo() {


                if (numeroTombo < 20) {

                    System.out.println("Informe o nome da obra:");
                    nomeDaObra = ler.next();


                    System.out.println("Informe o nome do autor:");
                    nomeDoAutor = ler.next();

                    System.out.println("Informe o nome da editora:");
                    nomeDaEditora = ler.next();


                    System.out.println("Informe o código da área:");
                    codigoArea = ler.nextInt();

                    if (codigoArea <= 3) {
                        numeroTombo = idTombo.incrementAndGet();

                        Tombo tombo = new Tombo(numeroTombo, nomeDaObra.toUpperCase(), nomeDoAutor.toUpperCase(), nomeDaEditora.toUpperCase(), codigoArea);
                        listaTombo.add(tombo);
                    } else {

                        System.out.println("Código de área não existe!");
                    }

                } else {
                    System.out.println("Limite máximo de cadastro de tombos atingindo, não será possível realizar novo cadastro!");
                }

            }

            public static boolean validarNomeAutor(String nomeDoAutor) {
                for (int i = 0; i < listaTombo.size(); i++) {
                    if (listaTombo.get(i).nomeDoAutor.equalsIgnoreCase(nomeDoAutor)) {
                        return true;
                    }
                }
                return false;
            }

            public static boolean validarNomeEditora(String nomeDaEditora) {
                for (int i = 0; i < listaTombo.size(); i++) {
                    if (listaTombo.get(i).nomeDaEditora.equalsIgnoreCase(nomeDaEditora)) {
                        return true;
                    }
                }
                return false;
            }


            public static boolean validarNumeroTombo(int numeroTombo) {
                for (int i = 0; i < listaTombo.size(); i++) {
                    if (listaTombo.get(i).numeroTombo == numeroTombo) {
                        return true;
                    }
                }
                return false;
            }

            public void obrasPorArea() {

                System.out.println("Infomre um número para obter as obras da área:\n1 — Exatas;\n2 — Humanas e sociais;\n3 — biomédicas.");
                codigoArea = ler.nextInt();
                while (codigoArea > 3) {
                    System.out.println("Opção inválida, informe um número válido para obter as obras da área:\n1 — Exatas;\n2 — Humanas e sociais;\n3 — biomédicas.");
                    codigoArea = ler.nextInt();

                }
                if (validarCodigoArea(codigoArea)) {
                    for (int i = 0; i < listaTombo.size(); i++) {
                        System.out.println("Nome da obra >>> " + listaTombo.get(i).nomeDaObra);
                        System.out.println("Nome da autor >>> " + listaTombo.get(i).nomeDoAutor);
                        System.out.println("Nome da editora >>> " + listaTombo.get(i).nomeDaEditora + "\n");


                    }

                } else {
                    System.out.println("Não existe nenhuma obra cadastrada nesta área!");
                }
            }

            public static boolean validarCodigoArea(int codigoArea) {
                for (int i = 0; i < listaTombo.size(); i++) {
                    if (listaTombo.get(i).codigoArea == codigoArea) {
                        return true;
                    }
                }
                return false;
            }

            public void obrasPorAutor() {

                System.out.println("Informe o nome do autor para obter suas obras:");
                nomeDoAutor = ler.next();

                if (validarNomeAutor(nomeDoAutor)) {
                    for (int i = 0; i < listaTombo.size(); i++) {
                        System.out.println("Nome da obra >>> " + listaTombo.get(i).nomeDaObra);
                        System.out.println("Nome da editora >>> " + listaTombo.get(i).nomeDaEditora + "\n");
                    }

                } else {
                    System.out.println("Não existe nenhuma obra cadastrada em nome do autor que foi digitado!");
                }
            }

            public void obrasPorEditora() {

                System.out.println("Informe o nome da editora para obter suas obras:");
                nomeDaEditora = ler.next();

                if (validarNomeEditora(nomeDaEditora)) {
                    for (int i = 0; i < listaTombo.size(); i++) {
                        System.out.println("Nome da obra >>> " + listaTombo.get(i).nomeDaObra);
                        System.out.println("Nome da autor >>> " + listaTombo.get(i).nomeDoAutor + "\n");
                    }

                } else {
                    System.out.println("Não existe nenhuma obra cadastrada em nome da editora que foi digitado!");
                }
            }

        }
    }
