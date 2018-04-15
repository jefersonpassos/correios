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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns="busca-cliente")
public class ClienteBuscaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
      
        PrintWriter writer = resp.getWriter();
        
        List<Cliente> lista = new ArrayList<Cliente>();
       
        try {
            lista=DaoCliente.buscar("11221");
            
            for(Cliente c : lista) {
                writer.println("nome: "+ c.getNome());
             }
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteBuscaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBuscaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    
}
