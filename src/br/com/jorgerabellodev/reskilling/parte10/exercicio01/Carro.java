package br.com.jorgerabellodev.reskilling.parte10.exercicio01;

import java.time.Year;
import java.util.List;

public class Carro {

    private final String placa;
    private final int anoFabricacao;


    public Carro(String placa, int anoFabricacao) {
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }



    public void calcularImposto(List<Carro> listaCarros) {

        int anoAtual = Year.now().getValue();

        for (Carro listaCarro : listaCarros) {

            int anoFabricacao = listaCarro.anoFabricacao;
            String placa = listaCarro.placa;


            if (anoAtual == anoFabricacao) {
                System.out.println("Veículo de placa " + placa + " pagará o imposto de R$ 500,00.");

            } else if ((anoAtual - anoFabricacao) == 1) {
                System.out.println("Veículo de placa " + placa + " pagará o imposto de R$ 400,00.");

            } else if ((anoAtual - anoFabricacao) == 2) {
                System.out.println("Veículo de placa " + placa + " pagará o imposto de R$ 300,00.");

            } else if ((anoAtual - anoFabricacao) == 3) {
                System.out.println("Veículo de placa " + placa + " pagará o imposto de R$ 200,00.");

            } else if ((anoAtual - anoFabricacao) >= 4 && (anoAtual - anoFabricacao) <= 9) {
                System.out.println("Veículo de placa " + placa + "pagará o imposto de R$ 100,00.");

            } else {
                System.out.println("Veículo de placa " + placa + " está isento de imposto");

            }
        }

    }

    public void totalDeImpostoPago(List<Carro> listaCarros) {
        double valor = 0;
        double totalValor = 0;
        int anoAtual = Year.now().getValue();

        for (Carro listaCarro : listaCarros) {
            valor = 0;
            if (anoAtual == listaCarro.anoFabricacao) {
                valor = 500;
            } else if ((anoAtual - listaCarro.anoFabricacao) == 1) {
                valor = 400;
            } else if ((anoAtual - listaCarro.anoFabricacao) == 2) {
                valor = 300;
            } else if ((anoAtual - listaCarro.anoFabricacao) == 3) {
                valor = 200;
            } else if ((anoAtual - listaCarro.anoFabricacao) >= 4 && (anoAtual - listaCarro.anoFabricacao) <= 9) {
                valor = 100;
            }

            totalValor += valor;
        }
        System.out.println("\nValor total de imposto arrecadado: " + totalValor);
    }

    public void totalDeCarroIsento(List<Carro> listaCarros) {
        int contador = 0;
        int anoAtual = Year.now().getValue();

        for (Carro listaCarro : listaCarros) {
            if ((anoAtual - listaCarro.anoFabricacao) > 9) {
                contador++;
            }
        }
        System.out.println("Total de veículo isento: " + contador);
    }



    public boolean validarAno() {
        boolean anoValido = true;
        String anoConvertido = Integer.toString(this.anoFabricacao);

        if (anoConvertido.matches("[0-9]{4}")) {
            return anoValido;
        }
        return false;
    }
}

