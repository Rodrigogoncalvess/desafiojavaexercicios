package br.com.jorgerabellodev.reskilling.parte06;

/**
 * Faça uma sub-rotina que receba como parâmetro dois vetores de dez números inteiros, determine e mostre o vetor intersecção entre eles.
 */
public class Exercicio19 {

    static int[] vetor1 = new int[]{3, 4, 5, 11, 12, 21, 33, 7, 71, 10};
    static int[] vetor2 = new int[]{3, 2, 14, 21, 10, 31, 18, 8, 17, 6};

    public static void main(String[] args) {

        SubRotina sub = new SubRotina();

        sub.interseccao();

    }

    static class SubRotina {
        public void interseccao() {
            for (int i = 0; i < vetor1.length; i++) {

                for (int j = 0; j < vetor2.length; j++) {
                    if (vetor1[i] == vetor2[j]) {
                        System.out.println(vetor1[i]);
                    }
                }
            }

        }
    }


}

