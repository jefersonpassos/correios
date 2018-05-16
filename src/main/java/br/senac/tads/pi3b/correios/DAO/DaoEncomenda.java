/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios.DAO;

import br.senac.tads.pi3b.correios.Encomenda;
import static br.senac.tads.pi3b.correios.DAO.DaoCliente.obterConexao;
import br.senac.tads.pi3b.correios.Destinatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rodrigo
 */
public class DaoEncomenda {
    
    
    public static String incluir(Encomenda encomenda, String cpf) throws ClassNotFoundException, SQLException{
        
        String query = "insert  into encomenda(idRemetente, destinatario, endereco, cidade,"
                + "estado, cep, altura, largura, comprimento, peso, valor, posicao, data_postagem, rastreio)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        String rastreio ="";
        
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
                Timestamp t = new Timestamp(encomenda.inicializarData().getTime());
                stmt.setTimestamp(13, t);
                rastreio = t.toString()+cpf;
                rastreio=rastreio.replace("-", "");
                rastreio=rastreio.replace(":", "");
                rastreio=rastreio.replace(".", "");
                rastreio=rastreio.replace(" ", "BR");
                stmt.setString(14, rastreio);
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
        return rastreio;
    }
    
    public static List<Encomenda> buscarRastreio(String rastreio) throws ClassNotFoundException, SQLException {

        String query = "SELECT * FROM correios.encomenda where rastreio = ?;";
        
        List<Encomenda> lista = new ArrayList<Encomenda>();
        
        try (Connection conn = Conection.obterConexao()){
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, rastreio);
                try (ResultSet resultados = stmt.executeQuery()) {

                    while (resultados.next()) {
                        int id = resultados.getInt("id");
                        int idRemetente = resultados.getInt("idRemetente");
                        String nomeDestinatario = resultados.getString("destinatario");
                        String endereco = resultados.getString("endereco");
                        String estado = resultados.getString("estado");
                        String cidade = resultados.getString("cidade");
                        String cep = resultados.getString("cep");
                        double altura = resultados.getDouble("altura");
                        double largura = resultados.getDouble("largura");
                        double comprimento = resultados.getDouble("comprimento");  
                        Destinatario destinatario = new Destinatario(nomeDestinatario, endereco, cep, cidade, estado);
                        Encomenda ee = new Encomenda(idRemetente, destinatario, comprimento, altura, largura);
                        ee.setPosicao(resultados.getString("posicao"));
                        ee.setRastreio(rastreio);
                        ee.setId(id);
                        
                        Date dataP = new Date(resultados.getTimestamp("data_postagem").getTime());
                        
                        dataP = new java.sql.Date(new java.util.Date().getTime());
                        
                        
                        
                        ee.setDataPostagem(dataP);
                        
                        lista.add(ee);
                    }
                    
                }
            } catch (SQLException e) {

            }
            return lista;
        }
    }
    
    public static void confEntrega(int id) throws ClassNotFoundException, SQLException{
        
        String query = "update coreios.encomenda set data_entrega = ? where = ?;";

        try (Connection conn = Conection.obterConexao()){
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                Date data = new Date();
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(data);
                data = calendario.getTime();
                Timestamp t = new Timestamp(data.getTime());
                stmt.setTimestamp(1, t);
                stmt.setInt(2, id);
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
    
    
       public static void deleta(int id) throws ClassNotFoundException, SQLException{
        
        String query = "delete FROM correios.encomenda where id = ?;";

        try (Connection conn = Conection.obterConexao()){
                try (PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, id);
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
