package br.com.jorgerabellodev.reskilling.parte09;

public class Recebimento {

    private int numDoc;
    private double valorDoc;
    private String dataEmissao;
    private String dataVencimento;
    private int codCliente;

    public Recebimento(int numDoc, double valorDoc, String dataEmissao, String dataVencimento, int codCliente) {
        this.numDoc = numDoc;
        this.valorDoc = valorDoc;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.codCliente = codCliente;
    }

    public Recebimento() {
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public double getValorDoc() {
        return valorDoc;
    }

    public void setValorDoc(double valorDoc) {
        this.valorDoc = valorDoc;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
}
