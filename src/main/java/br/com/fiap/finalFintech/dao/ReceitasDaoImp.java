package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Despesas;
import br.com.fiap.finalFintech.model.Receitas;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceitasDaoImp implements ReceitasDao {
    private Connection conexao;

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void save(Receitas receita) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_receitas (" + "idReceita, dsReceita , dtReceita, qtValorReceita)" + " values (seq_despesa.nextval, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, receita.getDsReceita());

            if (receita.getDtReceita() != null) {
                stmt.setDate(2, Date.valueOf(receita.getDtReceita()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setFloat(3, receita.getQtValorReceita());
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
    public void atualizar(Receitas receita) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();


        try {

            String sql = "UPDATE tb_receitas SET " +
                    "dsReceita = ?, " +
                    "dtReceita = ?, " +
                    "qtValorReceita = ? " +
                    "WHERE idReceita = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, receita.getDsReceita());

            if (receita.getDtReceita() != null) {
                stmt.setDate(2, Date.valueOf(receita.getDtReceita()));
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            stmt.setFloat(3, receita.getQtValorReceita());
            stmt.setInt(4, receita.getIdReceita());

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
            String sql = "DELETE FROM tb_receitas WHERE idReceita = ?";
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
    public List<Receitas> listar() {

        List<Receitas> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_receitas";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idReceita = rs.getInt("idReceita");
                String dsReceita = rs.getString("dsReceita");

                java.sql.Date date = rs.getDate("dtReceita");
                LocalDate dtReceita = (date != null) ? date.toLocalDate() : null;

                float qtValorReceita = rs.getFloat("qtValorReceita");

                Receitas receita = new Receitas(idReceita, dsReceita, dtReceita, qtValorReceita);
                lista.add(receita);

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
    public Receitas buscar(int id) {

        Receitas receita = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_receitas WHERE idReceita = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()){

                int idReceita = rs.getInt("idReceita");
                String dsReceita = rs.getString("dsReceita");

                java.sql.Date date = rs.getDate("dtReceita");
                LocalDate dtReceita = (date != null) ? date.toLocalDate() : null;

                float qtValorDespesa = rs.getFloat("qtValorReceita");

                receita = new Receitas(idReceita, dsReceita, dtReceita, qtValorDespesa);
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
        return receita;
    }
}
