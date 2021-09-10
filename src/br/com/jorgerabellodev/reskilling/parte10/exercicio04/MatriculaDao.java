package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements RepoMatriculaDao {

    public static List<Matricula> listaMatricula = new ArrayList<>();


    @Override
    public Matricula salvar(Matricula matricula) {
        listaMatricula.add(matricula);
        return matricula;
    }

    @Override
    public List<Matricula> findAll() {
        return listaMatricula;
    }

    public Matricula atualizar(int i, Matricula matricula) {
        listaMatricula.set(i, matricula);
        return matricula;
    }
}
