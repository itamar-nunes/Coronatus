package com.attinix.coronatus.client.store;

import com.attinix.coronatus.client.model.Entity;

/**
 * Interface de manipulação das entidades de dados utilizada pelo
 * {@link SimpleStore} para obter e notificar de atualizações sobre a entidade.
 * 
 * @author fabricio
 * 
 */
public interface EntityBind {

    /**
     * Notifica que a entidade foi atualizada.
     * 
     * @param entity Versão atualizada da entidade.
     */
    void updateBind(Entity entity);

    /**
     * Solicita a criação de uma entidade do tipo específico da implementação.
     * 
     * @return Nova instância da entidade.
     */
    Entity createEntity();
}
