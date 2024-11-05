package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Telefones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonesDao {
    private Connection conexao;

    public TelefonesDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Telefones telefone) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_telefones (idTelefone, nrCodigoPais, nrDdd, nrTelefone) VALUES (seq_telefone.nextval, ?, ?, ?)");
        stm.setString(1, telefone.getNrCodigoPais());
        stm.setString(2, telefone.getNrDdd());
        stm.setString(3, telefone.getNrTelefone());
        stm.executeUpdate();
    }


    private Telefones parseTelefone(ResultSet result) throws SQLException {
        int idTelefone = result.getInt("idTelefone");
        String nrCodigoPais = result.getString("nrCodigoPais");
        String nrDdd = result.getString("nrDdd");
        String nrTelefone = result.getString("nrTelefone");
        return new Telefones(idTelefone, nrCodigoPais, nrDdd, nrTelefone);
    }


    public Telefones pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_telefones where idTelefone = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Telefone não encontrado");
        return parseTelefone(result);
    }


    public List<Telefones> GetAllTelefones() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_telefones");
        ResultSet result = stm.executeQuery();
        List<Telefones> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseTelefone(result));
        }
        return lista;
    }

    public void atualizar(Telefones telefone) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_telefones SET idTelefone = ?, nrCodigoPais = ?, nrDdd = ?, nrTelefone = ? where idTelefone = 1");
        stm.setInt(1, telefone.getIdTelefone());
        stm.setString(2, telefone.getNrCodigoPais());
        stm.setString(3, telefone.getNrDdd());
        stm.setString(4, telefone.getNrTelefone());
        stm.executeUpdate();
    }

    public void remover(int idTelefone) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_telefones where idTelefone = ?");
        stm.setLong(1, idTelefone);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Telefone não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
