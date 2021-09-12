package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.ArrayList;
import java.util.List;

public class DependenteDao implements RepoDependenteDao {

    public static List<Dependente> listaDependente = new ArrayList<>();

    @Override
    public Dependente salvar(Dependente dependente) {
        listaDependente.add(dependente);
        return dependente;
    }

    public Dependente excluir(Dependente dependente) {
        listaDependente.remove(dependente);
        return dependente;
    }

    @Override
    public List<Dependente> findAll() {
        return listaDependente;
    }
}
