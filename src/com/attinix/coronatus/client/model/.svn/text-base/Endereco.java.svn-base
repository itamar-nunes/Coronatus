package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Endereco implements IsSerializable {

	private static final long serialVersionUID = -604234125772215911L;

	private Integer id;

	private Logradouro logradouro = new Logradouro();

	private String numero;

	private String cep;

	private String complemento;

	public Endereco() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Endereco))
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nLogradouro: " + logradouro.getId() + " - "
				+ logradouro.getNome() + "\nNúmero: " + this.numero + "\nCEP: "
				+ this.cep + "\nComplemento: " + this.complemento;
	}
}