package br.com.fiap.finalFintech.controller;

import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Investimentos;
import br.com.fiap.finalFintech.dao.InvestimentosDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import java.util.List;


@WebServlet("/investimentos")
public class InvestimentosServlet extends HttpServlet {

    private String message;
    private InvestimentosDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new InvestimentosDaoImp();
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        initializeDao();

        String acao = req.getParameter("acao");

        switch (acao){
            case "excluir":
                excluir(req,resp);
                break;
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
        }

    }
    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String ds_investimentos = req.getParameter("ds_investimentos");
            float qt_valor_investimento = Float.parseFloat(req.getParameter("qt_valor_investimento"));
            LocalDate dt_investimentos = LocalDate.parse(req.getParameter("dt_investimentos"));
            String dtEncerramentoParam = req.getParameter("dt_retirada_investimentos");
            LocalDate dt_retirada_investimentos = (dtEncerramentoParam != null && !dtEncerramentoParam.isEmpty())
                    ? LocalDate.parse(dtEncerramentoParam)
                    : null;

            Investimentos investimento = new Investimentos(ds_investimentos, qt_valor_investimento, dt_investimentos, dt_retirada_investimentos);
            investimento.setDs_investimentos(ds_investimentos);
            investimento.setQt_valor_investimento(qt_valor_investimento);
            investimento.setDt_investimentos(dt_investimentos);
            investimento.setDt_retirada_investimentos(dt_retirada_investimentos);

            InvestimentosDaoImp investimentoDao = new InvestimentosDaoImp();
            investimentoDao.save(investimento);

            req.setAttribute("message", "Investimento Cadastrado com sucesso!");


        } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao Cadastrar Investimento!");
        }
        req.getRequestDispatcher("/cadastroInvestimentos.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int cd_investimentos = Integer.parseInt(req.getParameter("cd_investimentos"));

            String ds_investimentos = req.getParameter("ds_investimentos");
            float qt_valor_investimento = Float.parseFloat(req.getParameter("qt_valor_investimento"));
            LocalDate dt_investimentos = LocalDate.parse(req.getParameter("dt_investimentos"));
            String dtEncerramentoParam = req.getParameter("dt_retirada_investimentos");
            LocalDate dt_retirada_investimentos = (dtEncerramentoParam != null && !dtEncerramentoParam.isEmpty())
                    ? LocalDate.parse(dtEncerramentoParam)
                    : null;

            Investimentos investimento = new Investimentos(cd_investimentos,ds_investimentos, qt_valor_investimento, dt_investimentos, dt_retirada_investimentos);
            investimento.setCd_investimentos(cd_investimentos);
            investimento.setDs_investimentos(ds_investimentos);
            investimento.setQt_valor_investimento(qt_valor_investimento);
            investimento.setDt_investimentos(dt_investimentos);
            investimento.setDt_retirada_investimentos(dt_retirada_investimentos);

            dao.atualizar(investimento);


            req.setAttribute("mensagem", "Investimento atualizado com sucesso!");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar!!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("erro", "Por favor, valide os dados");
        }
        listar(req,resp);
    }


    private void excluir(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(req.getParameter("codigoExcluir"));
        try {
            dao.remove(codigo);

            req.setAttribute("msg", "Investimento removido com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        }
        listar(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        initializeDao();
        String acao = req.getParameter("acao");

        switch (acao) {
            case "listar":
                listar(req, resp);
                break;
            case "abrir-form-edicao":
                abrirForm(req, resp);
                break;
            case "abrir-form-cadastro":
                abrirFormCadastro(req, resp);
                break;
        }

    }

    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cadastroInvestimentos.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cd_investimentos = Integer.parseInt(req.getParameter("cd_investimentos"));
        Investimentos investimentos = dao.buscar(cd_investimentos);
        req.setAttribute("investimentos", investimentos);
        req.setAttribute("cd_investimentos", cd_investimentos);

        LocalDate dt_retirada_investimentos = investimentos.getDt_retirada_investimentos();
        req.setAttribute("dt_retirada_investimentos", dt_retirada_investimentos != null ? dt_retirada_investimentos.toString() : "N/A");
        req.getRequestDispatcher("edicaoInvestimento.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Investimentos> lista = dao.listar();
        req.setAttribute("investimentos", lista);
        req.getRequestDispatcher("listaDeInvestimentos.jsp").forward(req, resp);
    }

}

