package br.com.jorgerabellodev.reskilling.parte04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Faça um programa que preencha um vetor com sete números inteiros, calcule e mostre:
 * ■ ■ os números múltiplos de 2;
 * ■ ■ os números múltiplos de 3;
 * ■ ■ os números múltiplos de 2 e de 3
 */
public class Exercicio02 {
    public static void main(String[] args) {

        var numero = new int[7];
        var multiploDois = new int[7];
        var multiploTres = new int[7];
        var multipos = new int[7];
        var dois = 0;
        var tres = 0;
        var todosNumeros = 0;


        Scanner scanner = new Scanner(System.in);
        try {

            for (int i = 0; i < numero.length; i++) {
                System.out.println("Informe o número: ");
                numero[i] = scanner.nextInt();
            }
            for (int i = 0; i < numero.length; i++) {


                if (numero[i] % 2 == 0) {
                    multiploDois[dois] = numero[i];
                    dois++;
                }
                if (numero[i] % 3 == 0) {
                    multiploTres[tres] = numero[i];
                    tres++;

                }
                if (numero[i] % 2 == 0 && numero[i] % 3 == 0) {
                    multipos[todosNumeros] = numero[i];
                    todosNumeros++;
                }
            }
            var contadorDois = new int[dois];
            for (int i = 0; i < dois; i++) {
                contadorDois[i] = multiploDois[i];

            }
            var contadorTres = new int[tres];
            for (int i = 0; i < tres; i++) {
                contadorTres[i] = multiploTres[i];

            }
            var todosNumerosMultiplos = new int[todosNumeros];
            for (int i = 0; i < todosNumeros; i++) {
                todosNumerosMultiplos[i] = multipos[i];
            }
            System.out.println("Números multiplos de 2: " + Arrays.toString(contadorDois));
            System.out.println("Números multiplos de 3: " + Arrays.toString(contadorTres));
            System.out.println("os números múltiplos de 2 e de 3: " + Arrays.toString(todosNumerosMultiplos));
        } catch (InputMismatchException i) {
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }
    }
}
