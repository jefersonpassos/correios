/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import br.senac.tads.pi3b.correios.DAO.DaoEncomenda;
import br.senac.tads.pi3b.correios.DAO.DaoRelatorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "GerarRelatorioServlet", urlPatterns = {"/gerar-relatorio"})
public class GerarRelatorioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Encomenda> lista = new ArrayList<Encomenda>();

        String dataI = req.getParameter("dataInicial");
        String dataF = req.getParameter("dataFinal");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat formato2 = new SimpleDateFormat("MM-dd-yyyy");
         
        try {
            Date dataInicial = formato.parse(dataI);
            Date dataFinal = formato.parse(dataF);
            
            
            //Date dataInicial = formato2.parse(dataI);
            //Date dataFinal = formato2.parse(dataF);

            lista = DaoRelatorio.gerarRelatorio(dataInicial, dataFinal);

            req.setAttribute("lista", lista);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/relatorios.jsp");
            dispatcher.forward(req, resp);

        } catch (ParseException ex) {
            Logger.getLogger(GerarRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerarRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
