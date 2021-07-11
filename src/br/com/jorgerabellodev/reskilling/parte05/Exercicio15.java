package br.com.jorgerabellodev.reskilling.parte05;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Crie um programa que preencha uma matriz 12 x 13 e divida todos os elementos de cada linha pelo
 * maior elemento em módulo daquela linha. O programa deverá escrever a matriz lida e a modificada.
 */
public class Exercicio15 {
    public static void main(String[] args) {


        var matriz = new int[12][13];
        var somaLinha = 0.0;
        var maiorNumeroLinha = 0.0;
        var dividida = 0.0;
        var decimal = new DecimalFormat("0.00");

        Random random =new Random();



        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(100);
//                System.out.println("Informe o " + (j + 1) + "° valor da linha [" + j + "] da primeira matriz na posição da coluna [" + i + "] : "+matriz[i][j] );

            }
        }
        for (int i = 0; i < matriz.length; i++) {
            somaLinha = 0;
            for (int j = 0; j < matriz[i].length; j++) {

                if (matriz[i][j] > maiorNumeroLinha) {
                    maiorNumeroLinha = matriz[i][j];
                }
                somaLinha += matriz[i][j];
            }
            dividida = somaLinha / maiorNumeroLinha;

            System.out.println("\nMaior valor da linha [ " + i + " ]: " + maiorNumeroLinha);
            System.out.println("Valor total da linha [ " + i + " ]: " + somaLinha );
            System.out.println("valor da divisão da linha: " + (decimal.format(dividida)));
        }
    }

}


