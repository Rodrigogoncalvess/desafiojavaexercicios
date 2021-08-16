package br.com.jorgerabellodev.reskilling.parte09;

public class Roupa {

    private int codigoRoupa;
    private String descricaoRoupa;
    private int codigoEstilista;
    private int codigoEstacao;
    private int ano;

    public Roupa(int codigoRoupa, String descricaoRoupa, int codigoEstilista, int codigoEstacao, int ano) {
        this.codigoRoupa = codigoRoupa;
        this.descricaoRoupa = descricaoRoupa;
        this.codigoEstilista = codigoEstilista;
        this.codigoEstacao = codigoEstacao;
        this.ano = ano;
    }

    public Roupa() {
    }

    public int getCodigoRoupa() {
        return codigoRoupa;
    }

    public void setCodigoRoupa(int codigoRoupa) {
        this.codigoRoupa = codigoRoupa;
    }

    public String getDescricaoRoupa() {
        return descricaoRoupa;
    }

    public void setDescricaoRoupa(String descricaoRoupa) {
        this.descricaoRoupa = descricaoRoupa;
    }

    public int getCodigoEstilista() {
        return codigoEstilista;
    }

    public void setCodigoEstilista(int codigoEstilista) {
        this.codigoEstilista = codigoEstilista;
    }

    public int getCodigoEstacao() {
        return codigoEstacao;
    }

    public void setCodigoEstacao(int codigoEstacao) {
        this.codigoEstacao = codigoEstacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
