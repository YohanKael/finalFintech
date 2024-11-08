package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Investimentos;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvestimentosDaoImp implements InvestimentosDao {
    private Connection conexao;

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void save(Investimentos investimento) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_investimentos (" + "cd_investimentos, ds_investimentos, qt_valor_investimento, dt_investimentos, dt_retirada_investimentos)" + " values (seq_investimento.nextval, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, investimento.getDs_investimentos());
            stmt.setFloat(2, investimento.getQt_valor_investimento());
            stmt.setDate(3, Date.valueOf(investimento.getDt_investimentos()));

            if (investimento.getDt_retirada_investimentos() != null) {
                stmt.setDate(4, Date.valueOf(investimento.getDt_retirada_investimentos()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

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
    public void atualizar(Investimentos investimento) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();

        try {

            String sql = "UPDATE tb_investimentos SET " +
                    "ds_investimentos = ?, " +
                    "qt_valor_investimento = ?, " +
                    "dt_investimentos = ?, " +
                    "dt_retirada_investimentos = ? " +
                    "WHERE cd_investimentos = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, investimento.getDs_investimentos());
            stmt.setFloat(2, investimento.getQt_valor_investimento());
            stmt.setDate(3, Date.valueOf(investimento.getDt_investimentos()));

            if (investimento.getDt_retirada_investimentos() != null) {
                stmt.setDate(4, Date.valueOf(investimento.getDt_retirada_investimentos()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

            stmt.setInt(5, investimento.getCd_investimentos());

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
            String sql = "DELETE FROM tb_investimentos WHERE cd_investimentos = ?";
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
    public List<Investimentos> listar() {

        List<Investimentos> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_investimentos";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int cd_investimentos = rs.getInt("cd_investimentos");
                String ds_investimentos = rs.getString("ds_investimentos");
                float qt_valor_investimento = rs.getFloat("qt_valor_investimento");

                LocalDate dt_investimentos = rs.getDate("dt_investimentos").toLocalDate();

                java.sql.Date date = rs.getDate("dt_retirada_investimentos");
                LocalDate dt_retirada_investimentos = (date != null) ? date.toLocalDate() : null;


                Investimentos investimentos = new Investimentos(cd_investimentos,ds_investimentos, qt_valor_investimento, dt_investimentos, dt_retirada_investimentos);
                lista.add(investimentos);

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
    public Investimentos buscar(int id) {

        Investimentos investimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_investimentos WHERE cd_investimentos = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()){

                int cd_investimentos = rs.getInt("cd_investimentos");
                String ds_investimentos = rs.getString("ds_investimentos");

                float qt_valor_investimento = rs.getFloat("qt_valor_investimento");
                LocalDate dt_investimentos = rs.getDate("dt_investimentos").toLocalDate();

                java.sql.Date date = rs.getDate("dt_retirada_investimentos");
                LocalDate dt_retirada_investimentos = (date != null) ? date.toLocalDate() : null;

                investimento = new Investimentos(cd_investimentos, ds_investimentos, qt_valor_investimento, dt_investimentos, dt_retirada_investimentos);
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
        return investimento;
    }
}
