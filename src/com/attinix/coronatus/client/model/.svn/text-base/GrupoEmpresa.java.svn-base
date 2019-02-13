package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GrupoEmpresa implements IsSerializable {

	private static final long serialVersionUID = 8084147787028053481L;

	private Integer id;

	private String nome;

	private String pastaUpload;

	public GrupoEmpresa() {

	}

	public GrupoEmpresa(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getPastaUpload() {
		return pastaUpload;
	}

	public void setPastaUpload(String pastaUpload) {
		this.pastaUpload = pastaUpload.toUpperCase();
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
		if (!(obj instanceof GrupoEmpresa))
			return false;
		GrupoEmpresa other = (GrupoEmpresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nNome: " + this.nome;
	}
}
