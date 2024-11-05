package br.com.fiap.finalFintech.view.bairros;
import br.com.fiap.finalFintech.dao.BairrosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Bairros;

import java.sql.SQLException;

public class PesquisaBairroPorId {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            Bairros bairro = dao.pesquisar(2);
            System.out.println("Id do Bairro: " + bairro.getIdBairro() + "," + " Descrição do Bairro: " + bairro.getDsBairro());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de Bairros");
        }
    }
}
