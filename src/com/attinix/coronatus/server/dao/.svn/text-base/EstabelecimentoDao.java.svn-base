package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.Estabelecimento;


public class EstabelecimentoDao {

	SqlMap sqlMap = new SqlMap();

	public Estabelecimento consultarPorCodigo(String codigo) {
		// Ajustando o nome do método a ser chamdo de dentro do XML do
		// iBatis
		Estabelecimento objectResult = (Estabelecimento) sqlMap.queryForObject(
				"retrieveEstabelecimentoPorCodigo", codigo);
		return objectResult;
	}

	public Estabelecimento consultarPorEmpresaCodigo(Integer codigo) {
		// Ajustando o nome do método a ser chamdo de dentro do XML do
		// iBatis
		Estabelecimento objectResult = (Estabelecimento) sqlMap.queryForObject(
				"retrieveEstabelecimentoPorEmpresaCodigo", codigo);
		return objectResult;
	}

	// Classe s� pra manter os metodos
	
	private class SqlMap {

		public Estabelecimento queryForObject(String string, String codigo) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub

		public Estabelecimento queryForObject(String string, Integer codigo) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
