package com.attinix.coronatus.client.store;


public interface IMessageConsumer {
    
    public enum MessageType {
        INFO, WARNING, ERROR
    }
    
    Message addMessage(String text, MessageType type);
    
    void removeMessage(Message message);
    
    void showCriticalMessage(String title, String text, String details, MessageType type);

    final IMessageConsumer DUMMY_CONSUMER = new IMessageConsumer() {

        @Override
        public Message addMessage(String text, MessageType type) {
            return null;
        }

        @Override
        public void removeMessage(Message message) {
        }

        @Override
        public void showCriticalMessage(String title, String text,
                String details, MessageType type) {
        }
        
    };
}
