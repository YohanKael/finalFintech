package br.com.fiap.finalFintech.view.telefones;

import br.com.fiap.finalFintech.dao.TelefonesDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverTelefone {
    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Telefone Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, telefone nao encontrado");

        }
    }
}
