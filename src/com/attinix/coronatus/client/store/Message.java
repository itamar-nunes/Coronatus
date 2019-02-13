/**
 * 
 */
package com.attinix.coronatus.client.store;

import com.attinix.coronatus.client.store.IMessageConsumer.MessageType;


public final class Message {

    private String text;
    private final MessageType type;

    public Message(String text, MessageType type) {
        this.text = text;
        this.type = type;
    }
    
    public MessageType getType() {
        return type;
    }
    
    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message msg = (Message) obj;
        return msg.text.equals(this.text);
    }

    @Override
    public String toString() {
        return text;
    }
}