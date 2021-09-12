package br.com.jorgerabellodev.reskilling.parte10.exercicio03;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static final double DESCONTO_CINCO_PORCENTO = 0.05;
    private int numeroCliente;
    private String nomeCliente;
    private String sexoCliente;

    Produto produto = new Produto();


    public static List<Cliente> clienteList = new ArrayList<>();

    public Cliente(int numeroCliente, String nomeCliente, String sexoCliente) {
        this.numeroCliente = numeroCliente;
        this.nomeCliente = nomeCliente;
        this.sexoCliente = sexoCliente;
    }

    public Cliente() {

    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }


    public double calcularDescontoAdicional(int numeroCliente, int quantidade,int numeroProduto) {


        Double valorTotalProduto = calcularDescontoAdicionalAMais(numeroCliente, quantidade, numeroProduto);
        if (valorTotalProduto != null) return valorTotalProduto;
        return 0;
    }


    private Double calcularDescontoAdicionalAMais(int numeroCliente, int quantidade, int numeroProduto) {
        for (int i = 0; i < clienteList.size(); i++) {
            String letra = clienteList.get(i).getSexoCliente();
            if (letra.equalsIgnoreCase("f")) {

                if (clienteList.get(i).getNumeroCliente() == numeroCliente) {
                    for (int j = 0;j < produto.produtoList.size();j++) {
                        if (produto.produtoList.get(j).getNumeroProduto() == numeroProduto) {
                            double valorTotalProduto = produto.produtoList.get(j).getPrecoProduto() * quantidade;
                            return valorTotalProduto * DESCONTO_CINCO_PORCENTO;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean validarNumeroCliente(int numeroCliente, List<Cliente> clienteList) {
        for (Cliente cliente : clienteList) {
            if (cliente.numeroCliente == numeroCliente) {
                System.err.println("Número do cliente já existe no cadastro! ");
                return true;
            }
        }
        return false;
    }

    public boolean validarNomeCliente(String nomeCliente, List<Cliente> clienteList) {

        for (Cliente clientes : clienteList) {
            if (clientes.nomeCliente.equalsIgnoreCase(nomeCliente)) {
                System.err.println("Nome do cliente já existe no cadastro!");
                return true;
            }
        }
        return false;
    }
}
