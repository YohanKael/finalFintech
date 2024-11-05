package br.com.fiap.finalFintech.dao;

import br.com.fiap.finalFintech.connection.ConnectionManager;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Enderecos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnderecosDao {
    private Connection conexao;

    public EnderecosDao() throws SQLException {
        conexao = ConnectionManager.getConnection();
    }

    public void cadastrar(Enderecos endereco) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_enderecos (id_Endereco, numero_cep, numero_residencia, nome_rua, complemento_endereco) VALUES (seq_investimento.nextval, ?, ?, ?, ?)");
        stm.setString(1, endereco.getNumeroCep());
        stm.setInt(2, endereco.getNumeroResidencia());
        stm.setString(3, endereco.getNomeRua());
        stm.setString(4, endereco.getComplementoEndereco());
        stm.executeUpdate();
    }


    private Enderecos parseEndereco(ResultSet result) throws SQLException {
        int idEndereco = result.getInt("id_Endereco");
        String numeroCep = result.getString("numero_cep");
        int numeroResidencia = result.getInt("numero_residencia");
        String nomeRua = result.getString("nome_rua");
        String complementoEndereco = result.getString("complemento_endereco");
        return new Enderecos(idEndereco, numeroCep, numeroResidencia, nomeRua, complementoEndereco);
    }


    public Enderecos pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_enderecos where id_Endereco = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Endereco não encontrado");
        return parseEndereco(result);
    }


    public List<Enderecos> getAllEnderecos() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_enderecos");
        ResultSet result = stm.executeQuery();
        List<Enderecos> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseEndereco(result));
        }
        return lista;
    }

    public void atualizar(Enderecos endereco) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_enderecos SET numero_cep = ?, numero_residencia = ?, nome_rua = ?, complemento_endereco = ? where id_endereco = ?");
        stm.setString(1, endereco.getNumeroCep());
        stm.setInt(2, endereco.getNumeroResidencia());
        stm.setString(3, endereco.getNomeRua());
        stm.setString(4, endereco.getComplementoEndereco());
        stm.setInt(5, endereco.getIdEndereco());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_enderecos where id_endereco = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Endereco não encontrado para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
