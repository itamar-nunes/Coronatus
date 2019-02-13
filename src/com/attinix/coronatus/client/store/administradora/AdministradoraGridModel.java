package com.attinix.coronatus.client.store.administradora;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.store.GridModel;
import com.attinix.coronatus.client.store.SimpleStore;

public class AdministradoraGridModel extends GridModel {

	public AdministradoraGridModel(SimpleStore store) {
		super(store);
	}

	@Override
	public String getCellValue(int row, int col) {
		Administradora administradora = (Administradora) entityList.get(row);
		switch (col) {
		case 0:
			return administradora.getCodigo();
		case 1:
			return administradora.getNome();
		default:
			break;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public int getColumnWidth(int col) {
	    switch (col) {
        case 0:
            return 80;
        case 1:
            return 180;
        }
	    return 0;
	}
	
	@Override
	public String getColumnTitle(int col) {
	    switch (col) {
        case 0:
            return "Código";
        case 1: 
            return "Nome";
        }
	    return null;
	}

}
