package br.com.jorgerabellodev.reskilling.parte09;

public class Estilista {

    private int codigoEstilista;
    private String nomeEstilista;
    private double salarioEstilista;

    public Estilista(int codigoEstilista, String nomeEstilista, double salarioEstilista) {
        this.codigoEstilista = codigoEstilista;
        this.nomeEstilista = nomeEstilista;
        this.salarioEstilista = salarioEstilista;
    }

    public Estilista() {
    }

    public int getCodigoEstilista() {
        return codigoEstilista;
    }

    public void setCodigoEstilista(int codigoEstilista) {
        this.codigoEstilista = codigoEstilista;
    }

    public String getNomeEstilista() {
        return nomeEstilista;
    }

    public void setNomeEstilista(String nomeEstilista) {
        this.nomeEstilista = nomeEstilista;
    }

    public double getSalarioEstilista() {
        return salarioEstilista;
    }

    public void setSalarioEstilista(double salarioEstilista) {
        this.salarioEstilista = salarioEstilista;
    }
}
