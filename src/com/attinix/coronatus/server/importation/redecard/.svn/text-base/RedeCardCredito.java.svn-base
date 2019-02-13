package com.attinix.coronatus.server.importation.redecard;

import java.util.ArrayList;
import java.util.List;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.EstabelecimentoCartao;
import com.attinix.coronatus.client.model.EstabelecimentoCartaoTaxa;
import com.attinix.coronatus.client.model.PagamentoCartao;
import com.attinix.coronatus.client.model.Terminal;
import com.attinix.util.DataBR;

/**
 * @author Itamar
 * @version 1.0
 */
public class RedeCardCredito extends RedeCard {

	private Estabelecimento estabelecimentoFilial;
	
	public RedeCardCredito() {
	}

	public boolean TratarLinha(String linha) throws Exception {
		String tipoRegistro;

		if (linha == null || "".equalsIgnoreCase(linha.trim())) {
			return false;
		}

		tipoRegistro = linha.substring(0, 3);

		// Header do arquivo
		if ("002".equalsIgnoreCase(tipoRegistro)) {
			registro002(linha);

			// Verifica se deve ser feito Inclussao, Alteracao ou Exclussao
			Integer acao = super.verificaAcao();

			//Excluir
			if(acao == 2) {
				super.atualizarCabecalhoPagamentoCartao(acao);
			}
			// Incluir
			super.atualizarCabecalhoPagamentoCartao(1);
			
			return true;
		}

		// Header Matriz
		if ("004".equalsIgnoreCase(tipoRegistro)) {
			registro004(linha);
		}
		
		// CV / NSU Rotativo (Resumos/transacoes Rotativos. Vendas com juros)
		// Verificar o metodo abaixo !!!
//		if ("008".equalsIgnoreCase(tipoRegistro)) {
//			PagamentoCartao pagamentoCartao = registro008(linha);
//
//			// Atualizacao do pagamentoCartao
//			super.atualizarPagamentoCartao(pagamentoCartao);
//		}

		// CV / NSU Parcelado sem juros
		if ("012".equalsIgnoreCase(tipoRegistro)) {
			List<PagamentoCartao> lstPcs = registro012(linha);

			for (PagamentoCartao pagamentoCartao : lstPcs) {
				super.atualizarPagamentoCartao(pagamentoCartao);
			}
		}

		return true;
	}

	// Header do arquivo
	protected void registro002(String linha) throws Exception {
		this.getCabecalhoPagamentoCartao().setSequencia(linha.substring(71, 77));

		String estabelecimento = linha.substring(77, 86);
		Estabelecimento estabelecimentoGrupo = super.buscarEstabelecimentoPorCodigo(estabelecimento);
		this.getCabecalhoPagamentoCartao().setEstabelecimento(estabelecimentoGrupo);
		
		// Administradora REDECARD
		Administradora administradora = super.buscarAdministradoraPorCodigo("REDECARD");
		
		// Tipo de cartao: 1 - Credito
		Cartao cartao = super.buscarCartaoPorAdministradoraETipo(administradora, 1);
		this.getCabecalhoPagamentoCartao().setCartao(cartao);
	}

	// Header da Matriz
	protected void registro004(String linha) throws Exception {
		String estabelecimento = linha.substring(3, 12);
		Estabelecimento estabelecimentoFilial = super.buscarEstabelecimentoPorCodigo(estabelecimento);
		this.setEstabelecimentoFilial(estabelecimentoFilial);
	}

	// CV / NSU Rotativo (Resumos/transacoes Rotativos. Vendas com juros).
	// Não esta funcionando ainda. Deve ser corrigido lembrando que, uma venda parcelada,
	//  eh recebida nos arquivos como venda unica, ou seja, somente um registro, e sem o tatal de parcelamentos !!!
//	protected PagamentoCartao registro008(String linha) throws Exception {
//		PagamentoCartao pagamentoCartao = new PagamentoCartao();
//		String aux;
//		Double valor;
//
//		// Numero do resumo
//		pagamentoCartao.setNumeroResumo(linha.substring(12, 21));
//		// Data
//		aux = linha.substring(21, 29);
//		// Hora
//		// aux = aux + linha.substring(132, 138);
//		// Aqui, testar a hora
//		pagamentoCartao.setDataMovimentacao(new DataBR(aux));
//		aux = linha.substring(37, 52);
//		valor = Double.parseDouble(aux) / 100;
//		pagamentoCartao.setValor(valor);
//		pagamentoCartao.setRejeicao(linha.substring(83, 86));
//		pagamentoCartao.setNumeroCVNSU(linha.substring(86, 98));
//		aux = linha.substring(111, 126);
//		valor = Double.parseDouble(aux) / 100;
//		pagamentoCartao.setValorDesconto(valor);
//		pagamentoCartao.setNumeroAutorizacao(linha.substring(126, 132));
//		aux = linha.substring(218, 226);
//		Terminal terminal = super.buscarTerminalPorCodigo(aux);
//		pagamentoCartao.setTerminal(terminal);
//
//		// Para buscar o EstabelecimentoCartaoTaxa. Com a taxa vigente conforme a data do pagamentoCartao
//		// Venda Credito Rotativo nao tem parcela. Entao nao eh necessario procurar com EstabelecimentoCartao.De - Ate.
//		EstabelecimentoCartao estabelecimentoCartao = new EstabelecimentoCartao();
//		estabelecimentoCartao.setCartao(this.getCabecalhoPagamentoCartao().getCartao());
//		estabelecimentoCartao.setEstabelecimento(this.getEstabelecimentoFilial());
//		// EstabelecimentoCartao.Tipo = 2 - Credito Rotativo com juros
//		estabelecimentoCartao.setTipo(2);
//		
//		EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa = new EstabelecimentoCartaoTaxa();
//		estabelecimentoCartaoTaxa.setEstabelecimentoCartao(estabelecimentoCartao);
//		estabelecimentoCartaoTaxa.setDataDe(pagamentoCartao.getDataMovimentacao());
//		estabelecimentoCartaoTaxa.setDataAte(pagamentoCartao.getDataMovimentacao());
//		// EstabelecimentoCartaoTaxa.Inativo = 0 - Ativo
//		estabelecimentoCartaoTaxa.setInativo(0);
//		
//		estabelecimentoCartaoTaxa = super.buscarEstabelecimentoCartaoTaxaPorDataDeAte(estabelecimentoCartaoTaxa);
//		
//		pagamentoCartao.setEstabelecimentoCartaoTaxa(estabelecimentoCartaoTaxa);
//		
//		// Padrao
//		pagamentoCartao.setSituacao(this.getSituacao());
//		pagamentoCartao.setCabecalhoPagamentoCartao(this.getCabecalhoPagamentoCartao());
//
//		// Rotativo nao tem parcela - padrao zero (0)
//		pagamentoCartao.setParcela(0);
//		
//		return pagamentoCartao;
//	}

	// CV / NSU Rotativo (Resumos/transacoes Rotativos. Vendas com juros).
	protected List<PagamentoCartao> registro012(String linha) throws Exception {
		List<PagamentoCartao> lstPcs = new ArrayList<PagamentoCartao>();
		String aux;
		Double valor;

		// Numero do resumo
		String numeroResumo = linha.substring(12, 21);
		// Data
		aux = linha.substring(21, 29);
		// Hora
		// aux = aux + linha.substring(134, 140);
		// Aqui, testar a hora
		DataBR dataMovimentacao = new DataBR(aux);
		// Rejeicao
		String rejeicao = linha.substring(83, 86);
		// Total de parcelas
		aux = linha.substring(86, 88);
		Integer totalParcela = Integer.parseInt(aux);
		// Numero de CVNSU
		String numeroCVNSU = linha.substring(88, 100);
		// Valor do desconto
		aux = linha.substring(113, 128);
		Double valorDesconto = Double.parseDouble(aux) / 100;
		// Numero de autorizacao
		String numeroAutorizacao = linha.substring(128, 134);
		// Valor liquido da primeira parcela
		aux = linha.substring(220, 235);
		Double valorLiquidoPrimeiraParcela = Double.parseDouble(aux) / 100;
		// Valor liquido das demais parcela
		aux = linha.substring(235, 250);
		Double valorLiquidoDemaisParcela = Double.parseDouble(aux) / 100;
		// Terminal
		String stTerminal = linha.substring(250, 258);
		Terminal terminal = super.buscarTerminalPorCodigo(stTerminal);

		// Para buscar o EstabelecimentoCartaoTaxa. Com a taxa vigente conforme a data do pagamentoCartao
		// Venda a Credito parcelado.
		EstabelecimentoCartao estabelecimentoCartao = new EstabelecimentoCartao();
		estabelecimentoCartao.setCartao(this.getCabecalhoPagamentoCartao().getCartao());
		estabelecimentoCartao.setEstabelecimento(this.getEstabelecimentoFilial());
		// Data de venda eh a data de vigencia do cartao
		estabelecimentoCartao.setDataVigente(dataMovimentacao);
		// EstabelecimentoCartao.Tipo = 2 - Credito parcelado sem juros
		estabelecimentoCartao.setTipo(2);
		
		EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa = new EstabelecimentoCartaoTaxa();
		estabelecimentoCartaoTaxa.setEstabelecimentoCartao(estabelecimentoCartao);
		// Credito parcelado. Verificar qual a faixa de parcelamento. Total do parcelamento eh o parcelamento de ocorrencia
		estabelecimentoCartaoTaxa.setTotalParcelamento(totalParcela);
		estabelecimentoCartaoTaxa = super.buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(estabelecimentoCartaoTaxa);
		
		// Total de parcelas
		for (int i = 1; i <= totalParcela; i++) {
			PagamentoCartao pagamentoCartao = new PagamentoCartao();

			// Padrao
			pagamentoCartao.setSituacao(this.getSituacao());
			pagamentoCartao.setCabecalhoPagamentoCartao(this.getCabecalhoPagamentoCartao());
			pagamentoCartao.setEstabelecimentoCartaoTaxa(estabelecimentoCartaoTaxa);

			pagamentoCartao.setNumeroResumo(numeroResumo);
			pagamentoCartao.setDataMovimentacao(dataMovimentacao);
			pagamentoCartao.setRejeicao(rejeicao);
			pagamentoCartao.setParcela(i);
			pagamentoCartao.setTotalParcela(totalParcela);
			pagamentoCartao.setNumeroCVNSU(numeroCVNSU);
			pagamentoCartao.setValorDesconto(valorDesconto);
			pagamentoCartao.setNumeroAutorizacao(numeroAutorizacao);
			// Valor liquido da primeira parcela
			if (i == 1) {
				pagamentoCartao.setValorLiquido(valorLiquidoPrimeiraParcela);
				// Valor bruto
				pagamentoCartao.setValorBruto(valorLiquidoPrimeiraParcela + valorDesconto);
			} else {
				// Valor liquido das demais parcela
				pagamentoCartao.setValorLiquido(valorLiquidoDemaisParcela);
				// Valor bruto
				pagamentoCartao.setValorBruto(valorLiquidoDemaisParcela + valorDesconto);
			}
			pagamentoCartao.setTerminal(terminal);

			lstPcs.add(pagamentoCartao);
		}

		return lstPcs;
	}

	public Estabelecimento getEstabelecimentoFilial() {
		return estabelecimentoFilial;
	}

	public void setEstabelecimentoFilial(Estabelecimento estabelecimentoFilial) {
		this.estabelecimentoFilial = estabelecimentoFilial;
	}

}
