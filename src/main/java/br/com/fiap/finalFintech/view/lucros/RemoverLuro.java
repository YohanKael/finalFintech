package br.com.fiap.finalFintech.view.lucros;
import br.com.fiap.finalFintech.dao.LucrosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverLuro {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Lucro Removida com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, lucro não encontrado");
        }
    }
}
