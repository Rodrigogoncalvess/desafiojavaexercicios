package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.Scanner;

public class Disciplina {

    private int codigoDisciplina;
    private String nomeDisciplina;
    private int cargaHoraria;
    private int cargaHorariaPratica;

    Scanner ler = new Scanner(System.in);
    DisciplinaDao disciplinaDao = new DisciplinaDao();

    public Disciplina(int codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(int codigoDisciplina, String nomeDisciplina, int cargaHoraria, int cargaHorariaPratica) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public Disciplina() {
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHorariaPratica() {
        return cargaHorariaPratica;
    }

    public boolean isInt(String valid) {
        try {
            Integer.valueOf(valid);
            return true;
        } catch (Exception e) {
            System.out.println("Programa não pode ser digitado letra nem simbolo.\n");

        }
        return false;
    }

    public void cadastrarDisciplina() {

        if (disciplinaDao.listaDisciplina.size() < 5) {

            System.out.println("Informe o código da disciplina para realizar o cadastro");
            String codigo = ler.next().concat(ler.nextLine());

            while (!isInt(codigo)) {
                System.out.println("Necessário que informe número para cadastrar o código da disciplina, digite novamente o código:");
                codigo = ler.next().concat(ler.nextLine());
            }

            codigoDisciplina = Integer.parseInt(codigo);

            if (!validarCodigoDisciplina(codigoDisciplina)) {

                System.out.println("Informe o nome da disciplina para realizar o cadastro");
                nomeDisciplina = ler.next().concat(ler.nextLine()).toUpperCase();


                while (validarNomeDisciplina(nomeDisciplina)) {
                    System.out.println("Informe o nome do aluno para realizar o cadastro");
                    nomeDisciplina = ler.next().concat(ler.nextLine()).toUpperCase();

                }
                System.out.println("Informe a carga horária da disciplina:");
                String cargaHorariaDigitada = ler.next().trim();


                while (!isInt(cargaHorariaDigitada)) {
                    System.out.println("Necessário que informe número para cadastrar a carga horária da disciplina, digite novamente a carga horária:");
                    cargaHorariaDigitada = ler.next().trim();
                }
                cargaHoraria = Integer.parseInt(cargaHorariaDigitada);

                while (true) {
                    System.out.println("Deseja inserir carga horária prática para essa disciplina?\nDigite 1 - Sim / 2 - Não");
                    String opcaoDigitada = ler.next().trim();

                    while (!isInt(opcaoDigitada)) {
                        System.out.println("Necessário que informe número para escolher a opção desejada, digite novamente um número válido:");
                        opcaoDigitada = ler.next().trim();
                    }
                    int opcao = Integer.parseInt(opcaoDigitada);

                    if (opcao == 1) {
                        System.out.println("Informe a carga horária prática desta disciplina");
                        String cargaHorariaPraticaDigitada = ler.next().trim();

                        while (!isInt(cargaHorariaPraticaDigitada)) {
                            System.out.println("Necessário que informe número para cadastrar a carga horária prática da disciplina, digite novamente a carga horária:");
                            cargaHorariaPraticaDigitada = ler.next().trim();
                        }
                        cargaHorariaPratica = Integer.parseInt(cargaHorariaPraticaDigitada);

                        Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria, cargaHorariaPratica);
                        disciplinaDao.salvar(disciplina);
                        break;
                    } else if (opcao == 2) {
                        Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria);
                        disciplinaDao.salvar(disciplina);
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }


            }
        } else {
            System.out.println("Não será possível realizar novo cadastro de disciplina, limite máximo de cadastramento já foi atingido! ");

        }
    }

    private boolean validarNomeDisciplina(String nomeDisciplina) {
        for (Disciplina disciplina : disciplinaDao.listaDisciplina) {
            if (disciplina.nomeDisciplina.equalsIgnoreCase(nomeDisciplina)) {
                System.out.println("Nome da disciplina informado já se encontra cadastrado no sistema!");
                return true;
            }
        }
        return false;
    }

    private boolean validarCodigoDisciplina(int codigoDisciplina) {
        for (Disciplina disciplina : disciplinaDao.listaDisciplina) {
            if (disciplina.codigoDisciplina == codigoDisciplina) {
                System.out.println("Código da disciplina informado já se encontra cadastrado no sistema!");
                return true;
            }
        }
        return false;
    }

    public boolean existeDisciplina(String nome) {
        for (Disciplina disciplinas : disciplinaDao.listaDisciplina) {
            if (disciplinas.nomeDisciplina.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        System.out.println("Disciplina ainda não foi cadastrado no sistema!");
        return false;
    }

    public boolean existeCodigoDisciplina(int codigo) {
        for (Disciplina disciplina : disciplinaDao.listaDisciplina) {
            if (disciplina.codigoDisciplina == codigo) {
                return true;
            }
        }
        System.out.println("Disciplina não existe no cadastro!");
        return false;

    }

    public String existeCodigoDisciplinaMaisNome(int codigo) {
        for (Disciplina disciplina : disciplinaDao.listaDisciplina) {
            if (disciplina.codigoDisciplina == codigo) {
                return disciplina.nomeDisciplina;
            }
        }

        return null;
    }


}
