package br.com.fiap.finalFintech.view.enderecos;

import br.com.fiap.finalFintech.dao.EnderecosDao;
import br.com.fiap.finalFintech.model.Enderecos;

import java.sql.SQLException;

public class CadastroEndereco {
    public static void main(String[] args) {
        try {
            EnderecosDao dao = new EnderecosDao();
            Enderecos endereco = new Enderecos("18190000", 50, "alameda dos girassois", "casa amarela ao final da rua");
            Enderecos endereco2 = new Enderecos("30058091", 68, "alameda das azaleias", "casa azul ao final da rua");
            Enderecos endereco3 = new Enderecos("28795723", 102, "alameda das rosas", "casa roxa ao final da rua");
            Enderecos endereco4 = new Enderecos("36979872", 1001, "alameda dos ipes", "casa verde ao final da rua");
            Enderecos endereco5 = new Enderecos("18793678", 1210, "alameda das flores", "casa amarela ao final da rua");

            dao.cadastrar(endereco);
            dao.cadastrar(endereco2);
            dao.cadastrar(endereco3);
            dao.cadastrar(endereco4);
            dao.cadastrar(endereco5);

            dao.fecharConexao();
            System.out.println("Endereço Cadastrado com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
