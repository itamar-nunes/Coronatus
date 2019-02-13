package com.attinix.coronatus.client.view;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.store.GridModel;
import com.attinix.coronatus.client.store.SimpleStore;
import com.attinix.coronatus.client.store.administradora.AdministradoraBind;
import com.attinix.coronatus.client.store.administradora.AdministradoraGridModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AdministradoraView extends DialogBox {
    
    interface AdministradoraUiBinder extends UiBinder<Widget, AdministradoraView> {}
    private static AdministradoraUiBinder uiBinder = GWT.create(AdministradoraUiBinder.class);

    @UiField VerticalPanel mainPanel;
    @UiField DisclosurePanel pesquisa;
    
    @UiField Button butInserir;
    @UiField Button butGravar;
    @UiField Button butExcluir;
    @UiField Button butCancelar;

    @UiField TextBox valorPesquisa;
    @UiField Button botaoPesquisa;
    @UiField Button botaoLimparPesquisa;
    
    @UiField TextBox codigo;
    @UiField TextBox nome;
    
    @UiField MessageArea messages;
    
    private final AdministradoraBind administradoraBind = new AdministradoraBind();
    private final SimpleStore administradoraStore = new SimpleStore("Administradora", administradoraBind);
    private GridModel administradoraGridModel;

    public AdministradoraView() {
        uiBinder.createAndBindUi(this);
        init();
    }
    
    private void init() {
        administradoraGridModel = new AdministradoraGridModel(administradoraStore);
        layout();
        administradoraGridModel.load();
        administradoraGridModel.setMessageConsumer(messages);
        
        administradoraStore.setMessageConsumer(messages);
        
        administradoraBind.setMessageConsumer(messages);
        administradoraBind.bindCodigo(codigo);
        administradoraBind.bindNome(nome);        
        
    }
    
    @UiFactory DisclosurePanel makeDisclosurePanel() { 
      return new DisclosurePanel("Pesquisa");
    }
    
    @UiFactory Grid makeGrid() {
        Grid grid = new Grid(2, 2);
        return grid;
    }

    
    private void layout() {
        setText("Cadastro de administradora");
        setWidget(mainPanel);
        
        mainPanel.insert(administradoraGridModel.getGrid(), 1);
        administradoraGridModel.getGrid().setHeight("120px");
    }
    
    @UiHandler("botaoPesquisa")
    public void pesquisar(ClickEvent event) {
        Administradora administradoraFilter = (Administradora) administradoraBind.createEntity();
        administradoraFilter.setNome("%" + valorPesquisa.getText() + "%");
        administradoraGridModel.filter(administradoraFilter);
    }
    
    @UiHandler("botaoLimparPesquisa")
    public void limparPesquisa(ClickEvent event) {
        administradoraGridModel.load();
    }
    
    @UiHandler("butInserir")
    public void inserir(ClickEvent event) {
        administradoraStore.inserir();
        administradoraGridModel.clearSelection();
    }
    
    @UiHandler("butGravar")
    public void gravar(ClickEvent event) {
        administradoraStore.gravar();
        administradoraGridModel.load();
    }
    
    @UiHandler("butExcluir")
    public void excluir(ClickEvent event) {
        administradoraStore.excluir();
        administradoraGridModel.load();
    }
    
    @UiHandler("butCancelar")
    public void cancelar(ClickEvent event) {
        administradoraStore.cancelar();
        administradoraGridModel.load();
    }

}