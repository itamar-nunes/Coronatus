package com.attinix.coronatus.client.store;


import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class HandlerFactory {
	
	public static IWidgetHandler createHandler(Widget widget) {
		if (widget.getClass().getName().equals(TextBox.class.getName())) {
			return new TextBoxHandler((TextBox) widget);
		}
		throw new RuntimeException("Unsupported widget: " + widget.getClass().getName());
	}

}
