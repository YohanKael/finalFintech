package br.com.fiap.finalFintech.controller;
import br.com.fiap.finalFintech.dao.ContasDaoImp;
import br.com.fiap.finalFintech.dao.DespesasDaoImp;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Despesas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesas")
public class DespesaServlet extends HttpServlet {
    private DespesasDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new DespesasDaoImp();
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
            String dsDespesa = req.getParameter("dsDespesa");
            LocalDate dtDespesa = LocalDate.parse(req.getParameter("dtDespesa"));
            float qtValorDespesa = Float.parseFloat(req.getParameter("qtValorDespesa"));

            Despesas despesa = new Despesas(dsDespesa, dtDespesa,qtValorDespesa);
            despesa.setDsDespesa(dsDespesa);
            despesa.setDtDespesa(dtDespesa);
            despesa.setQtValorDespesa(qtValorDespesa);

            DespesasDaoImp despesaDao = new DespesasDaoImp();
            despesaDao.save(despesa);

            req.setAttribute("message", "Despesa Cadastrada com sucesso!");
            req.getRequestDispatcher("/cadastroDespesas.jsp").forward(req,resp);


        } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar despesa!");
        }
        req.getRequestDispatcher("/cadastroDespesas.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            int idDespesa = Integer.parseInt(req.getParameter("idDespesa"));
            String dsDespesa = req.getParameter("dsDespesa");
            LocalDate dtDespesa = LocalDate.parse(req.getParameter("dtDespesa"));
            float qtValorDespesa = Float.parseFloat(req.getParameter("qtValorDespesa"));

            Despesas despesa = new Despesas(idDespesa, dsDespesa,dtDespesa,qtValorDespesa);
            despesa.setIdDespesa(idDespesa);
            despesa.setDsDespesa(dsDespesa);
            despesa.setDtDespesa(dtDespesa);
            despesa.setQtValorDespesa(qtValorDespesa);

            dao.atualizar(despesa);


            req.setAttribute("mensagem", "Despesa atualizada com sucesso!");
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

            req.setAttribute("msg", "Despesa removida com sucesso!");
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
        req.getRequestDispatcher("cadastroDespesa.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDespesa = Integer.parseInt(req.getParameter("idDespesa"));
        Despesas despesa = dao.buscar(idDespesa);
        req.setAttribute("despesas", despesa);
        req.getRequestDispatcher("edicaoDespesas.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Despesas> lista = dao.listar();
        req.setAttribute("despesas", lista);
        req.getRequestDispatcher("listaDeDespesas.jsp").forward(req, resp);
    }

}
