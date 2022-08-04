package com.xk72.charles.gui.transaction.popups;

import java.awt.*;

public class BPDecodeText extends BPDecode{

    private final String text;

    public BPDecodeText(String text){
        super(null);
        this.text = text;
    }

    public BPDecodeText(String text, Component component){
        super(component);
        this.text = text;
    }

    @Override
    public String getBody(){
        return this.text;
    }

}
