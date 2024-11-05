package br.com.fiap.finalFintech.view.telefones;
import br.com.fiap.finalFintech.dao.TelefonesDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Telefones;

import java.sql.SQLException;

public class AtualizarTelefone {

    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            Telefones telefone = dao.pesquisar(1);
            telefone.setNrCodigoPais("+55");
            telefone.setNrDdd("15");
            telefone.setNrTelefone("998717-5804");
            dao.atualizar(telefone);
            dao.fecharConexao();
            System.out.println("Telefone Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, Telefone não encontrado");
        }
    }
}
