package br.com.fiap.finalFintech.view.despesas;

import br.com.fiap.finalFintech.dao.DespesasDao;
import br.com.fiap.finalFintech.model.Despesas;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastrarDespesa {
    public static void main(String[] args) {
        try {
            LocalDate today = LocalDate.now();

            DespesasDao dao = new DespesasDao();
            Despesas despesa = new Despesas("Despesa com supermercado", today, 2000);
            Despesas despesa2 = new Despesas("Despesa com escola", today, 4000);
            Despesas despesa3 = new Despesas("Despesa com faculdade", today, 2500);
            Despesas despesa4 = new Despesas("Despesa com aluguel", today, 1600);
            Despesas despesa5 = new Despesas("Despesa com laser", today, 1555);

            dao.cadastrar(despesa);
            dao.cadastrar(despesa2);
            dao.cadastrar(despesa3);
            dao.cadastrar(despesa4);
            dao.cadastrar(despesa5);
            dao.fecharConexao();
            System.out.println("Cadastro de despesa realizado com sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
