package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Despesas;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesasDaoImp implements DespesasDao {
    private Connection conexao;


    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void save(Despesas despesa) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_despesas (" + "idDespesa, dsDespesa , dtDespesa, qtValorDespesa)" + " values (seq_despesa.nextval, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, despesa.getDsDespesa());
            stmt.setDate(2, Date.valueOf(despesa.getDtDespesa()));
            stmt.setFloat(3, despesa.getQtValorDespesa());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar os dados.");

        } finally {
            try {
                assert stmt != null;
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }

    }

    @Override
    public void atualizar(Despesas despesa) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();


        try {

            String sql = "UPDATE tb_despesas SET " +
                    "dsDespesa = ?, " +
                    "dtDespesa = ?, " +
                    "qtValorDespesa = ? " +
                    "WHERE idDespesa = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, despesa.getDsDespesa());
            stmt.setDate(2, Date.valueOf(despesa.getDtDespesa()));
            stmt.setFloat(3, despesa.getQtValorDespesa());
            stmt.setInt(4, despesa.getIdDespesa());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar.");
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
    public void remove(int codigo) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "DELETE FROM tb_despesas WHERE idDespesa = ?";
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
    public List<Despesas> listar() {

        List<Despesas> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_despesas";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idDespesa = rs.getInt("idDespesa");
                String dsDespesa = rs.getString("dsDespesa");
                LocalDate dtDespesa = rs.getDate("dtDespesa").toLocalDate();
                float qtValorDespesa = rs.getFloat("qtValorDespesa");

                Despesas despesa = new Despesas(idDespesa, dsDespesa, dtDespesa, qtValorDespesa);
                lista.add(despesa);

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
    public Despesas buscar(int id) {

        Despesas despesa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_despesas WHERE idDespesa = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()){

                int idDespesa = rs.getInt("idDespesa");
                String dsDespesa = rs.getString("dsDespesa");
                LocalDate dtDespesa = rs.getDate("dtDespesa").toLocalDate();
                float qtValorDespesa = rs.getFloat("qtValorDespesa");

                despesa = new Despesas(idDespesa, dsDespesa, dtDespesa, qtValorDespesa);
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
        return despesa;
    }
}
