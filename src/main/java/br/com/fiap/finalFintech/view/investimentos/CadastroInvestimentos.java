package br.com.fiap.finalFintech.view.investimentos;

import br.com.fiap.finalFintech.dao.InvestimentosDao;
import br.com.fiap.finalFintech.model.Investimentos;

import java.sql.SQLException;


public class CadastroInvestimentos {

    public static void main(String[] args) {
        try {
            InvestimentosDao dao = new InvestimentosDao();
            Investimentos investimento = new Investimentos("Investimento Imobiliario", 2000, "20/05/2023", "20/05/2024");
            Investimentos investimento2 = new Investimentos("Investimento em empresas", 5000, "15/06/2023", "15/06/2024");
            Investimentos investimento3 = new Investimentos("Investimento automobilistico", 6000, "5/07/2023", "20/05/2024");
            Investimentos investimento4 = new Investimentos("Investimento em ações", 1000, "10/08/2023", "20/05/2024");
            Investimentos investimento5 = new Investimentos("Investimento teste", 500, "20/10/2023", "20/05/2024");

            dao.cadastrar(investimento);
            dao.cadastrar(investimento2);
            dao.cadastrar(investimento3);
            dao.cadastrar(investimento4);
            dao.cadastrar(investimento5);

            dao.fecharConexao();
            System.out.println("Investimento Cadastrado com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}



