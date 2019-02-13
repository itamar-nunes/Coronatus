package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Estabelecimento implements IsSerializable {

	private static final long serialVersionUID = 8072924622496601123L;

	private Integer id;

	private Empresa empresa = new Empresa();

	private String codigo;

	public Estabelecimento() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
		if (!(obj instanceof Estabelecimento))
			return false;
		Estabelecimento other = (Estabelecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		String retorno;

		retorno = "\nId: " + this.getId() + "\nCodigo (num. est.): "
				+ this.getCodigo();

		if (this.getEmpresa() != null) {
			retorno += "\nEmpresa: " + this.getEmpresa().getId() + " - "
					+ this.getEmpresa().getRazaoSocial();
		}

		return retorno;
	}
}
