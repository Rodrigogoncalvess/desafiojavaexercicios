package br.com.jorgerabellodev.reskilling.parte08;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utilize as informações a seguir para criar um controle automatizado de uma clínica médica. Sabe-se que
 * essa clínica deseja ter um controle semanal (de segunda a sexta-feira) das consultas realizadas.
 * A cada dia, cada médico pode realizar, no máximo, duas consultas. Considere que serão cadastrados três médicos e cinco pacientes.
 * <p>
 * Paciente(cod_pac, nome, endereço, fone)
 * Médico(cod_med, nome, fone, endereço)
 * Consulta(num_consulta, dia semana, hora, cod_med, cod_pac)
 * <p>
 * O programa deverá criar rotinas para:
 * a) cadastrar os pacientes, não permitindo dois pacientes com o mesmo código;
 * b) cadastrar os médicos, não permitindo dois médicos com o mesmo código;
 * c) cadastrar as consultas, obedecendo às especificações apresentadas;
 * d) pesquisar as consultas de determinado médico em certo dia da semana (segunda a sexta-feira);
 * e) mostrar um relatório contendo todas as consultas realizadas em um dia.
 */
public class Exercicio14 {


    static Scanner ler = new Scanner(System.in);
    static boolean continuar = true;

    public static void main(String[] args) {


        int opcaoMenu;
        boolean continuarMenu = true;
        int opcaoMenuContinuar;

        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        Consulta consulta = new Consulta();

        while (continuar) {


            System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar paciente; \n2 - Cadastrar médico;\n3 - Cadastrar consulta;\n4 - Pesquisar consulta;\n5 - Todas as consultas realizada no dia;");
            opcaoMenu = ler.nextInt();


            switch (opcaoMenu) {

                case 1:
                    paciente.cadastarPaciente();
                    break;
                case 2:
                    medico.cadastarMedico();
                    break;
                case 3:
                    consulta.cadastarConsulta();
                    break;
                case 4:
                    consulta.pesquisarConsultaMedica();
                    break;
                case 5:
                    consulta.todasConsultasMedicadoDia();
                    break;

            }
            while (continuarMenu) {
                System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                opcaoMenuContinuar = ler.nextInt();
                if (opcaoMenuContinuar == 1) {
                    continuar = true;
                    break;
                } else if (opcaoMenuContinuar == 2) {
                    System.out.println("Obrigado por usar o programa");
                    continuar = false;
                    return;
                } else {
                    System.out.println("Opção inválida");
                }
            }
        }

    }

    static class Paciente {

        int codigoPaciente;
        String nome;
        String endereco;
        String telefone;
        static ArrayList<Paciente> listaPaciente = new ArrayList<>();
        static final AtomicInteger idPaciente = new AtomicInteger(0);

        public Paciente(int codigoPaciente, String nome, String endereco, String telefone) {
            this.codigoPaciente = codigoPaciente;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        public Paciente() {

        }

        public void cadastarPaciente() {

            codigoPaciente = idPaciente.incrementAndGet();

            if (!validarCodigoPaciente(codigoPaciente)) {


                System.out.println("Informe o nome do paciente::");
                nome = ler.next().concat(ler.nextLine());

                System.out.println("Informe o endereço do paciente:");
                endereco = ler.next().concat(ler.nextLine());

                System.out.println("Informe o telefone do paciente:");
                telefone = ler.next().concat(ler.nextLine());

                Paciente paciente = new Paciente(codigoPaciente, nome, endereco, telefone);
                listaPaciente.add(paciente);
            } else {
                System.out.println("Código informado já existe, cadastre outro código para o paciente! ");
            }

        }

        public boolean validarCodigoPaciente(int codigoPaciente) {
            for (int i = 0; i < listaPaciente.size(); i++) {
                if (listaPaciente.get(i).codigoPaciente == codigoPaciente) {
                    return true;
                }
            }
            return false;
        }

        public void todos() {
            for (int i = 0; i < listaPaciente.size(); i++) {
                System.out.println("Paciente : " + listaPaciente.get(i).nome + " código do paciente " + listaPaciente.get(i).codigoPaciente);

            }
        }
    }

    static class Medico {
        int codigoMedico;
        String nome;
        String telefone;
        String endereco;
        static ArrayList<Medico> listaMedica = new ArrayList<>();
        static final AtomicInteger idMedico = new AtomicInteger(0);

        public Medico(int codigoMedico, String nome, String telefone, String endereco) {
            this.codigoMedico = codigoMedico;
            this.nome = nome;
            this.telefone = telefone;
            this.endereco = endereco;
        }

        public Medico() {

        }

        public void cadastarMedico() {

            codigoMedico = idMedico.incrementAndGet();

            if (!validarCodigoMedico(codigoMedico)) {


                System.out.println("Informe o nome do médico:");
                nome = ler.next().concat(ler.nextLine());
                ;

                System.out.println("Informe o telefone do médico:");
                telefone = ler.next().concat(ler.nextLine());


                System.out.println("Informe o endereço do médico:");
                endereco = ler.next().concat(ler.nextLine());
                ;


                Medico medico = new Medico(codigoMedico, nome, telefone, endereco);
                listaMedica.add(medico);
            } else {
                System.out.println("Código informado já existe, cadastre outro código para o médico! ");
            }

        }

        public boolean validarCodigoMedico(int codigoMedico) {
            for (int i = 0; i < listaMedica.size(); i++) {
                if (listaMedica.get(i).codigoMedico == codigoMedico) {
                    return true;
                }
            }
            return false;
        }

        public void todos() {
            for (int i = 0; i < listaMedica.size(); i++) {
                System.out.println("Medico : " + listaMedica.get(i).nome + " código do médico " + listaMedica.get(i).codigoMedico);

            }
        }
    }

    static class Consulta {
        int numeroCosulta;
        String[] diaDaSemana;
        int nomeDia;
        Calendar hora = Calendar.getInstance();
        int codigoMedico;
        int codigoPaciente;
        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        private static final AtomicInteger idConsulta = new AtomicInteger(0);
        SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");
        DateFormatSymbols symbols = new DateFormatSymbols();

        static ArrayList<Consulta> listaConsulta = new ArrayList<>();

        public Consulta(int numeroCosulta, String[] diaDaSemana, SimpleDateFormat horaFormatada, int codigoMedico, int codigoPaciente) {
            this.numeroCosulta = numeroCosulta;
            this.diaDaSemana = diaDaSemana;
            this.horaFormatada = horaFormatada;
            this.codigoMedico = codigoMedico;
            this.codigoPaciente = codigoPaciente;
        }

        public Consulta() {

        }

        public void cadastarConsulta() {

            numeroCosulta = idConsulta.incrementAndGet();

            nomeDia = hora.get(Calendar.DAY_OF_WEEK);

            if (!validarDiaDaSemana()) {

                diaDaSemana = symbols.getWeekdays();

                System.out.println("Digite o código do médico:");
                codigoMedico = ler.nextInt();

                if (medico.validarCodigoMedico(codigoMedico)) {

                    System.out.println("Digite o código do paciente:");
                    codigoPaciente = ler.nextInt();
                    if (paciente.validarCodigoPaciente(codigoPaciente)) {

                        if (!contarConsulta(codigoMedico)) {

                            Consulta consulta = new Consulta(numeroCosulta, diaDaSemana, horaFormatada, codigoMedico, codigoPaciente);
                            listaConsulta.add(consulta);

                        } else {

                            System.out.println("Não pode cadastrar mais consulta para o médico nesta data!");
                        }

                    } else {
                        System.out.println("Código do paciente não existe!");
                    }
                } else {
                    System.out.println("Código do médico não existe!");
                }
            } else {
                System.out.println("Final de semana não pode cadastrar consulta!");
            }

        }

        public boolean validarDiaDaSemana() {
            if (nomeDia == 1 || nomeDia == 7) {
                return true;
            }
            return false;
        }

        public boolean contarConsulta(int codigoMedico) {
            int contador = 0;
            int totalConsulta = 0;


            for (int i = 0; i < listaConsulta.size(); i++) {


                if (listaConsulta.get(i).codigoMedico == codigoMedico) {
                    contador++;
                    totalConsulta += contador;

                    if (totalConsulta > 2) {

                        return true;
                    }
                }
            }
            return false;
        }

        public boolean validarFormatoEscrita(String dia) {
            for (int i = 0; i < diaDaSemana.length; i++) {

                if (diaDaSemana[i].equalsIgnoreCase(dia)) {
                    return true;
                }

            }
            return false;
        }

        public void pesquisarConsultaMedica() {
            String dia;
            boolean verificacao;

            System.out.println("Informe o código do médico:");
            codigoMedico = ler.nextInt();

            if (medico.validarCodigoMedico(codigoMedico)) {

                System.out.println(" Digite o dia da semana para realizar a consulta:");
                dia = ler.next();
                verificacao = validarFormatoEscrita(dia);

                while (!verificacao) {
                    System.out.println(" Digite o dia da semana no formato(terça-feira) para seguir com a pesquisa:");
                    dia = ler.next();
                    verificacao = validarFormatoEscrita(dia);
                }

                if (diaDaSemana[nomeDia].equalsIgnoreCase(dia)) {
                    for (int i = 0; i < listaConsulta.size(); i++) {

                        System.out.println("Número da consulta :" + listaConsulta.get(i).numeroCosulta);
                        System.out.println("Dia da semana: " + listaConsulta.get(i).diaDaSemana[nomeDia]);
                        System.out.println("Hora que a consulta foi: " + horaFormatada.format(hora.getTime()));
                        System.out.println("Código do médico: " + listaConsulta.get(i).codigoMedico);
                        System.out.println("Código do paciente: " + listaConsulta.get(i).codigoPaciente + "\n");
                    }
                } else {
                    System.out.println("Dia informado não foi realizado nenhuma consulta!");
                }
            } else {
                System.out.println("Código do médico não existe!");
            }

        }

        public void todasConsultasMedicadoDia() {
            String dia;
            boolean verificacao;


            System.out.println(" Digite o dia da semana para realizar a consulta:");
            dia = ler.next();
            verificacao = validarFormatoEscrita(dia);

            while (!verificacao) {
                System.out.println(" Digite o dia da semana no formato(terça-feira) para seguir com a pesquisa:");
                dia = ler.next();
                verificacao = validarFormatoEscrita(dia);
            }

            if (diaDaSemana[nomeDia].equalsIgnoreCase(dia)) {
                for (int i = 0; i < listaConsulta.size(); i++) {

                    System.out.println("Número da consulta :" + listaConsulta.get(i).numeroCosulta);
                    System.out.println("Dia da semana: " + listaConsulta.get(i).diaDaSemana[nomeDia]);
                    System.out.println("Hora que a consulta foi: " + horaFormatada.format(hora.getTime()));
                    System.out.println("Código do médico: " + listaConsulta.get(i).codigoMedico);
                    System.out.println("Código do paciente: " + listaConsulta.get(i).codigoPaciente + "\n");
                }
            } else {
                System.out.println("Dia informado não foi realizado nenhuma consulta!");
            }
        }
    }

}
