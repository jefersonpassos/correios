/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios.DAO;

import static br.senac.tads.pi3b.correios.DAO.DaoCliente.obterConexao;
import br.senac.tads.pi3b.correios.Destinatario;
import br.senac.tads.pi3b.correios.Encomenda;
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
 * @author rodri
 */
public class DaoRelatorio {

    public static List<Encomenda> gerarRelatorio(Date dataInicial, Date dataFinal) throws ClassNotFoundException, SQLException {

        //String query = "SELECT * FROM correios.encomenda WHERE data_postagem BETWEEN ('?') AND ('?');";
        String query = "SELECT * FROM correios.encomenda WHERE data_postagem BETWEEN ('2018-06-01 00:00:00') AND ('2018-06-18 00:00:00');";

        List<Encomenda> lista = new ArrayList<Encomenda>();
        java.sql.Date dataI = new java.sql.Date(dataInicial.getTime());
        java.sql.Date dataF = new java.sql.Date(dataFinal.getTime());

        try (Connection conn = Conection.obterConexao()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {

                //Timestamp di = new Timestamp(dataInicial.getTime());
                //Timestamp df = new Timestamp(dataFinal.getTime());
                //stmt.setTimestamp(1, di);
                //stmt.setTimestamp(2, df);
                //stmt.setDate(1, dataI);
                //stmt.setDate(2, dataF);
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
                        ee.setId(id);

                        Date dataP = new Date(resultados.getTimestamp("data_postagem").getTime());

                        dataP = new java.sql.Date(new java.util.Date().getTime());

                        ee.setDataPostagem(dataP);

                        lista.add(ee);

                    }

                }
            }
            return lista;
        }
    }

}
