package com.attinix.coronatus.client.service.core;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CrudException extends Throwable implements IsSerializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7680343459427081055L;

    public CrudException() {
        super();
    }
    
    public CrudException(String message) {
        super(message);
    }
    
    public CrudException(Throwable cause) {
        super(cause);
    }
    
    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }
}
