package com.attinix.coronatus.client.service.core;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;

public interface CrudServiceAsync {
	void alterar(String nome, IsSerializable parametro, AsyncCallback<Void> callback);

	void excluir(String nome, IsSerializable parametro, AsyncCallback<Void> callback);

	void inserir(String nome, IsSerializable parametro, AsyncCallback<IsSerializable> callback);

	void consultar(String nome, IsSerializable parametro, AsyncCallback<IsSerializable> callback);

	void consultarTodos(String nome, AsyncCallback<List<IsSerializable>> callback);

	void consultarTodos(String nome, IsSerializable parametro, AsyncCallback<List<IsSerializable>> callback);
}
