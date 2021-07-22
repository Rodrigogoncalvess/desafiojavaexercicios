package br.com.jorgerabellodev.reskilling.parte07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Faça um programa que receba uma data no formato DD/MM/AAAA e a mostre com o mês por extenso: DD/mês por extenso/AAAA
 */
public class Exercicio12 {
    public static void main(String[] args) {

        Date dataHoje = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        String dataFormatada = dateFormat.format(dataHoje);

        System.out.println("Data formatada: " + dataFormatada);


    }
}
