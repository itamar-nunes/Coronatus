package com.attinix.coronatus.client.model;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EstabelecimentoCartao implements IsSerializable {

	private static final long serialVersionUID = -1261206688988186217L;

	private Integer id;

	private Cartao cartao;

	private Estabelecimento estabelecimento;

	private Date dataDe;

	private Date dataAte;

	private Date dataCadastro;

	private Integer tipo;

	private Integer inativo;

	private List<EstabelecimentoCartaoTaxa> estabelecimentosCartoesTaxas;

	private Date dataVigente;

	public EstabelecimentoCartao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<EstabelecimentoCartaoTaxa> getEstabelecimentosCartoesTaxas() {
		return estabelecimentosCartoesTaxas;
	}

	public void setEstabelecimentosCartoesTaxas(List<EstabelecimentoCartaoTaxa> estabelecimentosCartoesTaxas) {
		this.estabelecimentosCartoesTaxas = estabelecimentosCartoesTaxas;
	}

	public Date getDataDe() {
		return dataDe;
	}

	public void setDataDe(Date dataDe) {
		this.dataDe = dataDe;
	}

	public Date getDataAte() {
		return dataAte;
	}

	public void setDataAte(Date dataAte) {
		this.dataAte = dataAte;
	}

	public Integer getInativo() {
		return inativo;
	}

	public void setInativo(Integer inativo) {
		this.inativo = inativo;
	}

	public Date getDataVigente() {
		return dataVigente;
	}

	public void setDataVigente(Date dataVigente) {
		this.dataVigente = dataVigente;
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
		if (!(obj instanceof EstabelecimentoCartao))
			return false;
		EstabelecimentoCartao other = (EstabelecimentoCartao) obj;
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

		retorno = "\nId: " + this.getId() + "\nData De: " + this.getDataDe() + "\nData Ate: " + this.getDataAte()
				+ "\nData cad.: " + this.getDataCadastro() + "\nTipo: " + this.getTipo() + "\nInativo: "
				+ this.getInativo();

		if (this.getCartao() != null) {
			retorno += "\nCartao: " + this.getCartao();
		}
		if (this.getEstabelecimento() != null) {
			retorno += "\nEstab.: " + this.getEstabelecimento();
		}
		if (this.getEstabelecimentosCartoesTaxas() != null) {
			if (this.getEstabelecimentosCartoesTaxas().size() > 0) {
				retorno += "\n--VERIFIQUE AS TAXAS EXISTENTES--";
			} else {
				retorno += "\n--NAO HA 'BEANS DE TAXAS' EXISTENTES PARA ESTE BEAN--";
			}
		}

		return retorno;
	}
}