package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Agencia implements IsSerializable {

	private static final long serialVersionUID = 2001532771543316621L;

	private Integer id;

	private String nome;

	private String codigo;

	private Banco banco = new Banco();

	public Agencia() {

	}

	public Agencia(Integer id, Banco banco, String nome, String codigo) {
		this.id = id;
		this.banco = banco;
		this.nome = nome;
		this.codigo = codigo;
	}

	public Agencia(Banco banco, String nome, String codigo) {
		this.banco = banco;
		this.nome = nome;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
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
		if (!(obj instanceof Agencia))
			return false;
		Agencia other = (Agencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nAgencia: " + this.nome + "\nCodigo: "
				+ this.codigo + "\nBanco:" + this.banco.getId() + " - "
				+ this.banco.getNome();
	}
}