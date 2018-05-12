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
    private int IdEncomenda;
    private Cliente cliente;
    private Destinatario destinatario;
    private double valor;
    private double comprimento;
    private double altura;
    private double largura;
    private double peso;

    public int getIdEncomenda() {
        return IdEncomenda;
    }

    public void setIdEncomenda(int IdEncomenda) {
        this.IdEncomenda = IdEncomenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public void setValor(double comprimento, double altura, double largura) {
        this.valor = (comprimento*altura*largura)/6.000;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
}
