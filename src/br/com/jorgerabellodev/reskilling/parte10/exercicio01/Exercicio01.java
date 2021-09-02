package br.com.jorgerabellodev.reskilling.parte10.exercicio01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Defina uma classe CARRO com os seguintes atributos: placa e ano de fabricação. Essa classe deve ter também
 * um método para calcular o imposto.
 * Faça o cadastro de cinco carros, calcule e mostre:
 * <p>
 * a) o imposto a ser pago por cada carro, sabendo-se que o cálculo é realizado assim:
 * No ano de fabricação, o carro paga R$ 500,00 de imposto. A cada ano de uso, o imposto é reduzido
 * em R$ 100,00. Contudo, o valor mínimo a ser pago pelo carro é de R$ 100,00 até o carro atingir o 10 o
 * ano de uso, quando, então, não precisará mais pagar imposto. As tabelas a seguir mostram exemplos
 * de dois carros, um fabricado em 2012 e outro fabricado em 2009. Supondo que o ano atual é 2012,
 * estão dispostos o valor dos impostos a serem pagos até 2021.
 * <p>
 * ------------------------------------------------------------
 * CARRO FABRICADO EM 2012
 * ------------------------------------------------------------
 * ANO ATUAL        VALOR DO IMPOSTO
 * ------------------------------------------------------------
 * 2012                 R$ 500,00
 * 2013                 R$ 400,00
 * 2014                 R$ 300,00
 * 2015                 R$ 200,00
 * 2016                 R$ 100,00
 * 2017                 R$ 100,00
 * 2018                 R$ 100,00
 * 2019                 R$ 100,00
 * 2020                 R$ 100,00
 * 2021                 R$   0,00
 * ------------------------------------------------------------
 * <p>
 * ------------------------------------------------------------
 * CARRO FABRICADO EM 2009
 * ------------------------------------------------------------
 * ANO ATUAL        VALOR DO IMPOSTO
 * 2012                 R$ 200,00
 * 2013                 R$ 100,00
 * 2014                 R$ 100,00
 * 2015                 R$ 100,00
 * 2016                 R$ 100,00
 * 2017                 R$ 100,00
 * 2018                 R$   0,00
 * 2019                 R$   0,00
 * 2020                 R$   0,00
 * 2021                 R$   0,00
 * ------------------------------------------------------------
 * Para cálculo do imposto, o usuário deverá informar o ano atual.
 * b) o total dos impostos, ou seja, a soma dos impostos de todos os carros (outro método).
 * c) a quantidade de carros que não pagam impostos (outro método).
 */
public class Exercicio01 {


    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int count = 0;

        List<Carro> listaCarros = new ArrayList<>();

        do {
            System.out.println("Informe a placa do carro que deseja cadastrar:");
            String placa = ler.next().toUpperCase().concat(ler.nextLine());

            try {

                validarPlaca(placa);

                System.out.println("Informe o ano de fabricação do carro que deseja cadastrar:");
                int anoFabricacao = ler.nextInt();

                Carro carro = new Carro(placa, anoFabricacao);

                if (carro.validarAno()) {
                    listaCarros.add(carro);
                    count++;
                }

            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }

        } while (count < 4);

        for (Carro carro : listaCarros) {
            carro.calcularImposto(listaCarros);
            break;
        }
        for (Carro carro : listaCarros) {
            carro.totalDeImpostoPago(listaCarros);
            break;
        }
        for (Carro carro : listaCarros) {
            carro.totalDeCarroIsento(listaCarros);
            break;
        }

    }

    private static void validarPlaca(String placa) {

        if (placa.length() > 0 && placa.length() <= 7 && !placa.matches("[A-Z]{3}('-')[0-9]{4}")) {
            throw new PlacaInvalidaException("Placa inválida!\nPlaca precisa ser digitada neste formato (AAA-1234)");
        }

    }

}