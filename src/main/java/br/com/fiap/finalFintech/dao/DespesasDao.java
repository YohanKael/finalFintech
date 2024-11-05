package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Despesas;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesasDao {
    private Connection conexao;

    public DespesasDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Despesas despesa) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_despesas (id_despesa, ds_despesa, dt_despesa, qt_valor_despesa) VALUES (seq_despesa.nextval, ?, ?, ?)");
        stm.setString(1, despesa.getDsDespesa());
        stm.setDate(2, Date.valueOf(despesa.getDtDespesa()));
        stm.setFloat(3, despesa.getQtValorDespesa());
        stm.executeUpdate();
    }


    private Despesas parseDespesa(ResultSet result) throws SQLException {
        int id_despesa = result.getInt("id_despesa");
        String ds_despesa = result.getString("ds_despesa");
        LocalDate dt_despesa = result.getDate("dt_despesa").toLocalDate();
        float qt_valor_despesa = result.getFloat("qt_valor_despesa");
        return new Despesas(id_despesa, ds_despesa, dt_despesa, qt_valor_despesa);
    }


    public Despesas pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_despesas where id_despesa = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Despesa não encontrada");
        return parseDespesa(result);
    }


    public List<Despesas> getAllDespesas() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_despesas");
        ResultSet result = stm.executeQuery();
        List<Despesas> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseDespesa(result));
        }
        return lista;
    }

    public void atualizar(Despesas despesa) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_despesas SET ds_despesa = ?, qt_valor_despesa = ? where id_despesa = ?");
        stm.setString(1, despesa.getDsDespesa());
        stm.setFloat(2, despesa.getQtValorDespesa());
        stm.setInt(3, despesa.getIdDespesa());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_despesas where id_despesa = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Despesa não encontrada para ser removida");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
