package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Paises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDao {
    private Connection conexao;

    public PaisDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Paises pais) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_paises (id_pais, nm_pais) VALUES (seq_pais.nextval, ?)");
        stm.setString(1, pais.getNmPais());
        stm.executeUpdate();
    }


    private Paises parsePais(ResultSet result) throws SQLException {
        int idPais = result.getInt("id_pais");
        String nmPais = result.getString("nm_pais");
        return new Paises(idPais, nmPais);
    }


    public Paises pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_paises where id_pais = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("País não encontrado");
        return parsePais(result);
    }


    public List<Paises> getAllPaises() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_paises");
        ResultSet result = stm.executeQuery();
        List<Paises> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parsePais(result));
        }
        return lista;
    }

    public void atualizar(Paises pais) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_paises SET nm_pais = ? where id_pais = ?");
        stm.setString(1, pais.getNmPais());
        stm.setInt(2, pais.getIdPais());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_paises where id_pais = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("País não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
