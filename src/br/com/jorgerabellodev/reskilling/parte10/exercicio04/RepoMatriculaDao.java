package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.List;

public interface RepoMatriculaDao {

    Matricula salvar(Matricula matricula);

    List<Matricula> findAll();
}
