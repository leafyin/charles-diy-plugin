package com.xk72.charles.gui.transaction.popups;

import javax.swing.text.JTextComponent;

public class BPDecodeTextComponent extends BPDecode{

    private final JTextComponent component;

    protected BPDecodeTextComponent(JTextComponent component) {
        super(component);
        this.component = component;
    }

    @Override
    protected String getBody() {
        String selectText = this.component.getSelectedText();
        return selectText == null ? this.component.getText() : selectText;
    }
}
