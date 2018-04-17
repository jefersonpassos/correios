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
 * @author rdg
 */
@WebServlet(urlPatterns = "/update-cliente")
public class UpdateClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String telefone = req.getParameter("telefone");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String endereco = req.getParameter("endereco");
            String estado = req.getParameter("estado");
            String cep = req.getParameter("cep");
            String cidade = req.getParameter("cidade");
            String idCliente = req.getParameter("idCliente");
            int id = Integer.parseInt(idCliente);

            Cliente cliente = new Cliente(nome, telefone, cpf, email, endereco, estado, cep, cidade, id);

            DaoCliente.editar(cliente);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("Cliente " + cliente.getNome() + " atualizado");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
