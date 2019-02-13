package com.attinix.coronatus.server.dao;

import java.util.List;

import com.attinix.coronatus.client.model.MovimentoEmpresa;

public class MovimentoEmpresaDao {

	SqlMap sqlMap = new SqlMap();

	public List<MovimentoEmpresa> consultarPorSituacoesDif4Empresas(List<Object> lstEmpresasCartoes) throws Exception {
		List<MovimentoEmpresa> objectResult = (List<MovimentoEmpresa>) sqlMap.queryForList(
				"retrieveMovimentoEmpresaPorSituacoesDif4Empresas", lstEmpresasCartoes);
		return objectResult;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public List<MovimentoEmpresa> queryForList(String string,
				List<Object> lstEmpresasCartoes) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub
	}

	public void excluir(MovimentoEmpresa movimentoEmpresa) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void incluir(MovimentoEmpresa movimentoEmpresa) {
		// TODO Auto-generated method stub
		
	}

}
