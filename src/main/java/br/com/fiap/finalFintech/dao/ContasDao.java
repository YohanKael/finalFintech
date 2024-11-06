package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Conta;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public interface ContasDao {

    void init(ServletConfig config) throws ServletException;


    void save(Conta conta) throws DBException;

    void atualizar(Conta conta) throws DBException;

    void remove(int codigo) throws DBException;

    List<Conta> listar();

    Conta buscar(int id);
}
