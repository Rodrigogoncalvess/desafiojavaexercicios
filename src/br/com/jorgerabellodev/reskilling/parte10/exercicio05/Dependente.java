package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.Scanner;

public class Dependente {

    private String nomeDependente;
    private int numeroFuncionario;

    DependenteDao dependenteDao = new DependenteDao();


    Scanner ler = new Scanner(System.in);

    public Dependente(String nomeDependente, int numeroFuncionario) {
        this.nomeDependente = nomeDependente;
        this.numeroFuncionario = numeroFuncionario;
    }

    public Dependente() {

    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "nomeDependente='" + nomeDependente + '\'' +
                ", numeroFuncionario=" + numeroFuncionario +
                '}';
    }

    public void cadastrarDependente(int numeroFuncionario) {

        while (true) {
            while (true) {
                System.out.println("Escolha uma opção: \n1 - Cadastrar dependente ;\n2 - Finalizar o cadastro! ");
                String menuDigitado = ler.next().trim();

                while (!Funcionario.isInt(menuDigitado)) {
                    System.out.println("Escolha uma opção: \n1 - Cadastrar dependente ;\n2 - Finalizar o cadastro! ");
                    menuDigitado = ler.next().trim();

                }
                int menu = Integer.parseInt(menuDigitado);

                if (menu == 1) {
                    break;
                } else if (menu == 2) {
                    System.out.println("Cadastro de dependentes finalizado!\n");
                    return;
                } else {
                    System.out.println("Opção inválida!");
                }
            }

            System.out.println("Informe o nome do dependente:");
            nomeDependente = ler.next().concat(ler.nextLine()).toUpperCase();

            Dependente dependente = new Dependente(nomeDependente, numeroFuncionario);
            dependenteDao.salvar(dependente);


        }
    }
}
