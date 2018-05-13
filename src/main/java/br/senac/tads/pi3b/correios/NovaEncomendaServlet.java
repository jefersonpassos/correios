/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import br.senac.tads.pi3b.correios.DAO.DaoCliente;
import br.senac.tads.pi3b.correios.DAO.DaoEncomenda;
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
 * @author rodrigo
 */
@WebServlet(name = "NovaEncomendaServlet", urlPatterns = {"/nova-encomenda"})
public class NovaEncomendaServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int idCliente=0;
        String cpf = req.getParameter("cpf");
         try {
             //buscar criente no banco return int id
             idCliente = DaoCliente.buscarCpf(cpf);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(NovaEncomendaServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(NovaEncomendaServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        String nomed = req.getParameter("nomed");
        String enderecod = req.getParameter("enderecod");
        String cepd = req.getParameter("cepd");
        String estadod = req.getParameter("estadod");
        String cidaded = req.getParameter("cidaded");
        //add objeto destinatario
        Destinatario destinatario = new Destinatario(nomed, enderecod,  cepd, cidaded, estadod);
       
        String comprimentoS = req.getParameter("comprimento");
        String alturaS = req.getParameter("altura");
        String larguraS = req.getParameter("largura");

        double comprimento = Double.parseDouble(comprimentoS);
        double altura = Double.parseDouble(alturaS);
        double largura = Double.parseDouble(larguraS);
        
        Encomenda encomenda = new Encomenda(idCliente, destinatario, comprimento, largura, altura);
        
        try {
            DaoEncomenda.incluir(encomenda);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(NovaEncomendaServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(NovaEncomendaServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        
            req.setAttribute("encomenda", encomenda);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nova-encomenda.jsp");
            dispatcher.forward(req, resp);
    }
    
}
