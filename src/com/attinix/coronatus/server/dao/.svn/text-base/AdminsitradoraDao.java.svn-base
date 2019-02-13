package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.Administradora;

public class AdminsitradoraDao {

	SqlMap sqlMap = new SqlMap();

	public Administradora consultarPorCodigo(String codigo) throws Exception {
		// Ajustando o nome do mÃ©todo a ser chamdo de dentro do XML do
		// iBatis
		Administradora objectResult = (Administradora) sqlMap.queryForObject(
				"retrieveAdministradoraPorCodigo", codigo);
		return objectResult;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public Administradora queryForObject(String string, String codigo) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
