package com.xk72.charles.gui.transaction.popups;

import javax.swing.text.JTextComponent;

public class CharlesUrlDecodeTextComponent extends CharlesUrlDecode{

    private final JTextComponent component;

    public CharlesUrlDecodeTextComponent(JTextComponent component){
        super(component);
        this.component = component;
    }

    @Override
    public String getBody() {
        String selectText = this.component.getSelectedText();
        return selectText == null ? this.component.getText() : selectText;
    }
}
