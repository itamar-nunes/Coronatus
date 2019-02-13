package com.attinix.coronatus.client.store;

import java.util.List;

import com.attinix.coronatus.client.model.Entity;
import com.attinix.coronatus.client.service.core.CrudService;
import com.attinix.coronatus.client.service.core.CrudServiceAsync;
import com.attinix.coronatus.client.store.IMessageConsumer.MessageType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;

public class SimpleStore {

    private final String entityName;
    private Entity entity;
    private final EntityBind entityBind;
    private final CrudServiceAsync crudServiceAsync;
    private IMessageConsumer messageConsumer = IMessageConsumer.DUMMY_CONSUMER;

    public SimpleStore(String entityName, EntityBind entityBind) {
        this.entityName = entityName;
        this.entityBind = entityBind;

        crudServiceAsync = CrudService.Util.getInstance();
    }

    public void setMessageConsumer(IMessageConsumer msgConsumer) {
        this.messageConsumer = msgConsumer;
    }

    public void setCurrentEntity(Entity entity) {
        this.entity = entity;
        entityBind.updateBind(entity);
    }

    public void cancelar() {
        AsyncCallback<IsSerializable> callback = new AsyncCallback<IsSerializable>() {

            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(IsSerializable result) {
                entityBind.updateBind((Entity) result);
                messageConsumer.addMessage("Registro cancelado com sucesso", MessageType.INFO);
            }
        };
        if (entity.getId() != null) {
            crudServiceAsync.consultar("retrieve" + entityName, entity, callback);
        } else {
            entity = null;
            entityBind.updateBind(null);
        }
    }

    public void inserir() {
        entity = entityBind.createEntity();
        entityBind.updateBind(entity);
    }

    public void gravar() {
        final boolean inserting = entity.getId() == null;
        AsyncCallback<IsSerializable> callback = new AsyncCallback<IsSerializable>() {

            @Override
            public void onSuccess(IsSerializable result) {
                entityBind.updateBind(entity);
                messageConsumer.addMessage("Registro inserido com sucesso.", MessageType.INFO);
            }

            @Override
            public void onFailure(Throwable caught) {
                messageConsumer.showCriticalMessage("Erro", "Ocorreu um erro ao inserir o registro", caught.getMessage(), MessageType.ERROR);
            }
        };
        AsyncCallback<Void> voidCallback = new AsyncCallback<Void>() {

            @Override
            public void onSuccess(Void result) {
                entityBind.updateBind(entity);
                messageConsumer.addMessage("Registro alterado com sucesso", MessageType.INFO);
            }

            @Override
            public void onFailure(Throwable caught) {
                messageConsumer.showCriticalMessage("Erro", "Ocorreu um erro ao alterar o registro", caught.getMessage(), MessageType.ERROR);
            }
        };
        if (inserting) {
            crudServiceAsync.inserir("create" + this.entityName, entity, callback);
        } else {
            crudServiceAsync.alterar("update" + this.entityName, entity, voidCallback);
        }

    }

    public void excluir() {
        if (entity.getId() != null) {
            crudServiceAsync.excluir("delete" + this.entityName, entity, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    messageConsumer.showCriticalMessage("Erro", "Ocorreu um erro ao inserir o registro: ", caught.getMessage(), MessageType.ERROR);
                }

                @Override
                public void onSuccess(Void result) {
                    entityBind.updateBind(null);
                    messageConsumer.addMessage("Registro excluído com sucesso", MessageType.INFO);
                }
            });
        }
    }

    public void consultarTodos(AsyncCallback<List<IsSerializable>> callback) {
        crudServiceAsync.consultarTodos("retrieveAll" + this.entityName, callback);
    }
    
    public void consultarTodos(AsyncCallback<List<IsSerializable>> callback, Entity filterExample) {
        crudServiceAsync.consultarTodos("retrieveAllFiltered" + entityName, filterExample, callback);
    }

}
