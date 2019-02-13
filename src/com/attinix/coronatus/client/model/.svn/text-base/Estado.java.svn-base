package com.attinix.coronatus.client.model;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Estado implements IsSerializable {

	private static final long serialVersionUID = 2001532771543316621L;

	private Integer id;

	private Pais pais = new Pais();

	private String nome;

	private String uf;

	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

	public Estado() {

	}

	public Estado(Integer id, Pais pais, String nome, String uf) {
		this.id = id;
		this.pais = pais;
		this.nome = nome;
		this.uf = uf;
	}

	public Estado(Pais pais, String nome, String uf) {
		this.pais = pais;
		this.nome = nome;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}

	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
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
		if (!(obj instanceof Estado))
			return false;
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nEstado: " + this.nome + "\nUF: " + this.uf
				+ "\nPais:" + this.pais.getId() + " - " + this.pais.getNome();
	}
}
