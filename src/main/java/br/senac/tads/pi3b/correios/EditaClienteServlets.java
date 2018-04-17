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
public class EditaClienteServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
      
        String idCliente = req.getParameter("id");
        int id = Integer.parseInt(idCliente);
        String nome = req.getParameter("nome");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String estado = req.getParameter("estado");
        String cep = req.getParameter("cep");
        String cidade = req.getParameter("cidade");

        Cliente cliente = new Cliente(nome, telefone, cpf, email, endereco, estado, cep, cidade, id);

        PrintWriter out = resp.getWriter();

        try {
            DaoCliente.editar(cliente);
            out.println("<html>");
            out.println("<body>");
            out.println("Cliente editado com sucesso =D");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
