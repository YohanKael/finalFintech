package br.com.fiap.finalFintech.controller;
import br.com.fiap.finalFintech.dao.TelefonesDaoImp;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Telefones;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/telefones")
public class TelefoneServlet extends HttpServlet {

    private String message;
    private TelefonesDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new TelefonesDaoImp();
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
            String nrCodigoPais = req.getParameter("nrCodigoPais");
            String nrDdd = req.getParameter("nrDdd");
            String nrTelefone = req.getParameter("nrTelefone");


            Telefones telefone = new Telefones(nrCodigoPais, nrDdd,nrTelefone);
            telefone.setNrCodigoPais(nrCodigoPais);
            telefone.setNrDdd(nrDdd);
            telefone.setNrTelefone(nrTelefone);

            TelefonesDaoImp telefoneDao = new TelefonesDaoImp();
            telefoneDao.save(telefone);

            req.setAttribute("message", "Telefone Cadastrado com sucesso!");


        } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao Cadastrar Telefone!");
        }
        req.getRequestDispatcher("/cadastroTelefones.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idTelefone = Integer.parseInt(req.getParameter("idTelefone"));
            String nrCodigoPais = req.getParameter("nrCodigoPais");
            String nrDdd = req.getParameter("nrDdd");
            String nrTelefone = req.getParameter("nrTelefone");


            Telefones telefone = new Telefones(nrCodigoPais, nrDdd,nrTelefone);
            telefone.setIdTelefone(idTelefone);
            telefone.setNrCodigoPais(nrCodigoPais);
            telefone.setNrDdd(nrDdd);
            telefone.setNrTelefone(nrTelefone);

            dao.atualizar(telefone);


            req.setAttribute("mensagem", "Telefone atualizado com sucesso!");
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

            req.setAttribute("msg", "Telefone removido com sucesso!");
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
        req.getRequestDispatcher("cadastroTelefones.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTelefone = Integer.parseInt(req.getParameter("idTelefone"));
        Telefones telefone = dao.buscar(idTelefone);
        req.setAttribute("telefones", telefone);
        req.setAttribute("idTelefone", idTelefone);

        req.getRequestDispatcher("edicaoTelefones.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Telefones> lista = dao.listar();
        req.setAttribute("telefones", lista);
        req.getRequestDispatcher("listaDeTelefones.jsp").forward(req, resp);
    }
}