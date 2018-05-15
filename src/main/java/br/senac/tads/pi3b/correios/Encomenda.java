/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author rodrigo
 */
// calculo peso cubico (C x L x A)/6.000.

public final class Encomenda {
    private int Id;
    private int IdCliente;
    private Destinatario destinatario;
    private double comprimento;
    private double altura;
    private double largura;
    private double peso3;
    private double valor;
    private Date dataPostagem;
    private Date dataEntrega;
    //satus da encoemnda entrega/caminho/postado
    private String posicao;
    private String rastreio;

    public Encomenda(int IdCliente, Destinatario destinatario, double comprimento, double altura, double largura){
        this.IdCliente = IdCliente;
        this.destinatario = destinatario;
        this.comprimento = comprimento;
        this.altura = altura;
        this.largura = largura;
        setPeso3(comprimento, altura, largura);
        setValor(peso3);
    }
    
    public Date inicializarData() {
        //Define um formatador de datas
        //SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");           
        Date data = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        data = calendario.getTime();
        return data;
    }
    
    private String inicializarRastreio(String cpf, Date dt){
        String rast = cpf+dt.toString();
        return rast;
    }
    
    

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega=dataEntrega;
    }
    
    public String getRastreio(){
        return rastreio;
    }
    
    public void setRastreio(String rastreio){
        this.rastreio = rastreio;
    }
    
    public String getPosicao(){
        return posicao;
    }
    
    public void setPosicao(String posicao){
        this.posicao = posicao;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double peso3) {
        this.valor = peso3*2.75;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getPeso3() {
        return peso3;
    }

    public void setPeso3(double comprimento, double altura, double largura) {
        this.peso3 = (comprimento*altura*largura)/6.000;
    }
    
    
}
