package com.attinix.coronatus.server.importation.redecard;

import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.PagamentoCartao;


/**
 * @author Itamar
 * @version 1.0
 */
public class RedeCardPagamento extends RedeCard {

	public boolean TratarLinha(String linha) throws Exception {
		String tipoRegistro;

		if (linha == null || "".equalsIgnoreCase(linha.trim())) {
			return false;
		}

		tipoRegistro = linha.substring(0, 3);

		// Header do arquivo 
		if ("030".equalsIgnoreCase(tipoRegistro)) {
			registro034(linha);
		}
		
		// Creditos - Ordem de Credito 
		if ("034".equalsIgnoreCase(tipoRegistro)) {
			registro034(linha);
		}
		
		return true;
	}
	
	// Header do arquivo
	protected void registro030(String linha) throws Exception {
		this.getCabecalhoPagamentoCartao().setSequencia(linha.substring(75, 81));

		String estabelecimento = linha.substring(81, 90);
		Estabelecimento estabelecimentoGrupo = super.buscarEstabelecimentoPorCodigo(estabelecimento);
		this.getCabecalhoPagamentoCartao().setEstabelecimento(estabelecimentoGrupo);
	}
	
	// Creditos - Ordem de Credito
	protected PagamentoCartao registro034(String linha) throws Exception {
		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		String aux;
		Double valor;

		// Padrao
		pagamentoCartao.setSituacao(this.getSituacao());
		
		return pagamentoCartao;
	}
	
	
	

}
