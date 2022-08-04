package com.xk72.charles.gui.transaction.popups;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static void writeLog(String text,String filename) {

        try {
            String realName = "E:\\" + filename + ".txt";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(realName), StandardCharsets.UTF_8));
            bw.write(text);
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}