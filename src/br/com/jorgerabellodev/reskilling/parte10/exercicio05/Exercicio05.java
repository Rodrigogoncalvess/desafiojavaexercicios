package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.Scanner;

/**
 * O departamento de pessoal de uma empresa deseja automatizar o cadastro dos funcionários. Para isso, repas-
 * sou os seguintes requisitos à equipe de analistas contratada:
 * É necessário o cadastramento dos funcionários e seus respectivos dependentes. Suas características são:
 * Funcionário: numeroFuncionario, nomeFuncionario, cargo, salário.
 * Dependente: funcionario (referência para um objeto da classe Funcionario), nomeDependente.
 * Existem diversos funcionários com quantidade diferenciada de dependentes.
 * Sua aplicação deverá mostrar as seguintes opções ao usuário:
 * 1) Cadastrar funcionário
 * Cada vez que essa operação for realizada, você deverá criar um novo objeto Funcionário, preencher
 * seus dados e inseri-lo no conjunto de funcionários da empresa.
 * O código do funcionário deve ser único.
 * Logo após, deverá realizar o cadastro de dependentes. Isso implica na criação de vários objetos da
 * classe Dependente e inseri-los no conjunto de dependentes (cada funcionário pode ter zero, um ou mais
 * dependentes. O usuário dará essa quantidade).
 * Você deverá verificar se há espaço nos vetores para esses cadastramentos.
 * 2) Mostrar bônus mensal de cada funcionário
 * Os funcionários têm 2% de aumento em seu salário para cada dependente. Por isso, mostre o nome de
 * cada funcionário, seguido da quantidade de dependentes que possui e do bônus a quem tem direito.
 * 3) Excluir funcionário
 * Você deverá excluir da lista um funcionário cujo código será informado pelo usuário.
 * Todos os dependentes desse funcionário também deverão ser excluídos.
 * Caso o funcionário informado não esteja cadastrado, mostre uma mensagem de erro “Funcionário
 * Inexistente”.
 * 4) Alterar salário de um funcionário
 * Em cada posição do conjunto de funcionários, existe um objeto Funcionario. Considerando que os
 * objetos funcionários possuam o método setSalario, você deverá procurar um funcionário (cujo código é
 * informado pelo usuário) e alterar o seu salário.
 * O valor do novo salário também deverá ser informado pelo usuário.
 * Caso o funcionário informado não esteja cadastrado, mostre uma mensagem de erro “Funcionário
 * Inexistente”.
 * OBSERVAÇÕES:
 * ■ ■ todos os atributos das classes devem ser private ;
 * ■ ■ cada atributo deve ter um método getter e um setter ;
 */
public class Exercicio05 {

    public static void main(String[] args) {
        int opcao = 0;

        Funcionario funcionario = new Funcionario();
        FuncionarioDao funcionarioDao = new FuncionarioDao();

        DependenteDao dependenteDao = new DependenteDao();

        Funcionario funcionario1 = new Funcionario(1, "RODRIGO", "ANALISTA", 1500);
        Funcionario funcionario2 = new Funcionario(2, "RYAN", "ANALISTA", 4500);

        funcionarioDao.salvar(funcionario1);
        funcionarioDao.salvar(funcionario2);

        Dependente dependente1 = new Dependente("RYAN", 1);
        Dependente dependente2 = new Dependente("TATY", 1);
        Dependente dependente3 = new Dependente("LUKE", 2);

        dependenteDao.salvar(dependente1);
        dependenteDao.salvar(dependente2);
        dependenteDao.salvar(dependente3);

        Scanner ler = new Scanner(System.in);

        while (opcao != 6) {
            System.out.println("Escolha uma das opções a seguir:\n1 - Cadastrar funcionário;\n2 - Bônus dos funcionários;\n3 - Excluir funcionário;\n4 - Atualizar salário;\n5 - Todos os funcionários cadastrados. ");
            String opcaoDigitada = ler.next().trim();

            while (!funcionario.isInt(opcaoDigitada)) {
                System.out.println("Escolha uma das opções a seguir:\n1 - Cadastrar funcionário\n2 -Bônus dos funcionários; \n3 - Excluir funcionário;\n4 - Atualizar salário\n5 - Todos os funcionários cadastrados. ");
                opcaoDigitada = ler.next().trim();

            }
            opcao = Integer.parseInt(opcaoDigitada);

            switch (opcao) {
                case 1:
                    funcionario.cadastrarFuncionario();
                    break;
                case 2:
                    funcionario.bonusDosFuncionarios();
                    break;
                case 3:
                    funcionario.excluirFuncionario();
                    break;
                case 4:
                    funcionario.atualizarSalario();
                    break;
                case 5:
                    System.out.println(funcionarioDao.findAll());
                    break;

                default:
                    System.out.println("Opção inválida!\n");

            }
            while (true) {
                System.out.println("\nEscolha uma opção: \n1 - Continuar o programa;\n2 - Finalizar o programa! ");
                String menuDigitado = ler.next().trim();

                while (!funcionario.isInt(menuDigitado)) {
                    System.out.println("Escolha uma opção: \n1 - Continuar o programa;\n2 - Finalizar o programa! ");
                    menuDigitado = ler.next().trim();

                }
                int menu = Integer.parseInt(menuDigitado);

                if (menu == 1) {
                    break;
                } else if (menu == 2) {
                    System.out.println("Programa finalizado!");
                    return;
                } else {
                    System.out.println("Opção inválida!");
                }

            }
        }

    }
}
