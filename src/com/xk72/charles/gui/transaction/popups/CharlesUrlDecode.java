package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class CharlesUrlDecode extends AbstractAction {

    private final Component component;

    protected CharlesUrlDecode(Component component){
        super("Decode to Json");
        this.component = component;
    }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent actionEvent) {
        String json = "";
        try {
            String sourceJson = this.getBody();
            if (sourceJson.contains(":") && sourceJson.contains("{")){
                sourceJson = JsonUtils.getValueByJson(sourceJson);
            }
            json = HttpUtils.doPost("http://49.232.170.172:8002/decodeJson", "{" + "\"code\"" + ":\"" + sourceJson + "\"}");
            json = JsonUtils.formatJson(json);
        }catch (Exception e){
            CharlesContext.getInstance().error("Fail to json decode!");
        }

        new ResultDialog(json);
    }

}