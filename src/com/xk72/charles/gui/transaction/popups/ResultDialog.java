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

    public ResultDialog(String content){
        this.setTitle("decode result");
        JToolBar toolBar = new JToolBar();
        textField.setText(searchHistory);
        toolBar.add(textField);
        toolBar.add(searchBtn);
        searchBtn.addActionListener(this);
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
        if (actionEvent.getSource() == searchBtn){
            String findText = textField.getText();
            String text = textArea.getText();
            //保存上次搜索得内容
            searchHistory = findText;
            if (findText.length() == 0){
                return;
            }
            if (!text.contains(findText)){
                JOptionPane.showMessageDialog(this,"内容未找到！");
            } else {
                Highlighter highlighter = textArea.getHighlighter();
                DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
                highlighter.removeAllHighlights();
                int index = 0,length;
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
}
