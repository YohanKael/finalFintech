package br.com.fiap.finalFintech.view.telefones;

import br.com.fiap.finalFintech.dao.TelefonesDao;
import br.com.fiap.finalFintech.model.Telefones;

import java.sql.SQLException;
import java.util.List;

public class GetAllTelefones {

    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            List<Telefones> telefones = dao.GetAllTelefones();
            for (Telefones telefone : telefones) {
                System.out.println("Id telefone:" + telefone.getIdTelefone() + " Telefone Completo: " + telefone.getNrCodigoPais() + " " + telefone.getNrDdd() + " " + telefone.getNrTelefone());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
