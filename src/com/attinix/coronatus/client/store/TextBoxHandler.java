package com.attinix.coronatus.client.store;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxHandler extends AbstractComponentHandler implements ChangeHandler {

	private final TextBox textBox;

	public TextBoxHandler(TextBox textBox) {
		this.textBox = textBox;	
		this.textBox.addChangeHandler(this);
	}
	
	@Override
	public void setValue(Object value) {
	    super.setValue(value);
		this.textBox.setValue(value == null ? "" : String.valueOf(value));
	}
	
	@Override
	public Object getValue() {
		return textBox.getValue();
	}
	
	@Override
	public void setEnabled(boolean enabled) {
	    textBox.setEnabled(enabled);
	}

    @Override
    public void onChange(ChangeEvent event) {
        invokeListeners();
    }

}
