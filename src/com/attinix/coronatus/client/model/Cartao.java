package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Cartao implements IsSerializable {

	private static final long serialVersionUID = -7664203176220028710L;

	private Integer id;

	private Administradora administradora = new Administradora();

	private String nome;

	private Integer tipo;

	private Integer codigo;

	public Cartao() {

	}

	public Cartao(Administradora administradora, String nome, Integer tipo) {
		this.administradora = administradora;
		this.nome = nome;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Administradora getAdministradora() {
		return administradora;
	}

	public void setAdministradora(Administradora administradora) {
		this.administradora = administradora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		if (!(obj instanceof Cartao))
			return false;
		Cartao other = (Cartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nExterno:" + this.codigo + "\nNome: "
				+ this.nome + "\nTipo: " + this.tipo + "\nAdministradora: "
				+ this.administradora.getId() + " - "
				+ this.administradora.getNome();
	}
}