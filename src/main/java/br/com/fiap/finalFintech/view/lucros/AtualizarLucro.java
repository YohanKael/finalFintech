package br.com.fiap.finalFintech.view.lucros;

import br.com.fiap.finalFintech.dao.LucrosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Lucros;

import java.sql.SQLException;

public class AtualizarLucro {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            Lucros lucro = dao.pesquisar(1);
            lucro.setDsLucro("lucro com Transporte");
            lucro.setQtValorLucro(5000);
            dao.atualizar(lucro);
            dao.fecharConexao();
            System.out.println("Lucro Atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Nao foi possivel realizar a atualição dos dados");
        }
    }
}
