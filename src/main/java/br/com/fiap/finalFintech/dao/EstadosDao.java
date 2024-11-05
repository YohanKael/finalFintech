package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Estados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EstadosDao {
    private Connection conexao;

    public EstadosDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Estados estado) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_estados (id_estado, nm_estado) VALUES (seq_estado.nextval, ?)");
        stm.setString(1, estado.getNmEstado());
        stm.executeUpdate();
    }


    private Estados parseEstado(ResultSet result) throws SQLException {
        int idEstado = result.getInt("id_estado");
        String nmEstado = result.getString("nm_estado");
        return new Estados(idEstado, nmEstado);
    }


    public Estados pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_estados where id_estado = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Estado não encontrado");
        return parseEstado(result);
    }


    public List<Estados> getAllEstados() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_estados");
        ResultSet result = stm.executeQuery();
        List<Estados> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseEstado(result));
        }
        return lista;
    }

    public void atualizar(Estados estado) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_estados SET nm_estado = ? where id_estado = ?");
        stm.setString(1, estado.getNmEstado());
        stm.setInt(2, estado.getIdEstado());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_estados where id_estado = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Estado não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
