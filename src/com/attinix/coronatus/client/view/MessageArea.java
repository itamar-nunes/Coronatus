package com.attinix.coronatus.client.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.attinix.coronatus.client.store.IMessageConsumer;
import com.attinix.coronatus.client.store.Message;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageArea extends Composite implements IMessageConsumer {

    private Set<Message> messages;
    private Map<Message, Integer> messageIndex;

    private FlexTable messageTable;
    private DisclosurePanel mainPanel;

    boolean empty = true;
    private DialogBox messageBox;

    public MessageArea() {
        messages = new HashSet<Message>();
        messageIndex = new HashMap<Message, Integer>();

        mainPanel = new DisclosurePanel("Mensagens");
        initWidget(mainPanel);

        messageTable = new FlexTable();
        messageTable.addStyleName("message-area");

        ScrollPanel scroll = new ScrollPanel(messageTable);
        mainPanel.add(scroll);

        setEmptyMessage();
    }

    public Message addMessage(String messageText, MessageType type) {
        Message message = new Message(messageText, type);
        if (messages.add(message)) {
            int row = messageTable.insertRow(messageTable.getRowCount());
            if (empty) {
                messageTable.removeRow(0);
                row = 0;
                messageTable.removeStyleName("message-area-empty");
                empty = false;
            }
            messageTable.addCell(row);
            messageTable.setWidget(row, 0, createImageFromType(type));
            messageTable.addCell(row);
            messageTable.setText(row, 1, messageText);
            Anchor removeButton = new Anchor("ok");
            removeButton.setTitle("Remove esta mensagem.");
            removeButton.addClickHandler(new RemoveMessageHandler(message));
            removeButton.addStyleName("message-area-remove");
            messageTable.setWidget(row, 2, removeButton);
            mainPanel.setOpen(true);

            messageIndex.put(message, row);

            return message;
        }
        return null;
    }

    public void removeMessage(Message message) {
        if (messages.remove(message)) {
            int index = messageIndex.remove(message);
            messageTable.removeRow(index);
            if (messageTable.getRowCount() == 0) {
                setEmptyMessage();
            } else {
                for (Message msg : messages) {
                    if (messageIndex.get(msg) > index) {
                        messageIndex.put(msg, messageIndex.get(msg) - 1);
                    }
                }
            }
        }
    }

    @Override
    public void showCriticalMessage(String title, String text, String details,
            MessageType type) {
        if (messageBox == null) {
            messageBox = new DialogBox();
            messageBox.setWidth("500px");
            messageBox.setText(title);
            messageBox.setModal(true);

            VerticalPanel mainPanel = new VerticalPanel();
            messageBox.add(mainPanel);

            FlexTable messageTable = new FlexTable();
            messageTable.insertRow(0);
            messageTable.insertRow(0);
            messageTable.setWidget(0, 0, createImageFromType(type));
            messageTable.setWidget(0, 1, new Label(text));
            DisclosurePanel detailsPanel = new DisclosurePanel("Detalhes");
            HTMLPanel detailsHtml = new HTMLPanel(details);
            detailsPanel.add(detailsHtml);
            messageTable.setWidget(1, 0, detailsPanel);
            messageTable.getFlexCellFormatter().setColSpan(1, 0, 2);
            mainPanel.add(messageTable);

            Button closeButton = new Button("OK");
            DockPanel butPanel = new DockPanel();
            butPanel.add(closeButton, DockPanel.LINE_END);
            mainPanel.add(butPanel);
            closeButton.addClickHandler(new ClickHandler() {

                @Override
                public void onClick(ClickEvent event) {
                    messageBox.hide();
                }
            });
        }
        messageBox.center();
        messageBox.show();

    }

    private class RemoveMessageHandler implements ClickHandler {

        private final Message message;

        public RemoveMessageHandler(Message message) {
            this.message = message;
        }

        @Override
        public void onClick(ClickEvent event) {
            removeMessage(message);
        }

    }

    private Image createImageFromType(MessageType type) {
        Image image = new Image();
        switch (type) {
        case INFO:
            image.setUrl("images/info.png");
            break;
        case WARNING:
            image.setUrl("images/warning.png");
            break;
        case ERROR:
            image.setUrl("images/error.png");
            break;
        default:
            break;
        }
        return image;
    }

    private void setEmptyMessage() {
        empty = true;
        messageTable.insertRow(0);
        messageTable.addCell(0);
        messageTable.setText(0, 0, "Nenhuma mensagem.");
        messageTable.addStyleName("message-area-empty");
    }
}
