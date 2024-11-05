package br.com.fiap.finalFintech.view.telefones;

import br.com.fiap.finalFintech.dao.TelefonesDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Telefones;

import java.sql.SQLException;

public class PesquisaTelefonePorId {

    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            Telefones telefone = dao.pesquisar(3);
            System.out.println("Id telefone:" + telefone.getIdTelefone() + " - Telefone Completo: " + telefone.getNrCodigoPais() + " " + telefone.getNrDdd() + " " + telefone.getNrTelefone());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela Telefone");
        }
    }
}
