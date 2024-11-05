package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Investimentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InvestimentosDao {

    private Connection conexao;

    public InvestimentosDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Investimentos investimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_investimento (cd_investimentos, ds_investimentos, qt_valor_investido, dt_investimentos, dt_retirada_investimentos) VALUES (seq_investimento.nextval, ?, ?, ?, ?)");
        stm.setString(1, investimento.getDs_investimentos());
        stm.setFloat(2, investimento.getQt_valor_investido());
        stm.setString(3, investimento.getDt_investimentos());
        stm.setString(4, investimento.getDt_retirada_investimentos());
        stm.executeUpdate();
    }


    private Investimentos parseInvestimento(ResultSet result) throws SQLException {
        int cd_investimentos = result.getInt("cd_investimentos");
        String ds_investimentos = result.getString("ds_investimentos");
        float qt_valor_investido = result.getFloat("qt_valor_investido");
        String dt_investimentos = result.getString("dt_investimentos");
        String dt_retirada_investimentos = result.getString("dt_retirada_investimentos");
        return new Investimentos(cd_investimentos, ds_investimentos, qt_valor_investido, dt_investimentos, dt_retirada_investimentos);
    }


    public Investimentos pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_investimento where cd_investimentos = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Investimento não encontrado");
        return parseInvestimento(result);
    }

//    public List<Investimentos> listar() throws SQLException {
//        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_investimento");
//        ResultSet result = stm.executeQuery();
//        List<Investimentos> lista = new ArrayList<>();
//        while (result.next()) {
//            lista.add(parseProduto(result));
//        }
//        return lista;
//    }

    public List<Investimentos> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_investimento");
        ResultSet result = stm.executeQuery();
        List<Investimentos> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseInvestimento(result));
        }
        return lista;
    }

    public void atualizar(Investimentos investimento) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_investimento SET cd_investimentos = ?, ds_investimentos = ?, qt_valor_investido = ?, dt_investimentos = ?, dt_retirada_investimentos = ? where cd_investimentos = 1");
        stm.setInt(1, investimento.getCd_investimentos());
        stm.setString(2, investimento.getDs_investimentos());
        stm.setDouble(3, investimento.getQt_valor_investido());
        stm.setString(4, investimento.getDt_investimentos());
        stm.setString(5, investimento.getDt_retirada_investimentos());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_investimento where cd_investimentos = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Investimento não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}

