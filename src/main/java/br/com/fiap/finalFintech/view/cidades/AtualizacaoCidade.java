package br.com.fiap.finalFintech.view.cidades;
import br.com.fiap.finalFintech.dao.CidadesDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Cidades;

import java.sql.SQLException;

public class AtualizacaoCidade {
    public static void main(String[] args) {
        try {
            CidadesDao dao = new CidadesDao();
            Cidades cidade = dao.pesquisar(1);
            cidade.setNmCidade("Santos");
            dao.atualizar(cidade);
            dao.fecharConexao();
            System.out.println("Cidade Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, Cidade não encontrado");
        }
    }
}
