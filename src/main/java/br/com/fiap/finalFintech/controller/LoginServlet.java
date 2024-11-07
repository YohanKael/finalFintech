package br.com.fiap.finalFintech.controller;
import br.com.fiap.finalFintech.dao.UsuarioDaoImp;
import br.com.fiap.finalFintech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDaoImp dao;

    private void initializeDao() {
        if (this.dao == null) {
            this.dao = new UsuarioDaoImp();
        }
    }

    public LoginServlet() {
        dao = new UsuarioDaoImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initializeDao();
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(email, senha);

        if (dao.validarUsuario(usuario)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", email);

            request.setAttribute("loginSucesso", true);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            request.setAttribute("erro", "Usuário e/ou senha inválidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}