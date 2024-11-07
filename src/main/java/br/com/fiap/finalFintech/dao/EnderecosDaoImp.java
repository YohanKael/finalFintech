package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Enderecos;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EnderecosDaoImp implements EnderecosDao {
    private Connection conexao;


    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void save(Enderecos endereco) throws DBException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = null;

        String sql = "insert into tb_enderecos (" + "idEndereco, numeroCep , numeroResidencia, nomeRua, complementoEndereco )" + " values (seq_enderecos.nextval, ?, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getNumeroCep());
            stmt.setInt(2, endereco.getNumeroResidencia());
            stmt.setString(3, endereco.getNomeRua());
            stmt.setString(4, endereco.getComplementoEndereco());

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
    public void atualizar(Enderecos endereco) throws DBException {

        PreparedStatement stmt = null;
        Connection conn = ConnectionManager.getConnection();


        try {

            String sql = "UPDATE tb_enderecos SET " +
                    "numeroCep = ?, " +
                    "numeroResidencia = ?, " +
                    "nomeRua = ?, " +
                    "complementoEndereco = ? " +
                    "WHERE idEndereco = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getNumeroCep());
            stmt.setInt(2, endereco.getNumeroResidencia());
            stmt.setString(3, endereco.getNomeRua());
            stmt.setString(4, endereco.getComplementoEndereco());
            stmt.setInt(5, endereco.getIdEndereco());

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
            String sql = "DELETE FROM tb_enderecos WHERE idEndereco = ?";
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
    public List<Enderecos> listar() {

        List<Enderecos> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_enderecos";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idEndereco = rs.getInt("idEndereco");
                String numeroCep = rs.getString("numeroCep");
                int numeroResidencia = rs.getInt("numeroResidencia");
                String nomeRua = rs.getString("nomeRua");
                String complementoEndereco = rs.getString("complementoEndereco");


                Enderecos endereco = new Enderecos(idEndereco, numeroCep, numeroResidencia, nomeRua, complementoEndereco);
                lista.add(endereco);

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
    public Enderecos buscar(int id) {

        Enderecos endereco = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnection();
            String sql = "SELECT * FROM tb_enderecos WHERE idEndereco = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();



            if (rs.next()){

                int idEndereco = rs.getInt("idEndereco");
                String numeroCep = rs.getString("numeroCep");
                int numeroResidencia = rs.getInt("numeroResidencia");
                String nomeRua = rs.getString("nomeRua");
                String complementoEndereco = rs.getString("complementoEndereco");


                endereco = new Enderecos(idEndereco, numeroCep, numeroResidencia, nomeRua, complementoEndereco);
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
        return endereco;
    }

}
