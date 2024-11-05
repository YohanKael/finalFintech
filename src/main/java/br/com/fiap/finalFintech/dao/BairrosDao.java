package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Bairros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BairrosDao {
    private Connection conexao;

    public BairrosDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Bairros bairro) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_bairros (id_bairro, ds_bairro) VALUES (seq_bairro.nextval, ?)");
        stm.setString(1, bairro.getDsBairro());
        stm.executeUpdate();
    }


    private Bairros parseBairro(ResultSet result) throws SQLException {
        int idBairro = result.getInt("id_bairro");
        String dsBairro = result.getString("ds_bairro");
        return new Bairros(idBairro, dsBairro);
    }


    public Bairros pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_bairros where id_bairro = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Bairro não encontrado");
        return parseBairro(result);
    }


    public List<Bairros> getAllBairros() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_bairros");
        ResultSet result = stm.executeQuery();
        List<Bairros> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseBairro(result));
        }
        return lista;
    }

    public void atualizar(Bairros bairro) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_bairros SET ds_bairro = ? where id_bairro = ?");
        stm.setString(1, bairro.getDsBairro());
        stm.setInt(2, bairro.getIdBairro());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_bairros where id_bairro = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Bairro não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
