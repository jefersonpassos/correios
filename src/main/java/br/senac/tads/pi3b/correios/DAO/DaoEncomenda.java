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

/**
 *
 * @author rodrigo
 */
public class DaoEncomenda {
    
    
    public static boolean buscarPorEmail(Encomenda encomenda) throws ClassNotFoundException, SQLException{
        
        String query = "select * from usuario where email = ? ";

        try (Connection conn = Conection.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, email);
                
            try (ResultSet resultados = stmt.executeQuery()) {
                while(resultados.next()){   
                    int id = resultados.getInt("id");
                    String senha = resultados.getString("senha");
                    String nome = resultados.getString("nome");
                    String perfil = resultados.getString("perfil");
                    
                    usuario.setId(id);
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenhaHash(senha);
                    usuario.setPerfil(perfil);
                }           
            }
        } catch (SQLException e) {
            System.out.print("@@@@@@@@@@@@@@@@@erro@@@@@@@@@@@@@@@@@@@@");
        }   
        return usuario;    
    }
    
}
