/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.senac.tads.pi3b.correios.DAO.DaoUsuario;
import br.senac.tads.pi3b.correios.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fernando.tsuda
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("usuario") != null) {
      // Usuario ja esta logado
      response.sendRedirect(request.getContextPath() + "/home.jsp");
    } else {
      request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
	      .forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      try {
          String email = request.getParameter("email");
          String senha = request.getParameter("senha");
          
          Usuario usuario = DaoUsuario.buscarPorEmail(email);
          
          if (usuario != null && usuario.validarSenha(senha)) {
              // Usuario existe e senha está correta
              HttpSession sessao = request.getSession();
              sessao.setAttribute("usuario", usuario);
              response.sendRedirect(request.getContextPath() + "/home.jsp");
          } else {
              // Erro no login - mostrar tela de erro
              request.getRequestDispatcher("/WEB-INF/jsp/erro-login.jsp")
                      .forward(request, response);
          } } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

}