package com.attinix.coronatus.client;

import com.attinix.coronatus.client.view.AdministradoraView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Coronatus implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Button button = new Button("Teste", new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				administradoraView();
			}
		});

		RootPanel.get().add(button);
	}
	
	public void administradoraView() {
		AdministradoraView tela = new AdministradoraView();
		tela.center();
		tela.show();
	}
}
