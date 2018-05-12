/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios.DAO;

import br.senac.tads.pi3b.correios.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jefyn
 */
public class DaoUsuario {
    
    public static Usuario buscarPorEmail(String email) throws ClassNotFoundException, SQLException{
        
        String query = "select * from usuario where email = ? ";
        
        Usuario usuario = new Usuario();        
        
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
