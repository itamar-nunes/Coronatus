package com.attinix.coronatus.client.model;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class MovimentoEmpresa implements IsSerializable {

	private static final long serialVersionUID = 496155114325343470L;

	private Integer id;

	private Terminal terminal;

	private String autorizacao;

	private Double valorBruto = new Double(0);

	private Double valorDesconto = new Double(0);

	private Double valorLiquido = new Double(0);

	private Integer parcela;

	// TODO: Usar DataBR - Verificar questão da hora. E se da erro ao gravar no
	// banco.
	private Date dataMovimentacao = new Date();

	private Integer situacao;

	private String numeroCVNSU;

	private Integer totalParcela;

	private Estabelecimento estabelecimento;

	private Cartao cartao;

	public MovimentoEmpresa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Integer getParcela() {
		return parcela;
	}

	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public String getNumeroCVNSU() {
		return numeroCVNSU;
	}

	public void setNumeroCVNSU(String numeroCVNSU) {
		this.numeroCVNSU = numeroCVNSU;
	}

	public Integer getTotalParcela() {
		return totalParcela;
	}

	public void setTotalParcela(Integer totalParcela) {
		this.totalParcela = totalParcela;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
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
		if (!(obj instanceof MovimentoEmpresa))
			return false;
		MovimentoEmpresa other = (MovimentoEmpresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String retorno = "";

		if (this.getEstabelecimento() != null) {
			retorno += this.getEstabelecimento();

			if (this.getEstabelecimento().getEmpresa() != null) {
				retorno += this.getEstabelecimento().getEmpresa();
			}
		}
		if (this.getTerminal() != null) {
			retorno += this.getTerminal();
		}
		if (this.getCartao() != null) {
			retorno += this.getCartao();
		}

		retorno += "\nId: " + this.getId() + "\nAutorizacao: "
				+ this.getAutorizacao() + "\nData mov.: "
				+ this.getDataMovimentacao() + "\nValor bruto: "
				+ this.getValorBruto() + "\nDesconto: "
				+ this.getValorDesconto() + "\nValor liq.: "
				+ this.getValorLiquido() + "\nParcela: " + this.getParcela()
				+ "\nSituacao: " + this.getSituacao() + "\nCV/NSU: "
				+ this.getNumeroCVNSU();

		return retorno;
	}

}
