package br.com.fiap.finalFintech.view.bairros;

import br.com.fiap.finalFintech.dao.BairrosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Bairros;

import java.sql.SQLException;


public class AtualizacaoBairro {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            Bairros bairro = dao.pesquisar(1);
            bairro.setDsBairro("Jardim Europa");
            dao.atualizar(bairro);
            dao.fecharConexao();
            System.out.println("Bairro Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, Bairro não encontrado");
        }
    }
}
