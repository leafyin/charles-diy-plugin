package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.CharlesContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CharlesUrlDecode extends AbstractAction {

    private final Component component;

    protected CharlesUrlDecode(Component component){
        // 右键菜单的名称
        super("Decode to Json");
        this.component = component;
    }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent actionEvent) {
        // 这里按照你的需求去做(coding what you need to do)
        String json;
        try {
            String sourceJson = this.getBody();
            if (sourceJson.contains(":") && sourceJson.contains("{")){
                sourceJson = JsonUtils.getValueByJson(sourceJson);
            }
            // 这里是用接口访问的形式做的
            json = HttpUtils.doPost("http://*.*.*.*:****/decodeJson", "{" + "\"code\"" + ":\"" + sourceJson + "\"}");
            json = JsonUtils.formatJson(json);
            new ResultDialog(json);
        }catch (Exception e){
            CharlesContext.getInstance().error("Fail to json decode!");
        }
    }

}