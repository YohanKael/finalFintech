package br.com.fiap.finalFintech.view.transacoes;
import br.com.fiap.finalFintech.dao.TransacoesDao;
import br.com.fiap.finalFintech.model.Transacoes;

import java.sql.SQLException;

public class CadastroTransacao {
    public static void main(String[] args) {
        try {
            TransacoesDao dao = new TransacoesDao();
            Transacoes transacao = new Transacoes(2000, 3000);
            Transacoes transacao2 = new Transacoes(200, 500);
            Transacoes transacao3 = new Transacoes(1000, 5000);
            Transacoes transacao4 = new Transacoes(-3000, 3500);
            Transacoes transacao5 = new Transacoes(-2000, 3000);

            dao.cadastrar(transacao);
            dao.cadastrar(transacao2);
            dao.cadastrar(transacao3);
            dao.cadastrar(transacao4);
            dao.cadastrar(transacao5);

            dao.fecharConexao();
            System.out.println("Transação Cadastrada com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
