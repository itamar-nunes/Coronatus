package com.attinix.coronatus.client.model;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Pais implements IsSerializable {

	private static final long serialVersionUID = -4654435545377692403L;

	private Integer id;

	private String nome;

	private String nacionalidade;

	private String sigla;

	private ArrayList<Estado> estados = new ArrayList<Estado>();

	public Pais() {
	}

	public Pais(Integer id) {
		this.id = id;
		this.nome = "";
		this.nacionalidade = "";
		this.sigla = "";
	}

	public Pais(Integer id, String nome, String nacionalidade, String sigla) {
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.sigla = sigla;
	}

	public Pais(String nome, String nacionalidade, String sigla) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.sigla = sigla;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade.toUpperCase();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
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
		if (!(obj instanceof Pais))
			return false;
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nNome: " + this.nome + "\nNacionalidade: "
				+ this.nacionalidade + "\nSigla: " + this.sigla;
	}
}
