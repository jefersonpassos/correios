/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.correios;

import org.mindrot.jbcrypt.BCrypt;
import java.io.Serializable;

/**
 *
 * @author jeferson passos
 */

public class Usuario implements Serializable {
	
    private int id;
    private String nome;
    private String email;
    private String hashSenha;
    private String perfil;
    
    public Usuario() {
    }
    
    public Usuario(int id, String nome, String email, String senha, String perfil){
        this.nome = nome;
        this.email = email;
        this.setSenha(senha);
        this.perfil = perfil;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public boolean validarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, this.hashSenha);
    }
   
    public void setSenha(String senhaAberta) {
        this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
    }
    
    public void setSenhaHash(String senhaHash){
        this.hashSenha = senhaHash;
    }

    

}
