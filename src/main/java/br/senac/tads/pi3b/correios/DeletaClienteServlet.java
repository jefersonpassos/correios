/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import br.senac.tads.pi3b.correios.DAO.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(urlPatterns = "/deleta-cliente")
public class DeletaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html"); // Tipo de conteúdo
        resp.setCharacterEncoding("UTF-8"); // Codificação do conteúdo
        String idCliente = req.getParameter("idCliente");
        int id = Integer.parseInt(idCliente);
        PrintWriter out = resp.getWriter();

        try {
            DaoCliente.deletar(id);
            out.println("<html>");
            out.println("<body>");
            out.println("Cliente Deletado T-T");
            out.println("</body>");
            out.println("</html>");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
