package br.com.jorgerabellodev.reskilling.parte10.exercicio03;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int numeroProduto;
    private double precoProduto;

    public static List<Produto> produtoList = new ArrayList<>();


    public Produto(int numeroProduto, double precoProduto) {
        this.numeroProduto = numeroProduto;
        this.precoProduto = precoProduto;
    }

    public Produto() {
    }

    public int getNumeroProduto() {
        return numeroProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public double calcularValorDesconto(double precoProduto) {

        final double descontoQuinzePorcento = 0.15;
        final double descontoCincoPorcento = 0.05;

        if (precoProduto > 100) {
            return (precoProduto - (precoProduto * descontoQuinzePorcento));
        }
        return precoProduto - (precoProduto * descontoCincoPorcento);
    }

    public boolean validarPreco(double precoProduto) {
        if (precoProduto >= 20 && precoProduto <= 350) {
            return true;
        }
        return false;
    }
}
