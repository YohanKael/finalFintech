package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Transacoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacoesDao {
    private Connection conexao;

    public TransacoesDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Transacoes transacao) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_transacoes (IDTRANSACAO, QTVALOR, QTSALDO, QTSALDOATUALIZADO) VALUES (seq_transacao.nextval, ?, ?, ?)");
        stm.setFloat(1, transacao.getQtSaldo());
        stm.setFloat(2, transacao.getQtValor());
        stm.setFloat(3, transacao.getQtSaldoAtualizado());
        stm.executeUpdate();
    }


    private Transacoes parseTransacao(ResultSet result) throws SQLException {
        int idTransacao = result.getInt("idTransacao");
        float qtValor = result.getFloat("qtValor");
        float qtSaldo = result.getFloat("qtSaldo");
        float qtSaldoAtualizado = result.getFloat("qtSaldoAtualizado");
        return new Transacoes(idTransacao, qtValor, qtSaldo, qtSaldoAtualizado);
    }


    public Transacoes pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_transacoes where idTransacao = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Transação não encontrada");
        return parseTransacao(result);
    }


    public List<Transacoes> getAllTransacoes() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_transacoes");
        ResultSet result = stm.executeQuery();
        List<Transacoes> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseTransacao(result));
        }
        return lista;
    }

    public void atualizar(Transacoes transacao) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_transacoes SET QTVALOR = ?, QTSALDO = ?, QTSALDOATUALIZADO = ? WHERE IDTRANSACAO = ?");
        stm.setFloat(1, transacao.getQtValor());
        stm.setFloat(2, transacao.getQtSaldo());
        stm.setFloat(3, transacao.getQtSaldoAtualizado());
        stm.setInt(4, transacao.getIdTransacao());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_transacoes where idTransacao = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Transacao não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}

