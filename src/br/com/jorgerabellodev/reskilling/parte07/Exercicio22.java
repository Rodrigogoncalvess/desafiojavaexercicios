package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Considere uma string composta por várias subsequências, por exemplo, cccaaaabbbbxdddddddddaaannn.
 * A menor subsequência é a da letra x, com apenas um elemento; a maior subsequência é a da letra d,
 * com nove elementos. Faça um programa para ler uma string e mostrar qual é a letra que ocorre na
 * maior subsequência e o tamanho dessa subsequência.
 * Exemplo:
 * Entrada: aaabbbbaaa
 * Saída: maior b, tamanho 4
 */
public class Exercicio22 {
    public static void main(String[] args) {
        String frase = "aaabbbbxxxxxxaaaaa";
        int contador = 0;
        int maior = 0;
        char letra = 0;

        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < frase.length(); j++) {
                if (frase.charAt(i) == frase.charAt(j)) {
                    contador++;

                } else {
                    contador = 0;
                }
                if (contador > maior) {
                    maior = contador;
                    letra = frase.charAt(i);
                }
            }
            contador = 0;
        }
        System.out.println("A letra " + letra + " tem a maior sequência " + maior);
    }
}