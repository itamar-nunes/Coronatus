package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.Cartao;


public class CartaoDao {

	SqlMap sqlMap = new SqlMap();

	public Cartao consultarPorCodigo(Integer codigo) throws Exception {
		// Ajustando o nome do método a ser chamdo de dentro do XML do
		// iBatis
		Cartao objectResult = (Cartao) sqlMap.queryForObject("retrieveCartaoPorCodigo", codigo);
		return objectResult;
	}
	
	public Cartao consultarPorAdministradoraETipo(Cartao cartao) throws Exception {
		// Ajustando o nome do método a ser chamdo de dentro do XML do
		// iBatis
		Cartao objectResult = (Cartao) sqlMap.queryForObject("retrieveCartaoPorAdministradoraETipo", cartao);
		return objectResult;
	}

	// Classe s� pra manter os metodos
	
	private class SqlMap {

		public Cartao queryForObject(String string, Cartao cartao) {
			// TODO Auto-generated method stub
			return null;
		}

		public Cartao queryForObject(String string, Integer codigo) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
