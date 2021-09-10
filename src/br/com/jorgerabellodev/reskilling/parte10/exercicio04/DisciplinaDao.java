package br.com.jorgerabellodev.reskilling.parte10.exercicio04;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements RepoDisciplinaDao {

    public static List<Disciplina> listaDisciplina = new ArrayList<>();

    @Override
    public Disciplina salvar(Disciplina disciplina) {
        listaDisciplina.add(disciplina);
        return disciplina;
    }

    @Override
    public List<Disciplina> findAll() {
        return listaDisciplina;
    }

}
