package br.com.jorgerabellodev.reskilling.parte03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Em uma eleição presidencial existem quatro candidatos. Os votos são informados por meio de código.
 * Os códigos utilizados são:
 * ------------------------------------------------------------
 * 1, 2, 3, 4       Votos para os respectivos candidatos
 * 5                Voto nulo
 * 6                Voto em branco
 * ------------------------------------------------------------
 * Faça um programa que calcule e mostre:
 * ■ ■ o total de votos para cada candidato;
 * ■ ■ o total de votos nulos;
 * ■ ■ o total de votos em branco;
 * ■ ■ a porcentagem de votos nulos sobre o total de votos; e
 * ■ ■ a porcentagem de votos em branco sobre o total de votos.
 * Para finalizar o conjunto de votos, tem-se o valor zero e, para códigos inválidos, o programa deverá
 * mostrar uma mensagem.
 */
public class Exercicio21 {
    public static void main(String[] args) {

        var votos = new int[10];
        var votosCandidatos = 0;
        var votoNulo = 0;
        var votoBranco = 0;
        var totalVotos = 0.0;
        var porcentagemNulo = 0.0;
        var porcentagemBranco = 0.0;


        var teclado = new Scanner(System.in);
try {
            System.out.println("Informe uma das opções abaixo: \n" +
                "código: 1, 2, 3 e 4 - Votos para os respectivos candidatos; \n" +
                "código: 5 - Voto nulo;\n" +
                "código: 6 - Voto em branco.\n");

        for (int i = 0; i < votos.length; i++) {

            System.out.println("Informe o código do Voto:  ");
            votos[i] = teclado.nextInt();

            if (votos[i] == 0) {
                System.out.println("Votação encerrada!");
                break;
            }

            if (votos[i] >= 1 && votos[i] <= 4) {
                votosCandidatos++;

            }
            if (votos[i] == 5) {
                votoNulo++;
            }
            if (votos[i] == 6) {
                votoBranco++;
            }
            while (votos[i] > 6) {
                if (votos[i] > 6) {
                    System.out.println("Códigos inválidos");
                    break;
                }

            }
            totalVotos = votosCandidatos + votoBranco + votoNulo;
            porcentagemNulo = (float) (votoNulo / totalVotos) * 100;
            porcentagemBranco = (float) (votoBranco / totalVotos) * 100;

        }
        System.out.println("Total de votos para os candidatos: " + votosCandidatos);
        System.out.println("Total de votos nulos: " + votoNulo);
        System.out.println("Total de votos em branco: " + votoBranco);
        System.out.println("Porcentagem de votos nulos sobre o total de votos: " + porcentagemNulo + "%");
        System.out.println("porcentagem de votos em branco sobre o total de votos: " + porcentagemBranco + "%");
    }catch (InputMismatchException e){
    System.out.println("Programa não pode inserir letra ou símbolo.");
    }
}}

