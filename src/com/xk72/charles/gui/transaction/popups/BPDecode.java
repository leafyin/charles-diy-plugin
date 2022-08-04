package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class BPDecode extends AbstractAction {

    private final Component component;

    protected BPDecode(Component component){
        super("BP Decode");
        this.component = component;
    }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent actionEvent) {
        String resultJson = "";
        try{
            String sourceJson = this.getBody();
            if (sourceJson.contains(":") && sourceJson.contains("{"))
            {
                sourceJson = JsonUtils.getValueByJson(sourceJson);
            }
            String jsonParam = "{\"bp\":\"" + sourceJson + "\"}";
            resultJson = HttpUtils.doPost("http://49.232.170.172:8002/bpDecodeJson", jsonParam);
            resultJson = JsonUtils.formatJson(resultJson);
        } catch (Exception e){
            CharlesContext.getInstance().error("Fail to bp decode!");
        }
        new ResultDialog(resultJson);
    }

}
