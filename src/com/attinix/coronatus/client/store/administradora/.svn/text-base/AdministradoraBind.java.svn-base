package com.attinix.coronatus.client.store.administradora;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.model.Entity;
import com.attinix.coronatus.client.store.EntityBind;
import com.attinix.coronatus.client.store.HandlerFactory;
import com.attinix.coronatus.client.store.IComponentListener;
import com.attinix.coronatus.client.store.IMessageConsumer;
import com.attinix.coronatus.client.store.IWidgetHandler;
import com.attinix.coronatus.client.store.Message;
import com.google.gwt.user.client.ui.Widget;

public class AdministradoraBind implements EntityBind, IComponentListener {

	private Administradora administradora;
	private IWidgetHandler codigo;
	private IWidgetHandler nome;
    private IMessageConsumer messageConsumer;

	
    public void setMessageConsumer(IMessageConsumer messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
    
    @Override
	public void updateBind(Entity entity) {
		this.administradora = (Administradora) entity;
		boolean hasEntity = entity != null;
        codigo.setEnabled(hasEntity);
		if (codigo != null && hasEntity) {
			codigo.setValue(this.administradora.getCodigo());
		}
		nome.setEnabled(hasEntity);
		if (nome != null && hasEntity) {
			nome.setValue(this.administradora.getNome());
		}
	}
	
	@Override
	public Entity createEntity() {
		return new Administradora();
	}
	
	public void bindNome(Widget widget) {
		nome = HandlerFactory.createHandler(widget);		
		initHandler(nome, "Nome", true);
	}
	
	public void bindCodigo(Widget widget) {
		codigo = HandlerFactory.createHandler(widget);
		initHandler(codigo, "Código", true);
	}
	
	private void initHandler(IWidgetHandler handler, String name, boolean required) {
	    handler.addListener(this);
	    handler.setName(name);
	    handler.setMessageConsumer(messageConsumer);
	    handler.setEnabled(false);
	    handler.setRequired(required);
	}
	
	Message message;
	
	@Override
	public void valueChanged(IWidgetHandler sender) {
		if (sender == codigo) {
		    administradora.setCodigo(String.valueOf(sender.getValue()));
		}
		if (sender == nome) {
			administradora.setNome(String.valueOf(sender.getValue()));
		}
	}

}
