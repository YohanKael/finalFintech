package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Enderecos;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public interface EnderecosDao {

    void init(ServletConfig config) throws ServletException;

    void save(Enderecos endereco) throws DBException;

    void atualizar(Enderecos endereco) throws DBException;

    void remove(int codigo) throws DBException;

    List<Enderecos> listar();

    Enderecos buscar(int id);
}
