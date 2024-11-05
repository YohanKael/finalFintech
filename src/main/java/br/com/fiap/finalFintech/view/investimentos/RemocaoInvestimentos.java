package br.com.fiap.finalFintech.view.investimentos;

import br.com.fiap.finalFintech.dao.InvestimentosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemocaoInvestimentos {


    public static void main(String[] args){
        try{
            InvestimentosDao dao = new InvestimentosDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Investimento Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, investimento nao encontrado");

        }
    }
}
