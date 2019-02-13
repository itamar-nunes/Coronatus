package com.attinix.coronatus.server.dao;

import java.util.List;

import com.attinix.coronatus.client.model.Empresa;
import com.attinix.coronatus.client.model.MovimentoEmpresa;

public class EmpresaDao {

	SqlMap sqlMap = new SqlMap();

	public Empresa consultarPorCodigo(Integer codigo) throws Exception {
		// Ajustando o nome do mÃ©todo a ser chamdo de dentro do XML do
		// iBatis
		Empresa objectResult = (Empresa) sqlMap.queryForObject("retrieveEmpresaPorCodigo", codigo);
		return objectResult;
	}
	public List<Empresa> consultarPorGrupo(Integer grupo) throws Exception{
		List<Empresa> empresas = (List<Empresa>) sqlMap.queryForList("retrieveEmpresaPorGrupo", grupo);
		return empresas;
	}

	// Classe só pra manter os metodos
	
	private class SqlMap {

		public List<MovimentoEmpresa> queryForList(String string,
				List<Object> lstEmpresasCartoes) {
			// TODO Auto-generated method stub
			return null;
		}
		// TODO Auto-generated method stub

		public List<Empresa> queryForList(String string, Integer grupo) {
			// TODO Auto-generated method stub
			return null;
		}

		public Empresa queryForObject(String string, Integer codigo) {
			// TODO Auto-generated method stub
			return null;
		}
	}


}
