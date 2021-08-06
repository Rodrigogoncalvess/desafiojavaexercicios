package br.com.jorgerabellodev.reskilling.parte08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Faça um programa que utilize as informações a seguir:
 * ------------------------------------------------------------
 * MÉDICOS         PACIENTES       CONSULTAS
 * ------------------------------------------------------------
 * codMedico       codPaciente     numProntuario
 * nome            nomePaciente    dataConsulta
 * endereco        endereco        diagnostico
 * salario         idade           codMedico
 * codPaciente
 * ------------------------------------------------------------
 * O programa deverá:
 * a) criar uma rotina para realizar inclusões e alterações no cadastro de pacientes e de médicos;
 * b) criar uma rotina para excluir um médico (lembre-se: se existir alguma consulta realizada por esse médico, ele
 * não poderá ser excluído);
 * c) criar uma rotina para mostrar todas as consultas realizadas em uma data qualquer escolhida pelo usuário
 * (lembre-se de mostrar também o nome do médico e o nome do paciente envolvido na consulta).
 */

public class Exercicio11 {
    static Scanner ler = new Scanner(System.in);

    static int opcaoMenu;
    static boolean continuar = true;
    static int opcaoContinuar;
    static ArrayList<Medico> listaMedico = new ArrayList<Medico>();
    static ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
    static ArrayList<Consulta> listaConsulta = new ArrayList<Consulta>();

    public static void main(String[] args) {

        while (continuar) {

            System.out.println("Ferramenta de cadastro\n");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Cadastrar médico");
            System.out.println("3 - Atualizar dados do paciente");
            System.out.println("4 - Atualizar dados do médico");
            System.out.println("5 - Cadastrar consulta");
            System.out.println("6 - Buscar consulta");
            System.out.println("7 - Excluir médico");
            System.out.println("8 - Listar médicos");
            System.out.println("\n\nInforme a opção desejada: ");
            opcaoMenu = ler.nextInt();

            switch (opcaoMenu) {

                case 1:
                    cadastrarPaciente();
                    break;

                case 2:
                    cadastrarMedico();
                    break;

                case 3:
                    AtualizarPaciente();
                    break;

                case 4:
                    atualizarMedico();
                    break;

                case 5:
                    cadastrarConsulta();
                    break;

                case 6:
                    buscarConsulta();
                    break;

                case 7:
                    excluirMedico();
                    break;

                case 8:
                    listarMedico();
                    break;

            }

            System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
            opcaoContinuar = ler.nextInt();

            if (opcaoContinuar == 1) {
                continuar = true;
            } else if (opcaoContinuar == 2) {
                System.out.println("Obrigado por usar o programa");
                continuar = false;
            } else {
                System.out.println("Opção inválida");
                break;
            }

        }

    }

    public static void cadastrarPaciente() {
        int codPaciente;
        String nomePaciente;
        String enderecoPaciente;
        int idadePaciente;

        System.out.println("Informe o codigo do paciente: ");
        codPaciente = ler.nextInt();

        System.out.println("Informe o nome do paciente: ");
        nomePaciente = ler.next().concat(ler.nextLine());

        System.out.println("Informe o endereço do paciente: ");
        enderecoPaciente = ler.next().concat(ler.nextLine());

        System.out.println("Informe a idade do paciente: ");
        idadePaciente = ler.nextInt();

        Paciente paciente = new Paciente(codPaciente, nomePaciente, enderecoPaciente, idadePaciente);
        listaPaciente.add(paciente);

    }

    public static void AtualizarPaciente() {
        int codPaciente;
        String nomePaciente;
        String enderecoPaciente;
        int idadePaciente;

        if (!listaPaciente.isEmpty()) {

            System.out.println("Informe o código do paciente que deseja atualizar: ");
            codPaciente = ler.nextInt();

            for (int i = 0; i < listaPaciente.size(); i++) {

                if (listaPaciente.get(i).codPaciente == codPaciente) {
                    System.out.println("Informe o nome do paciente: ");
                    nomePaciente = ler.next().concat(ler.nextLine());

                    System.out.println("Informe o endereço do paciente: ");
                    enderecoPaciente = ler.next().concat(ler.nextLine());

                    System.out.println("Informe a idade do paciente: ");
                    idadePaciente = ler.nextInt();

                    Paciente paciente = new Paciente(codPaciente, nomePaciente, enderecoPaciente, idadePaciente);
                    listaPaciente.set(i, paciente);
                } else {
                    System.out.println("Paciente não existe!");
                }
            }

        } else {
            System.out.println("Não existem pacientes cadastrado.");
        }

    }

    public static void cadastrarMedico() {

        int codMedico;
        String nome;
        String endereco;
        double salario;
        int codPaciente;

        System.out.println("Informe o codigo do médico: ");
        codMedico = ler.nextInt();

        System.out.println("Informe o nome do médico: ");
        nome = ler.next().concat(ler.nextLine());

        System.out.println("Informe o endereço do médico: ");
        endereco = ler.next().concat(ler.nextLine());

        System.out.println("Informe o salário do médico: ");
        salario = ler.nextDouble();

        System.out.println("Informe o codigo do paciente do médico: ");
        codPaciente = ler.nextInt();

        Medico medico = new Medico(codMedico, nome, endereco, salario, codPaciente);
        listaMedico.add(medico);
    }

    public static void atualizarMedico() {
        int codMedico;
        String endereco;
        double salario;

        if (!listaMedico.isEmpty()) {

            System.out.println("Informe o código do medico que deseja atualizar: ");
            codMedico = ler.nextInt();

            for (int i = 0; i < listaMedico.size(); i++) {

                if (listaMedico.get(i).codMedico == codMedico) {

                    System.out.println("Informe o endereço do médico: ");
                    endereco = ler.next().concat(ler.nextLine());

                    System.out.println("Informe o salário do médico: ");
                    salario = ler.nextDouble();

                    Medico medico = new Medico(listaMedico.get(i).codMedico, listaMedico.get(i).nome, endereco, salario,
                            listaMedico.get(i).codPaciente);

                    listaMedico.set(i, medico);

                    break;

                } else {
                    System.out.println("Médico não existe!");
                }

            }

        } else {
            System.out.println("Não existem médicos cadastrado.");

        }
    }

    public static void cadastrarConsulta() {
        int numProntuario;
        String dataConsulta;
        String diagnostico;
        int codMedico;

        System.out.println("Informe o numero do prontuario: ");
        numProntuario = ler.nextInt();

        System.out.println("Informe a data da consulta: ");
        dataConsulta = ler.next().concat(ler.nextLine());

        System.out.println("Informe o diagnostico: ");
        diagnostico = ler.next().concat(ler.nextLine());

        System.out.println("Informe o código do médico: ");
        codMedico = ler.nextInt();

        Consulta consulta = new Consulta(numProntuario, dataConsulta, diagnostico, codMedico);
        listaConsulta.add(consulta);
    }

    public static void buscarConsulta() {
        String dataConsulta;
        String nomeMedico;
        String nomePaciente;

        if (!listaConsulta.isEmpty()) {

            System.out.println("Informe uma data para buscar a(s) consulta(s): ");
            dataConsulta = ler.next();

            for (int i = 0; i < listaConsulta.size(); i++) {

                if (listaConsulta.get(i).dataConsulta.contains(dataConsulta)) {

                    nomeMedico = buscarNomeMedico(listaConsulta.get(i).codMedico);
                    nomePaciente = buscarNomePaciente(listaConsulta.get(i).codMedico);

                    System.out.println("####### Formulário N˚ " + (i + 1) + " #######");
                    System.out.println("Dados da consulta referente a data " + dataConsulta);
                    System.out.println("Numero prontuário: " + listaConsulta.get(i).numProntuario);
                    System.out.println("Diagnostico: " + listaConsulta.get(i).diagnostico);
                    System.out.println("Código do médico: " + listaConsulta.get(i).codMedico);

                    System.out.println("Nome do médico: " + nomeMedico);
                    System.out.println("Nome do paciente: " + nomePaciente);
                    System.out.println();

                } else {

                    System.out.println("Não existem consulta para a data informada.");
                }

            }
        } else {
            System.out.println("Não existem consultas cadastradas.");
        }

    }

    public static String buscarNomeMedico(int codMedico) {

        for (int i = 0; i < listaMedico.size(); i++) {

            if (listaMedico.get(i).codMedico == codMedico) {
                return listaMedico.get(i).nome;
            }

        }

        return "Médico não cadastrado nesse sistema";

    }

    public static String buscarNomePaciente(int codMedico) {

        for (int i = 0; i < listaMedico.size(); i++) {

            if (listaMedico.get(i).codMedico == codMedico) {

                if (listaMedico.get(i).codPaciente == listaPaciente.get(i).codPaciente) {
                    return listaPaciente.get(i).nomePaciente;
                }
            }

        }

        return "Problemas ao buscar o nome do paciente";
    }

    public static void listarMedico() {
        Iterator itr = listaMedico.iterator();

        Iterator itr2 = listaPaciente.iterator();


        while (itr.hasNext()) {
            Medico st = (Medico) itr.next();
            System.out.println("Medico: " + st.codMedico + " " + st.nome + " " + st.endereco);
        }

        if (listaMedico.isEmpty()) {
            System.out.println("Não existem médicos cadastrado");
        }

        while (itr2.hasNext()) {
            Paciente st2 = (Paciente) itr2.next();
            System.out.println("Medico: " + st2.codPaciente + " " + st2.nomePaciente + " " + st2.enderecoPaciente);
        }

        if (listaPaciente.isEmpty()) {
            System.out.println("Não existem pacientes cadastrado");
        }

    }

    public static void excluirMedico() {
        int codMedico;
        boolean existe = false;

        System.out.println("Informe o código do médico que deseja excluir: ");
        codMedico = ler.nextInt();

        if (!listaMedico.isEmpty()) {

            if (!listaConsulta.isEmpty()) {

                for (int i = 0; i < listaConsulta.size(); i++) {

                    if (listaConsulta.get(i).codMedico == codMedico) {
                        System.out.println(
                                "Existem consultas para o médico selecionado, não será possível seguir com a exclusão");
                        break;

                    } else {

                        for (int j = 0; j < listaMedico.size(); j++) {
                            if (listaMedico.get(j).codMedico == codMedico) {
                                listaMedico.remove(j);
                                System.out.println("Médico com o código (" + codMedico + ") removido com sucesso!");
                                existe = true;
                                break;
                            } else {
                                existe = false;
                            }
                        }

                        if (existe == false) {
                            System.out.println("Não existe o médico consultado na lista de médicos");
                            break;
                        }

                    }
                }

            } else {

                System.out.println("Lista de consultas vázia, seguindo com exclusão...");

                for (int j = 0; j < listaMedico.size(); j++) {

                    if (listaMedico.get(j).codMedico == codMedico) {
                        listaMedico.remove(j);
                        System.out.println("Médico com o código (" + codMedico + ") removido com sucesso!");
                        break;
                    } else {

                        System.out.println("Não existe o médico consultado na lista de médicos");
                        break;
                    }
                }

            }

        } else {

            System.out.println("Não existem médicos cadastrado.");
        }

    }

}

class Medico {
    int codMedico;
    String nome;
    String endereco;
    double salario;
    int codPaciente;

    public Medico(int codMedico, String nome, String endereco, double salario, int codPaciente) {
        this.codMedico = codMedico;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.codPaciente = codPaciente;
    }
}

class Paciente {
    int codPaciente;
    String nomePaciente;
    String enderecoPaciente;
    int idadePaciente;

    public Paciente(int codPaciente, String nomePaciente, String enderecoPaciente, int idadePaciente) {
        this.codPaciente = codPaciente;
        this.nomePaciente = nomePaciente;
        this.enderecoPaciente = enderecoPaciente;
        this.idadePaciente = idadePaciente;
    }

}

class Consulta {
    int numProntuario;
    String dataConsulta;
    String diagnostico;
    int codMedico;

    public Consulta(int numProntuario, String dataConsulta, String diagnostico, int codMedico) {
        this.numProntuario = numProntuario;
        this.dataConsulta = dataConsulta;
        this.diagnostico = diagnostico;
        this.codMedico = codMedico;
    }

}

