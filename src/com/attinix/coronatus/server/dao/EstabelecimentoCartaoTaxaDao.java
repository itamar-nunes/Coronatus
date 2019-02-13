package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.EstabelecimentoCartaoTaxa;

public class EstabelecimentoCartaoTaxaDao {

	SqlMap sqlMap = new SqlMap();

	public EstabelecimentoCartaoTaxa buscarEstabelecimentoCartaoTaxaPorParceladoDeAte(EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) throws Exception {
		EstabelecimentoCartaoTaxa objectResult = (EstabelecimentoCartaoTaxa) sqlMap.queryForObject(
				"retrieveEstabelecimentoCartaoTaxaPorParceladoDeAte", estabelecimentoCartaoTaxa);
		
		return objectResult;
	}

	public EstabelecimentoCartaoTaxa buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) throws Exception {
		EstabelecimentoCartaoTaxa objectResult = (EstabelecimentoCartaoTaxa) sqlMap.queryForObject(
				"retrieveEstabelecimentoCartaoTaxaPorParceladoEDataDeAte", estabelecimentoCartaoTaxa);
		
		return objectResult;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public EstabelecimentoCartaoTaxa queryForObject(String string,
				EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
