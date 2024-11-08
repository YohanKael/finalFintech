package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Enderecos;
import br.com.fiap.finalFintech.model.Telefones;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonesDaoImp implements TelefonesDao {
    private Connection conexao;


    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void save(Telefones telefone) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_telefones (" + "idTelefone, nrCodigoPais , nrDdd, nrTelefone )" + " values (seq_investimento.nextval, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefone.getNrCodigoPais());
            stmt.setString(2, telefone.getNrDdd());
            stmt.setString(3, telefone.getNrTelefone());

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
    public void atualizar(Telefones telefone) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();


        try {

            String sql = "UPDATE tb_telefones SET " +
                    "nrCodigoPais = ?, " +
                    "nrDdd = ?, " +
                    "nrTelefone = ? " +
                    "WHERE idTelefone = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefone.getNrCodigoPais());
            stmt.setString(2, telefone.getNrDdd());
            stmt.setString(3, telefone.getNrTelefone());
            stmt.setInt(4, telefone.getIdTelefone());

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
            String sql = "DELETE FROM tb_telefones WHERE idTelefone = ?";
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
    public List<Telefones> listar() {

        List<Telefones> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_telefones";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idTelefone = rs.getInt("idTelefone");
                String nrCodigoPais = rs.getString("nrCodigoPais");
                String nrDdd = rs.getString("nrDdd");
                String nrTelefone = rs.getString("nrTelefone");


                Telefones telefone = new Telefones(idTelefone, nrCodigoPais, nrDdd, nrTelefone);
                lista.add(telefone);

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
    public Telefones buscar(int id) {

        Telefones telefone = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_telefones WHERE idTelefone = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();



            if (rs.next()){

                int idTelefone = rs.getInt("idTelefone");
                String nrCodigoPais = rs.getString("nrCodigoPais");
                String nrDdd = rs.getString("nrDdd");
                String nrTelefone = rs.getString("nrTelefone");


                telefone = new Telefones(idTelefone, nrCodigoPais, nrDdd, nrTelefone);
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
        return telefone;
    }

}
