package br.com.fiap.finalFintech.controller;
import br.com.fiap.finalFintech.dao.ReceitasDaoImp;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Receitas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/receitas")
public class ReceitaServlet extends HttpServlet {
    private ReceitasDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new ReceitasDaoImp();
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

            String dsReceita = req.getParameter("dsReceita");
            String dtReceitaParam = req.getParameter("dtReceita");
            LocalDate dtReceita = (dtReceitaParam != null && !dtReceitaParam.isEmpty())
                    ? LocalDate.parse(dtReceitaParam)
                    : null;

            float qtValorReceita = Float.parseFloat(req.getParameter("qtValorReceita"));

            Receitas receita = new Receitas(dsReceita, dtReceita,qtValorReceita);
            receita.setDsReceita(dsReceita);
            receita.setDtReceita(dtReceita);
            receita.setQtValorReceita(qtValorReceita);

            ReceitasDaoImp receitaDao = new ReceitasDaoImp();
            receitaDao.save(receita);

            req.setAttribute("message", "Receita Cadastrada com sucesso!");
            req.getRequestDispatcher("/cadastroReceitas.jsp").forward(req,resp);


        } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao cadastrar despesa!");
        }
        req.getRequestDispatcher("/cadastroReceitas.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            int idReceita = Integer.parseInt(req.getParameter("idReceita"));
            String dsReceita = req.getParameter("dsReceita");

            String dtReceitaParam = req.getParameter("dtReceita");
            LocalDate dtReceita = (dtReceitaParam != null && !dtReceitaParam.isEmpty())
                    ? LocalDate.parse(dtReceitaParam)
                    : null;

            float qtValorReceita = Float.parseFloat(req.getParameter("qtValorReceita"));

            Receitas receita = new Receitas(idReceita, dsReceita,dtReceita,qtValorReceita);
            receita.setIdReceita(idReceita);
            receita.setDsReceita(dsReceita);
            receita.setDtReceita(dtReceita);
            receita.setQtValorReceita(qtValorReceita);

            dao.atualizar(receita);


            req.setAttribute("mensagem", "Receita atualizada com sucesso!");
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

            req.setAttribute("msg", "Receita removida com sucesso!");
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
        req.getRequestDispatcher("cadastroReceitas.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idReceita = Integer.parseInt(req.getParameter("idReceita"));
        Receitas receita = dao.buscar(idReceita);
        req.setAttribute("receita", receita);
        req.setAttribute("idReceita", idReceita);

        LocalDate dtReceita = receita.getDtReceita();
        req.setAttribute("dtReceita", dtReceita != null ? dtReceita.toString() : "N/A");
        req.getRequestDispatcher("edicaoReceitas.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Receitas> lista = dao.listar();
        req.setAttribute("receitas", lista);
        req.getRequestDispatcher("listaDeReceitas.jsp").forward(req, resp);
    }
}
