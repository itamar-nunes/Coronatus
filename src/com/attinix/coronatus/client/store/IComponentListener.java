package com.attinix.coronatus.client.store;

/**
 * Interface que representa um listener de mudança em um componente {@link IWidgetHandler}.
 * 
 * @author fabricio
 *
 */
public interface IComponentListener {
	
    /**
     * Método invocado quando uma alteração em um componente de um <code>WidgetHandler</code> acontece.
     * 
     * @param sender O componente que sofreu a alteração.
     * 
     * @see IWidgetHandler#addListener(IComponentListener)
     */
	void valueChanged(IWidgetHandler sender);
	
}
