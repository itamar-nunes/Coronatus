package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LogradouroTipo implements IsSerializable {

	private static final long serialVersionUID = 4594815153116889648L;

	private Integer id;

	private String sigla;

	private String nome;

	public LogradouroTipo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
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
		if (!(obj instanceof LogradouroTipo))
			return false;
		LogradouroTipo other = (LogradouroTipo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nSigla: " + this.sigla + "\nNome: "
				+ this.nome;
	}
}