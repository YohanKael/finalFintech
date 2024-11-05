package br.com.fiap.finalFintech.view.pais;

import br.com.fiap.finalFintech.dao.PaisDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Paises;

import java.sql.SQLException;

public class AtualizarPais {
    public static void main(String[] args) {
        try{
            PaisDao dao = new PaisDao();
            Paises pais = dao.pesquisar(1);
            pais.setNmPais("Brazil");
            dao.atualizar(pais);
            dao.fecharConexao();
            System.out.println("Pais Atualizado com sucesso");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Nao foi possivel realizar a atualização, Pais não encontrado");
        }
    }
}
