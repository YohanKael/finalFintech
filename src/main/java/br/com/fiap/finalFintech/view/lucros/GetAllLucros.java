package br.com.fiap.finalFintech.view.lucros;

import br.com.fiap.finalFintech.dao.LucrosDao;
import br.com.fiap.finalFintech.model.Lucros;

import java.sql.SQLException;
import java.util.List;

public class GetAllLucros {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            List<Lucros> lucros = dao.getAllLucros();
            for (Lucros lucro : lucros) {
                System.out.println("Id da lucro:" + lucro.getIdLucro() + "," + " Descrição do lucro: " + lucro.getDsLucro() + "," + " Valor do lucro: R$" + lucro.getQtValorLucro() + "," + " Data do lucro: " + lucro.getDtLucro());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
