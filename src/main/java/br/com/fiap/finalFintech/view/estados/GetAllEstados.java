package br.com.fiap.finalFintech.view.estados;

import br.com.fiap.finalFintech.dao.EstadosDao;
import br.com.fiap.finalFintech.model.Estados;

import java.sql.SQLException;
import java.util.List;

public class GetAllEstados {
    public static void main(String[] args) {
        try {
            EstadosDao dao = new EstadosDao();
            List<Estados> estados = dao.getAllEstados();
            for (Estados estado : estados){
                System.out.println("Id do Estado: " + estado.getIdEstado() + "," + " Nome da Cidade: " + estado.getNmEstado());
            }
                dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
