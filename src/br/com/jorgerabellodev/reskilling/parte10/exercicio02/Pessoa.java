package br.com.jorgerabellodev.reskilling.parte10.exercicio02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class Pessoa {

    String nome;
    String idade;


    public Pessoa(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;

    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public void calcularIdadeEmMeses(String dataNascimento) {

        Date dataHoje = new Date();
        final double calcularDias = (24 * 60 * 60 * 1000);
        final double mediaDiaMes = 30.41;


        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");


        dataFormatada.setLenient(false);


        try {

            Date dataInformada = dataFormatada.parse(dataNascimento);
            long data = (dataHoje.getTime() - dataInformada.getTime());


            System.out.println("Nome da pessoa: " + nome + " e sua idade é " + Math.round(data / calcularDias / 365) + " anos!");

            System.out.println("Total de meses até presente data: " + Math.round(data / calcularDias / mediaDiaMes));

        } catch (ParseException e) {
            System.err.println("Data informada não existe!");

        }

    }

    public void calcularAnoEmMeses(String dataNascimento) {

        final int calcularDias = 24 * 60 * 60 * 1000;

        int anoDoisMilECinquenta = 2050;
        int anoAtual = Year.now().getValue();
        Date dataHoje = new Date();

        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataInformada = dataFormatada.parse(dataNascimento);

            // calcula data do momento da pesquisa com a data informada
            long anosConvertidoMeses = (dataHoje.getTime() - dataInformada.getTime());
            //converte anos em dias
            int dias = (int) (anosConvertidoMeses / calcularDias);
            int totalDeAnos = dias / 365;

            anoDoisMilECinquenta -= anoAtual;

            int idadeEmDoisMilCinquenta = anoDoisMilECinquenta + totalDeAnos;

            System.out.println("Pessoa terá em 2050 a idade de " + idadeEmDoisMilCinquenta + " anos!");

        } catch (ParseException e) {

        }
    }

}

