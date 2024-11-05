package br.com.fiap.finalFintech.view.enderecos;

import br.com.fiap.finalFintech.dao.EnderecosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Enderecos;

import java.sql.SQLException;

public class PesquisaEnderecoPorId {
    public static void main(String[] args) {
        try {
            EnderecosDao dao = new EnderecosDao();
            Enderecos endereco = dao.pesquisar(30);
            System.out.println("Id do endereço:" + endereco.getIdEndereco() + "," + " Numero do CEP: " + endereco.getNumeroCep() + "," + "Numero da rua: " + endereco.getNumeroResidencia() + "," + "Nome Da Rua: " +  endereco.getNomeRua());
            System.out.println("Complemento do endereço: "  + endereco.getComplementoEndereco());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela Investimento");
        }
    }
}
