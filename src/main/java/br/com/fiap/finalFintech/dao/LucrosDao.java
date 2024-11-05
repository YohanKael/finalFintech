package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Lucros;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LucrosDao {
    private Connection conexao;

    public LucrosDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Lucros lucro) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_lucros (id_lucro, ds_lucro, dt_lucro, qt_valor_lucro) VALUES (seq_lucro.nextval, ?, ?, ?)");
        stm.setString(1, lucro.getDsLucro());
        stm.setDate(2, Date.valueOf(lucro.getDtLucro()));
        stm.setFloat(3, lucro.getQtValorLucro());
        stm.executeUpdate();
    }


    private Lucros parseLucro(ResultSet result) throws SQLException {
        int id_lucro = result.getInt("id_lucro");
        String ds_lucro = result.getString("ds_lucro");
        LocalDate dt_lucro = result.getDate("dt_lucro").toLocalDate();
        float qt_valor_lucro = result.getFloat("qt_valor_lucro");
        return new Lucros(id_lucro, ds_lucro, dt_lucro, qt_valor_lucro);
    }


    public Lucros pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_lucros where id_lucro = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Lucro não encontrado");
        return parseLucro(result);
    }


    public List<Lucros> getAllLucros() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_lucros");
        ResultSet result = stm.executeQuery();
        List<Lucros> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseLucro(result));
        }
        return lista;
    }

    public void atualizar(Lucros lucro) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_lucros SET ds_lucro = ?, qt_valor_lucro = ? where id_lucro = ?");
        stm.setString(1, lucro.getDsLucro());
        stm.setFloat(2, lucro.getQtValorLucro());
        stm.setInt(3, lucro.getIdLucro());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_lucros where id_lucro = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Lucro não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
