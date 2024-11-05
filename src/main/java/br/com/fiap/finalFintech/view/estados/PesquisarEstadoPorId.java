package br.com.fiap.finalFintech.view.estados;

import br.com.fiap.finalFintech.dao.EstadosDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Estados;

import java.sql.SQLException;

public class PesquisarEstadoPorId {
    public static void main(String[] args) {
        try{
            EstadosDao dao = new EstadosDao();
            Estados estado = dao.pesquisar(1);
            System.out.println("Id do Estado: " + estado.getIdEstado() + "," + " Nome do Estado: " + estado.getNmEstado());
            dao.fecharConexao();

        } catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e){
            System.err.println("Id não existe na tabela de Estados");
        }
    }
}
