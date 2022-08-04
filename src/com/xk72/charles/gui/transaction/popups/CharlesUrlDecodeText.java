package com.xk72.charles.gui.transaction.popups;

import java.awt.*;

public class CharlesUrlDecodeText extends CharlesUrlDecode{

    private final String text;

    public CharlesUrlDecodeText(String str){
        super((Component)null);
        this.text = str;
    }

    public CharlesUrlDecodeText(String str, Component component) {
        super(component);
        this.text = str;
    }

    @Override
    public String getBody() {
        return this.text;
    }
}
