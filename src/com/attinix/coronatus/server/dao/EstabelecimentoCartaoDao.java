package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.EstabelecimentoCartao;

public class EstabelecimentoCartaoDao {

	SqlMap sqlMap = new SqlMap();

	public EstabelecimentoCartao buscarEstabelecimentoCartaoPorDataDeAte(EstabelecimentoCartao estabelecimentoCartao) throws Exception {
		EstabelecimentoCartao objectResult = (EstabelecimentoCartao) sqlMap.queryForObject(
				"retrieveEstabelecimentoCartaoPorDataDeAte", estabelecimentoCartao);
		
		return objectResult;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public EstabelecimentoCartao queryForObject(String string,
				EstabelecimentoCartao estabelecimentoCartao) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
