package br.com.fiap.finalFintech.view.estados;

import br.com.fiap.finalFintech.dao.EstadosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverEstado {

    public static void main(String[] args) throws SQLException {
        try {
            EstadosDao dao = new EstadosDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Estado Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, estado nao encontrado");
        }

    }
}
