package br.com.fiap.finalFintech.view.bairros;

import br.com.fiap.finalFintech.dao.BairrosDao;
import br.com.fiap.finalFintech.model.Bairros;

import java.sql.SQLException;
import java.util.List;

public class GetAllBairros {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            List<Bairros> bairros = dao.getAllBairros();
            for (Bairros bairro : bairros) {
                System.out.println("Id do Bairro: " + bairro.getIdBairro() + "," + "Descrição do bairro: " + bairro.getDsBairro());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
