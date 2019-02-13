package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ContaAgencia implements IsSerializable {

	private static final long serialVersionUID = 6592197140882603285L;

	private Integer id;

	private String numero;

	private String titular;

	private Agencia agencia;

	private Empresa empresa;

	public ContaAgencia() {

	}

	public ContaAgencia(Integer id, String numero, String titular) {
		this.id = id;
		this.numero = numero;
		this.titular = titular;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero.toUpperCase();
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular.toUpperCase();
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String toString() {
		return "Id: " + this.id + "\nTitular: " + this.titular + "\nNumero: "
				+ this.numero + "\nAgencia: " + this.agencia + "\nEmpresa: "
				+ this.empresa;
	}
}
