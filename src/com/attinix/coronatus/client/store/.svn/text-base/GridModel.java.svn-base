package com.attinix.coronatus.client.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.attinix.coronatus.client.model.Entity;
import com.attinix.coronatus.client.store.IMessageConsumer.MessageType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.widgetideas.table.client.FixedWidthGrid;
import com.google.gwt.widgetideas.table.client.ScrollTable;
import com.google.gwt.widgetideas.table.client.SelectionGrid;

public abstract class GridModel {

    private final SimpleStore store;
    protected List<Entity> entityList;
    private ScrollTable scrollTable;
    private FixedWidthGrid dataTable;
    private FixedWidthGrid headerTable;
    private AsyncCallback<List<IsSerializable>> loadCallback;
    private AsyncCallback<List<IsSerializable>> filterCallback;
    private IMessageConsumer messageConsumer = IMessageConsumer.DUMMY_CONSUMER;

    public GridModel(SimpleStore store) {
        this.store = store;
        entityList = new ArrayList<Entity>();

        initGrid();
    }

    private void initGrid() {

        headerTable = new FixedWidthGrid();
        dataTable = new FixedWidthGrid();

        for (int i = 0; i < getColumnCount(); i++) {
            headerTable.setText(0, i, getColumnTitle(i));
            headerTable.setColumnWidth(i, getColumnWidth(i));
            headerTable.getColumnFormatter().setStyleName(i, "headerWrapper");
            dataTable.setColumnWidth(i, getColumnWidth(i));
        }

        headerTable.setCellPadding(0);
        headerTable.setCellSpacing(0);

        dataTable.setCellPadding(0);
        dataTable.setCellSpacing(0);
        dataTable.setSelectionPolicy(SelectionGrid.SELECTION_POLICY_ONE_ROW);
        dataTable.addTableSelectionListener(new SelectionListener());
        dataTable.addStyleName("dataWrapper");

        scrollTable = new ScrollTable(dataTable, headerTable);
        scrollTable.addStyleName("gwt-ScrollTable");

        loadCallback = new LoadCallback(false);
        filterCallback = new LoadCallback(true);
    }

    public void setMessageConsumer(IMessageConsumer messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

    public void load() {
        store.consultarTodos(loadCallback);

    }

    public void filter(Entity example) {
        store.consultarTodos(filterCallback, example);
    }

    public void clearSelection() {
        dataTable.deselectRows();
    }

    public Widget getGrid() {
        return scrollTable;
    }

    public abstract int getColumnCount();

    public abstract String getCellValue(int row, int col);

    public abstract int getColumnWidth(int col);

    public abstract String getColumnTitle(int col);

    private class LoadCallback implements AsyncCallback<List<IsSerializable>> {

        private final boolean feedback;
        private Message loadMessage;

        public LoadCallback(boolean feedback) {
            this.feedback = feedback;
        }

        @Override
        public void onFailure(Throwable caught) {
            messageConsumer.showCriticalMessage("Erro", "Ocorreu um erro ao pesquisar", caught.getMessage(), MessageType.ERROR);
        }

        @Override
        public void onSuccess(List<IsSerializable> result) {
            int size = result.size();
            if (feedback) {
                if (loadMessage != null) {
                    messageConsumer.removeMessage(loadMessage);
                }
                if (size > 0) {
                    loadMessage = messageConsumer.addMessage(size + " registro(s) encontrado(s).", MessageType.INFO);
                } else {
                    loadMessage = messageConsumer.addMessage("Nenhum registro encontrado", MessageType.WARNING);
                }
            }

            entityList.clear();
            entityList.addAll((Collection<? extends Entity>) result);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < getColumnCount(); j++) {
                    dataTable.setText(i, j, getCellValue(i, j));
                }
            }
            while (dataTable.getRowCount() > size) {
                dataTable.removeRow(dataTable.getRowCount() - 1);
            }
        }

    }

    private final class SelectionListener extends TableSelectionListenerAdapter {

        @Override
        public void onRowsSelected(int firstRow, int numRows) {
            store.setCurrentEntity(entityList.get(firstRow));
        }

    }
}
