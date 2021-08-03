package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;

/**
 * Faça um programa contendo os serviços que uma oficina mecânica pode realizar: ordem de serviço (número da OS, data, valor, serviço realizado, cliente).
 * Leia as informações sobre várias ordens de serviço e determine, ao final, a média dos valores, o nome
 * do cliente que realizou o serviço mais caro, junto com a descrição desse serviço e a data de sua realização.
 */
public class Exercicio20 {
    public static void main(String[] args) {
        OrdemServico ordemServico = new OrdemServico();

        OrdemServico dado1 = new OrdemServico(1, "1/1/2020", 123.0, "Ajuste1", "Cliente1");
        OrdemServico dado2 = new OrdemServico(2, "2/1/2020", 124.0, "Ajuste2", "Cliente2");
        OrdemServico dado3 = new OrdemServico(3, "3/1/2020", 125.0, "Ajuste3", "Cliente3");
        OrdemServico dado4 = new OrdemServico(4, "4/1/2020", 126.0, "Ajuste4", "Cliente4");

        ordemServico.listaOrdemServico.add(dado1);
        ordemServico.listaOrdemServico.add(dado2);
        ordemServico.listaOrdemServico.add(dado3);
        ordemServico.listaOrdemServico.add(dado4);


        System.out.println("Média de valores: ");
        System.out.println(ordemServico.mediaValores());

        System.out.println("Serviço mais caro: ");
        ordemServico.servicoMaisCaro();

    }

    static class OrdemServico {
        int numeroOS;
        String data;
        double valor;
        String servicoRealizado;
        String cliente;

        double mediaValores;
        double valorMaior;

        String tempNome;
        String tempServicoRealizado;
        String tempData;

        ArrayList<OrdemServico> listaOrdemServico = new ArrayList<OrdemServico>();

        public OrdemServico(int numeroOS, String data, double valor, String servicoRealizado, String cliente) {
            super();
            this.numeroOS = numeroOS;
            this.data = data;
            this.valor = valor;
            this.servicoRealizado = servicoRealizado;
            this.cliente = cliente;
        }

        public OrdemServico() {
        }

        public double mediaValores() {
            for (int i = 0; i < listaOrdemServico.size(); i++) {
                mediaValores += listaOrdemServico.get(i).valor;
            }

            return mediaValores / listaOrdemServico.size();
        }

        public void servicoMaisCaro() {
            for (int i = 0; i < listaOrdemServico.size(); i++) {
                if (listaOrdemServico.get(i).valor > valorMaior) {
                    valorMaior = listaOrdemServico.get(i).valor;
                    tempServicoRealizado = listaOrdemServico.get(i).servicoRealizado;
                    tempData = listaOrdemServico.get(i).data;
                    tempNome = listaOrdemServico.get(i).cliente;
                }
            }

            System.out.println("O cliente " + tempNome + " pagou o maior valor foi de serviço: " + valorMaior
                    + " o tipo de serviço foi: " + tempServicoRealizado + " na data: " + tempData);
        }

    }

}

