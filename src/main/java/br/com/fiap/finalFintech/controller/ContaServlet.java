package br.com.fiap.finalFintech.controller;

import br.com.fiap.finalFintech.dao.ContasDao;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Conta;
import br.com.fiap.finalFintech.dao.ContasDaoImp;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import java.util.List;


@WebServlet("/contas")
public class ContaServlet extends HttpServlet {

    private String message;
    private ContasDaoImp dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new ContasDaoImp(); //
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

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
        float saldo = Float.parseFloat(req.getParameter("saldo"));
        LocalDate dt_criacao_conta = LocalDate.parse(req.getParameter("dt_criacao_conta"));
        LocalDate dt_encerramento_conta = LocalDate.parse(req.getParameter("dt_encerramento_conta"));

        Conta conta = new Conta(saldo, dt_criacao_conta);
        conta.setSaldo(saldo);
        conta.setDt_criacao_conta(dt_criacao_conta);
        conta.setDt_encerramento_conta(dt_encerramento_conta);

        ContasDaoImp contaDao = new ContasDaoImp();
        contaDao.save(conta);

        req.setAttribute("message", "Conta Cadastrada com sucesso!");
        req.getRequestDispatcher("/cadastroConta.jsp").forward(req,resp);


    } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao Cadastrar Conta!");
        }
        req.getRequestDispatcher("/cadastroConta.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            float saldo = Float.parseFloat(req.getParameter("saldo"));
            LocalDate dt_criacao_conta = LocalDate.parse(req.getParameter("dt_criacao_conta"));
            LocalDate dt_encerramento_conta = LocalDate.parse(req.getParameter("dt_encerramento_conta"));

            Conta conta = new Conta(saldo, dt_criacao_conta, dt_encerramento_conta);
            conta.setSaldo(saldo);
            conta.setDt_criacao_conta(dt_criacao_conta);
            conta.setDt_encerramento_conta(dt_encerramento_conta);

            dao.atualizar(conta);


            req.setAttribute("mensagem", "Produto atualizado!");
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

            req.setAttribute("msg", "Conta removida com sucesso!");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erro", "Erro ao atualizar");
        }
        listar(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

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
        req.getRequestDispatcher("cadastroConta.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_conta = Integer.parseInt(req.getParameter("id_conta"));
        Conta conta = dao.buscar(id_conta);
        req.setAttribute("contas", conta);
        req.getRequestDispatcher("edicaoConta.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Conta> lista = dao.listar();
        req.setAttribute("contas", lista);
        req.getRequestDispatcher("listaDeContas.jsp")
                .forward(req, resp);
    }


}

