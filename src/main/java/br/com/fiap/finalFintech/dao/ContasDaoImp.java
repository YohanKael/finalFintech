package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Conta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContasDaoImp implements ContasDao {
    private Connection conexao;

    @Override
    public void save(Conta conta) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_contas (" + "id_conta, saldo, dt_criacao_conta, dt_encerramento_conta)" + " values (seq_conta.nextval, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, conta.getSaldo());
            stmt.setDate(2, Date.valueOf(conta.getDt_criacao_conta()));
            stmt.setDate(3, Date.valueOf(conta.getDt_encerramento_conta()));


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar os dados.");

        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }

    }



    @Override
    public void atualizar(Conta conta) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();

        try {

            String sql = "UPDATE tb_contas SET " +
                    "saldo = ?, " +
                    "dt_criacao_conta = ?, " +
                    "dt_encerramento_conta = ? " +
                    "WHERE id_conta = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, conta.getSaldo());
            stmt.setDate(2, Date.valueOf(conta.getDt_criacao_conta()));
            stmt.setDate(3, Date.valueOf(conta.getDt_encerramento_conta()));
            stmt.setInt(4, conta.getId_conta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar.");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void remove(int codigo) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "DELETE FROM tb_contas WHERE id_conta = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Conta> listar() {

        List<Conta> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_contas";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_conta = rs.getInt("id_conta");
                Float saldo = rs.getFloat("saldo");
                LocalDate dt_criacao_conta = rs.getDate("dt_criacao_conta").toLocalDate();
                LocalDate dt_encerramento_conta = rs.getDate("dt_encerramento_conta").toLocalDate();


                Conta conta = new Conta(id_conta, saldo, dt_criacao_conta, dt_encerramento_conta);
                lista.add(conta);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Conta buscar(int id) {

        Conta conta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_contas WHERE id_conta = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()){

                int id_conta = rs.getInt("id_conta");
                Float saldo = rs.getFloat("saldo");
                LocalDate dt_criacao_conta = rs.getDate("dt_criacao_conta").toLocalDate();
                LocalDate dt_encerramento_conta = rs.getDate("dt_encerramento_conta").toLocalDate();

                conta = new Conta(id_conta, saldo, dt_criacao_conta, dt_encerramento_conta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conta;
    }
}
