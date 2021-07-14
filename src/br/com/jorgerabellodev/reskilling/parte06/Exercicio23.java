package br.com.jorgerabellodev.reskilling.parte06;

import java.util.Scanner;

/**
 * Crie um programa que receba três valores (obrigatoriamente maiores que zero), representando as medi-
 * das dos três lados de um triângulo.
 * Elabore sub-rotinas para:
 * ■ ■ determinar se esses lados formam um triângulo (sabe-se que, para ser triângulo, a medida de um lado qualquer deve ser inferior ou igual à soma das medidas dos outros dois).
 * ■ ■ determinar e mostrar o tipo de triângulo (equilátero, isósceles ou escaleno), caso as medidas formem um triângulo.
 * Todas as mensagens deverão ser mostradas no programa principal.
 */
public class Exercicio23 {

    static int valor1;
    static int valor2;
    static int valor3;

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro valor:");
        valor1 = scanner.nextInt();

        System.out.println("Digite o segundo valor:");
        valor2 = scanner.nextInt();

        System.out.println("Digite o terceiro valor:");
        valor3 = scanner.nextInt();

        sub.triangulo();
    }

    static class SubRotina {
        public void triangulo() {


            if ((valor1 < valor2 + valor3) && (valor2 < valor1 + valor3) && (valor3 < valor1 + valor2)) {
                if (valor1 == valor2 && valor1 == valor3) {
                    System.out.println("Triangulo Equilátero");
                } else if ((valor1 == valor2) || (valor1 == valor3)) {
                    System.out.println("Triangulo Isósceles");
                } else
                    System.out.println("Triângulo Escaleno");
            } else {
                System.out.println("Os valores informado não forma um triangulo!");
            }

        }
    }

}

