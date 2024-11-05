package br.com.fiap.finalFintech.view.investimentos;

import br.com.fiap.finalFintech.dao.InvestimentosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Investimentos;

import java.sql.SQLException;

public class AtualizacaoInvestimento {

    public static void main(String[] args) {
        try {
            InvestimentosDao dao = new InvestimentosDao();
            Investimentos investimento = dao.pesquisar(1);
            investimento.setDs_investimentos("Investimento em Tecnologia");
            investimento.setDt_investimentos("10/12/2023");
            investimento.setQt_valor_investido(3000.00F);
            investimento.setDt_retirada_investimentos("10/02/2024");
            dao.atualizar(investimento);
            dao.fecharConexao();
            System.out.println("Investimento Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, investimento não encontrado");
        }
    }
}