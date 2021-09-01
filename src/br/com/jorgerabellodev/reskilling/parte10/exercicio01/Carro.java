package br.com.jorgerabellodev.reskilling.parte10.exercicio01;

import java.util.ArrayList;
import java.util.Scanner;

public class Carro {

    String placa;
    int anoFabricacao;
    int anoAtual;
    int opcao = 0;

    ArrayList<Carro> listaCarros = new ArrayList<>();

    Scanner ler = new Scanner(System.in);

    public Carro(String placa, int anoFabricacao) {
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    public Carro() {

    }

    public void cadastrarCarro() {

        while (true) {


            System.out.println("Informe a placa do carro que deseja cadastrar:");
            placa = ler.next().toUpperCase().concat(ler.nextLine());
            if (validarPlaca(placa)) {

                System.out.println("Informe o ano de fabricação do carro que deseja cadastrar:");
                anoFabricacao = ler.nextInt();

                if (validarAno(anoFabricacao)) {

                    Carro carro = new Carro(placa, anoFabricacao);
                    listaCarros.add(carro);
                } else {
                    System.out.println("Ano digitado não é válido! ");
                }
            } else {
                System.out.println("placa informada não é válida!");
            }

            while (true) {

                System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                opcao = ler.nextInt();

                if (opcao == 1) {

                    break;
                } else if (opcao == 2) {
                    System.out.println("Obrigado por usar o programa");

                    for (Carro car : listaCarros) {
                        System.out.println("Placa: " + car.placa + " Ano " + car.anoFabricacao);
                    }
                    return;
                } else {
                    System.out.println("Opção inválida");
                }
            }
        }
    }

    public void calcularImposto() {


        System.out.println("Informe o ano atual:");
        anoAtual = ler.nextInt();

        if (validarAno(anoAtual)) {

            for (int i = 0; i < listaCarros.size(); i++) {

                if (anoAtual == listaCarros.get(i).anoFabricacao) {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + " pagará o imposto de R$ 500,00.");

                } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 1) {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + " pagará o imposto de R$ 400,00.");

                } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 2) {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + " pagará o imposto de R$ 300,00.");

                } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 3) {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + " pagará o imposto de R$ 200,00.");

                } else if ((anoAtual - listaCarros.get(i).anoFabricacao) >= 4 && (anoAtual - listaCarros.get(i).anoFabricacao) <= 9) {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + "pagará o imposto de R$ 100,00.");

                } else {
                    System.out.println("Veículo de placa " + listaCarros.get(i).placa + " está isento de imposto");

                }
            }
        } else {
            System.out.println("Ano digitado não é válido!");
        }

    }

    public void totalDeImpostoPago() {
        double valor = 0;
        double totalValor = 0;

        for (int i = 0; i < listaCarros.size(); i++) {
            valor = 0;
            if (anoAtual == listaCarros.get(i).anoFabricacao) {
                valor = 500;
            } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 1) {
                valor = 400;
            } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 2) {
                valor = 300;
            } else if ((anoAtual - listaCarros.get(i).anoFabricacao) == 3) {
                valor = 200;
            } else if ((anoAtual - listaCarros.get(i).anoFabricacao) >= 4 && (anoAtual - listaCarros.get(i).anoFabricacao) <= 9) {
                valor = 100;
            }

            totalValor += valor;
        }
        System.out.println("\nValor total de imposto arrecadado: " + totalValor);
    }

    public void totalDeCarroIsento() {
        int contador = 0;

        for (int i = 0; i < listaCarros.size(); i++) {
            if ((anoAtual - listaCarros.get(i).anoFabricacao) > 9) {
                contador++;
            }
        }
        System.out.println("Total de veículo isento: " + contador);
    }

    public boolean validarPlaca(String placa) {
        boolean placaValida = true;

        if (placa.length() > 0 && placa.length() <= 7) {

            if ((!placa.matches("[A-Z]{3}[0-9]{4}"))) {
                placaValida = false;
            }
        }
        return placaValida;
    }

    public boolean validarAno(int ano) {
        boolean anoValido = true;
        String anoConvertido;
        anoConvertido = Integer.toString(ano);

        if (anoConvertido.matches("[0-9]{4}")) {
            return anoValido;
        }
        return false;
    }
}

