/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios.DAO;

import br.senac.tads.pi3b.correios.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author rodri
 */
public class DaoCliente {
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException {

        // 1A) Registrar driver JDBC
        Class.forName("com.mysql.jdbc.Driver");

        // 1B) Abrir conexão com DB
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/correios", "root", "");
    }
    
    public static void incluir(Cliente cliente) throws ClassNotFoundException, SQLException {

    String query = "INSERT INTO cliente (nomeCliente, telefone, cpf, cep, endereco,"
            + " estado, cidade, email)"
            + " VALUES (?, ?, ?, ? ,? ,? ,? ,?)";
    try (Connection conn = obterConexao()) {
      conn.setAutoCommit(false);

      
      try (PreparedStatement stmt = conn.prepareStatement(query)) {
          System.out.println("Nome: "+ cliente.getNome());
	stmt.setString(1, cliente.getNome());
	stmt.setString(2, cliente.getTelefone());
	stmt.setString(3, cliente.getCpf());
	stmt.setString(4, cliente.getCep());
	stmt.setString(5, cliente.getEndereco());
	stmt.setString(6, cliente.getEstado());
	stmt.setString(7, cliente.getCidade());
	stmt.setString(8, cliente.getEmail());
	stmt.executeUpdate();
/*
	// Tenta recuperar o ID gerado no banco de dados
	try (ResultSet chaves = stmt.getGeneratedKeys()) {
	  if (chaves.next()) {
	    long idPessoa = chaves.getLong(1);

	    try (PreparedStatement stmt2 = conn.prepareStatement(queryContato)) {
	      stmt2.setInt(1, email.getTipo());
	      stmt2.setString(2, email.getValor());
	      stmt2.setLong(3, idPessoa);
	      stmt2.executeUpdate();
	    }
	    
	    // Efetivar todas as operações no BD
	    conn.commit();
	  }
	}
*/
      } catch (SQLException e) {
	// Volta pra situação onde o autocommit foi definido como false
	conn.rollback();
	throw e;
      }
    }
  }
    
}
