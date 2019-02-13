package com.attinix.coronatus.client.model;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Perfil implements IsSerializable {

	private static final long serialVersionUID = 6071546714257376331L;

	private Integer id;

	private String nome;

	private List<Menu> menus;

	private Integer[] lstIdMenu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Integer[] getLstIdMenu() {
		return lstIdMenu;
	}

	public void setLstIdMenu(Integer[] lstIdMenu) {
		this.lstIdMenu = lstIdMenu;
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
		if (!(obj instanceof Perfil))
			return false;
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + "\nNome " + this.nome;
	}
}