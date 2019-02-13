package com.attinix.coronatus.server.dao;

import java.util.List;

import com.attinix.coronatus.client.model.PagamentoCartao;

public class PagamentoCartaoDao {

	SqlMap sqlMap = new SqlMap();
	
	public Integer excluirTodosPagamentoCartao(Integer codigo) {
		return sqlMap.delete("deleteAllPagamentoCartao", codigo);
	}

	public List<PagamentoCartao> consultarPorSituacoesDif4Empresas(List<Object> lstEmpresasCartoes) throws Exception {
		List<PagamentoCartao> objectResult = (List<PagamentoCartao>) sqlMap.queryForList(
				"retrievePagamentoCartaoPorSituacoesDif4Empresas", lstEmpresasCartoes);
		return objectResult;
	}

	
	// Classe só pra manter os metodos
	
	private class SqlMap {
		// TODO Auto-generated method stub
		
		public Integer delete(String string, Integer codigo) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<PagamentoCartao> queryForList(String string,
				List<Object> lstEmpresasCartoes) {
			// TODO Auto-generated method stub
			return null;
		}
	}


	public void excluir(PagamentoCartao pagamentoCartao) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void incluir(PagamentoCartao pc) {
		// TODO Auto-generated method stub
		
	}

}
