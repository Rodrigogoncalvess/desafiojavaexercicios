package br.com.jorgerabellodev.reskilling.parte10.exercicio03;

public class Compra {

    private int numeroProduto;
    private int numeroCliente;
    private int quantidade;
    private double valorTotal;

    Produto produto = new Produto();
    Cliente cliente = new Cliente();


    public Compra(int numeroProduto, int numeroCliente, int quantidade, double valorTotal) {
        this.numeroProduto = numeroProduto;
        this.numeroCliente = numeroCliente;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Compra() {
    }

    public int getNumeroProduto() {
        return numeroProduto;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean existeProduto(int numeroProduto) {

        for (Produto produtos : produto.produtoList) {
            if (produtos.getNumeroProduto() == numeroProduto) {
                return true;
            }
        }
        return false;
    }

    public double valorTotalCompra(int numeroProduto, int quantidade) {
        for (int i = 0; i < produto.produtoList.size(); i++) {
            if (produto.produtoList.get(i).getNumeroProduto() == numeroProduto) {
                double preco = produto.produtoList.get(i).getPrecoProduto();
                return preco * quantidade;
            }
        }
        return 0;
    }

    public double descontoValorTotal(int numeroProduto, int quantidade) {
        for (int i = 0; i < produto.produtoList.size(); i++) {
            if (produto.produtoList.get(i).getNumeroProduto() == numeroProduto) {
                double preco = produto.produtoList.get(i).getPrecoProduto();
                double desconto = (preco - produto.calcularValorDesconto(preco)) * quantidade;
                return  desconto;

                //Desconto apenas uma vez em cima do preço do produto.
//                double desconto =(preco - produto.calcularValorDesconto(preco));
//                preco *= quantidade;
//                return preco - desconto;
//                return ((preco * quantidade) - desconto);

            }
        }
        return 0;
    }

    public boolean existeCliente(int numeroCliente) {
        for (Cliente clientes : cliente.clienteList) {
            if (clientes.getNumeroCliente() == numeroCliente) {
                return true;
            }
        }
        return false;
    }
}


