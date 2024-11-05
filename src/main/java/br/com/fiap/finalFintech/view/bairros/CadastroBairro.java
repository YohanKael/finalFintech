package br.com.fiap.finalFintech.view.bairros;

import br.com.fiap.finalFintech.dao.BairrosDao;
import br.com.fiap.finalFintech.model.Bairros;

import java.sql.SQLException;

public class CadastroBairro {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            Bairros bairro = new Bairros("Lago azul");
            Bairros bairro2 = new Bairros("Vila helena");
            Bairros bairro3 = new Bairros("Vila haro");
            Bairros bairro4 = new Bairros("Campolim");
            Bairros bairro5 = new Bairros("Vila hortencia");

            dao.cadastrar(bairro);
            dao.cadastrar(bairro2);
            dao.cadastrar(bairro3);
            dao.cadastrar(bairro4);
            dao.cadastrar(bairro5);

            dao.fecharConexao();
            System.out.println("Bairro Cadastrado com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
