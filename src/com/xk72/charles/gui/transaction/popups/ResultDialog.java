package com.xk72.charles.gui.transaction.popups;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;

public class ResultDialog extends JFrame implements ActionListener {

    JButton searchBtn = new JButton("搜索");
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();

    private static String searchHistory = "";

    public static void main(String[] args) {
        new ResultDialog("""
                {
                    "name": "中国",
                    "province": [{
                        "name": "黑龙江",
                        "cities": {
                            "city": ["哈尔滨", "大庆"]
                        }
                    }, {
                        "name": "广东",
                        "cities": {
                            "city": ["广州", "深圳", "珠海"]
                        }
                    }, {
                        "name": "台湾",
                        "cities": {
                            "city": ["台北", "高雄"]
                        }
                    }, {
                        "name": "新疆",
                        "cities": {
                            "city": ["乌鲁木齐"]
                        }
                    }]
                }""");
    }

    /**
     * 解密内容弹窗
     * @param content 内容
     */
    public ResultDialog(String content){
        this.setTitle("decode result");
        JToolBar toolBar = new JToolBar();
        textField.setText(searchHistory);
        toolBar.add(textField);
        toolBar.add(searchBtn);
        searchBtn.addActionListener(this);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textHighlighter();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.add(toolBar, BorderLayout.PAGE_START);
        textArea.setEditable(false);
        textArea.setText(content);
        textArea.setCaretPosition(0);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setSize(new Dimension(1000,500));
        this.add(new JScrollPane(textArea),BorderLayout.CENTER);
        this.pack();
        this.setLocation(400,100);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == searchBtn) {
            this.textHighlighter();
        }
    }

    /**
     * 高亮
     */
    private void textHighlighter() {
        String findText = textField.getText();
        String text = textArea.getText();
        //保存上次搜索得内容
        searchHistory = findText;
        if (findText.isEmpty()){
            return;
        }
        if (!text.contains(findText)){
            JOptionPane.showMessageDialog(this,"内容未找到！");
        } else {
            Highlighter highlighter = textArea.getHighlighter();
            DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            highlighter.removeAllHighlights();
            int index = 0,length;
            // 在一段内容中标记出搜索到的内容
            while ((index = text.indexOf(findText,index)) >= 0){
                try{
                    length = findText.length();
                    highlighter.addHighlight(index,index + length,painter);
                    index += length;
                }catch (BadLocationException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
