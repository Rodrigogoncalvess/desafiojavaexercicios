package br.com.jorgerabellodev.reskilling.parte09;

public class Estacao {

    private int codigoEstaca;
    private String nomeEstacao;

    public Estacao(int codigoEstaca, String nomeEstacao) {
        this.codigoEstaca = codigoEstaca;
        this.nomeEstacao = nomeEstacao;
    }

    public Estacao() {
    }

    public int getCodigoEstaca() {
        return codigoEstaca;
    }

    public void setCodigoEstaca(int codigoEstaca) {
        this.codigoEstaca = codigoEstaca;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    public void setNomeEstacao(String nomeEstacao) {
        this.nomeEstacao = nomeEstacao;
    }
}
