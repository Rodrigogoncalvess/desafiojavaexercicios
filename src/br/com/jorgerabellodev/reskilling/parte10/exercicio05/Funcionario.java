package br.com.jorgerabellodev.reskilling.parte10.exercicio05;


import java.util.Scanner;

public class Funcionario {

    private int numeroFuncionario;
    private String nomeFuncionario;
    private String cargo;
    private double salario;
    Dependente dependente;


    Dependente dependentes = new Dependente();
    DependenteDao dependenteDao = new DependenteDao();
    FuncionarioDao funcionarioDao = new FuncionarioDao();

    Scanner ler = new Scanner(System.in);

    public Funcionario(int numeroFuncionario, String nomeFuncionario, String cargo, double salario) {
        this.numeroFuncionario = numeroFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(int numeroFuncionario, String nomeFuncionario, String cargo, double salario, Dependente dependente) {
        this.numeroFuncionario = numeroFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.dependente = dependente;
    }

    public Funcionario() {
    }


    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public Dependente getDependente() {
        return dependente;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "numeroFuncionario=" + numeroFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }

    public static boolean isInt(String valid) {
        try {
            Integer.valueOf(valid);
            return true;
        } catch (Exception e) {
            System.out.println("Programa não pode ser digitado letra nem simbolo.\n");

        }
        return false;
    }

    public boolean isDouble(String valid) {
        try {
            Double.valueOf(valid);
            return true;
        } catch (Exception e) {
            System.out.println("Programa não pode ser digitado letra nem simbolo.\n");

        }
        return false;
    }

    public void cadastrarFuncionario() {

        System.out.println("Informe o número do funcionário para realizar o cadastro");
        String codigo = ler.next().concat(ler.nextLine());

        while (!isInt(codigo)) {
            System.out.println("Necessário que informe número para cadastrar o funcionário, digite novamente o número(s):");
            codigo = ler.next().concat(ler.nextLine());
        }

        numeroFuncionario = Integer.parseInt(codigo);

        if (!validarNumeroFuncionario(numeroFuncionario)) {

            System.out.println("Informe o nome do funcionário para realizar o cadastro");
            nomeFuncionario = ler.next().concat(ler.nextLine()).toUpperCase();

            if (!existeFuncionario(nomeFuncionario)) {

                System.out.println("Informe o cargo:");
                cargo = ler.next().concat(ler.nextLine()).toUpperCase();

                System.out.println("Informe o salário:");
                String salarioDigitado = ler.next();

                while (!isDouble(salarioDigitado)) {
                    System.out.println("Informe o salário:");
                    salarioDigitado = ler.next();

                }
                salario = Double.parseDouble(salarioDigitado);

                dependentes.cadastrarDependente(numeroFuncionario);


                Funcionario funcionario = new Funcionario(numeroFuncionario, nomeFuncionario, cargo, salario);
                funcionarioDao.salvar(funcionario);

            }


        }


    }

    public boolean existeFuncionario(String nome) {
        for (Funcionario funcionario : funcionarioDao.listaFuncionario) {
            if (funcionario.nomeFuncionario.equalsIgnoreCase(nome)) {
                System.out.println("Nome informado já existe cadastrado no sistema!");
                return true;
            }
        }
        return false;
    }

    public boolean existeCodigo(int codigo) {

        for (Funcionario funcionario : funcionarioDao.listaFuncionario) {
            if (funcionario.numeroFuncionario == codigo) {
                return true;
            }
        }
        System.out.println("Código informado não existe no cadastro!");
        return false;
    }

    private boolean validarNumeroFuncionario(int numero) {
        for (Funcionario funcionario : funcionarioDao.listaFuncionario) {
            if (funcionario.numeroFuncionario == numero) {
                System.out.println("Número do funcionário informado já se encontra cadastrado no sistema!");
                return true;
            }
        }
        return false;
    }

    public void bonusDosFuncionarios() {
        int count = 0;
        final double AUMENTO_DOIS_PORCENTO = 0.02;
        for (int i = 0; i < funcionarioDao.listaFuncionario.size(); i++) {
            double salario = funcionarioDao.listaFuncionario.get(i).salario;

            for (int j = 0; j < dependenteDao.listaDependente.size(); j++) {
                if (funcionarioDao.listaFuncionario.get(i).getNumeroFuncionario() == dependenteDao.listaDependente.get(j).getNumeroFuncionario()) {
                    count++;

                }
            }
            System.out.println("Funcionário : " + funcionarioDao.listaFuncionario.get(i).getNomeFuncionario() + " possui : " + count + " dependente e receberá um bônus equivalente a R$ " + (count * AUMENTO_DOIS_PORCENTO) * salario);
            count = 0;
        }

    }


    public void excluirFuncionario() {

        System.out.println("Informe o código do funcionário que deseja excluir:");
        String codigo = ler.next().concat(ler.nextLine());

        while (!isInt(codigo)) {
            System.out.println("Necessário que informe código (número) do funcionário que deseja excluir:");
            codigo = ler.next().concat(ler.nextLine());
        }
        numeroFuncionario = Integer.parseInt(codigo);
        existeCodigo(numeroFuncionario);
        excluirFuncionarioDoCadastro(numeroFuncionario);


    }

    public void excluirFuncionarioDoCadastro(int codigo) {
        for (int i = 0; i < funcionarioDao.listaFuncionario.size(); i++) {
            if (funcionarioDao.listaFuncionario.get(i).numeroFuncionario == codigo) {
                funcionarioDao.listaFuncionario.remove(i);
                for (int j = 0; j < dependenteDao.listaDependente.size(); j++) {
                    if (dependenteDao.listaDependente.get(j).getNumeroFuncionario() == codigo) {
                        dependenteDao.listaDependente.remove(j);

                    }
                }
            }
        }

    }

    public void atualizarSalario() {
        System.out.println("Informe o código do funcionário para atualizar o salário:");
        String codigo = ler.next().concat(ler.nextLine());

        while (!isInt(codigo)) {
            System.out.println("Necessário que informe o código do funcionário para atualizar o salário, digite novamente o código:");
            codigo = ler.next().concat(ler.nextLine());
        }

        numeroFuncionario = Integer.parseInt(codigo);
        if (existeCodigo(numeroFuncionario)) {


            System.out.println("Informe o salário novo:");
            String salarioDigitado = ler.next();

            while (!isDouble(salarioDigitado)) {
                System.out.println("Informe o salário:");
                salarioDigitado = ler.next();

            }
            salario = Double.parseDouble(salarioDigitado);

            for (int i = 0; i < funcionarioDao.listaFuncionario.size(); i++) {
                if (funcionarioDao.listaFuncionario.get(i).getNumeroFuncionario() == numeroFuncionario) {
                    Funcionario funcionario = new Funcionario(funcionarioDao.listaFuncionario.get(i).numeroFuncionario, funcionarioDao.listaFuncionario.get(i).nomeFuncionario, funcionarioDao.listaFuncionario.get(i).cargo, salario);
                    funcionarioDao.atualizar(i, funcionario);
                }


            }
        }
    }
}

