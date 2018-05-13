/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

/**
 *
 * @author rodrigo
 */
// calculo peso cubico (C x L x A)/6.000.

public class Encomenda {
    private int Id;
    private int IdCliente;
    private Destinatario destinatario;
    private double comprimento;
    private double altura;
    private double largura;
    private double peso3;
    private double valor;
    //satus da encoemnda entrega/caminho/postado
    private String posicao;

    public Encomenda(int IdCliente, Destinatario destinatario, double comprimento, double altura, double largura){
        this.IdCliente = IdCliente;
        this.destinatario = destinatario;
        this.comprimento = comprimento;
        this.altura = altura;
        this.largura = largura;
        setPeso3(comprimento, altura, largura);
        setValor(peso3);
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

    private void setValor(double peso3) {
        this.valor = peso3*2.2;
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

    private void setPeso3(double comprimento, double altura, double largura) {
        this.peso3 = (comprimento*altura*largura)/6.000;
    }
    
    
}
