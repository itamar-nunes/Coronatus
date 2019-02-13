package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.CabecalhoPagamentoCartao;

public class CabecalhoPagamentoCartaoDao {

	SqlMap sqlMap = new SqlMap();

	public CabecalhoPagamentoCartao consultaPorCartaoEstabelecimentoSequencia(CabecalhoPagamentoCartao codigo) throws Exception {
		CabecalhoPagamentoCartao retorno = null;
			retorno = (CabecalhoPagamentoCartao) 
				sqlMap.queryForObject("retrieveCabecalhoPagamentoCartaoPorCartaoEstabelecimentoSequencia", codigo);
		return retorno;
	}

	private class SqlMap {

		public CabecalhoPagamentoCartao queryForObject(String string,
				CabecalhoPagamentoCartao codigo) {
			// TODO Auto-generated method stub
			return null;
		}

		// TODO Auto-generated method stub
	}

	public void incluir(CabecalhoPagamentoCartao cabecalhoPagamentoCartao) {
		// TODO Auto-generated method stub
		
	}

}
