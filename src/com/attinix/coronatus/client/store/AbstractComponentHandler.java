package com.attinix.coronatus.client.store;

import java.util.ArrayList;
import java.util.List;

import com.attinix.coronatus.client.store.IMessageConsumer.MessageType;

/**
 * Implementação básica de {@link IWidgetHandler}, com a manutenção dos
 * listeners e validações básicas. Deve ser extendida por todas implementações
 * específicas para os componentes.
 * 
 * @author fabricio
 * 
 */
public abstract class AbstractComponentHandler implements IWidgetHandler {

    List<IComponentListener> listeners = new ArrayList<IComponentListener>();
    protected IMessageConsumer messageConsumer;
    protected Message message;
    private boolean required;
    private String name;

    @Override
    public void addListener(IComponentListener listener) {
        listeners.add(listener);
    }

    protected void invokeListeners() {
        if (String.valueOf(getValue()).isEmpty() && required) {
            message = messageConsumer.addMessage(name + " - Campo requerido", MessageType.ERROR);
            return;
        }
        if (message != null) {
            messageConsumer.removeMessage(message);
            message = null;
        }
        for (IComponentListener listener : listeners) {
            listener.valueChanged(this);
        }
    }
    
    @Override
    public void setValue(Object value) {
        if (message != null) {
            messageConsumer.removeMessage(message);
            message = null;
        }
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public void setMessageConsumer(IMessageConsumer msgConsumer) {
        this.messageConsumer = msgConsumer;
    }

}
