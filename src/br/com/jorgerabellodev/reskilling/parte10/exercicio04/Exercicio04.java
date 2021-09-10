package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.Scanner;

/**
 * Crie uma aplicação para a secretaria de uma escola, em que sejam controladas as informações sobre Alunos,
 * Disciplinas e Matrículas.
 * Antes de a escola começar a funcionar, todas as disciplinas foram cadastradas.
 * Quando o aluno chega à escola, deve ser feito um cadastro dos seus dados pessoais. Só depois, ele é,
 * anualmente, matriculado em disciplinas.
 * Os atributos das classes são:
 * Aluno (código, nome)
 * Disciplina (código, nome, carga horária geral)
 * DisciplinaPratica (carga horária prática)
 * Matricula (ano_letivo, serie, aluno, disciplina, nota1Bim, nota2Bim, nota3Bim, nota4Bim)
 * O atributo aluno na classe Matricula deve ser uma referência para a classe Aluno.
 * O atributo disciplina na classe Matricula deve ser uma referência para a classe Disciplina.
 * A DisciplinaPratica deve possuir todas as características da classe Disciplina, mais as suas especificida-
 * des (herança).
 * Essa aplicação deve fornecer meios para:
 * a) Cadastrar as disciplinas oferecidas na escola (práticas ou não).
 * b) Cadastrar alunos.
 * c) Matricular aluno em uma disciplina qualquer.
 * d) Lançar notas de um aluno.
 * e) Mostrar Boletim do aluno.
 * <p>
 * Você deverá possuir um conjunto de alunos, de disciplinas e de matrículas. Como sugestão, trabalhe
 * com, no máximo, dez alunos, cinco disciplinas e trinta matrículas (controle o preenchimento máximo).
 * Para a opção 1:
 * Cadastre uma disciplina por vez (prática ou não). O código deverá ser único.
 * Deverá existir um único vetor de disciplinas para referenciar tanto disciplinas sem prática quanto dis-
 * ciplinas práticas.
 * O usuário, durante a execução, decidirá se deseja cadastrar uma disciplina prática ou não.
 * Para a opção 2:
 * Cadastre um aluno por vez. O código deverá ser único.
 * Para a opção 3:
 * Matricule um aluno em uma disciplina (prática ou não) por vez.
 * Aluno e Matrícula já devem ter sido cadastrados.
 * Não matricule um aluno mais que uma vez, na mesma disciplina, no mesmo ano.
 * No momento da matrícula, o valor das notas deverá ser zero.
 * Para a opção 4:
 * O usuário deverá informar o código do aluno, o código da disciplina, o ano e o bimestre. Se houver
 * alguma matrícula com essas características, solicitar a digitação da nota correspondente, alterando o objeto.
 * Caso contrário, mostrar a mensagem Matrícula Inválida.
 * Para a opção 5:
 * O usuário deverá informar o código do aluno e o ano. A aplicação deverá procurar os dados corres-
 * pondentes e mostrar um relatório, conforme abaixo. Caso os dados informados não correspondam a uma
 * matrícula, mostrar a mensagem Matrícula Inválida.
 * <p>
 * Código: 1234
 * Nome: Joãozinho
 * Ano: 2011
 * <p>
 * DISCIPLINA           CH          CH PRÁTICA      1 BIM       2 BIM       3 BIM       4 BIM       MEDIA
 * INGLES               100         50                          5           7           10          7,5
 * PORTUGUÊS            140                         8           8           9           7           8
 * MATEMÁTICA           160         40              3           7           9           6           6,33
 * GEOGRAFIA            80                          8,5         9,5         6,0         7           7,75
 * <p>
 * Disciplinas práticas têm cálculo de média ponderada, em que as notas do 2 o e 4 o bimestres possuem
 * peso 2 e as demais, peso 1. Para as outras disciplinas, a média é aritmética.
 */
public class Exercicio04 {
    public static void main(String[] args) {

        Disciplina disciplina = new Disciplina();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        Aluno aluno = new Aluno();
        AlunoDao alunoDao = new AlunoDao();
        Matricula matricula = new Matricula();
        MatriculaDao matriculaDao = new MatriculaDao();

        int opcao = 0;
        int menu;
        Scanner ler = new Scanner(System.in);

        Disciplina disciplina1 = new Disciplina(1, "INGLÊS", 100, 50);
        Disciplina disciplina2 = new Disciplina(2, "PORTUGUÊS", 140);
        Disciplina disciplina3 = new Disciplina(3, "MATEMÁTICA", 160, 40);
        Disciplina disciplina4 = new Disciplina(4, "GEOGRAFIA", 80);


        disciplinaDao.salvar(disciplina1);
        disciplinaDao.salvar(disciplina2);
        disciplinaDao.salvar(disciplina3);
        disciplinaDao.salvar(disciplina4);

        Aluno aluno1 = new Aluno(1, "Rodrigo");
        Aluno aluno2 = new Aluno(2, "Ryan");
        Aluno aluno3 = new Aluno(3, "Luke");

        alunoDao.salvar(aluno1);
        alunoDao.salvar(aluno2);
        alunoDao.salvar(aluno3);

        Matricula matricula1 = new Matricula(1, "INGLÊS    ", 2021, "8ª", 8, 7, 8.0, 7);
        Matricula matricula2 = new Matricula(1, "MATEMÁTICA", 2021, "8ª", 8, 10, 10, 10);
        Matricula matricula3 = new Matricula(2, "INGLÊS    ", 2020, "8ª", 0, 0, 0, 7.70);
        Matricula matricula4 = new Matricula(2, "MATEMÁTICA", 2020, "8ª", 8.70, 0, 0, 0);

        matriculaDao.salvar(matricula1);
        matriculaDao.salvar(matricula2);
        matriculaDao.salvar(matricula3);
        matriculaDao.salvar(matricula4);


        while (opcao != 6) {
            System.out.println("Escolha uma das opções a seguir:\n1 - Cadastrar disciplina;\n2 - cadastrar aluno;\n3 - Matricular aluno na disciplina;\n4 - Cadastrar nota;\n5 - Boletim do aluno.");
            String opcaoDigitada = ler.next().trim();

            while (!disciplina.isInt(opcaoDigitada)) {
                System.out.println("Escolha uma das opções a seguir:\n1 - Cadastrar disciplina;\n2 - cadastrar aluno;\n3 - Matricular aluno na disciplina\n4 - Cadastrar nota;\n5 - Boletim do aluno.");
                opcaoDigitada = ler.next().trim();

            }
            opcao = Integer.parseInt(opcaoDigitada);

            switch (opcao) {
                case 1:
                    disciplina.cadastrarDisciplina();
                    break;
                case 2:
                    aluno.cadastrarAluno();
                    break;
                case 3:
                    matricula.matricularAluno();

                    break;
                case 4:
                    matricula.cadastrarNotas();
                    break;
                case 5:
                    matricula.boletimAluno();
                    break;

                default:
                    System.out.println("Opção inválida!\n");

            }
            while (true) {
                System.out.println("Escolha uma opção: \n1 - Continuar o programa;\n2 - Finalizar o programa! ");
                String menuDigitado = ler.next().trim();

                while (!disciplina.isInt(menuDigitado)) {
                    System.out.println("Escolha uma opção: \n1 - Continuar o programa;\n2 - Finalizar o programa! ");
                    menuDigitado = ler.next().trim();

                }
                menu = Integer.parseInt(menuDigitado);

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
