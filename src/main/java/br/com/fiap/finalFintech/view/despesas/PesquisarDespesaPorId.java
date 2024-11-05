package br.com.fiap.finalFintech.view.despesas;
import br.com.fiap.finalFintech.dao.DespesasDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Despesas;

import java.sql.SQLException;

public class PesquisarDespesaPorId {
    public static void main(String[] args) {
        try {
            DespesasDao dao = new DespesasDao();
            Despesas despesa = dao.pesquisar(2);
            System.out.println("Id da despesa:" + despesa.getIdDespesa() + "," + " Descrição da despesa: " + despesa.getDsDespesa() + "," + " Valor da despesa: R$" + despesa.getQtValorDespesa() +  "," + " Data da despesa: " + despesa.getDtDespesa());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de despesas");
        }
    }
}
