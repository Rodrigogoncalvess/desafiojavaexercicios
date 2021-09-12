package br.com.jorgerabellodev.reskilling.parte10.exercicio05;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao implements RepoFuncionarioDao {

    public static List<Funcionario> listaFuncionario = new ArrayList<>();

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        listaFuncionario.add(funcionario);
        return funcionario;
    }

    @Override
    public Funcionario excluir(Funcionario funcionario) {
        listaFuncionario.remove(funcionario);
        return funcionario;
    }


    public Funcionario atualizar(int i, Funcionario funcionario) {
        listaFuncionario.set(i, funcionario);
        return funcionario;
    }


    @Override
    public List<Funcionario> findAll() {
        return listaFuncionario;
    }
}
