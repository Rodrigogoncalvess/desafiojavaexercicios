package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.List;

public interface RepoFuncionarioDao {

    Funcionario salvar(Funcionario funcionario);

    Funcionario excluir(Funcionario funcionario);


    List<Funcionario> findAll();
}
