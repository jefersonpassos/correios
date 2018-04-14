package usuarios;

public class Cliente extends Usuario{
	
	private int idCliente;
	private String endereco;
	private String cep;
	/*

Nome: 
CPF: 
Sobrenome:
RG: 
Endereço: 
CEP: 
Telefone: 
Celular: 
Estado: 
Cidade: 
Email: 
 
        */
	public Cliente(int idCliente, String nome, String endereco, String cep) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
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
	
	
	

}
