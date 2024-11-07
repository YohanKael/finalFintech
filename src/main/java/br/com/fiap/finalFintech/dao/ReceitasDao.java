package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Despesas;
import br.com.fiap.finalFintech.model.Receitas;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public interface ReceitasDao {

    void init(ServletConfig config) throws ServletException;

    void save(Receitas receita) throws DBException;

    void atualizar(Receitas receita) throws DBException;

    void remove(int codigo) throws DBException;

    List<Receitas> listar();

    Receitas buscar(int id);
}
