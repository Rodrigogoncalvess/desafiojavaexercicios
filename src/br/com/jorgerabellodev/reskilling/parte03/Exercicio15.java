package br.com.jorgerabellodev.reskilling.parte03;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma empresa fez uma pesquisa de mercado para saber se as pessoas gostaram ou não de um novo pro-
 * duto lançado. Para isso, forneceu o sexo do entrevistado e sua resposta (S — sim; ou N — não). Sabe-se
 * que foram entrevistadas dez pessoas. Faça um programa que calcule e mostre:
 * ■ ■ o número de pessoas que responderam sim;
 * ■ ■ o número de pessoas que responderam não;
 * ■ ■ o número de mulheres que responderam sim; e
 * ■ ■ a percentagem de homens que responderam não, entre todos os homens analisados.
 */
public class Exercicio15 {
    public static void main(String[] args) {

        var sexo = new String[4];
        var resposta = new String[4];
        var respoderamSim = 0;
        var respoderamNao = 0;
        var mulheres = 0;
        var homem = 0;
        var homemNão = 0;
        var percentual = 0.0;


        var scanner = new Scanner(System.in);

        for (var i = 0; i < sexo.length; i++) {
            System.out.print("Informe seu sexo" +
                    " \nM — Masculino \nF — Feminino ");

            sexo[i] = scanner.next();
           while (!sexo[i].equals("M")&& !sexo[i].equals("F")){
               System.out.print("\nEscolha uma das opções abaixo:" +
                       " \nM — Masculino \nF — Feminino ");
               sexo[i] = scanner.next();

            }

            System.out.print("Resposta" +
                    " \nS — Sim \nN — Não ");
            resposta[i] = scanner.next();
            while (!resposta[i].equals("S")&& !resposta[i].equals("N")){

                System.out.print("\nResponda uma das opções abaixo:" +
                        " \nS — Sim \nN — Não ");
                resposta[i] = scanner.next();
            }

            if (resposta[i].equals("S")) {
                respoderamSim++;

            } else if (resposta[i].equals("N")) {
                respoderamNao++;
            }
            if (sexo[i].equals("F") && resposta[i].equals("S")) {
                mulheres++;
            }
            if (sexo[i].equals("M")) {
                homem++;
            }
            if (sexo[i].equals("M") && resposta[i].equals("N")) {
                homemNão++;
            }
            percentual =(double) homemNão / homem * 100;
        }
        System.out.println("Número de pessoas que responderam não: " + respoderamNao);
        System.out.println("Número de pessoas que responderam sim: " + respoderamSim);
        System.out.println("Número de mulheres que responderam sim: " + mulheres);
        System.out.printf("Percentagem de homens que responderam não: %.2f" , percentual);
    }
}

