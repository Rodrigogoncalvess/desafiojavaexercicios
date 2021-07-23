package br.com.jorgerabellodev.reskilling.parte07;

import java.text.Collator;
import java.util.Scanner;

/**
 * A busca por subcadeias dentro de grandes cadeias de caracteres é um problema clássico na computação,
 * especificamente em bancos de dados. Faça um programa que receba uma cadeia de caracteres e uma
 * subcadeia, determine e mostre quantas vezes a subcadeia aparece dentro da cadeia.
 * <p>
 * OBS: O tamanho da subcadeia obrigatoriamente deve ser menor que o da cadeia.
 * Exemplos:
 * Entradas:
 * Cadeia = aaaassdffffghssiiii
 * Subcadeia = ss
 * Saída: a subcadeia aparece 2 vez(es) na cadeia
 * Entradas:
 * Cadeia = xxxxxaauuuyyyydrtsss
 * Subcadeia = yydrts
 * Saída: a subcadeia aparece 1 vez(es) na cadeia.
 * Entradas:
 * Cadeia = fffffhuiojjjjkkkkkssjh
 * Subcadeia = fdkjfdfjdiiiioooooopppppwwqertttesss
 * Erro! Tamanho incorreto. Digite outra subcadeia.
 * Subcadeia = dsh
 * Saída: a subcadeia não está contida na cadeia.
 */
public class Exercicio23 {
    public static void main(String[] args) {

        String cadeia;
        String subCadeia;
        int contador = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a cadeia de caracteres:");
        cadeia= scanner.next();

        System.out.println("Digite a subcadeia de caracteres:");
        subCadeia= scanner.next();

        int qtd = cadeia.indexOf(subCadeia);

        if (cadeia.equals("")) {
            System.out.println("A subcadeia não está contida na cadeia");

        } else if (cadeia.length() < subCadeia.length()) {
            System.out.println("Erro! Tamanho incorreto. Digite outra subcadeia.");

        } else {
            while (qtd >= 0) {
                qtd = qtd + 1;
                contador = contador + 1;
                qtd = cadeia.indexOf(subCadeia, qtd);
            }
            System.out.println("Subcadeia aparece " + contador + " vez(es) na cadeia");
        }
    }
}









