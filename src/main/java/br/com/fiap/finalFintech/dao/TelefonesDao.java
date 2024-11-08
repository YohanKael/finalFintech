package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Telefones;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public interface TelefonesDao {

    void init(ServletConfig config) throws ServletException;

    void save(Telefones telefone) throws DBException;

    void atualizar(Telefones telefone) throws DBException;

    void remove(int codigo) throws DBException;

    List<Telefones> listar();

    Telefones buscar(int id);
}