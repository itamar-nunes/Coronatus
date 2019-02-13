package com.attinix.coronatus.client.model;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Usuario implements IsSerializable {

	private static final long serialVersionUID = 836660909610116746L;

	private Integer id;

	private GrupoEmpresa grupoEmpresa;

	private String nome;

	private String login;

	private String senha;

	private List<Menu> menus;

	private Empresa empresa;

	private Integer mestre;

	public Usuario() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GrupoEmpresa getGrupoEmpresa() {
		return grupoEmpresa;
	}

	public void setGrupoEmpresa(GrupoEmpresa grupoEmpresa) {
		this.grupoEmpresa = grupoEmpresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getMestre() {
		return mestre;
	}

	public void setMestre(Integer mestre) {
		this.mestre = mestre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.getId() + "\nLogin: " + this.getLogin()
				+ (this.getNome() != null ? "\nNome: " + this.getNome() : "");
	}
}