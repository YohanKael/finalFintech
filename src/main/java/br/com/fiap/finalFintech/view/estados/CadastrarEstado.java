package br.com.fiap.finalFintech.view.estados;

import br.com.fiap.finalFintech.dao.EstadosDao;
import br.com.fiap.finalFintech.model.Estados;

import java.sql.SQLException;

public class CadastrarEstado {
    public static void main(String[] args) {
        try{
            EstadosDao dao = new EstadosDao();
            Estados estado = new Estados("São Paulo");
            Estados estado2 = new Estados("Minas Gerais");
            Estados estado3 = new Estados("Rio De Janeiro");
            Estados estado4 = new Estados("Pará");
            Estados estado5 = new Estados("Espirito Santo");

            dao.cadastrar(estado);
            dao.cadastrar(estado2);
            dao.cadastrar(estado3);
            dao.cadastrar(estado4);
            dao.cadastrar(estado5);

            System.out.println("Estado Cadastrado Com sucesso");

            dao.fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
