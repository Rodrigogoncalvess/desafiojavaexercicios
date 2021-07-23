package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que criptografe cada palavra de uma frase, substituindo por ? a última metade de
 * seus caracteres.
 * Exemplo:
 * A aula é boa mas poderia ser mais curta.
 * ? au?? ? b?? m?? pod???? s?? ma?? cu???.
 */
public class Exercicio18 {
    public static void main(String[] args) {

        String frase = "A aula é boa mas poderia ser mais curta.";

        String[] fraseNova;

        fraseNova = frase.replace(".", " ").split(" ");

        for (int i = 0; i < fraseNova.length; i++) {
            int tamanho = fraseNova[i].length();
            int caracter = fraseNova[i].length() / 2;

            fraseNova[i] = fraseNova[i].substring(0, caracter);

            for (int j = fraseNova[i].length(); j < tamanho; j++) {
                fraseNova[i] = fraseNova[i].concat("?");
            }

        }
        System.out.println(String.join(" ", fraseNova));

    }
}







