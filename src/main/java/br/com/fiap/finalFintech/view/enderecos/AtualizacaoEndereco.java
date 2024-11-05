package br.com.fiap.finalFintech.view.enderecos;
import br.com.fiap.finalFintech.dao.EnderecosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Enderecos;

import java.sql.SQLException;

public class AtualizacaoEndereco {
    public static void main(String[] args) {
        try {
            EnderecosDao dao = new EnderecosDao();
            Enderecos endereco = dao.pesquisar(35);
            endereco.setNomeRua("alamedas das orquideas");
            endereco.setNumeroCep("58790-910");
            endereco.setComplementoEndereco("Casa branca e azul");
            dao.atualizar(endereco);
            dao.fecharConexao();
            System.out.println("Endereco Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, endereço não encontrado");
        }
    }
}
