package br.com.fiap.finalFintech.view.transacoes;

import br.com.fiap.finalFintech.dao.TransacoesDao;
import br.com.fiap.finalFintech.model.Transacoes;

import java.sql.SQLException;
import java.util.List;

public class getAllTransacoes {
    public static void main(String[] args) {
        try {
            TransacoesDao dao = new TransacoesDao();
            List<Transacoes> transacoes = dao.getAllTransacoes();
            for (Transacoes transacao : transacoes) {
                System.out.println("Id transacao:" + transacao.getIdTransacao() + " " + "Valor investido: " + transacao.getQtValor() + " " + "Quantidade de saldo: " + " "  + transacao.getQtSaldo() + " " + "Saldo Final: " + transacao.getQtSaldoAtualizado());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
