/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads.pi3b.correios.Cliente;
import br.senac.tads.pi3b.correios.DAO.DaoCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author rodri
 */
@WebServlet(urlPatterns = "/novo-cliente")
public class NovoClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String estado = req.getParameter("estado");
        String cep = req.getParameter("cep");
        String cidade = req.getParameter("cidade");

        Cliente cliente = new Cliente(nome, telefone, cpf, email, endereco, estado, cep, cidade, 0);

        try {
            DaoCliente.incluir(cliente);

            req.setAttribute("cliente", cliente);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/novo-cliente.jsp");
            dispatcher.forward(req, resp);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
