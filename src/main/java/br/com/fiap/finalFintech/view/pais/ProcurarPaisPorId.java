package br.com.fiap.finalFintech.view.pais;
import br.com.fiap.finalFintech.dao.PaisDao;
import br.com.fiap.finalFintech.exception.EntidadeNaoEncontradaException;
import br.com.fiap.finalFintech.model.Paises;

import java.sql.SQLException;


public class ProcurarPaisPorId {
    public static void main(String[] args) {
        try {
            PaisDao dao = new PaisDao();
            Paises pais = dao.pesquisar(1);
            System.out.println("Id do Pais: " + pais.getIdPais() + "," + " Nome do Pais: " + pais.getNmPais());


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e){
            System.err.println("Indice não encontrado na tabela de Paises");
        }
    }
}
