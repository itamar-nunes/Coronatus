package com.attinix.coronatus.client.model;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CabecalhoPagamentoCartao implements IsSerializable {

	private static final long serialVersionUID = 9159358600642042747L;

	private Integer id;

	private Cartao cartao;

	private Estabelecimento estabelecimento;

	private String sequencia;

	private List<PagamentoCartao> pagamentosCartoes;

	public CabecalhoPagamentoCartao() {
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

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public List<PagamentoCartao> getPagamentosCartoes() {
		return pagamentosCartoes;
	}

	public void setPagamentosCartoes(List<PagamentoCartao> pagamentosCartoes) {
		this.pagamentosCartoes = pagamentosCartoes;
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
		if (!(obj instanceof CabecalhoPagamentoCartao))
			return false;
		CabecalhoPagamentoCartao other = (CabecalhoPagamentoCartao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		String retorno;

		retorno = "\nId: " + this.getId() + "\nSequencia: "
				+ this.getSequencia();

		if (this.getCartao() != null) {
			retorno += "\nCartao: " + this.getCartao();
		}
		if (this.getEstabelecimento() != null) {
			retorno += "\nEstabelecimento: " + this.getEstabelecimento();
		}

		return retorno;
	}
}
