package br.com.jorgerabellodev.reskilling.parte09;

public class Cliente {

    private int codCliente;
    private String nome;
    private String endereco;
    private String nome2;

    public Cliente(int codCliente, String nome, String endereco, String nome2) {
        super();
        this.codCliente = codCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.nome2 = nome2;
    }

    public Cliente() {

    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }

}
