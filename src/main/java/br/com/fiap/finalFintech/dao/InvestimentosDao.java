package br.com.fiap.finalFintech.dao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Investimentos;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import java.util.List;


public interface InvestimentosDao {

        void init(ServletConfig config) throws ServletException;

        void save(Investimentos investimento) throws DBException;

        void atualizar(Investimentos investimento) throws DBException;

        void remove(int codigo) throws DBException;

        List<Investimentos> listar();

        Investimentos buscar(int id);
}
