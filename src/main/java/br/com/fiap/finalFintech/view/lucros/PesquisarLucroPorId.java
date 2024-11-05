package br.com.fiap.finalFintech.view.lucros;

import br.com.fiap.finalFintech.dao.LucrosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Lucros;

import java.sql.SQLException;

public class PesquisarLucroPorId {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            Lucros lucro = dao.pesquisar(2);
            System.out.println("Id da lucro:" + lucro.getIdLucro() + "," + " Descrição do lucro: " + lucro.getDsLucro() + "," + " Valor do lucro: R$" + lucro.getQtValorLucro() + "," + " Data do lucro: " + lucro.getDtLucro());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de lucros");
        }
    }
}
