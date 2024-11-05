package br.com.fiap.finalFintech.view.lucros;

import br.com.fiap.finalFintech.dao.LucrosDao;
import br.com.fiap.finalFintech.model.Lucros;

import java.sql.SQLException;
import java.time.LocalDate;

public class CadastrarLucro {
    public static void main(String[] args) {
        try {

            LocalDate today = LocalDate.now();

            LucrosDao dao = new LucrosDao();
            Lucros lucro = new Lucros("Lucro com Investimentos", today, 2000);
            Lucros lucro2 = new Lucros("Lucro do aluguel", today, 4000);
            Lucros lucro3 = new Lucros("Lucro com rendas ativas", today, 2500);
            Lucros lucro4 = new Lucros("Pagamento Salário", today, 1600);
            Lucros lucro5 = new Lucros("Lucro com peças", today, 1555);

            dao.cadastrar(lucro);
            dao.cadastrar(lucro2);
            dao.cadastrar(lucro3);
            dao.cadastrar(lucro4);
            dao.cadastrar(lucro5);
            dao.fecharConexao();
            System.out.println("Cadastro de lucro realizado com sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
