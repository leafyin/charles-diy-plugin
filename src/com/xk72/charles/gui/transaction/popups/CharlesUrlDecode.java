package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
            StringBuilder sb = new StringBuilder();
            sb.append("{").append("\"code\"").append(":\"").append(sourceJson).append("\"}");
            //这里是用接口访问的形式做的
            json = HttpUtils.doPost("http://*.*.*.*:****/decodeJson", sb.toString());
            json = JsonUtils.formatJson(json);
        }catch (Exception e){
            CharlesContext.getInstance().error("Fail to json decode!");
        }

        new ResultDialog(json);
    }

}