package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.Scanner;

public class Aluno {

    private int codigo;
    private String nome;

    AlunoDao alunoDao = new AlunoDao();
    Disciplina disciplina = new Disciplina();

    Scanner ler = new Scanner(System.in);

    public Aluno(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Aluno() {
    }

    @Override
    public String
    toString() {
        return "Aluno{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean validarCodigoAluno(int codigo) {
        for (Aluno aluno : alunoDao.listaAluno) {
            if (aluno.codigo == codigo) {
                System.out.println("Código digitado já existe no cadastro!");
                return true;
            }
        }
        return false;
    }

    public boolean validarNomeAluno(String nome) {
        for (Aluno aluno : alunoDao.listaAluno) {
            if (aluno.nome.equalsIgnoreCase(nome)) {
                System.out.println("Nome digitado já existe no cadastro com outro código!");
                return true;
            }
        }
        return false;
    }

    public void cadastrarAluno() {
        if (alunoDao.listaAluno.size() < 10) {
            System.out.println("Informe o código do aluno para realizar o cadastro");
            String codigoDigitado = ler.next().trim();

            while (!disciplina.isInt(codigoDigitado)) {
                System.out.println("Informe o código do aluno para realizar o cadastro");
                codigoDigitado = ler.next().trim();
            }
            codigo = Integer.parseInt(codigoDigitado);

            if (!validarCodigoAluno(codigo)) {

                System.out.println("Informe o nome do aluno para realizar o cadastro");
                String nome = ler.next().concat(ler.nextLine()).toUpperCase();

                while (validarNomeAluno(nome)) {
                    System.out.println("Informe o nome do aluno para realizar o cadastro");
                    nome = ler.next().concat(ler.nextLine()).toUpperCase();

                }


                Aluno alunos = new Aluno(codigo, nome);
                alunoDao.salvar(alunos);


            }
        } else {
            System.out.println("Não será possível realizar novo cadastro de aluno, limite máximo de cadastramento já foi utilizado! ");

        }

    }

    public boolean existeAluno(int codigo) {
        for (Aluno aluno : alunoDao.listaAluno) {
            if (aluno.codigo == codigo) {
                return true;
            }
        }
        System.out.println("Aluno ainda não foi cadastrado no sistema!");
        return false;
    }

    public String existeCodigoMaisNome(int codigo) {
        for (Aluno aluno : alunoDao.listaAluno) {
            if (aluno.getCodigo() == codigo) {
                return aluno.nome;
            }
        }

        return null;
    }
}
