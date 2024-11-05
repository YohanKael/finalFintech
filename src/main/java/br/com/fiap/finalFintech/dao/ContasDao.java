package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Conta;

import java.sql.SQLException;
import java.util.List;

public interface ContasDao {

    void save(Conta conta) throws DBException;

    void atualizar(Conta conta) throws DBException;

    void remove(int codigo) throws DBException;

    List<Conta> listar();

    Conta buscar(int id);
}
