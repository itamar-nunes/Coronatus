package com.attinix.coronatus.client.service.core;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

@RemoteServiceRelativePath("coronatus/crud")
public interface CrudService extends RemoteService {

	public void alterar(String nome, IsSerializable parametro) throws CrudException;

	public void excluir(String nome, IsSerializable parametro);

	public IsSerializable inserir(String nome, IsSerializable parametro) throws CrudException;

	public IsSerializable consultar(String nome, IsSerializable parametro);

	public List<IsSerializable> consultarTodos(String nome);

	public List<IsSerializable> consultarTodos(String nome,
			IsSerializable parametro);

	/**
	 * Utility class to get the RPC Async interface from client-side code
	 */
	public static class Util {
		private static CrudServiceAsync instance;

		public static CrudServiceAsync getInstance() {
			if (instance == null) {
				instance = (CrudServiceAsync) GWT.create(CrudService.class);
				ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL()
						+ "service/crud");
			}
			return instance;
		}
	}
}
