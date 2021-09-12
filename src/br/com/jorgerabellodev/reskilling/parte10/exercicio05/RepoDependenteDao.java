package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.List;

public interface RepoDependenteDao {

    Dependente salvar(Dependente dependente);

    Dependente excluir(Dependente dependente);

    List<Dependente> findAll();
}
