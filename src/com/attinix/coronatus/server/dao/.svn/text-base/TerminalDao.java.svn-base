package com.attinix.coronatus.server.dao;

import com.attinix.coronatus.client.model.Terminal;

public class TerminalDao {

	SqlMap sqlMap = new SqlMap();

	public Terminal consultarPorCodigo(String codigo) throws Exception {
		// Ajustando o nome do mÃ©todo a ser chamdo de dentro do XML do
		// iBatis
		Terminal objectResult = (Terminal) sqlMap.queryForObject("retrieveTerminalPorCodigo", codigo);
		return objectResult;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public Terminal queryForObject(String string, String codigo) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
