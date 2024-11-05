package br.com.fiap.finalFintech.view.transacoes;
import br.com.fiap.finalFintech.dao.TransacoesDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Transacoes;

import java.sql.SQLException;

public class AtualizarTransacao {
    public static void main(String[] args) {
        try {
            TransacoesDao dao = new TransacoesDao();
            Transacoes transacao = dao.pesquisar(50);
            transacao.setQtValor(500);
            transacao.setQtSaldo(300);
            dao.atualizar(transacao);
            dao.fecharConexao();
            System.out.println("Transacao Atualizada Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualizaão dos dados, transação não encontrado");
        }
    }
}
