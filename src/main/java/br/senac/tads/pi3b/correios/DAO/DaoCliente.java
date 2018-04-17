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
import java.util.ArrayList;
import java.util.List;

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

        String query = "insert into cliente(nomeCliente, telefone, cpf, cep, endereco,"
                + "estado, cidade, email)"
                + "VALUES (?, ?, ?, ? ,? ,? ,? ,?)";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getCpf());
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getEndereco());
                stmt.setString(6, cliente.getEstado());
                stmt.setString(7, cliente.getCidade());
                stmt.setString(8, cliente.getEmail());
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                // Volta pra situação onde o autocommit foi definido como false
                conn.rollback();
                throw e;
            }
        }
    }

    public static List<Cliente> buscar(String Cpf) throws ClassNotFoundException, SQLException {

        String query = "SELECT * FROM correios.cliente";

        List<Cliente> lista = new ArrayList<Cliente>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            try (ResultSet resultados = stmt.executeQuery()) {

                while (resultados.next()) {
                    int id = resultados.getInt("idCliente");
                    String nome = resultados.getString("nomeCliente");
                    String telefone = resultados.getString("telefone");
                    String cpf = resultados.getString("cpf");
                    String cep = resultados.getString("cep");
                    String endereco = resultados.getString("endereco");
                    String estado = resultados.getString("estado");
                    String cidade = resultados.getString("cidade");
                    String email = resultados.getString("email");
                    Cliente c = new Cliente(nome, telefone, cpf, email, endereco, estado, cep, cidade, id);
                    lista.add(c);
                }
            }
        } catch (SQLException e) {

        }

        // 3) Fechar conexão (tratado pelo try acima - try-with-resources)
        return lista;

    }

    public static void deletar(int id) throws ClassNotFoundException, SQLException {
        String query = "delete from cliente where idCliente = ?;";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, 3);
                stmt.execute();
                conn.close();
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static void editar(Cliente cliente) throws ClassNotFoundException, SQLException {

        String query = "update  cliente set nomeCliente = ?, telefone = ?, cpf = ?,"
                + "cep = ?, endereco = ?, estado = ?, cidade = ?, email = ?"
                + "where idCliente = ?";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getCpf());
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getEndereco());
                stmt.setString(6, cliente.getEstado());
                stmt.setString(7, cliente.getCidade());
                stmt.setString(8, cliente.getEmail());
                stmt.setInt(9, cliente.getIdCliente());
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                // Volta pra situação onde o autocommit foi definido como false
                conn.rollback();
                throw e;
            }
        }
    }

}
