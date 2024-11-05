package br.com.fiap.finalFintech.view.pais;
import br.com.fiap.finalFintech.dao.PaisDao;
import br.com.fiap.finalFintech.model.Paises;

import java.sql.SQLException;
import java.util.List;

public class GetAllPaises {
    public static void main(String[] args) {
        try {
            PaisDao dao = new PaisDao();
            List<Paises> paises = dao.getAllPaises();
            for (Paises pais : paises) {
                System.out.println("Id do País: " + pais.getIdPais() + "," + " Descrição do pais: " + pais.getNmPais());
            }
            dao.fecharConexao();
        } catch (
                SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

