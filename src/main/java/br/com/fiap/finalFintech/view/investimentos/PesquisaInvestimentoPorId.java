package br.com.fiap.finalFintech.view.investimentos;
import br.com.fiap.finalFintech.dao.InvestimentosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Investimentos;

import java.sql.SQLException;

public class PesquisaInvestimentoPorId {
    public static void main(String[] args) {
        try {
            InvestimentosDao dao = new InvestimentosDao();
            Investimentos Investimentos = dao.pesquisar(3);
            System.out.println(Investimentos.getCd_investimentos() + " " + Investimentos.getDs_investimentos() + ", " + Investimentos.getDt_retirada_investimentos());
            System.out.println("R$ " + Investimentos.getQt_valor_investido() + ", " + Investimentos.getDt_retirada_investimentos());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela Investimento");
        }
    }
}