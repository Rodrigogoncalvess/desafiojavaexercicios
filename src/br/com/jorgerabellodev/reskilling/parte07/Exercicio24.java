package br.com.jorgerabellodev.reskilling.parte07;

/**
 * Faça um programa que receba um verbo regular terminado em ER e mostre sua conjugação no presente.
 * Exemplo:
 * verbo: vender
 * Eu vendo
 * Tu vendes
 * Ele vende
 * Ela vende
 * Nós vendemos
 * Vós vendeis
 * Eles vendem
 * Elas vendem
 */
public class Exercicio24 {

    public static void main(String[] args) {
        String verbo = "vender";
        String verboConjulgado;
        int posicaoVerbo = verbo.lastIndexOf("er");

        for (int i = 1; i < 9; i++) {
            switch (i) {
                case 1:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "o";
                    System.out.println("Eu " + verboConjulgado);
                    break;
                case 2:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "es";
                    System.out.println("Tu " + verboConjulgado);
                    break;
                case 3:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "e";
                    System.out.println("Ele " + verboConjulgado);
                    break;
                case 4:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "e";
                    System.out.println("Ela " + verboConjulgado);
                    break;
                case 5:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "emos";
                    System.out.println("Nós " + verboConjulgado);
                    break;
                case 6:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "eis";
                    System.out.println("Vós " + verboConjulgado);
                    break;
                case 7:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "em";
                    System.out.println("Eles " + verboConjulgado);
                    break;
                case 8:
                    verboConjulgado = verbo.substring(0, posicaoVerbo) + "em";
                    System.out.println("Elas " + verboConjulgado);
                    break;
            }
        }
    }
}


