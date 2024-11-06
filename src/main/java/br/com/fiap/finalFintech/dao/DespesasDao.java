package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Despesas;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public interface DespesasDao {

    void init(ServletConfig config) throws ServletException;

    void save(Despesas despesa) throws DBException;

    void atualizar(Despesas despesa) throws DBException;

    void remove(int codigo) throws DBException;

    List<Despesas> listar();

    Despesas buscar(int id);

}
