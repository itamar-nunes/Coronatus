package com.attinix.coronatus.server.importation;

import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * @author Itamar
 * @version 1.0
 */
public class Conexao {
	
	private SqlMapClient sqlMap;

	public Conexao() {
		try {
			this.sqlMap = SqlMapClientBuilder.buildSqlMapClient(Resources.getResourceAsReader("SqlMapConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlMapClient getSqlMap() {
		return sqlMap;
	}

}
