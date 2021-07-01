package br.com.jorgerabellodev.reskilling.parte02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Uma empresa decidiu dar uma gratificação de Natal a seus funcionários, baseada no número de horas
 * extras e no número de horas que o funcionário faltou ao trabalho. O valor do prêmio é obtido pela con-
 * sulta à tabela que se segue, na qual:
 * H = número de horas extras – (2/3 * (número de horas falta))
 * <p>
 * ------------------------------------------------------------
 * H (MINUTOS)                      PRÊMIO (R$)
 * ------------------------------------------------------------
 * >= 2.400                         500,00
 * 1.800 A 2.400                    400,00
 * 1.200 A 1.800                    300,00
 * 600 A 1.200                    200,00
 * < 600                            100,00
 * ------------------------------------------------------------
 */
public class Exercicio25 {
    public static void main(String[] args) {

        var horaExtra = 0;
        var horaFalta = 0;
        var gratificacao = 0;


        var scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o número de horas extras: ");
            horaExtra = scanner.nextInt();

            System.out.println("Informe o número de horas que faltou: ");
            horaFalta = scanner.nextInt();
        }catch (InputMismatchException i){
            System.out.println("Programa não pode inserir letra ou símbolo.");
        }

        gratificacao = (horaExtra - (2 / 3 * (horaFalta)));

        if (gratificacao >= 2400) {
            System.out.println("Funcionário receberá uma gratificação de R$ 500,00");

        } else if (gratificacao >= 1800 && gratificacao < 2400) {
            System.out.println("Funcionário receberá uma gratificação de R$ 400,00");

        } else if (gratificacao >= 1200 && gratificacao < 1800) {
            System.out.println("Funcionário receberá uma gratificação de R$ 300,00");

        } else if (gratificacao >= 600 && gratificacao < 1200) {
            System.out.println("Funcionário receberá uma gratificação de R$ 200,00");

        } else if (gratificacao < 600) {
            System.out.println("Funcionário receberá uma gratificação de R$ 100,00");

        }
    }
}
