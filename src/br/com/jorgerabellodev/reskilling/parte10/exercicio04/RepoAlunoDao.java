package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.List;

public interface RepoAlunoDao {

    Aluno salvar(Aluno aluno);

    List<Aluno> findAll();
}
