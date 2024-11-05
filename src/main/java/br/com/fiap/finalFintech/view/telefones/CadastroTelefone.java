package br.com.fiap.finalFintech.view.telefones;

import br.com.fiap.finalFintech.dao.TelefonesDao;
import br.com.fiap.finalFintech.model.Telefones;

import java.sql.SQLException;

public class CadastroTelefone {
    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            Telefones telefone = new Telefones("+55", "21", "99804-9852" );
            Telefones telefone2 = new Telefones("+55", "11", "99804-6982");
            Telefones telefone3 = new Telefones("+55", "18", "99804-6720");
            Telefones telefone4 = new Telefones("+55", "15", "99804-2898");
            Telefones telefone5 = new Telefones("+55", "32", "99804-9987");

            dao.cadastrar(telefone);
            dao.cadastrar(telefone2);
            dao.cadastrar(telefone3);
            dao.cadastrar(telefone4);
            dao.cadastrar(telefone5);

            dao.fecharConexao();
            System.out.println("Telefone Cadastrado com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
