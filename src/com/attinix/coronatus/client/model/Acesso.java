package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Acesso implements IsSerializable {

	private static final long serialVersionUID = -156788701916984465L;

	private Usuario usuario;

	private Perfil perfil;

	private Empresa empresa;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getId() {
		return null;
	}

	public String toString() {
		return "Usuario: " + usuario.getNome() + "-" + usuario.getLogin()
				+ "\nEmpresa: " + empresa.getNomeFantasia() + "\nPeril: "
				+ perfil.getNome();
	}
}