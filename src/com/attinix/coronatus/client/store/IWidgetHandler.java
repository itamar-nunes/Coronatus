package com.attinix.coronatus.client.store;

import com.google.gwt.user.client.ui.Widget;

/**
 * Interface para abstrair com componentes visuais quando ocorre manipulação de
 * dados. Suas implementações devem conhecer os detalhes de um {@link Widget}
 * específico para executar o contrato da interface.
 * 
 * @author fabricio
 * 
 */
public interface IWidgetHandler {

    /**
     * Seta o valor no componente. O tipo informado deve ser compatível com o
     * tipo esperado pelo componente.
     * 
     * @param value
     *            valor a ser setado no componente.
     */
    void setValue(Object value);

    /**
     * Retorna o valor do componente. Este valor tem o tipo correspondente ao
     * tipo que o componente trabalha.
     * 
     * @return valor do componente.
     */
    Object getValue();
    
    /**
     * Configura o nome deste campo, utilizado em mensagens de validação.
     * 
     * @param name Nome do campo manipulado pelo Widget.
     */
    void setName(String name);

    /**
     * Habilita/Desabilita o componente.
     * 
     * @param enabled
     *            <code>true</code> para habilitar o componente,
     *            <code>false</code> para desabilitá-lo.
     */
    void setEnabled(boolean enabled);

    /**
     * Adiciona um listener para receber notificações de que o valor do
     * componente foi alterado.
     * 
     * @param listener
     *            Listener de alteração para o componente.
     */
    void addListener(IComponentListener listener);
    
    /**
     * Informa se o valor editado por este Widget é requerido ou não.
     * 
     * @param required <code>true</code> se o valor do campo é requerido, senão <code>false</code>.
     */
    void setRequired(boolean required);

    /**
     * Configura um consumidor de mensagens para o componente, para que sejam
     * adicionadas e removidas mensagens de validação.
     * 
     * @param msgConsumer Consumidor de mensagens para o componente.
     */
    void setMessageConsumer(IMessageConsumer msgConsumer);
}
