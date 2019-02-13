package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EstabelecimentoCartaoTaxa implements IsSerializable {

	private static final long serialVersionUID = -8036502641279888953L;

	private Integer id;

	private EstabelecimentoCartao estabelecimentoCartao;

	private Integer parceladoDe;

	private Integer parceladoAte;

	private Integer totalParcelamento;

	private Double percentualTaxa;

	public EstabelecimentoCartaoTaxa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstabelecimentoCartao getEstabelecimentoCartao() {
		return estabelecimentoCartao;
	}

	public void setEstabelecimentoCartao(
			EstabelecimentoCartao estabelecimentoCartao) {
		this.estabelecimentoCartao = estabelecimentoCartao;
	}

	public Integer getParceladoDe() {
		return parceladoDe;
	}

	public void setParceladoDe(Integer parceladoDe) {
		this.parceladoDe = parceladoDe;
	}

	public Integer getParceladoAte() {
		return parceladoAte;
	}

	public void setParceladoAte(Integer parceladoAte) {
		this.parceladoAte = parceladoAte;
	}

	public Integer getTotalParcelamento() {
		return totalParcelamento;
	}

	public void setTotalParcelamento(Integer totalParcelamento) {
		this.totalParcelamento = totalParcelamento;
	}

	public Double getPercentualTaxa() {
		return percentualTaxa;
	}

	public void setPercentualTaxa(Double percentualTaxa) {
		this.percentualTaxa = percentualTaxa;
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
		if (!(obj instanceof EstabelecimentoCartaoTaxa))
			return false;
		EstabelecimentoCartaoTaxa other = (EstabelecimentoCartaoTaxa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String retorno;

		retorno = "\nId: " + this.getId() + "\nParcelado De: "
				+ this.getParceladoDe() + "\nParcelado Ate: "
				+ this.getParceladoAte();

		if (this.getEstabelecimentoCartao() != null) {
			retorno += "\nEstab.: " + this.getEstabelecimentoCartao();
		}

		return retorno;
	}

}