package br.com.fiap.finalFintech.view.despesas;

import br.com.fiap.finalFintech.dao.DespesasDao;
import br.com.fiap.finalFintech.model.Despesas;

import java.sql.SQLException;
import java.util.List;

public class GetAllDespesas {
    public static void main(String[] args) {
        try {
            DespesasDao dao = new DespesasDao();
            List<Despesas> despesas = dao.getAllDespesas();
            for (Despesas despesa : despesas) {
                System.out.println("Id da despesa:" + despesa.getIdDespesa() + "," + " Descrição da despesa: " + despesa.getDsDespesa() + "," + " Valor da despesa: R$" + despesa.getQtValorDespesa() +  "," + " Data da despesa: " + despesa.getDtDespesa());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
