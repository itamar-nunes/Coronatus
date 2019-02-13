package com.attinix.coronatus.server.service;

import java.sql.SQLException;
import java.util.List;

import com.attinix.coronatus.client.service.core.CrudException;
import com.attinix.coronatus.client.service.core.CrudService;
import com.attinix.coronatus.server.ibatis.Transactional;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.inject.Inject;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CrudServiceImpl implements CrudService {

	@Inject
	private SqlMapClient map;
	
	@Transactional
	public void alterar(String nome, IsSerializable parametro) throws CrudException {
		try {
			map.update(nome, parametro);
		} catch (SQLException e) {
			throw new CrudException(e);
		}
	}

	public IsSerializable consultar(String nome, IsSerializable parametro) {
		try {
			return (IsSerializable) map.queryForObject(nome, parametro);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<IsSerializable> consultarTodos(String nome) {
		try {
			return map.queryForList(nome);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public void excluir(String nome, IsSerializable parametro) {
		try {
			map.delete(nome, parametro);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	@Transactional
	public IsSerializable inserir(String nome, IsSerializable parametro) throws CrudException {
		try {
			map.insert(nome, parametro);
			return parametro;
		} catch (SQLException e) {
			throw new CrudException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<IsSerializable> consultarTodos(String nome, IsSerializable parametro) {
		try {
			return map.queryForList(nome, parametro);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
