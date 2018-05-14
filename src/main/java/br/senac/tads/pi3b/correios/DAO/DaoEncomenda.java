/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios.DAO;

import br.senac.tads.pi3b.correios.Encomenda;
import br.senac.tads.pi3b.correios.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author rodrigo
 */
public class DaoEncomenda {
    
    
    public static void incluir(Encomenda encomenda) throws ClassNotFoundException, SQLException{
        
        String query = "insert  into encomenda(idRemetente,destinatario,endereco,cidade,"
                + "estado,cep,altura,largura,comprimento,peso,valor,posicao,data_postagem)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = Conection.obterConexao()){
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, encomenda.getIdCliente());
                stmt.setString(2, encomenda.getDestinatario().getNome());
                stmt.setString(3, encomenda.getDestinatario().getEndereco());
                stmt.setString(4, encomenda.getDestinatario().getCidade());
                stmt.setString(5, encomenda.getDestinatario().getEstado());
                stmt.setString(6, encomenda.getDestinatario().getCep());
                stmt.setDouble(7, encomenda.getAltura());
                stmt.setDouble(8, encomenda.getLargura());
                stmt.setDouble(9, encomenda.getComprimento());
                stmt.setDouble(10, encomenda.getPeso3());
                stmt.setDouble(11, encomenda.getValor());
                stmt.setString(12, "postado");
                //coversao data no "formato sql"
                Timestamp t = new Timestamp(encomenda.getDataPostagem().getTime());
                stmt.setTimestamp(13, t);
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                // Volta pra situação onde o autocommit foi definido como false
                conn.rollback();
                throw e;
            }
    
        } catch (SQLException e) {
            System.out.print("@@@@@@@@@@@@@@@@@erro@@@@@@@@@@@@@@@@@@@@");
        }     
    }
    
}
