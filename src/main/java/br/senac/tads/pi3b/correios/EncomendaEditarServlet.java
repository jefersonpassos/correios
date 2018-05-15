/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import br.senac.tads.pi3b.correios.DAO.DaoEncomenda;
import java.io.IOException;
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
 * @author rodrigo
 */
public class EncomendaEditarServlet {
    
    @WebServlet(urlPatterns = {"/editar-encomenda"})
public class EncomendaDeletaServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idE = req.getParameter("idEncomenda");
        int id = Integer.parseInt(idE);
        
            try {
                DaoEncomenda.confEntrega(id);
                req.setAttribute("id", id);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/update-encomenda.jsp");
                dispatcher.forward(req, resp);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EncomendaBuscaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EncomendaBuscaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
