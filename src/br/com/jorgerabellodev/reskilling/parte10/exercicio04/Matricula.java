package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Matricula {

    private int codigo;
    private String nomeDisciplina;
    private int anoLetivo;
    private String serie;
    private String nomeAluno;


    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double media;


    Aluno aluno = new Aluno();
    Disciplina disciplina = new Disciplina();
    DisciplinaDao disciplinaDao = new DisciplinaDao();


    MatriculaDao matriculaDao = new MatriculaDao();

    Scanner ler = new Scanner(System.in);

    public Matricula(int codigo, String nomeDisciplina, int anoLetivo, String serie, double nota1, double nota2, double nota3, double nota4) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public Matricula() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public String getSerie() {
        return serie;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getNota4() {
        return nota4;
    }


    @Override
    public String toString() {
        return
                "codigo = " + codigo +
                        "\nDisciplina = " + nomeDisciplina +
                        "\nAno letivo = " + anoLetivo +
                        "\nSerie = " + serie +
                        "\nNota 1 = " + nota1 +
                        "\nNota 2 = " + nota2 +
                        "\nNota 3 = " + nota3 +
                        "\nNota 4 = " + nota4 + "\n";
    }

    public void matricularAluno() {

        if (matriculaDao.listaMatricula.size() < 30) {
            System.out.println("Informe o codigo do aluno para realizar a matrícula:");
            codigo = ler.nextInt();

            if (aluno.existeAluno(codigo)) {


                System.out.println("Informe a disciplina que deseja cadastrar o aluno:");
                nomeDisciplina = ler.next().trim();


                while (!disciplina.existeDisciplina(nomeDisciplina)) {
                    System.out.println("Necessário informar uma disciplina válida, digite novamente a disciplina que deseja cadastrar o aluno:");
                    nomeDisciplina = ler.next().trim();

                }
                System.out.println("Informe o ano da matrícula:");
                String ano = ler.next();

                while (!validarAno(ano)) {
                    System.out.println("Formato do ano deve ser digitado (yyyy), digite novamente o ano da matrícula:");
                    ano = ler.next();
                }
                anoLetivo = Integer.parseInt(ano);

                if (!existeCadastroMesmaDisciplina()) {

                    System.out.println("Informa a série do aluno:");
                    serie = ler.next().concat(ler.nextLine());

                    Matricula matricula = new Matricula(codigo, nomeDisciplina, anoLetivo, serie, nota1, nota2, nota3, nota4);
                    matriculaDao.salvar(matricula);
                }

            }
        } else {
            System.out.println("Não será possível realizar novo cadastro da matrícula, limite máximo de cadastramento já foi atingido! ");

        }

    }

    private boolean existeCadastroMesmaDisciplina() {
        for (Matricula matriculas : matriculaDao.listaMatricula) {
            if (matriculas.codigo == codigo) {
                if (matriculas.nomeDisciplina.equalsIgnoreCase(nomeDisciplina)) {
                    if (matriculas.anoLetivo == anoLetivo) {
                        System.out.println("Aluno já está  cadastrado nesta disciplina neste ano!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validarAno(String ano) {
        return ano.matches("[0-9]{4}");
    }

    public boolean existeCodigoAlunoMatriculado(int codigoAluno) {
        for (Matricula matricula : matriculaDao.listaMatricula) {
            if (matricula.codigo == codigoAluno) {
                return true;
            }
        }
        System.out.println("Aluno ainda não foi cadastrado em nenhuma disciplina!");
        return false;

    }

    public void cadastrarNotas() {

        System.out.println("Informe código do aluno;");
        String codigoDigitado = ler.next().trim();

        while (!disciplina.isInt(codigoDigitado)) {
            System.out.println("Informe código do aluno;");
            codigoDigitado = ler.next().trim();
        }
        codigo = Integer.parseInt(codigoDigitado);

        if (aluno.existeAluno(codigo)) {

            if (existeCodigoAlunoMatriculado(codigo)) {

                System.out.println("Informe código da disciplina;");
                String codigoDisciplinaDigitado = ler.next().trim();

                while (!disciplina.isInt(codigoDigitado)) {
                    System.out.println("Informe código da disciplina;");
                    codigoDisciplinaDigitado = ler.next().trim();
                }
                int codigoDisciplina = Integer.parseInt(codigoDisciplinaDigitado);

                if (disciplina.existeCodigoDisciplina(codigoDisciplina)) {

                    nomeDisciplina = disciplina.existeCodigoDisciplinaMaisNome(codigoDisciplina);

                    System.out.println("Informe o ano para cadastrar as notas:");
                    String ano = ler.next().trim();

                    while (!validarAno(ano)) {
                        System.out.println("Informe o ano para cadastrar as notas:");
                        ano = ler.next().trim();
                    }
                    anoLetivo = Integer.parseInt(ano);

                    if (existeAnoCadastrado(anoLetivo, nomeDisciplina)) {

                        int opcao = 0;
                        while (opcao != 4) {
                            System.out.println("Informe qual bimestre deseja lançar nota:\nDigite: 1 - 1° BIM\nDigite: 2 - 2° BIM\nDigite: 3 - 3° BIM\nDigite: 4 - 4° BIM");
                            String opcaoDigitada = ler.next().trim();
                            if (!disciplina.isInt(opcaoDigitada)) {
                                System.out.println("Informe qual bimestre deseja lançar nota:\nDigite: 1 - 1° BIM\nDigite: 2 - 2° BIM\nDigite: 3 - 3° BIM\nDigite: 4 - 4° BIM");
                                opcaoDigitada = ler.next().trim();
                            }
                            opcao = Integer.parseInt(opcaoDigitada);

                            switch (opcao) {
                                case 1:
                                    System.out.println("Digite a nota do 1° bimestre:");
                                    String notaDigitada = ler.next().trim();

                                    if (!isDouble(notaDigitada)) {
                                        System.out.println("Digite a nota do 1° bimestre:");
                                        notaDigitada = ler.next().trim();
                                    }
                                    nota1 = Double.parseDouble(notaDigitada);
                                    alterarNota1(codigo, nota1, nomeDisciplina);
                                    break;
                                case 2:
                                    System.out.println("Digite a nota do 2° bimestre:");
                                    notaDigitada = ler.next().trim();

                                    if (!isDouble(notaDigitada)) {
                                        System.out.println("Digite a nota do 2° bimestre:");
                                        notaDigitada = ler.next().trim();
                                    }
                                    nota2 = Double.parseDouble(notaDigitada);
                                    alterarNota2(codigo, nota2, nomeDisciplina);
                                    break;
                                case 3:
                                    System.out.println("Digite a nota do 2° bimestre:");
                                    notaDigitada = ler.next().trim();

                                    if (!isDouble(notaDigitada)) {
                                        System.out.println("Digite a nota do 2° bimestre:");
                                        notaDigitada = ler.next().trim();
                                    }
                                    nota3 = Double.parseDouble(notaDigitada);
                                    alterarNota3(codigo, nota3, nomeDisciplina);
                                    break;
                                case 4:
                                    System.out.println("Digite a nota do 2° bimestre:");
                                    notaDigitada = ler.next().trim();

                                    if (!isDouble(notaDigitada)) {
                                        System.out.println("Digite a nota do 2° bimestre:");
                                        notaDigitada = ler.next().trim();
                                    }
                                    nota4 = Double.parseDouble(notaDigitada);
                                    alterarNota4(codigo, nota4, nomeDisciplina);
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                            }

                            while (true) {
                                System.out.println("Escolha uma opção: \n1 - Continuar aplicando notas;\n2 - Finalizar a aplicações de notas! ");
                                String menuDigitado = ler.next().trim();

                                while (!disciplina.isInt(menuDigitado)) {
                                    System.out.println("Escolha uma opção: \n1 - Continuar aplicando notas;\n2 - Finalizar a aplicações de notas! ");
                                    menuDigitado = ler.next().trim();

                                }
                                int menu = Integer.parseInt(menuDigitado);

                                if (menu == 1) {
                                    break;
                                } else if (menu == 2) {
                                    System.out.println("Aplicação de notas finalizado!!");
                                    return;
                                } else {
                                    System.out.println("Opção inválida!");
                                }
                            }


                            System.out.println(matriculaDao.findAll());
                        }
                    }
                }
            }
        }
    }

    private boolean existeAnoCadastrado(int ano, String nomeDisciplina) {

        for (Matricula matriculas : matriculaDao.listaMatricula) {
            if (matriculas.anoLetivo == ano && matriculas.getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                return true;
            }
        }
        System.out.println("Ano informado não existe nenhum cadastro deste aluno!");
        return false;
    }

    private boolean existeAnoCadastradoParaAluno(int ano) {

        for (Matricula matriculas : matriculaDao.listaMatricula) {
            if (matriculas.anoLetivo == ano) {
                return true;
            }
        }
        System.out.println("Ano informado não existe nenhum cadastro deste aluno!");
        return false;
    }

    public boolean isDouble(String valid) {
        try {
            Double.valueOf(valid);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Programa não pode ser digitado letra nem simbolo.\n");

        }
        return false;
    }

    public void alterarNota1(int codigoAluno, double nota1, String nomeDisciplina) {
        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {
            if (matriculaDao.listaMatricula.get(i).getCodigo() == codigoAluno && matriculaDao.listaMatricula.get(i).getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                Matricula matricula = new Matricula(matriculaDao.listaMatricula.get(i).codigo, matriculaDao.listaMatricula.get(i).nomeDisciplina, matriculaDao.listaMatricula.get(i).anoLetivo, matriculaDao.listaMatricula.get(i).serie, nota1, matriculaDao.listaMatricula.get(i).nota2, matriculaDao.listaMatricula.get(i).nota3, matriculaDao.listaMatricula.get(i).nota4);
                matriculaDao.atualizar(i, matricula);
            }
        }
    }

    public void alterarNota2(int codigoAluno, double nota1, String nomeDisciplina) {
        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {

            if (matriculaDao.listaMatricula.get(i).getCodigo() == codigoAluno && matriculaDao.listaMatricula.get(i).getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                Matricula matricula = new Matricula(matriculaDao.listaMatricula.get(i).codigo, matriculaDao.listaMatricula.get(i).nomeDisciplina, matriculaDao.listaMatricula.get(i).anoLetivo, matriculaDao.listaMatricula.get(i).serie, matriculaDao.listaMatricula.get(i).nota1, nota2, matriculaDao.listaMatricula.get(i).nota3, matriculaDao.listaMatricula.get(i).nota4);
                matriculaDao.atualizar(i, matricula);
            }

        }
    }

    public void alterarNota3(int codigoAluno, double nota1, String nomeDisciplina) {
        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {

            if (matriculaDao.listaMatricula.get(i).getCodigo() == codigoAluno && matriculaDao.listaMatricula.get(i).getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                Matricula matricula = new Matricula(matriculaDao.listaMatricula.get(i).codigo, matriculaDao.listaMatricula.get(i).nomeDisciplina, matriculaDao.listaMatricula.get(i).anoLetivo, matriculaDao.listaMatricula.get(i).serie, matriculaDao.listaMatricula.get(i).nota1, matriculaDao.listaMatricula.get(i).nota2, nota3, matriculaDao.listaMatricula.get(i).nota4);
                matriculaDao.atualizar(i, matricula);
            }

        }
    }

    public void alterarNota4(int codigoAluno, double nota1, String nomeDisciplina) {
        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {

            if (matriculaDao.listaMatricula.get(i).getCodigo() == codigoAluno && matriculaDao.listaMatricula.get(i).getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                Matricula matricula = new Matricula(matriculaDao.listaMatricula.get(i).codigo, matriculaDao.listaMatricula.get(i).nomeDisciplina, matriculaDao.listaMatricula.get(i).anoLetivo, matriculaDao.listaMatricula.get(i).serie, matriculaDao.listaMatricula.get(i).nota1, matriculaDao.listaMatricula.get(i).nota2, matriculaDao.listaMatricula.get(i).nota3, nota4);
                matriculaDao.atualizar(i, matricula);
            }

        }
    }

    public void boletimAluno() {

        System.out.println("Informe código do aluno;");
        String codigoDigitado = ler.next().trim();

        while (!disciplina.isInt(codigoDigitado)) {
            System.out.println("Informe código do aluno;");
            codigoDigitado = ler.next().trim();
        }
        codigo = Integer.parseInt(codigoDigitado);

        nomeAluno = aluno.existeCodigoMaisNome(codigo);

        if (aluno.existeAluno(codigo)) {
            existeCodigoAlunoMatriculado(codigo);

            System.out.println("Informe o ano para obter o boletim:");
            String ano = ler.next().trim();

            while (!validarAno(ano)) {
                System.out.println("Informe o ano para cadastrar as notas:");
                ano = ler.next().trim();
            }
            anoLetivo = Integer.parseInt(ano);

            if (existeAnoCadastradoParaAluno(anoLetivo)) {

                dadosAluno(codigo, anoLetivo);
                dadosDisciplina(codigo, anoLetivo);

            }

        }
    }

    public void dadosAluno(int codigo, int anoLetivo) {

        for (Matricula matricula : matriculaDao.listaMatricula) {
            if (matricula.codigo == codigo && matricula.anoLetivo == anoLetivo) {
                System.out.println("Código: " + matricula.codigo + "\nNome: " + nomeAluno + "\nAno: " + matricula.anoLetivo + "\n");
                break;
            }
        }
    }

    public void dadosDisciplina(int codigo, int anoLetivo) {
        DecimalFormat decimal = new DecimalFormat("0.00");

        System.out.println("DISCIPLINA  " + "CH " + "  CH PRÁTICA  " + "1° BIM " + "     2° BIM " + "     3° BIM " + "     4° BIM " + "       MÉDIA");
        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {
            media = calcularMedia(matriculaDao.listaMatricula.get(i).nomeDisciplina);
            if (matriculaDao.listaMatricula.get(i).codigo == codigo && matriculaDao.listaMatricula.get(i).anoLetivo == anoLetivo) {
                for (int j = 0; j < disciplinaDao.listaDisciplina.size(); j++) {

                    System.out.println(matriculaDao.listaMatricula.get(i).getNomeDisciplina() + "  " + disciplinaDao.listaDisciplina.get(j).getCargaHoraria() + "     " + disciplinaDao.listaDisciplina.get(j).getCargaHorariaPratica() + "         " + matriculaDao.listaMatricula.get(i).getNota1() + "         " + matriculaDao.listaMatricula.get(i).getNota2() + "         " + matriculaDao.listaMatricula.get(i).getNota3() + "       " + matriculaDao.listaMatricula.get(i).getNota4() + "           " + decimal.format(media));
                    break;
                }
            }
        }
        System.out.println();
    }

    public Double calcularMedia(String nomeDisciplina) {
        final int PESO_UM = 1;
        final int PESO_DOIS = 2;

        for (int i = 0; i < matriculaDao.listaMatricula.size(); i++) {
            if (matriculaDao.listaMatricula.get(i).getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                double somaNota = (matriculaDao.listaMatricula.get(i).getNota1() * PESO_UM) + (matriculaDao.listaMatricula.get(i).getNota2() * PESO_DOIS) +
                        (matriculaDao.listaMatricula.get(i).getNota3() * PESO_UM) + (matriculaDao.listaMatricula.get(i).getNota4() * PESO_DOIS);

                double somaPeso = (PESO_UM + PESO_DOIS + PESO_UM + PESO_DOIS);

                return somaNota / somaPeso;
            }

        }
        return 0.0;
    }

}