package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Telefone implements IsSerializable {

	private static final long serialVersionUID = 6424908700312008846L;

	private Integer id;

	private String tipo;

	private String DDI;

	private String DDD;

	private String numero;

	private String contato;

	private String ramal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDDI() {
		return DDI;
	}

	public void setDDI(String ddi) {
		DDI = ddi;
	}

	public String getDDD() {
		return DDD;
	}

	public void setDDD(String ddd) {
		DDD = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
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
		if (!(obj instanceof Telefone))
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "/nTipo: " + this.getTipo() + "/nDDI: " + this.getDDI()
				+ "/nDDD: " + this.getDDD() + "/nNumero: " + this.getNumero()
				+ "/nContato: " + this.getContato() + "/nRamal: "
				+ this.getRamal();
	}
}
