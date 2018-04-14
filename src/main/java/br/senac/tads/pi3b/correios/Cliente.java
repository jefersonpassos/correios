package br.senac.tads.pi3b.correios;

public class Cliente{
    
    private int idCliente;
    private String nome;
    private String endereco;
    private String cep;
    private String telefone;
    private String estado;
    private String cidade;
    private String email;
    private String cpf;

    public Cliente(String nome, String telefone, String cpf, 
            String email, String endereco, String estado, String cep, String cidade) {
        //this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = telefone;
        this.cep = estado;
        this.cep = cep;
        this.cpf = cpf;
        this.cidade = cidade;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    

}
