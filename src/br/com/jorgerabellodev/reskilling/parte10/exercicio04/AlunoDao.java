package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements RepoAlunoDao {

    public static List<Aluno> listaAluno = new ArrayList<>();

    @Override
    public Aluno salvar(Aluno aluno) {
        listaAluno.add(aluno);
        return aluno;
    }

    @Override
    public List<Aluno> findAll() {
        return listaAluno;
    }

}
