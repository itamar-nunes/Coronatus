package com.attinix.coronatus.client.model;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PagamentoCartao implements IsSerializable {
	/**
	 *  utilizado para fazer a persistencia do Pagamento de Cartao. Sera
	 * utilizado na tabela pagamentocartao do banco coronatus.
	 */
	private static final long serialVersionUID = 351445697611L;

	private Integer id;

	private CabecalhoPagamentoCartao cabecalhoPagamentoCartao;

	private EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa;

	private Terminal terminal;

	private String numeroAutorizacao;

	private Double valorBruto;

	private Double valorDesconto;

	private Integer parcela;

	private Date dataMovimentacao;

	private Date dataDeposito;

	private Integer situacao;

	private String numeroResumo;

	private String rejeicao;

	private String numeroCVNSU;

	private Double valorPago;

	private Integer totalParcela;

	private Double valorLiquido;

	public PagamentoCartao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CabecalhoPagamentoCartao getCabecalhoPagamentoCartao() {
		return cabecalhoPagamentoCartao;
	}

	public void setCabecalhoPagamentoCartao(
			CabecalhoPagamentoCartao cabecalhoPagamentoCartao) {
		this.cabecalhoPagamentoCartao = cabecalhoPagamentoCartao;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public String getNumeroAutorizacao() {
		return numeroAutorizacao;
	}

	public void setNumeroAutorizacao(String numeroAutorizacao) {
		this.numeroAutorizacao = numeroAutorizacao;
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

	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public String getNumeroResumo() {
		return numeroResumo;
	}

	public void setNumeroResumo(String numeroResumo) {
		this.numeroResumo = numeroResumo;
	}

	public String getRejeicao() {
		return rejeicao;
	}

	public void setRejeicao(String rejeicao) {
		this.rejeicao = rejeicao;
	}

	public String getNumeroCVNSU() {
		return numeroCVNSU;
	}

	public void setNumeroCVNSU(String numeroCVNSU) {
		this.numeroCVNSU = numeroCVNSU;
	}

	public EstabelecimentoCartaoTaxa getEstabelecimentoCartaoTaxa() {
		return estabelecimentoCartaoTaxa;
	}

	public void setEstabelecimentoCartaoTaxa(
			EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) {
		this.estabelecimentoCartaoTaxa = estabelecimentoCartaoTaxa;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getTotalParcela() {
		return totalParcela;
	}

	public void setTotalParcela(Integer totalParcela) {
		this.totalParcela = totalParcela;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
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
		// Atencao, Nao remova esse metodo para refaze-lo automaticamente.
		// Pois este eh especifico deste objeto

		if (obj == null) {
			return false;
		}
		if (obj instanceof PagamentoCartao) {
			if (this == obj) {
				return true;
			}

			PagamentoCartao other = (PagamentoCartao) obj;
			if (this.id == null) {
				if (other.id != null) {
					return false;
				}
			} else if (!this.id.equals(other.id)) {
				return false;
			}

			return true;

		} else if (obj instanceof MovimentoEmpresa) {
			// Se for um Bean de - MovimentoEmpresa
			// Avaliar:
			// Empresa - Administradora - numeroCVNSU -
			// dataMovimentacao - Parcela
			// Atualmente nao esta sendo avaliado o Terminal

			// Avaliando atributos "deste" objeto
			if (this.getEstabelecimentoCartaoTaxa() == null
					|| this.getEstabelecimentoCartaoTaxa()
							.getEstabelecimentoCartao() == null
					|| this.getEstabelecimentoCartaoTaxa()
							.getEstabelecimentoCartao().getEstabelecimento() == null
					|| this.getEstabelecimentoCartaoTaxa()
							.getEstabelecimentoCartao().getEstabelecimento()
							.getEmpresa() == null
					|| this.getEstabelecimentoCartaoTaxa()
							.getEstabelecimentoCartao().getCartao() == null
					|| this.getEstabelecimentoCartaoTaxa()
							.getEstabelecimentoCartao().getCartao()
							.getAdministradora() == null
					|| this.getNumeroCVNSU() == null
					|| this.getDataMovimentacao() == null
					|| this.getParcela() == null) {

				return false;
			}

			MovimentoEmpresa me = (MovimentoEmpresa) obj;
			// Avaliando atributos do obejto meBean (MovimentoEmpresa)
			if (me.getEstabelecimento() == null
					|| me.getEstabelecimento().getEmpresa() == null
					|| me.getCartao() == null
					|| me.getCartao().getAdministradora() == null
					|| me.getNumeroCVNSU() == null
					|| me.getDataMovimentacao() == null
					|| me.getParcela() == null) {

				return false;
			}

			// Verificando se eh o mesmo registro (Lembrando..., sem o Terminal)
			/*DataBR pcDataMovimentacao = new DataBR(this.getDataMovimentacao());
			DataBR meDataMovimentacao = new DataBR(me.getDataMovimentacao());
			if (pcDataMovimentacao.compareTo(meDataMovimentacao) == 0) {
				if (this.getEstabelecimentoCartaoTaxa()
						.getEstabelecimentoCartao().getEstabelecimento()
						.getEmpresa().equals(
								me.getEstabelecimento().getEmpresa())
						&& this.getEstabelecimentoCartaoTaxa()
								.getEstabelecimentoCartao().getCartao()
								.getAdministradora().equals(
										me.getCartao().getAdministradora())
						&& this.getNumeroCVNSU().trim().equalsIgnoreCase(
								me.getNumeroCVNSU().trim())
						&& this.getParcela().equals(me.getParcela())) {

					return true;
				}
			}*/
		}

		return false;
	}

	public String toString() {
		String retorno = "";

		if (this.getEstabelecimentoCartaoTaxa() != null) {
			retorno = "\nEstabelecimento: "
					+ this.getEstabelecimentoCartaoTaxa();
		}

		if (this.getCabecalhoPagamentoCartao() != null) {
			retorno += "\nSequencia: "
					+ this.getCabecalhoPagamentoCartao().getSequencia();

			if (this.getCabecalhoPagamentoCartao().getCartao() != null) {
				retorno += "\nCartao: "
						+ this.getCabecalhoPagamentoCartao().getCartao();
			}

			if (this.getCabecalhoPagamentoCartao().getEstabelecimento() != null) {
				retorno += "\nEstab. Matriz: "
						+ this.getCabecalhoPagamentoCartao()
								.getEstabelecimento();
			}
		}

		if (this.getTerminal() != null) {
			retorno += "\nTerminal: " + this.getTerminal();
		}

		retorno += "\nAutorizacao: " + this.getNumeroAutorizacao()
				+ "\nValor bruto: " + this.getValorBruto() + "\nValor pago: "
				+ this.getValorPago() + "\nDesconto: "
				+ this.getValorDesconto() + "\nValor liq.: "
				+ this.getValorLiquido() + "\nParcela: " + this.getParcela()
				+ "\nData Movimentacao: " + this.getDataMovimentacao()
				+ "\nDeposito: " + this.getDataDeposito() + "\nSitucao: "
				+ this.getSituacao() + "\nResumo de Venda: "
				+ this.getNumeroResumo() + "\nCV/NSU: " + this.getNumeroCVNSU()
				+ "\nRejeicao: " + this.getRejeicao();

		return retorno;
	}
}