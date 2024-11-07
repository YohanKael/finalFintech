package br.com.fiap.finalFintech.controller;
import br.com.fiap.finalFintech.dao.EnderecosDaoImp;
import br.com.fiap.finalFintech.exception.DBException;
import br.com.fiap.finalFintech.model.Enderecos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/enderecos")
public class EnderecoServlet extends HttpServlet {

    private String message;
    private EnderecosDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new EnderecosDaoImp();
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
            String numeroCep = req.getParameter("numeroCep");
            int numeroResidencia = Integer.parseInt(req.getParameter("numeroResidencia"));
            String nomeRua = req.getParameter("nomeRua");
            String complementoEndereco = req.getParameter("complementoEndereco");


            Enderecos endereco = new Enderecos(numeroCep, numeroResidencia,nomeRua,complementoEndereco);
            endereco.setNumeroCep(numeroCep);
            endereco.setNumeroResidencia(numeroResidencia);
            endereco.setNomeRua(nomeRua);
            endereco.setComplementoEndereco(complementoEndereco);

            EnderecosDaoImp enderecoDao = new EnderecosDaoImp();
            enderecoDao.save(endereco);

            req.setAttribute("message", "Endereço Cadastrado com sucesso!");


        } catch (DBException db){
            db.printStackTrace();
            req.setAttribute("erro", "Erro ao Cadastrar Endereço!");
        }
        req.getRequestDispatcher("/cadastroEnderecos.jsp").forward(req,resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idEndereco = Integer.parseInt(req.getParameter("idEndereco"));
            String numeroCep = req.getParameter("numeroCep");
            int numeroResidencia = Integer.parseInt(req.getParameter("numeroResidencia"));
            String nomeRua = req.getParameter("nomeRua");
            String complementoEndereco = req.getParameter("complementoEndereco");


            Enderecos endereco = new Enderecos(idEndereco, numeroCep, numeroResidencia,nomeRua,complementoEndereco);
            endereco.setIdEndereco(idEndereco);
            endereco.setNumeroCep(numeroCep);
            endereco.setNumeroResidencia(numeroResidencia);
            endereco.setNomeRua(nomeRua);
            endereco.setComplementoEndereco(complementoEndereco);

            dao.atualizar(endereco);


            req.setAttribute("mensagem", "Endereço atualizado com sucesso!");
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

            req.setAttribute("msg", "Endereço removido com sucesso!");
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
        req.getRequestDispatcher("cadastroEnderecos.jsp").forward(req, resp);
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEndereco = Integer.parseInt(req.getParameter("idEndereco"));
        Enderecos endereco = dao.buscar(idEndereco);
        req.setAttribute("enderecos", endereco);
        req.setAttribute("idEndereco", idEndereco);

        req.getRequestDispatcher("edicaoEnderecos.jsp").forward(req, resp);
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Enderecos> lista = dao.listar();
        req.setAttribute("enderecos", lista);
        req.getRequestDispatcher("listaDeEnderecos.jsp").forward(req, resp);
    }
}
