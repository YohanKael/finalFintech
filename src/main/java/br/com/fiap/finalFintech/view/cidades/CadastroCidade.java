package br.com.fiap.finalFintech.view.cidades;

import br.com.fiap.finalFintech.dao.CidadesDao;
import br.com.fiap.finalFintech.model.Cidades;

import java.sql.SQLException;

public class CadastroCidade {
    public static void main(String[] args) {
        try {
            CidadesDao dao = new CidadesDao();
            Cidades cidade = new Cidades("São Paulo");
            Cidades cidade2 = new Cidades("Sorocaba");
            Cidades cidade3 = new Cidades("Santos");
            Cidades cidade4 = new Cidades("Ouro Fino");
            Cidades cidade5 = new Cidades("Jundiaí");

            dao.cadastrar(cidade);
            dao.cadastrar(cidade2);
            dao.cadastrar(cidade3);
            dao.cadastrar(cidade4);
            dao.cadastrar(cidade5);

            dao.fecharConexao();
            System.out.println("Cidade Cadastrada com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
